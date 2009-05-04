/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bbdd.pruebasBBDD;

import bbdd.beans.Salas;
import java.util.ArrayList;

import bbdd.gestorBBDD.GestorBBDDImp;
import bbdd.gestorBBDD.InterfazBBDD;

/**
 *
 * @author Ambrin Chaudhary y Joaquin Lopez
 */
public class testSalas {

    static InterfazBBDD bbdd = null;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        bbdd = new GestorBBDDImp();

       //borrarSala();
        getSalas();

    }

    private static void borrarSala() {
        bbdd.borrarSala(bbdd.getSalaPorCodigo(1));
        bbdd.borrarSala(bbdd.getSalaPorCodigo(2));
        bbdd.borrarSala(bbdd.getSalaPorCodigo(3));
        bbdd.borrarSala(bbdd.getSalaPorCodigo(4));
    }

    private static void getSalas() {

        mostrarDatos(bbdd.getSalas());

    }

    private static void insertarSala() {

        Salas sala = new Salas();
        sala.setCodigo(18);
        sala.setJuegos(bbdd.getJuegoPorCodigo(51));
        sala.setNombre("Sala de prueba");

        bbdd.insertarSala(sala);

    }

    private static void modificarSala() {

        Salas s = bbdd.getSalaPorCodigo(18);

        s.setNombre("cambio nombre");
        s.setJuegos(bbdd.getJuegoPorCodigo(81));

        bbdd.modificarSala(s);


    }

    private static void mostrarDatos(ArrayList lista) {
        String s = "  ";
        System.out.println("**************  SALAS **************");
        for (int i = 0; i < lista.size(); i++) {
            Salas sala = (Salas) lista.get(i);


            System.out.print("Codigo:" + sala.getCodigo() + s);
            System.out.print("Juegos:" + sala.getJuegos().getCodigo() + s);
            System.out.println("Nombre:" + sala.getNombre() + s);


        }
    }
}
