/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servidorcasino;

/**
 *
 * @author Administrador
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        
       
        
        Servidor servidor=new Servidor();
        servidor.iniciaServidor();
        
        //esto se creará cada vez que un cliente ejecute su aplicación
        /*// (Cada jugador es un hilo nuevo)
        Hilo hiloCliente=new Hilo();
        hiloCliente.start();*/
        
        
        
    }

}
