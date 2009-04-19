/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import java.util.Observable;

/**
 *
 * @author david
 */
public class Modelo extends Observable{

    private String chat;
    private String usuario;

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void modelo(){
        chat = "";
    }

    public void addmensajechat(String mensaje){
        chat = mensaje;
        setChanged();
        notifyObservers();
    }

    public String getmensajechat(){
        return chat;
    }

    public void ponerapuesta(){

    }

    public void quitarapuesta(){

    }
}
