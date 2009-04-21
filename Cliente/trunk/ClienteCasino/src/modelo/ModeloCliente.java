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
public class ModeloCliente extends Observable{

    private MensajeChat chat;
    private String usuario;
    private int id;
    private int sala;
    private int mesa;

    public void modelo(){
        chat = null;
        id = 0;
        sala = 0;
        mesa = 0;
    }

    public int getId() {
        return id;
    }

    public int getSala() {
        return sala;
    }

    public int getMesa() {
        return mesa;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setId(int ID) {
        id = ID;
    }

    public void setSala(int sal) {
        sala = sal;
    }

    public void setMesa(int mes) {
        mesa = mes;
    }
    
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void addmensajechat(MensajeChat mensaje){
        chat = mensaje;
        setChanged();
        notifyObservers();
    }

    public MensajeChat getmensajechat(){
        return chat;
    }

    public void ponerapuesta(){

    }

    public void quitarapuesta(){

    }
}
