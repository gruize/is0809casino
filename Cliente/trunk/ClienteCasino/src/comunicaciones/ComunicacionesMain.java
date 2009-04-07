/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package comunicaciones;

/**
 *
 * @author alkaitz
 */
public class ComunicacionesMain {

    public static void main(String[] args) {
       Comunicador c = new Comunicador();
       c.enviarMensaje(0, new String("Hola"));
    }
}
