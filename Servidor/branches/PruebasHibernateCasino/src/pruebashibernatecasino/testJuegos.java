/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pruebashibernatecasino;

import Beans.Juegos;
import Beans.Salas;
import DAO.DAOJuegos;
import java.util.ArrayList;
import java.util.Iterator;

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


    }
    
    private static void insertarJuego(){
        //la sala debe estar creada. 
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
        for (int i = 0; i < lista.size(); i++) {
            Juegos juego = (Juegos) lista.get(i);

            System.out.println("**************  JUEGOS **************");
            System.out.print("Codigo:" + juego.getCodigo() + s);
            System.out.print("Nombre:" + juego.getNombre() + s);
            System.out.print("Jugadores Min:" + juego.getJugadoresmin() + s);
            System.out.print("Reglas:" + juego.getReglas()+ s);
            System.out.print(" Salas: ");
            Iterator it=juego.getSalases().iterator();
            while (it.hasNext()){
                Salas sala=(Salas)it.next();
                System.out.print(sala.getNombre()+s);
            }
            
        }
    }

}
