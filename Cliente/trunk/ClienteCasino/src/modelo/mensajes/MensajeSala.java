/*
 * Mensaje enviado entre cliente-servidor para entrar-salir de una sala
 */

package modelo.mensajes;

import java.io.Serializable;

/**
 *
 * @author Chaudhary
 */
public class MensajeSala implements Serializable{

    private int usuario;//id del usuario
    private int sala;//id de la sala

    public MensajeSala(int usuario, int sala) {
        this.usuario = usuario;
        this.sala = sala;
    }

    public int getSala() {
        return sala;
    }

    public int getUsuario() {
        return usuario;
    }

    public void setSala(int sala) {
        this.sala = sala;
    }

    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }
    

}
