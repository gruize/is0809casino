/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

/**
 *
 * @author GabiPC
 */
public class PeticionMesa {

    private int idMesa;
    private Juegos juego;
    private int apuestaMin;
    private int numJugadores;

    public PeticionMesa(int idMesa, Juegos juego, int apuestaMin, int numJugadores) {
        this.idMesa = idMesa;
        this.juego = juego;
        this.apuestaMin = apuestaMin;
        this.numJugadores = numJugadores;
    }

    public int getApuestaMin() {
        return apuestaMin;
    }

    public void setApuestaMin(int apuestaMin) {
        this.apuestaMin = apuestaMin;
    }

    public int getIdMesa() {
        return idMesa;
    }

    public void setIdMesa(int idMesa) {
        this.idMesa = idMesa;
    }

    public Juegos getJuego() {
        return juego;
    }

    public void setJuego(Juegos juego) {
        this.juego = juego;
    }

    public int getNumJugadores() {
        return numJugadores;
    }

    public void setNumJugadores(int numJugadores) {
        this.numJugadores = numJugadores;
    }
    
}
