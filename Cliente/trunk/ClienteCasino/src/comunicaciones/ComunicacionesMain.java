/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package comunicaciones;

import controlador.ControladorCliente;
import modelo.ModeloCliente;

/**
 *
 * @author alkaitz
 */
public class ComunicacionesMain {

    public static void main(String[] args) {
       Comunicador c = new Comunicador(new ControladorCliente(new ModeloCliente()));
       c.abreConexion("alberto", "prueba");
       c.enviarMensaje(0,new String("Hola"));
       System.out.println("Se acabó...");
    }
}
