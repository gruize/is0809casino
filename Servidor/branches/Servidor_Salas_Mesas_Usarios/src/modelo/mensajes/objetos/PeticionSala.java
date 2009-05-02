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
public class PeticionSala implements Serializable {


    private int idSala;
    private NombreJuegos juego;
    private int numMesas;

    public PeticionSala(int idSala, NombreJuegos juego, int numMesas) {
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

    public NombreJuegos getJuego() {
        return juego;
    }

    public void setJuego(NombreJuegos juego) {
        this.juego = juego;
    }

    public int getNumMesas() {
        return numMesas;
    }

    public void setNumMesas(int numMesas) {
        this.numMesas = numMesas;
    }


}
