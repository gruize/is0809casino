/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.LogicaJuegos.logicaRuleta;

import bbdd.beans.Clientes;
import bbdd.beans.Mesas;
import bbdd.beans.Participantes;
import bbdd.beans.ParticipantesId;
import bbdd.beans.Partidas;
import bbdd.beans.Salas;
import bbdd.gestorBBDD.*;
import controlador.ControladorServidor;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import modelo.Jugada;
import modelo.LogicaJuegos.*;
import java.util.Vector;
import modelo.mensajes.MensajeEstadoRuleta;
import modelo.mensajes.MensajeInfoCliente;
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

    //para enviar los mensajes hacia los clientes por el controlador
    private ControladorServidor controlador;
    // su homólogo en BBDD
    private Mesas mesa_bbdd;

    //identificador de la partida actual
    private int idPartidaActual;

    //para guardar los cambios en bbdd
    InterfazBBDD bbdd;

    //lista de jugadores que están en la mesa
    private Vector<Clientes> jugadores = null;

    // Por cada partida tendremos lo siguiente:
    private Vector<Jugada> apuestas = null; //lista de apuestas de cada partida!!! tras lanzar la bola se vaciará
    private Vector<Clientes> participantes = null; //lista de participantes
    private int ultimaBola = 0;
    private int idGanador = -1; //Id del jugador que gana cada partida
    private CreaRuleta ruleta;

    //********** reloj**************
    private Timer timer = null;

    //log4j
    private static Logger log = Logger.getLogger(MesaRuleta.class);
    //TODO pensar como obtener este valor
    private static int codigoPartida = 1;

    //============================================================================
    //          MÉTODOS DE LA CLASE
    //============================================================================
    /**
     * Constructora por defecto
     * @param idMesa identificador de la mesa
     * @param sala objeto Sala que se guarda en BBDD, para asociarla a la mesa
     */
    public MesaRuleta(int idMesa, Salas sala, ControladorServidor c) {

        this.controlador = c;
        this.bbdd = new GestorBBDDImp();

        crearMesaBBDD(idMesa, sala);

        this.jugadores = new Vector<Clientes>();
        this.participantes=new Vector<Clientes>();
        this.apuestas = new Vector<Jugada>();
        this.ruleta = new CreaRuleta();
        this.ruleta.InicializarRuleta();



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
        mesa_bbdd.setJugadores(0);
        mesa_bbdd.setSalas(sala);

        if (bbdd.insertarMesa(mesa_bbdd)) {
            log.info("MesaRuleta : crearMesaBBDD : mesa " + idMesa + " guardada en BBDD");
        } else {
            log.error("MesaRuleta : crearMesaBBDD : No se ha podido guardar la mesa " + idMesa + " en BBDD");
        }

    }

    /**
     * Carga e inicia el reloj que lanzará la bola de la ruleta
     */
    private void activarReloj() {
        TimerTask timerTask = new TimerTask() {

            public void run() {

                //si no hay jugadores en la mesa, parar el timer!!!
                if (jugadores.size() <= 0) {
                    timer.cancel();
                    log.info("***** NO HAY JUGADORES EN LA MESA... PARO TIMER");
                } else {
                    log.debug("***** Timer activado. Total jugadores: "+jugadores.size());

                    lanzaBola();//lanza bola de la ruleta
                    enviarPararRuleta(); //enviar mensaje al cliente para que pare su ruleta
                    comprobarApuestas(ultimaBola); //Comprueba las apuestas y paga a los ganadores
                    enviarSaldos(); //envia a cada cliente su nuevo saldo
                    modificarPartida(); //actualiza la partida en BBDD
                    try {
                        //paro 10s, para que de tiempo de enviar los nuevos saldos, y de que los clientes muestren los resultados

                        reiniciar();
                        Thread.sleep(10000); //paro 10 seg
                        //nuevo ronda: volver a crear una partida
                        crearPartida();
                        //enviar mensaje al cliente para que reanude su ruleta
                        enviarReiniciarRuleta();

                    } catch (InterruptedException ex) {
                        java.util.logging.Logger.getLogger(MesaRuleta.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
            }
        };
        // Aquí se pone en marcha el timer cada minuto.
        this.timer = new Timer();
        // Dentro de 1min ejecútate cada 1min
        this.timer.scheduleAtFixedRate(timerTask, 1000 * 60, 1000 * 60);
    }


    //==================================================================
    //      mensajes hacia los jugadores
    //==================================================================
    /**
     * 
     * Envia al controlador un vector de MensajeInfoClientes en el que para todos los
     * "participantes" de la partida se envía el nuevo saldo, y la casilla donde ha caido la bola
     */
    public void enviarSaldos() {

        //recorro todos los jugadores y envío su saldo... (no se lo envio sólo a quienes se le haya modificado)
        for (int i = 0; i < participantes.size(); i++) {
            MensajeInfoCliente mensaje = new MensajeInfoCliente();
            mensaje.setIdUsuario(participantes.get(i).getCodigo());
            mensaje.setSaldo(participantes.get(i).getSaldo());
           // mensaje.setBola(ultimaBola);
            controlador.enviarMensajeInfoCliente(participantes.get(i).getCodigo(), mensaje);
        }
    }

    /**
     * Envia un mensaje al controlador para que los "jugadores" paren su ruleta.
     * Tipo de Mensaje enviado: MensajeEstadoRuleta
     */
    private void enviarPararRuleta() {

        MensajeEstadoRuleta mensaje = new MensajeEstadoRuleta();
        mensaje.setParado(true);
        mensaje.setBola(ultimaBola);
        //recorro todos los jugadores y envío un mensaje para que paren la ruleta)
        for (int i = 0; i < jugadores.size(); i++) {
            controlador.enviarMensajeEstadoRuleta(jugadores.get(i).getCodigo(), mensaje);
        }
    }

    /**
     * Envia un mensaje al controlador para que los "jugadores" vuelvan a arrancar su ruleta.
     * Tipo de Mensaje enviado: MensajeEstadoRuleta
     */
    private void enviarReiniciarRuleta() {
        MensajeEstadoRuleta mensaje = new MensajeEstadoRuleta();
        mensaje.setParado(false);
        mensaje.setBola(ultimaBola);
        //recorro todos los jugadores y envío un mensaje para que reanuden la ruleta
        for (int i = 0; i < jugadores.size(); i++) {
            controlador.enviarMensajeEstadoRuleta(jugadores.get(i).getCodigo(), mensaje);
        }
    }

    //========================================================================
    //          TRATAMIENTO DE APUESTAS
    //========================================================================


    /**
     * Si la apuesta es válida para el jugador (si este tiene saldo suficiente), se le guarda en
     * el array de apuestas.
     *
     * Si era la 1ª apuesta del jugador en la partida, se inserta como participante
     *
     * @param jugada
     * @return 1 si la apuesta es correcta, -1 si no le queda saldo al jugador
     */
    private int colocarApuesta(Jugada jugada) {


        //comprobar que la apuesta es mayor a la apuestaMinima
        if (jugada.getCantidad()<apuestaMin)
            return -1;

        //comprobar que el jugador tiene saldo suficiente para realizar su apuesta
        int saldoJugador = getJugador(jugada.getUsuario()).getSaldo();
        if ((jugada.getCantidad()) <= saldoJugador) {

            //se considera participante. Se añade su apuesta y se actualiza su saldo

            apuestas.add(jugada);
            System.out.println("Apuesta: "+" tipo "+jugada.getTipo()+" Casilla "+jugada.getCasilla()+" Cantidad "+jugada.getCantidad());
            actualizaSaldoJugador(jugada.getUsuario(), saldoJugador - jugada.getCantidad());
            //crear participante si era su 1ª apuesta
            if (primeraApuestaDeParticipante(jugada.getUsuario())) {
                log.debug("MesaRuleta : colocarApuesta : 1ª apuesta del jugador " + jugada.getUsuario() + ". se crea el participante");
                crearParticipante(idPartidaActual, jugada.getUsuario());
            }
            return 1;
        } else {
            return -1;
        }

    }

    /**
     * Actualiza el saldo de un jugador y lo guarda en BBDD
     * @param idJugador
     */
    private void actualizaSaldoJugador(int idJugador, int nuevoSaldo) {

        getJugador(idJugador).setSaldo(nuevoSaldo);
        bbdd.modificarCliente(getJugador(idJugador));

    }

    /**
     * Lanza una bola
     */
    public void lanzaBola() {

        System.out.println("****** BOLA LANZADA ********");
        ultimaBola = (int) Math.round((Math.random() * 36));


    }

    /**
     * Recorre todas las apuestas de la mesa, y comprueba si han resultado premiadas
     * @param bolaLanzada numero de la ruleta donde ha caido la bola
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


    }

    /**
     * 
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
            //NUMERO
            if ((tipo.equalsIgnoreCase("NUMERO")) && (apuesta.getCasilla() == casillaBola.getNumero())) {
                return apuesta.getCantidad() * 36;
            //COLOR
            } else if (tipo.equalsIgnoreCase("COLOR")) {
                if ((apuesta.getCasilla() == 1) && casillaBola.getColor().equalsIgnoreCase("ROJO")) {
                    return apuesta.getCantidad() * 2;
                } else if ((apuesta.getCasilla() == 2) && casillaBola.getColor().equalsIgnoreCase("NEGRO")) {
                    return apuesta.getCantidad() * 2;
                }
            //DOCENA
            } else if (tipo.equals("DOCENA")) {
                //PRIMERA DOCENA
                if ((casillaBola.getNumero() >= 1) && (casillaBola.getNumero() <= 12) && (apuesta.getCasilla() == 1)) {
                    return apuesta.getCantidad() * 3;
                } //SEGUNDA DOCENA
                else if ((casillaBola.getNumero() >= 13) && (casillaBola.getNumero() <= 24) && (apuesta.getCasilla() == 2)) {
                    return apuesta.getCantidad() * 3;
                //TERCERA DOCENA
                } else if ((casillaBola.getNumero() >= 25) && (casillaBola.getNumero() <= 36) && (apuesta.getCasilla() == 3)) {
                    return apuesta.getCantidad() * 3;
                }
            } //PARIMPAR
            else if (tipo.equals("PARIMPAR")) {
                //PAR
                if ((casillaBola.getTipo_parImpar().equalsIgnoreCase("PAR")) && (apuesta.getCasilla() == 2)) {
                    return apuesta.getCantidad() * 2;
                } //IMPAR
                else if ((casillaBola.getTipo_parImpar().equalsIgnoreCase("IMPAR")) && (apuesta.getCasilla() == 1)) {
                    return apuesta.getCantidad() * 2;
                }
            } //FALTAPASA
            else if (tipo.equals("FALTAPASA")) {
                //FALTA
                if ((casillaBola.getNumero() < 19) && (apuesta.getCasilla() == 1)) {
                    return apuesta.getCantidad() * 2;
                } //PASA
                else if ((casillaBola.getNumero() > 18) && (apuesta.getCasilla() == 2)) {
                    return apuesta.getCantidad() * 2;
                }

            } //LINEA
            else if (tipo.equals("LINEA")) {
                //PRIMERA LINEA
                if ((casillaBola.getLinea().equalsIgnoreCase("LINEA_UNO")) && (apuesta.getCasilla() == 1)) {
                    return apuesta.getCantidad() * 3;
                } //PASA
                else if ((casillaBola.getLinea().equalsIgnoreCase("LINEA_DOS")) && (apuesta.getCasilla() == 2)) {
                    return apuesta.getCantidad() * 3;
                } else if ((casillaBola.getLinea().equalsIgnoreCase("LINEA_TRES")) && (apuesta.getCasilla() == 3)) {
                    return apuesta.getCantidad() * 3;
                }

            } //CUADRO
            else if (tipo.equals("CUADRO")) {
                //CUADRO
                if (estaEnCuadro(casillaBola.getNumero(), apuesta.getCasilla())) {
                    return apuesta.getCantidad() * 8;
                }
            }

        } //La bola lanzada es CERO: si la apuesta es simple se devuelte la mitad.
        else {
            if (apuesta.getTipo().equalsIgnoreCase("PARIMPAR") || apuesta.getTipo().equalsIgnoreCase("COLOR") || apuesta.getTipo().equalsIgnoreCase("FALTAPASA")) {
                return apuesta.getCantidad() / 2;
            } else if (apuesta.getTipo().equalsIgnoreCase("NUMERO") && (apuesta.getCasilla() == casillaBola.getNumero())) {
                return apuesta.getCantidad() * 36;
            }
        }
        return 0;
    }

    /**
     * Comprueba si es la primera apuesta que realiza un jugador en la partida.
     * Para ello comprueba si ya esta insertado en BBDD como un participante de la partida
     * @param usuario
     * @return
     */
    private boolean primeraApuestaDeParticipante(int usuario) {

        try {
            if (bbdd.getParticipante(usuario, idPartidaActual) != null) {
                return false;
            } else {
                return true;
            }

        } catch (Exception e) {
            log.error("MesaRuleta : primeraApuestaDeParticipante : usuario =" + usuario + ". Mensaje de error: " + e.getMessage());
            return true;
        }
    }

    /**
     * Cuando empieza una nueva partida, se borra todo lo de la anterior
     */
    private void reiniciar() {
        this.apuestas = new Vector<Jugada>();
        this.participantes = new Vector<Clientes>();
        this.idGanador = -1;
        this.idPartidaActual = -1;
    }
    //======================================================================
    //              Partida y participantes (RONDAS)
    //======================================================================

    /**
     * Crea la partida. Se guarda en bbdd y se lanza la bola (activa el timer)
     * La partida se crea tras recibir el primer jugador de la mesa
     */
    public void crearPartida() {

        Partidas p = new Partidas();
        p.setCodigo(codigoPartida);
        p.setMesas(mesa_bbdd);
        p.setNumjugadores(this.participantes.size());//al principio siempre sera 0
        p.setGanador(-1); //al crear la partida, aún no hay ganador

        try{
        //insertar en BBDD
        bbdd.insertarPartida(p);

        this.idPartidaActual = codigoPartida;

        //para las proximas partidas
        codigoPartida++;

        }catch (Exception e){
            log.error("MesaRuleta : crearPartida : error al crear la partida "+codigoPartida+" en BBDD. Motivo: "+e.getMessage());
        }

    }

    /**
     * Modifica la partida actual y la actualiza en BBDD.
     * Se hará cuando se lance la bola, para incluir el nº de participantes finales, y el ganador
     */
    private void modificarPartida() {

        try {
            Partidas partidaActual = bbdd.getPartida(idPartidaActual);
            partidaActual.setNumjugadores(this.participantes.size());
            partidaActual.setGanador(this.idGanador);

            if (bbdd.modificarPartida(partidaActual)) {
                log.info("MesaRuleta : modificarPartida : partida guardada en BBDD. Ganador=" + idGanador + " y numParticipantes=" + this.participantes.size());
            } else {
                log.error("MesaRuleta : modificarPartida : La partida NO se ha podido actualizar : " + idPartidaActual);
            }

        } catch (Exception e) {
            log.error("MesaRuleta : modificarPartida : error al actualizar la partida " + idPartidaActual + ". Motivo: " + e.getMessage());
        }
    }

    /**
     * Inserta un nuevo participante en la partida actual.
     * Se considera participante si ha realizado una apuesta.
     *
     * NOTA: un partipante puede hacer varias apuesta..antes de insertar, comprobar que no está ya (solo en la 1ª apuesta)
     *
     * NOTA: puede ser jugador y estar en la mesa, pero no haber participado en la ronda (no ha apostado)
     * @param idPartida
     * @param idJugador
     */
    public void crearParticipante(int idPartida, int idJugador) {

        ParticipantesId pId = new ParticipantesId();
        pId.setPartida(idPartida);
        pId.setJugador(idJugador);

        Participantes p = new Participantes();
        p.setId(pId);

        bbdd.insertarParticipante(p);


        //guardo en el vector de participantes
        this.participantes.add(jugadores.get(getPosicionJugador(idJugador)));

    }

    // ======================================================================
    //              Getters
    // ======================================================================
    /**
     * Devuelve la posicion que ocupa en jugador en el vector de jugadores de la mesa
     * @param idJugador
     * @return pos si lo encuentra, -1 si no
     */
    private int getPosicionJugador(int idJugador) {

        int pos = 0;
        boolean enc = false;
        while (!enc && pos < this.jugadores.size()) {
            enc = this.jugadores.get(pos).getCodigo() == idJugador;
            pos++;
        }
        if (enc) {
            return pos - 1;
        } else {
            return -1;
        }
    }

    /**
     * Devuelve un jugador de la mesa
     * @param idJugador
     * @return objeto Clientes
     */
    private Clientes getJugador(int idJugador) {
        return this.jugadores.get(getPosicionJugador(idJugador));
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

    /**
     * Devuelve el código que identifica a la mesa (coincide con el de BBDD)
     * @return idMesa
     */
    public int getCodigoMesa() {
        return this.mesa_bbdd.getCodigo();
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
     * Inserta un nuevo jugador en la mesa
     * @param idJugador
     * @return false si el jugador ya estaba en la mesa. True en otro caso
     */
    public boolean colocarJugador(Clientes jugador) {

        boolean primerJugador = false;
        if (existeJugadorEnMesa(jugador.getCodigo())) {
            log.error("MesaRuleta : colocarJugador : El jugador " + jugador.getCodigo() + " ya estaba en la mesa " + getCodigoMesa());
            return false;
        } else {

            if (jugadores.size() == 0) {
                primerJugador = true;
            }
            //añado el jugador
            jugadores.add(jugador);
            log.info("MesaRuleta : colocarJugador : Jugador " + jugador.getCodigo() + " colocado en la mesa " + getCodigoMesa());

            //13/05/09 - aumentar el numero de jugadores de la mesa
            int jug=mesa_bbdd.getJugadores();
            jug++; 
            mesa_bbdd.setJugadores(jug);
            bbdd.modificarMesa(mesa_bbdd);
            
            //Si era el primer jugador... activo el timer para crear una nueva

            if (primerJugador) {
                log.info("***** ERA EL PRIMER JUGADOR DE LA MESA... CREO PARTIDA Y ACTIVO EL TIMER");
                crearPartida();
                activarReloj();
            }

                 //enviarle el saldo, en un mensajeInfoCliente

            MensajeInfoCliente mensajeIC=new MensajeInfoCliente();
            mensajeIC.setIdUsuario(jugador.getCodigo());
            mensajeIC.setSaldo(jugador.getSaldo());
            controlador.enviarMensajeInfoCliente(jugador.getCodigo(), mensajeIC);

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
        if (existeJugadorEnMesa(idJugador)) {

            //puede desconectarse y no ser participante, por lo que no chekeo este error
            participantes.removeElement(getJugador(idJugador));
            
            if (!jugadores.removeElement(getJugador(idJugador)))
                return false;
             else log.info("MesaRuleta : eliminarJugador : jugador ["+idJugador+"] eliminado de la lista de jugadores. ");

            //13/05/09 - disminuir el numero de jugadores de la mesa
            int jug=mesa_bbdd.getJugadores();
            jug--; 
            mesa_bbdd.setJugadores(jug);
            bbdd.modificarMesa(mesa_bbdd);
            

            return true;
        } else {
            log.info("MesaRuleta : eliminarJugador : El jugador " + idJugador + " NO estaba en la mesa " + getCodigoMesa());
            return false;
        }
    }

    /**
     * Devuelve todos los jugadores que están en la mesa
     * @return
     */
    public Vector<Clientes> getJugadores_Mesa() {

        return this.jugadores;
    }

    /**
     * Comprueba si el jugador ya está en la mesa
     * @param idJugador
     * @return true si ya está en la mesa, false si no lo está
     */
    public boolean existeJugadorEnMesa(int idJugador) {

        return (getPosicionJugador(idJugador) != -1);

    }

    /**
     * Comprueba si el numero esta en el cuadro apostado
     * @param numero cuadro
     * @return true si numero esta en el cuadro cuadro.
     */
    private boolean estaEnCuadro(int numero, int cuadro) {

        int resultado = cuadro + cuadro / 2;
        if ((cuadro % 2) == 0) {
            resultado--;
        }
        if ((resultado == numero) || (resultado + 1 == numero) || (resultado + 3 == numero) || (resultado + 4 == numero)) {
            return true;
        }
        return false;

    }

    /**
     * Borra la mesa de BBDD
     */
    public void borrarMesa() {
        bbdd.borrarMesa(mesa_bbdd);
        
    }

}
