/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package casino;

/**
 *
 * @author Administrador
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Jugador j= new Jugador(1,100);
        PartidaBJ p=new PartidaBJ(j,666);
        Casino c = new Casino();
        c.nuevaPartidaBJ(p);
        Jugada jug = new Jugada(1,666,1,33);
        c.nuevajugada(jug);
        
    }

}