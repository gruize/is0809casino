/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bbdd.pruebasBBDD;

import bbdd.beans.Partidas;
import java.util.ArrayList;

import bbdd.gestorBBDD.GestorBBDDImp;
import bbdd.gestorBBDD.InterfazBBDD;

/**
 *
 * @author Ambrin Chaudhary y Joaquin Lopez
 */
public class testPartidas {

    static InterfazBBDD bbdd = null;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    
        bbdd = new GestorBBDDImp();
        //borrarPartida();

        getPartidas();

    }

    private static void borrarPartida() {
        bbdd.borrarPartida(bbdd.getPartida(70));

    }

    private static void getPartidas() {
      
        mostrarDatos(bbdd.getPartidas());
    }

    private static void insertarPartida() {
        Partidas partida = new Partidas();
        partida.setCodigo(70);
        partida.setMesas(bbdd.getMesa(31)); //si no existe la mesa --> org.hibernate.TransactionException

        partida.setNumjugadores(10);

       bbdd.insertarPartida(partida);


    }

    private static void modificarPartida() {

       
        Partidas p = bbdd.getPartida(70);

        p.setNumjugadores(5);
        p.setGanador(6); // no referencia a ningun jugador ... ¿no debería?

        bbdd.modificarPartida(p);
    }

    private static void mostrarDatos(ArrayList lista) {
        String s = "  ";
        System.out.println("**************  PARTIDAS **************");
        for (int i = 0; i < lista.size(); i++) {
            Partidas p = (Partidas) lista.get(i);


            System.out.print("Codigo:" + p.getCodigo() + s);
            System.out.print("Mesa:" + p.getMesas().getCodigo() + s);
            System.out.print("NumJugadores:" + p.getNumjugadores() + s);
            System.out.println("Ganador:" + p.getGanador() + s);


        }
    }
}
