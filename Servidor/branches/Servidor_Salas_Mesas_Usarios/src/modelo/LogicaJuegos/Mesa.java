/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo.LogicaJuegos;

import bbdd.beans.Mesas;
import modelo.Jugada;

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


}
