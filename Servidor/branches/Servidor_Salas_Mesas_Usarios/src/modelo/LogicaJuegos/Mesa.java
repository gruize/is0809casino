/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo.LogicaJuegos;

import bbdd.beans.Clientes;
import bbdd.beans.Mesas;
import java.util.Vector;
import modelo.LogicaJuegos.Jugada;

/**
 *
 * @author Jaime Guimera
 */
public interface Mesa {
    boolean procesaJugada(Jugada j);

   //cada mesa de juego guardará su homologo de bbdd
    public Mesas getMesaBBDD();

    //Apuesta mínima de cada mesa
    public double getApuestaMin();

    //Apuesta máxima de cada mesa
    public double getApuestaMax();

    //Nº de puestos máximos de la mesa
    public int getPuestosMax();

    public int getCodigoMesa();

    public boolean colocarJugador(Clientes idJugador);

    public boolean eliminarJugador(int idJugador);

    /**
     * Devuelve una lista de los jugadores que están en la mesa
     * @return
     */
    public Vector<Clientes> getJugadores_Mesa();

    public boolean existeJugadorEnMesa(int idJugador);


}
