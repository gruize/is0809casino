/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo.mensajes;

import java.io.Serializable;
import java.util.Vector;

/**
 *
 * @author GabiPC
 */
public class MensajeUsuariosEnMesa implements Serializable{

    private Vector<String> jugadores;
    private int idMesa;

    public MensajeUsuariosEnMesa(Vector<String> jugadores, int idMesa) {
        this.jugadores = jugadores;
        this.idMesa = idMesa;
    }

    public Vector<String> getJugadores() {
        return jugadores;
    }

    public void setJugadores(Vector<String> jugadores) {
        this.jugadores = jugadores;
    }

    public int getIdMesa() {
        return idMesa;
    }

    public void setIdMesa(int idMesa) {
        this.idMesa = idMesa;
    }   

}
