/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.LogicaJuegos;

/**
 *
 * @author Administrador
 */
public class Jugador {

    private int id;
    private int saldo;

    public Jugador() {
        id = 0;
        saldo = 0;
    }
    ;

    public Jugador(int i, int s) {
        id = i;
        saldo = s;
    }
    ;

    public Jugador(int i, double s) {
        id = i;
        saldo = (int) s;
    }
    ;

    public Jugador(Jugador j) {
        id = j.getId();
        saldo = j.getSaldo();
    }
    ;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }
}
