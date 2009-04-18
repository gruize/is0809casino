/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador;

import java.io.IOException;
import java.io.Serializable;
import comunicaciones.*;
import modelo.*;
/**
 *
 * @author david
 */
public class ControladorCliente {


    private Comunicador comunicador;

    private Jugador jugador;

    public ControladorCliente(){        
        comunicador = new Comunicador(this); 
    }

    public boolean conectar(String usuario,String password) {
         if (comunicador!=null){
            if(comunicador.abreConexion(usuario, password)){
                jugador= new Jugador();
                jugador.setId(comunicador.getIdentificador());
                jugador.setMes(1);
                jugador.setSala(1);
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
        MensajeChat mensajeChat = new MensajeChat(jugador.getId(),1,mensaje);
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
    
    public void mensajeRecibido(int tipo, Serializable mensaje){
        //TODO Este método se invoca cuando se recibe un mensaje
    }

}
