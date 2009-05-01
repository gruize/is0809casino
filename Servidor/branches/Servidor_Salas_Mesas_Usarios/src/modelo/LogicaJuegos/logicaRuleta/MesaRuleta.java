/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.LogicaJuegos.logicaRuleta;

import bbdd.beans.Mesas;
import controlador.ControladorServidor;
import java.util.Timer;
import java.util.TimerTask;
import modelo.Jugada;
import modelo.LogicaJuegos.*;
import java.util.Vector;
import modelo.GestorUsuarios;

/**
 *
 * @author Jaime Guimera
 */
public class MesaRuleta implements Mesa {

    // atributos específicos para una la mesa de ruleta. ¿estaticos? O cada mesa de ruleta tiene su maximo y min?
    public static double apuestaMin = 1.00;
    public static double apuestaMax = 500;
    public static int puestosMax = 100; //nº maximo de personas que pueden estar jugando en una mesa

    // TODO su homólogo en BBDD

    int nJugadores = 0;
    Vector<Jugada> apuestas = null; //lista de apuestas de la mesa
    int ultimaBola = 0;
    ControladorServidor controlador;
    CreaRuleta ruleta;
    boolean flag = true; //Si Flag=true se admiten apuestas si Flag = false no se admiten apuestas
    //********** reloj**************
    Timer timer = null;

    public MesaRuleta(ControladorServidor c, int id) {
         controlador = c;
        apuestas = new Vector();
        ruleta = new CreaRuleta();
        ruleta.InicializarRuleta();


        //cargar e iniciar ele reloj
        // Clase en la que está el código a ejecutar
        TimerTask timerTask = new TimerTask() {

            public void run() {
                // Aquí el código que queremos ejecutar.
                lanzaBola();
            }
        };
        // Aquí se pone en marcha el timer cada segundo.
        timer = new Timer();
        // Dentro de 1min ejecútate cada 1min
        timer.scheduleAtFixedRate(timerTask, 1000 * 60, 1000 * 60);


    }

    /**
     * Si la apuesta es válida para el jugador (si este tiene saldo suficiente), se le guarda en
     * el array de apuestas
     * @param jugada
     * @return 1 si la apuesta es correcta, -1 si no le queda saldo al jugador
     */
    private int colocarApuesta(Jugada jugada) {


        int saldoJugador = GestorUsuarios.getInstancia().getJugadorConectado(jugada.getUsuario()).getSaldoJugador();
        if ((jugada.getCantidad()) <= saldoJugador) {
            apuestas.add(jugada);
            
            GestorUsuarios.getInstancia().actualizaSaldoJugador(jugada.getUsuario(),saldoJugador - jugada.getCantidad());
            return 1;
        } else {
            return -1;
        }

    }


    //Lanza una bola y comprueba todas las apuestas de los jugadores.
    public void lanzaBola() {

        System.out.println("****** BOLA LANZADA ********");
        flag = false;
        ultimaBola = (int) Math.round((Math.random() * 36));
        comprobarApuestas(ultimaBola);
        flag = true;
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
            saldo = GestorUsuarios.getInstancia().getJugadorConectado(apuesta.getUsuario()).getSaldoJugador();
            saldo = saldo + apuestaGanadora(apuesta, bola);
            GestorUsuarios.getInstancia().actualizaSaldoJugador(apuesta.getUsuario(), saldo);

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

    public void enviarSaldos() {
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
        throw new UnsupportedOperationException("Not supported yet.");
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
}