/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;

/**
 * De momento representa una jugada de Ruleta. Debería ser una clase abstracta...
 * @author Administrador
 */
public class Jugada implements Serializable{

    private int usuario;
    private int mesa;
    //tipo de apuesta:Numero,Color,ParImpar, Docena, Linea,FaltaPasa....
    private String tipo;
    //Casilla donde se apuesta: al 21, al Rojo , a la 2º Docena,Falta, Par ...
    private int casilla;
    //Cantidad a postada
    private int cantidad;

    public Jugada(int usuario, int mesa, String tipo, int casilla, int cantidad) {
        this.usuario = usuario;
        this.mesa = mesa;
        this.tipo = tipo;
        this.casilla = casilla;
        this.cantidad = cantidad;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getCasilla() {
        return casilla;
    }

    public void setCasilla(int casilla) {
        this.casilla = casilla;
    }

    public int getMesa() {
        return mesa;
    }

    public void setMesa(int mesa) {
        this.mesa = mesa;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getUsuario() {
        return usuario;
    }

    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }


}