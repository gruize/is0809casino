/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo.mensajes.objetos;

import java.io.Serializable;
import modelo.NombreJuegos;

/**
 *
 * @author GabiPC
 */
public class PeticionMesa implements Serializable {

    private int idMesa;
    private NombreJuegos juego;
    private double apuestaMin;
    private int numJugadores;

    public PeticionMesa(int idMesa, NombreJuegos juego, double apuestaMin, int numJugadores) {
        this.idMesa = idMesa;
        this.juego = juego;
        this.apuestaMin = apuestaMin;
        this.numJugadores = numJugadores;
    }

    public double getApuestaMin() {
        return apuestaMin;
    }

    public void setApuestaMin(double apuestaMin) {
        this.apuestaMin = apuestaMin;
    }

    public int getIdMesa() {
        return idMesa;
    }

    public void setIdMesa(int idMesa) {
        this.idMesa = idMesa;
    }

    public NombreJuegos getJuego() {
        return juego;
    }

    public void setJuego(NombreJuegos juego) {
        this.juego = juego;
    }

    public int getNumJugadores() {
        return numJugadores;
    }

    public void setNumJugadores(int numJugadores) {
        this.numJugadores = numJugadores;
    }

}
