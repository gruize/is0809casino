/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

/**
 *
 * @author GabiPC
 */
public class PeticionSala {


    private int idSala;
    private Juegos juego;
    private int numMesas;

    public PeticionSala(int idSala, Juegos juego, int numMesas) {
        this.idSala = idSala;
        this.juego = juego;
        this.numMesas = numMesas;
    }

    public int getIdSala() {
        return idSala;
    }

    public void setIdSala(int idSala) {
        this.idSala = idSala;
    }

    public Juegos getJuego() {
        return juego;
    }

    public void setJuego(Juegos juego) {
        this.juego = juego;
    }

    public int getNumMesas() {
        return numMesas;
    }

    public void setNumMesas(int numMesas) {
        this.numMesas = numMesas;
    }

    
}
