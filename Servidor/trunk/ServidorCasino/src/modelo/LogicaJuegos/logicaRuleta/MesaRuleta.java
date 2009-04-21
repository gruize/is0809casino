/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.LogicaJuegos.logicaRuleta;

import controlador.ControladorServidor;
import modelo.Jugada;
import modelo.LogicaJuegos.*;
import java.util.Vector;

/**
 *
 * @author Jaime Guimera
 */
public class MesaRuleta implements Mesa {

    int id = 0;
    int nJugadores = 0;
    Vector<Jugada> apuestas = null; //lista de apuestas de la mesa
    int nApuestas = 0;
    Vector<Jugador> jugadoresMesa = null; //lista de jugadores de la mesa
    Vector numeros = null;
    int ultimaBola = 0;
    ControladorServidor controlador;

    public MesaRuleta(ControladorServidor c) {
        controlador = c;
        apuestas=new Vector();
        jugadoresMesa=new Vector();
    }

    public boolean procesaJugada(Jugada j) {
        System.out.println("Mensaje procesado por la Mesa");
        if (this.colocarApuesta(j) == 1) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Si la apuesta es válida para el jugador (si este tiene saldo suficiente), se le guarda en
     * el array de apuestas
     * @param jugada
     * @return 1 si la apuesta es correcta, -1 si no le queda saldo al jugador
     */
    private int colocarApuesta(Jugada jugada) {
        int posicionJugador = posicionJugador(jugada.getUsuario());
        int saldoJugador = jugadoresMesa.get(posicionJugador).getSaldo();
        if ((jugada.getCantidad()) <= saldoJugador) {
            apuestas.add(jugada);
            nApuestas++;
            jugadoresMesa.get(posicionJugador).setSaldo(saldoJugador - jugada.getCantidad());

            return 1;
        } else {
            return -1;
        }

    }

    /**
     * Devuelve el índice del jugador de entre todos los
     * jugadores activos de la partida de la ruleta.
     * @param idJugador valor que identifica al jugador
     * @return índice del array de jugadores donde se encuentra el jugador
     */
    private int posicionJugador(int idJugador) {
        boolean encontrado = false;
        int index = 0;
        while ((!encontrado) && (index < jugadoresMesa.size())) {
            encontrado = jugadoresMesa.get(index).getId() == idJugador;
            index++;
        }
        return index - 1;


    }
    //Lanza una bola y comprueba todas las apuestas de los jugadores.

    public void lanzaBola() {
        //TODO rellenar codigo
    }
    //A�ade un Jugadora la mesa

    public boolean addJugador(Jugador j) {
        //TODO Comprobar que no este ya en la mesa
        jugadoresMesa.add(j);
        return true;
    }
}
