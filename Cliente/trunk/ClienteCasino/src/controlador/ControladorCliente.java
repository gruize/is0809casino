/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador;

import java.io.IOException;
import java.io.Serializable;
import modelo.ModeloCliente;
import vista.VistaCliente;
import vista.VistaLogin;
/**
 *
 * @author david
 */
public class ControladorCliente {

    private ModeloCliente modelo;
    private VistaLogin vistalogin;
    private VistaCliente vistajugar;

    public ControladorCliente(ModeloCliente modelocliente){
        modelo = modelocliente;
        vistalogin =new VistaLogin(this);
        
    }

    public boolean conectar(String usuario,String password) {
        if(modelo.conectar(usuario,password)){
            vistalogin.dispose();
            vistajugar = new VistaCliente(this);
            return true;
        }
        return false;
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
