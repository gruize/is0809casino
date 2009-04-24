/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador;

import comunicaciones.Comunicador;
import java.io.IOException;
import java.io.Serializable;
import modelo.MensajeChat;
import modelo.ModeloCliente;
/**
 *
 * @author david
 */
public class ControladorCliente {


    private Comunicador comunicador;
    private ModeloCliente modelo;

    public ControladorCliente(ModeloCliente model){
        comunicador = new Comunicador(this);
        modelo = model;
    }

    public ModeloCliente getModelo(){
        return modelo;
    }

    public boolean conectar(String usuario,String password) {
         if (comunicador!=null){
            if(comunicador.abreConexion(usuario, password)){
             modelo.setId(comunicador.getIdentificador());
             modelo.setUsuario(usuario);
             return true;
            }
        }
        return false;
    }

    public boolean desconectar() {
        
        //return modelo.desconectar();
        return true;
    }

    public void desconectarCliente() throws IOException{
        //modelo.desconectarCliente();
    }

    public void enviarMensajeChat(String mensaje) {
        MensajeChat mensajeChat = new MensajeChat(modelo.getId(),1,mensaje,modelo.getUsuario());
        comunicador.enviarMensaje(1,mensajeChat);
    }

    public int getNumeroMesas(int sala) {
        //TODO:
        /**
         * Devuelve el numero de mesas existentes en una sala determinada.
         */
        int numeroMesas = 10;
        return numeroMesas;
    }

    public int getNumeroSalas() {
        //Obtiene el  numero de salas existentes en el casino
        return 0;
    }

    public void realizarApuesta(int totalApostado, String valor) {
        //modelo.realizarApuesta(totalApostado,valor);
        //Apuesta apuestaRealizada = new Apuesta(totalApostado,valor);
        //TODO:Enviar la apuesta al servidor
        //apuestaRealizada.imprimir();
    }
    
    public synchronized void mensajeRecibido(int tipo, Serializable mensaje){
        //TODO Este método se invoca cuando se recibe un mensaje
       if (tipo == 1){
            MensajeChat m=(MensajeChat)mensaje;
            modelo.addmensajechat(m);
        }
        else if (tipo == 2) {
           //MensajeJugada
        }

    }

}
