/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador;

import java.awt.Label;
import java.io.IOException;
import modelo.ModeloCliente;
/**
 *
 * @author david
 */
public class ControladorCliente {

    private ModeloCliente modelo;

    public ControladorCliente(ModeloCliente modelocliente){
        modelo = modelocliente;
    }

    public boolean desconectar() {
        return modelo.desconectar();
    }

    public void desconectarCliente() throws IOException{
        modelo.desconectarCliente();
    }

    public void enviarMensajeChat(String mensaje) {
        modelo.enviarMensajeChat(mensaje);
    }

    public void realizarApuesta(int totalApostado, String valor) {
        modelo.realizarApuesta(totalApostado,valor);
    }

}
