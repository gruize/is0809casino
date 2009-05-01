/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.LogicaJuegos.logicaRuleta;

import bbdd.beans.Clientes;
import bbdd.beans.Mesas;
import bbdd.beans.Salas;
import bbdd.gestorBBDD.*;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import modelo.LogicaJuegos.Jugada;
import modelo.LogicaJuegos.*;
import java.util.Vector;
import modelo.GestorUsuarios;
import org.apache.log4j.Logger;

/**
 *
 * @author Jaime Guimera
 */
public class MesaRuleta implements Mesa {

    // atributos específicos para una la mesa de ruleta. ¿estaticos? O cada mesa de ruleta tiene su maximo y min?
    public static double apuestaMin = 1.00;
    public static double apuestaMax = 500;
    public static int puestosMax = 100; //nº maximo de personas que pueden estar jugando en una mesa
    // su homólogo en BBDD
    private Mesas mesa_bbdd;

    //para guardar los cambios en bbdd
    InterfazBBDD bbdd;

    //lista de jugadores
    private Vector<Clientes> jugadores = null;
    private Vector<Jugada> apuestas = null; //lista de apuestas de la mesa
    private int ultimaBola = 0;
    private CreaRuleta ruleta;

    //********** reloj**************
    private Timer timer = null;
    
    //log4j
    private static Logger log = Logger.getLogger(MesaRuleta.class);

    //============================================================================
    //          MÉTODOS DE LA CLASE
    //============================================================================
    /**
     * Constructora por defecto
     * @param idMesa identificador de la mesa
     * @param sala objeto Sala que se guarda en BBDD, para asociarla a la mesa
     */
    public MesaRuleta(int idMesa, Salas sala) {


        crearMesaBBDD(idMesa, sala);

        this.jugadores = new Vector<Clientes>();
        this.apuestas = new Vector<Jugada>();
        this.ruleta = new CreaRuleta();
        this.ruleta.InicializarRuleta();


        //cargar e iniciar el reloj, que lanzará la bola
        activarReloj();
    //TODO hacerlo cuando entre el primer jugador, o se haga la 1ª apuesta


    }

    /**
     * Carga e inicia el reloj que lanzará la bola de la ruleta
     */
    private void activarReloj() {
        TimerTask timerTask = new TimerTask() {

            public void run() {
                // Aquí el código que queremos ejecutar.

                lanzaBola();
                enviarSaldos();
                try {
                   //paro 20s,para q de tiempo de enviar los nuevos saldos
                    Thread.sleep(100000);
                } catch (InterruptedException ex) {
                    java.util.logging.Logger.getLogger(MesaRuleta.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
        // Aquí se pone en marcha el timer cada segundo.
        this.timer = new Timer();
        // Dentro de 1min ejecútate cada 1min
        this.timer.scheduleAtFixedRate(timerTask, 1000 * 60, 1000 * 60);
    }

    /**
     * Si la apuesta es válida para el jugador (si este tiene saldo suficiente), se le guarda en
     * el array de apuestas
     * @param jugada
     * @return 1 si la apuesta es correcta, -1 si no le queda saldo al jugador
     */
    private int colocarApuesta(Jugada jugada) {


        int saldoJugador =getJugador(jugada.getUsuario()).getSaldo();
        if ((jugada.getCantidad()) <= saldoJugador) {
            apuestas.add(jugada);
            actualizaSaldoJugador(jugada.getUsuario(), saldoJugador - jugada.getCantidad());
            return 1;
        } else {
            return -1;
        }

    }

   /**
    * Actualiza el saldo de un jugador y lo guarda en BBDD
    * @param idJugador
    */
    private void actualizaSaldoJugador(int idJugador, int nuevoSaldo){

        getJugador(idJugador).setSaldo(nuevoSaldo);
        bbdd.modificarCliente(getJugador(idJugador));
       
    }



    /**
     * Lanza una bola y comprueba todas las apuestas de los jugadores.
     */
    public void lanzaBola() {

        System.out.println("****** BOLA LANZADA ********");
       
        ultimaBola = (int) Math.round((Math.random() * 36));
        comprobarApuestas(ultimaBola);

    }

    /**
     * Recorre todas las apuestas de la mesa, y comprueba si han resultado premiadas
     * @param bolaLanzada n�mero de la ruleta donde ha ca�do la bola
     * @return
     */
    private void comprobarApuestas(int bolaLanzada) {

        Numero bola = ruleta.getNumero(bolaLanzada);
        int saldo;
        for (int i = 0; i < apuestas.size(); i++) {
            Jugada apuesta = apuestas.get(i);
            saldo = getJugador(apuesta.getUsuario()).getSaldo();
            saldo = saldo + apuestaGanadora(apuesta, bola);
            actualizaSaldoJugador(apuesta.getUsuario(), saldo);
        }
        apuestas.removeAllElements();
        enviarSaldos();

    }

    /**
     * Comprueba si la apuesta que hizo el jugador ha resultado premiada o no, a partir de la
     * bola de la ruleta
     * @param apuesta del jugador
     * @param casillaBola casilla de la ruleta que ha resultado seleccionada
     * @return lo que el jugador gana
     *
     */
    private int apuestaGanadora(Jugada apuesta, Numero casillaBola) {
        String tipo = apuesta.getTipo();
        if (casillaBola.getNumero() != 0) {
            //apuesta a N�MERO
            if ((tipo.equals("numero")) && (apuesta.getCasilla() == casillaBola.getNumero())) {
                return apuesta.getCantidad() * 36;
            //apuesta a COLOR (0=>Negro, 1 =>ROJO
            } else if (tipo.equalsIgnoreCase("COLOR")) {
                if ((apuesta.getCasilla() == 1) && casillaBola.getColor().equalsIgnoreCase("ROJO")) {
                    return apuesta.getCantidad() * 2;
                } else if ((apuesta.getCasilla() == 0) && casillaBola.getColor().equalsIgnoreCase("NEGRO")) {
                    return apuesta.getCantidad() * 2;
                }
            //apuesta a 1� DOCENA
            } else if (tipo.equals("1docena") && casillaBola.getNumero() >= 1 && casillaBola.getNumero() <= 12) {
                return apuesta.getCantidad() * 3;
            //apeusta a 2� DOCENA
            } else if (tipo.equals("2docena") && casillaBola.getNumero() > 12 && casillaBola.getNumero() <= 24) {
                return apuesta.getCantidad() * 3;
            //apuesta a 3� DOCENA
            } else if (tipo.equals("3docena") && casillaBola.getNumero() > 24 && casillaBola.getNumero() <= 36) {
                return apuesta.getCantidad() * 3;

            }
        } else {//la bola lanzada es CERO: si la apuesta es al color se devuelte la mitad.
            if (apuesta.getTipo().equals("COLOR")) {
                return apuesta.getCantidad() / 2;
            } else if (apuesta.getTipo().equals("numero") && (apuesta.getCasilla() == casillaBola.getNumero())) {
                return apuesta.getCantidad() * 36;
            }
        }
        return 0;
    }
    //Envia los saldos nuevos a los jugadores de la mesa

    /**
     * TODO implementar
     * Envia los saldos nuevos a los jugadores de la mesa
     */
    public void enviarSaldos() {

        //recorro todos los jugadores y envío su saldo... (no se lo envio sólo a quienes se le haya modificado)
        for (int i=0; i<jugadores.size(); i++){
            
        }
    }

    // ======================================================================
    //              METODOS DE LA INTERFAZ
    // ======================================================================
    public boolean procesaJugada(Jugada j) {
        if (this.colocarApuesta(j) == 1) {
            System.out.println("///////// Apuesta Aceptada \\\\\\\\");
            return true;
        } else {
            return false;
        }
    }

    public Mesas getMesaBBDD() {
        return this.mesa_bbdd;
    }

    public double getApuestaMin() {
        return apuestaMin;
    }

    public double getApuestaMax() {
        return apuestaMin;
    }

    public int getPuestosMax() {
        return puestosMax;
    }

    /**
     * Crea una nueva mesa y la guarda en bbdd
     * @param idMesa
     * @param idSala
     */
    private void crearMesaBBDD(int idMesa, Salas sala) {
        mesa_bbdd = new Mesas();
        mesa_bbdd.setCodigo(idMesa);
        mesa_bbdd.setApuestamax(apuestaMax);
        mesa_bbdd.setApuestamin(apuestaMin);
        mesa_bbdd.setPuestos(puestosMax);
        mesa_bbdd.setSalas(sala);

        if (bbdd.insertarMesa(mesa_bbdd))
            log.info("MesaRuleta : crearMesaBBDD : mesa "+idMesa+" guardada en BBDD");
        else log.error("MesaRuleta : crearMesaBBDD : No se ha podido guardar la mesa "+idMesa+" en BBDD");

    }

    /**
     * Devuelve el código que identifica a la mesa (coincide con el de BBDD)
     * @return idMesa
     */
    public int getCodigoMesa() {
        return this.mesa_bbdd.getCodigo();
    }


    /**
     * Devuelve la posicion que ocupa en jugador en el vector de jugadores de la mesa
     * @param idJugador
     * @return pos si lo encuentra, -1 si no
     */
    private int getPosicionJugador(int idJugador){

        int pos=0;
        boolean enc=this.jugadores.get(pos).getCodigo()==idJugador;
        while (!enc && pos<this.jugadores.size()){
            pos++;
            enc=this.jugadores.get(pos).getCodigo()==idJugador;
        }
        if (enc)
            return pos;
        else return -1;
    }

    /**
     * Devuelve un jugador de la mesa
     * @param idJugador
     * @return objeto Clientes
     */
    private Clientes getJugador(int idJugador){
        return this.jugadores.get(getPosicionJugador(idJugador));
    }

    /**
     * Inserta un nuevo jugador en la mesa
     * @param idJugador
     * @return false si el jugador ya estaba en la mesa. True en otro caso
     */
    public boolean colocarJugador(Clientes jugador) {

        if (existeJugadorEnMesa(jugador.getCodigo())) {
            log.error("MesaRuleta : colocarJugador : El jugador " + jugador.getCodigo() + " ya estaba en la mesa " + getCodigoMesa());
            return false;
        } else {
            if (this.jugadores == null) {
                this.jugadores = new Vector<Clientes>();
            }

            //añado el jugador
            jugadores.add(jugador);
            log.info("MesaRuleta : colocarJugador : Jugador " + jugador.getCodigo() + " colocado en la mesa " + getCodigoMesa());

            return true;
        }



    }

    /**
     * Elimina a un jugador de la mesa
     * @param idJugador
     * @return false si no estaba en la mesa. True si se ha podido eliminar
     */
    public boolean eliminarJugador(int idJugador) {

        //por seguridad, compruebo si realmente está en la mesa
        if (existeJugadorEnMesa(idJugador)){
            return jugadores.remove(getJugador(idJugador));
        }else{
            log.info("MesaRuleta : eliminarJugador : El jugador " + idJugador + " NO estaba en la mesa " + getCodigoMesa());
            return false;
        }
    }

    /**
     * Devuelve todos los jugadores que están en la mesa
     * @return
     */
    public Vector<Clientes> getJugadores_Mesa() {

        /*Vector<Integer> listaJugadores = new Vector<Integer>();
        for (int i = 0; i < jugadores.size(); i++) {
            listaJugadores.add(jugadores.get(i).getCodigo());
        }

        return listaJugadores;*/

        return this.jugadores;
    }

    /**
     * Comprueba si el jugador ya está en la mesa
     * @param idJugador
     * @return true si ya está en la mesa, false si no lo está
     */
    public boolean existeJugadorEnMesa(int idJugador) {

        int i = 0;
        boolean enc = jugadores.get(i).getCodigo() == idJugador;
        while (!enc && i < jugadores.size()) {
            i++;
            enc = jugadores.get(i).getCodigo() == idJugador;
        }
        return enc;
    }
}
