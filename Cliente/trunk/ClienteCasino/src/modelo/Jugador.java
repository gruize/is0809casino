/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

/**
 *
 * @author Fiutten
 */
public class Jugador {

    private int id;
    private int sala;
    private int mesa;

    public Jugador() {
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

    public void setId(int ID) {
        id = ID;
    }

    public void setSala(int sal) {
        sala = sal;
    }

    public void setMes(int mes) {
        mesa = mes;
    }
    
}
