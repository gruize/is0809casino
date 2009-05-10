/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo.LogicaJuegos;

import bbdd.beans.Clientes;
import bbdd.beans.Mesas;
import java.util.Vector;
import modelo.Jugada;

/**
 *
 * @author Jaime Guimera
 */
public interface Mesa {

    
    public boolean procesaJugada(Jugada j);

   //cada mesa de juego guardará su homologo de bbdd
    public Mesas getMesaBBDD();

    //Apuesta mínima de cada mesa
    public double getApuestaMin();

    //Apuesta máxima de cada mesa
    public double getApuestaMax();

    //Nº de puestos máximos de la mesa
    public int getPuestosMax();

    /**
     * Devuelve el código de la mesa, guardada en BBDD
     * @return int
     */
    public int getCodigoMesa();

    /**
     * Inserta al jugador en la mesa
     * @param idJugador
     * @return
     */
    public boolean colocarJugador(Clientes idJugador);

    /**
     * Elimina un jugador de la mesa
     * @param idJugador
     * @return
     */
    public boolean eliminarJugador(int idJugador);

    /**
     * Devuelve una lista de los jugadores que están en la mesa
     * @return
     */
    public Vector<Clientes> getJugadores_Mesa();

    /**
     * Comprueba si el jugador está ya en la mesa
     * @param idJugador
     * @return
     */
    public boolean existeJugadorEnMesa(int idJugador);


    /**
     * Las partidas representan las rondas. La 1ª partida de una mesa se crea 
     * cuando entra el primer jugador, y se actualiza al tirar la bola. 
     * Tras lanzar la bola, comienza una nueva ronda, con lo cual hay que crear otra partida
     */
    public void crearPartida();

    /**
     * Guarda en BBDD un nuevo participante. La partida debe estar creada previamente.
     * @param idPartida id de la partida actual que se está jugando
     * @param idJugador id del cliente
     *
     */
    public void crearParticipante(int idPartida, int idJugador);

    /**
     * Borra la mesa de BBDD
     */
    public void borrarMesa();

}
