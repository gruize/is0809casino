/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bbdd.pruebasBBDD;

import bbdd.beans.Mesas;
import java.util.ArrayList;

import bbdd.gestorBBDD.GestorBBDDImp;
import bbdd.gestorBBDD.InterfazBBDD;

/**
 *
 * @author Ambrin Chaudhary y Joaquin Lopez
 */
public class testMesas {

    static InterfazBBDD bbdd = null;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        bbdd = new GestorBBDDImp();
        // borrarMesa();

        getMesas();

    }

    private static void borrarMesa() {
        
        bbdd.borrarMesa(bbdd.getMesa(100));
    }

    private static void getMesas() {
        
        mostrarDatos(bbdd.getMesas());

    }

    private static void insertarMesa() {


        Mesas mesa = new Mesas();
        mesa.setCodigo(100);
        mesa.setSalas(bbdd.getSalaPorCodigo(41));
        mesa.setPuestos(0);
        mesa.setJugadores(1);
        mesa.setApuestamin(1);
        mesa.setApuestamax(20.55);

        bbdd.insertarMesa(mesa);
        
    }

    private static void modificarMesa() {
        

        Mesas mesa = bbdd.getMesa(100);
        mesa.setApuestamin(100.00); //TODO cómo controlamos que la apuesta min < apuesta max?

        mesa.setJugadores(5);

        bbdd.modificarMesa(mesa);
    }

    private static void mostrarDatos(ArrayList lista) {
        String s = "  ";
        System.out.println("**************  MESAS **************");
        for (int i = 0; i < lista.size(); i++) {
            Mesas mesa = (Mesas) lista.get(i);


            System.out.print("Codigo:" + mesa.getCodigo() + s);
            System.out.print("Sala:" + mesa.getSalas().getCodigo() + s);
            System.out.print("Puestos:" + mesa.getPuestos() + s);
            System.out.print("Jugadores:" + mesa.getJugadores() + s);
            System.out.print("Apuesta minima:" + mesa.getApuestamin() + s);
            System.out.println("Apuesta maxima:" + mesa.getApuestamax() + s);


        }
    }
}
