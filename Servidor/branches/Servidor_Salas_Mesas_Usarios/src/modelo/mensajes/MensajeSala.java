/*
 * Mensaje enviado entre cliente-servidor para entrar-salir de una sala
 */

package modelo.mensajes;

import java.io.Serializable;
import modelo.mensajes.objetos.PeticionSala;

/**
 *
 * @author Chaudhary
 */
public class MensajeSala implements Serializable{

    private int usuario;//id del usuario
    private int sala;//id de la sala
    private PeticionSala peticionSala; //solo lo recibirá cuando el servidor le mande todas las salas que hay


    public MensajeSala(int usuario, int sala) {
        this.usuario = usuario;
        this.sala = sala;
    }

        public MensajeSala(int usuario, int sala, PeticionSala p) {
        this.usuario = usuario;
        this.sala = sala;
        this.peticionSala=p;
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

        public PeticionSala getPeticionSala() {
        return peticionSala;
    }

    public void setPeticionSala(PeticionSala peticionSala) {
        this.peticionSala = peticionSala;
    }

}
