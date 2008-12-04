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
       
        
        /*Casino c = new Casino();              
        int idPartida=c.creaPartidaRuleta();
        Jugador j= new Jugador(1,100);
        c.anadeJugadorAPartida(j,idPartida);
        Jugada jug = new Jugada(1,idPartida,1,33,44);
        c.procesarJugada(jug);*/
        
        Servidor servidor=new Servidor();
        servidor.iniciaServidor();
        
        //esto se creará cada vez que un cliente ejecute su aplicación
        /*// (Cada jugador es un hilo nuevo)
        Hilo hiloCliente=new Hilo();
        hiloCliente.start();*/
        
        
        
    }

}
