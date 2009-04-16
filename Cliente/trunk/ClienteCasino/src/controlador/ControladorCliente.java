/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador;

import java.io.IOException;
import java.io.Serializable;
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

    public boolean conectar(String usuario,String password) {
        return modelo.conectar(usuario,password);

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
    
    public void mensajeRecibido(int tipo, Serializable mensaje){
        //TODO Este método se invoca cuando se recibe un mensaje
    }

}
