/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;


import java.io.IOException;
import java.util.Observable;
import comunicaciones.*;

/**
 *
 * @author Fiutten
 */
public class ModeloCliente extends Observable {
    private Comunicador comunicador;
    public ModeloCliente(Comunicador c) {
        comunicador=c;
    }
    public ModeloCliente() {

    }
    public boolean desconectar() {
        //TODO:
        return true;
    }

    public boolean conectar(String usuario,String password) {
        if (comunicador!=null){
            comunicador.abreConexion(usuario, password);
            return true;
        }
        return false;
    }

    public void desconectarCliente() throws IOException{
        //TODO: desconectarCliente;
    }

    public void enviarMensajeChat(String mensaje) {
        
        //TODO: enviarMensaje
        System.out.println(mensaje);
    }

    public void realizarApuesta(int totalApostado, String valor) {
        Apuesta apuestaRealizada = new Apuesta(totalApostado,valor);
        //TODO:Enviar la apuesta al servidor
        apuestaRealizada.imprimir();
    }

    public void setComunicaciones(Comunicador c){

        comunicador=c;
    }

}
