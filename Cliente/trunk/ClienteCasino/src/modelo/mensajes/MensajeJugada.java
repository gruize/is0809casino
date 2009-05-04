/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo.mensajes;
import modelo.Jugada;
import modelo.*;
import java.io.Serializable;
/**
 *
 * @author Administrador
 */
public class MensajeJugada implements Serializable{
    private int usuario;
    private int sala;
    private int mesa;

    public MensajeJugada() {
    }

    public MensajeJugada(MensajeJugada j) {
       this.usuario = j.getUsuario();
       this.sala = j.getSala();
       this.mesa = j.getMesa();
    }

    public MensajeJugada(int usuario, int sala, int mesa) {
        this.usuario = usuario;
        this.sala = sala;
        this.mesa = mesa;
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

    public int getSala() {
        return sala;
    }

    public void setSala(int sala) {
        this.sala = sala;
    }



}


