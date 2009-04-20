/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo.LogicaJuegos.logicaRuleta;

import modelo.LogicaJuegos.*;
import java.util.Vector;

/**
 *
 * @author Jaime Guimera
 */
public class MesaRuleta implements Mesa {

    int id=0;
    int nJugadores=0;
    Vector<Jugada> apuestas=null; //lista de apuestas de la partida
    int nApuestas=0;
    Vector<Jugador> jugadoresPartida=null; //lista de jugadores de la partida
    Vector numeros=null;
    int ultimaBola=0;

     public boolean procesaJugada(Jugada j) {
        if (this.colocarApuesta(j)==1) return true;
        else return false;
    }
    /**
     * Si la apuesta es válida para el jugador (si éste tiene saldo suficiente), se le guarda en
     * su array de apuestas
     * @param jugada
     * @return 1 si la apuesta es correcta, -1 si no le queda saldo al jugador, -2 si se excede el nº máximo
     * de apuestas en la ronda
     */
    private int colocarApuesta(Jugada jugada) {
        int posicionJugador = posicionJugador(jugada.getUsuario());
         int saldoJugador = jugadoresPartida.get(posicionJugador).getSaldo();
            if ((jugada.getCantidad()) <= saldoJugador) {
                apuestas.add(jugada);
                nApuestas++;
                jugadoresPartida.get(posicionJugador).setSaldo(saldoJugador - jugada.getCantidad());

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
        while ((!encontrado) && (index < jugadoresPartida.size())) {
            encontrado = jugadoresPartida.get(index).getId() == idJugador;
            index++;
        }
        return index - 1;


    }
    //Lanza una bola y comprueba todas las apuestas de los jugadores.
    public void lanzaBola(){
    //TODO rellenar codigo
    }

}
