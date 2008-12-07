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
        
        
        		CrearRuleta ruleta1 = new CrearRuleta();
		ruleta1.InicializarRuleta();
		ruleta1.pintarRuleta();
        
        
        
    }

}
