/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;
import java.io.Serializable;
/**
 * Mensaje que se genera tanto para jugadas como para entrar o salir de una mesa o sala
 * 
 * @author Administrador
 */
public class MensajeJugada implements Serializable{
    private int usuario;
    private int mesa;
    private Jugada jugada;

    MensajeJugada(MensajeJugada j) {
       this.usuario = j.usuario;
        this.mesa = j.mesa;
        this.jugada = j.jugada;
    }

    public MensajeJugada(int usuario, int mesa, Jugada jugada) {
        this.usuario = usuario;
        this.mesa = mesa;
        this.jugada = jugada;
    }

    public Jugada getJugada() {
        return jugada;
    }

    public void setJugada(Jugada jugada) {
        this.jugada = jugada;
    }

    public int getMesa() {
        return mesa;
    }

    public void setMesa(int mesa) {
        this.mesa = mesa;
    }

    public int getUsuario() {
        return usuario;
    }

    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }

}

