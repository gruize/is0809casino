/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo.LogicaJuegos;

import modelo.Jugada;

/**
 *
 * @author Jaime Guimera
 */
public interface Mesa {
    boolean procesaJugada(Jugada j);

    // atributos específicos para una la mesa de ruleta
    public static double apuestaMin=1.00;
    public static double apuestaMax=500;
    public static int puestosMax=100; //nº maximo de personas que pueden estar jugando en una mesa


}
