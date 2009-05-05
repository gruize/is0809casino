/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo.mensajes;

import java.io.Serializable;

/**
 *
 * @author GabiPC
 */
public class MensajeUsuariosEnMesa implements Serializable{

    private String[] jugadores;
    private int idMesa;

    public MensajeUsuariosEnMesa(String[] jugadores, int idMesa) {
        this.jugadores = jugadores;
        this.idMesa = idMesa;
    }

    public int getIdMesa() {
        return idMesa;
    }

    public void setIdMesa(int idMesa) {
        this.idMesa = idMesa;
    }

    public String[] getJugadores() {
        return jugadores;
    }

    public void setJugadores(String[] jugadores) {
        this.jugadores = jugadores;
    }

    

}
