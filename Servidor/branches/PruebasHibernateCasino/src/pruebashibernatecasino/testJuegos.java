/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebashibernatecasino;

import Beans.Juegos;

import GestorBBDD.GestorBBDDImp;
import GestorBBDD.InterfazBBDD;
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

        borrarJuego();
        getJuegos();

    }

    /**
     * Inserta un juego
     */
    private static void insertarJuego() {
       // DAOJuegos dao = new DAOJuegos();

        Juegos juego = new Juegos();
        juego.setCodigo(81);
        juego.setNombre("Juego Prueba");
        juego.setJugadoresmin(2);
        juego.setReglas("No hay reglas");
        
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
        /* System.out.print(" Salas: ");
        Iterator it=juego.getSalases().iterator();
        while (it.hasNext()){
        Salas sala=(Salas)it.next();
        System.out.print(sala.getNombre()+s);
        }
         */

        /* Ha saltado esta excepcion
         * 
         * Exception in thread "main" org.hibernate.LazyInitializationException: failed to lazily initialize a collection of role: Beans.Juegos.salases, no session or session was closed
        at org.hibernate.collection.AbstractPersistentCollection.throwLazyInitializationException(AbstractPersistentCollection.java:358)
        at org.hibernate.collection.AbstractPersistentCollection.throwLazyInitializationExceptionIfNotConnected(AbstractPersistentCollection.java:350)
        at org.hibernate.collection.AbstractPersistentCollection.initialize(AbstractPersistentCollection.java:343)
        at org.hibernate.collection.AbstractPersistentCollection.read(AbstractPersistentCollection.java:86)
        at org.hibernate.collection.PersistentSet.iterator(PersistentSet.java:163)
        at pruebashibernatecasino.testJuegos.mostrarDatos(testJuegos.java:90)
        at pruebashibernatecasino.testJuegos.getJuegos(testJuegos.java:59)
        at pruebashibernatecasino.testJuegos.insertarJuego(testJuegos.java:42)
        at pruebashibernatecasino.testJuegos.main(testJuegos.java:26)
        
         * 
         */
        }
    }
}
