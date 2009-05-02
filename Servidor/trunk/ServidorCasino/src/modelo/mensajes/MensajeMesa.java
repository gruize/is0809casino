/*
 * Mensaje enviado entre cliente-servidor para entrar o salir de una mesa
 */
package modelo.mensajes;

import java.io.Serializable;

/**
 *
 * @author Chaudhary
 */
public class MensajeMesa implements Serializable {

    private int usuario;//id del usuario que entra/sale de la mesa
    private int mesa;//id de la mesa en
    private int sala;//id de la sala a la que pertenece la mesa

    public MensajeMesa(int usuario, int mesa, int sala) {
        this.usuario = usuario;
        this.mesa = mesa;
        this.sala = sala;
    }

    public int getMesa() {
        return mesa;
    }

    public void setMesa(int mesa) {
        this.mesa = mesa;
    }

    public int getSala() {
        return sala;
    }

    public void setSala(int sala) {
        this.sala = sala;
    }

    public int getUsuario() {
        return usuario;
    }

    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }


}
