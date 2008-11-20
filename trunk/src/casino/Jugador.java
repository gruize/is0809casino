/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package casino;

/**
 *
 * @author Administrador
 */
public class Jugador {
    int id;
    int saldo;
    public Jugador(){id=0;saldo=0;};
    public Jugador (int i,int s){id=i;saldo=s;};
public Jugador (Jugador j){id=j.id;saldo=j.saldo;};
}
