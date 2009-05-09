/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bbdd.pruebasBBDD;

import bbdd.beans.Juegos;

import bbdd.gestorBBDD.GestorBBDDImp;
import bbdd.gestorBBDD.InterfazBBDD;
import java.util.ArrayList;

/**
 *
 * @author Ambrin Chaudhary y Joaquin Lopez
 */
public class testJuegos {

    static InterfazBBDD bbdd = null;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        bbdd = new GestorBBDDImp();

        getJuegos();

    }

    /**
     * Inserta un juego
     */
    private static void insertarJuego() {
     Juegos juego = new Juegos();
        juego.setCodigo(12);
        juego.setNombre("Juego Dados");
        juego.setJugadoresmin(1);
        juego.setReglas("No hay reglas para el juego de los dados");

        bbdd.insertarJuego(juego);


    }

    private static void modificarJuego() {

        Juegos j=bbdd.getJuegoPorCodigo(81);
        //j.setCodigo(10); el código nunca se puede modificar. No da errores, por lo que no avisa.
        j.setJugadoresmin(0);
        j.setReglas("Quito reglas");

        bbdd.modificarJuego(j);

    }

    private static void borrarJuego() {

        bbdd.borrarJuego(bbdd.getJuegoPorCodigo(81));
    }

    /**
     * Obtiene todos los juegos activos del casino
     */
    private static void getJuegos() {

        mostrarDatos(bbdd.getJuegos());
    }



    private static void mostrarDatos(ArrayList lista) {
        String s = "  ";
        System.out.println("**************  JUEGOS **************");
        for (int i = 0; i < lista.size(); i++) {
            Juegos juego = (Juegos) lista.get(i);


            System.out.print("Codigo:" + juego.getCodigo() + s);
            System.out.print("Nombre:" + juego.getNombre() + s);
            System.out.print("Jugadores Min:" + juego.getJugadoresmin() + s);
            System.out.println("Reglas:" + juego.getReglas() + s);

        }
    }
}
