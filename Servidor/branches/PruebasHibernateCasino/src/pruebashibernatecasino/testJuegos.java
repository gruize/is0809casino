/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pruebashibernatecasino;

import Beans.Juegos;
import DAO.DAOJuegos;
import java.util.ArrayList;


/**
 *
 * @author Chaudhary
 */
public class testJuegos {

     /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        getJuegos();

    }
    
    private static void insertarJuego(){
        DAOJuegos dao=new DAOJuegos();
        
        Juegos juego=new Juegos();
        juego.setCodigo(51);
        juego.setNombre("Juego Ruleta");
        juego.setJugadoresmin(2);
        juego.setReglas("Reglas de la ruleta aún por determinar");
       // juego.setSalases(null);
        
        dao.insertarNuevoJuego(juego);
        
        getJuegos();
        
      
        
        
    }
    
    private static void modificarJuego(){
        
    }
    
    private static void borrarJuego(){
        
    }
    
    /**
     * Obtiene todos los juegos activos del casino
     */
    private static void getJuegos(){
        DAOJuegos dao=new DAOJuegos();
        ArrayList lista=dao.getJuegosCasino();
        mostrarDatos(lista);
    }
   
    /**
     * Obtiene todos los juegos que se están jugando en una determinada sala
     */
    private static void getJuegosporSala(){
      
    }
    
    /**
     * Obtiene todos los juegos que se estén jugando en una mesa (deberá ser único)
     */
    private static void getJuegosPorMesa(){
        
        
    }
    
    
    private static void mostrarDatos(ArrayList lista) {
        String s = "  ";
        System.out.println("**************  JUEGOS **************");
        for (int i = 0; i < lista.size(); i++) {
            Juegos juego = (Juegos) lista.get(i);

           
            System.out.print("Codigo:" + juego.getCodigo() + s);
            System.out.print("Nombre:" + juego.getNombre() + s);
            System.out.print("Jugadores Min:" + juego.getJugadoresmin() + s);
            System.out.print("Reglas:" + juego.getReglas()+ s);
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
