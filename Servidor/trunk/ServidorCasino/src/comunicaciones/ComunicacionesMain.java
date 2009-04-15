/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package comunicaciones;

import controlador.ControladorServidor;
import modelo.ModeloServidor;

/**
 *
 * @author alkaitz
 */
public class ComunicacionesMain {

    public static void main(String[] args) {
       Comunicador c = new Comunicador(new ControladorServidor(new ModeloServidor()));
    }
}
