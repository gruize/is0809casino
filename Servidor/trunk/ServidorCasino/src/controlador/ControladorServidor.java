/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador;

import comunicaciones.Comunicador;
import java.io.IOException;
import java.io.Serializable;
import javax.swing.DefaultListModel;
import modelo.GestorChatServidor;
import modelo.MensajeChat;
import modelo.ModeloServidor; 

/**
 *
 * @author Fiutten
 */
public class ControladorServidor {

    private ModeloServidor modelo;
    private Comunicador comunicador;

    public ControladorServidor(ModeloServidor modeloServidor) {
        modelo = modeloServidor;
        comunicador = new Comunicador(this);
        GestorChatServidor chat = new GestorChatServidor(this);
        chat.run();
    }

    public void cerrarConexion() throws IOException {
        modelo.cerrarConexion();
    }

    public void expulsarJugador(String jugador) {
        modelo.expulsarJugador(jugador);
    }

    public DefaultListModel getListaConectados() {
        return modelo.getListaConectados();
    }

    public DefaultListModel getListaMesas() {
        return modelo.getListaMesas();
    }

    public DefaultListModel getListaJugadores() {
        return modelo.getListaJugadores();
    }

    public DefaultListModel getListaSalas() {
        return modelo.getListaSalas();
    }

    public void mostrarJugadoresAsociados(String mesa) {
        modelo.mostrarJugadoresAsociados(mesa);
    }

    public void mostrarMesasAsociadas(String sala) {
        modelo.mostrarMesasAsociadas(sala);
    }

    public boolean servidorConectado() {
        return modelo.servidorConectado();
    }

    public void verEstadisticas(String usuario) {
        modelo.verEstadisticas(usuario);
    }
     public void enviarMensajeChat(int id,MensajeChat mensaje) {
        comunicador.enviarMensaje(id,mensaje);
    }

    public void mensajeRecibido(int tipo, Serializable mensaje){
        //TODO Este método se invoca cuando se recibe un mensaje
        if (tipo==1){
            MensajeChat mensajeChat = ((MensajeChat)mensaje);
            GestorChatServidor.getInstance(this).dejamensaje(mensajeChat);
            System.out.println(mensajeChat.get_men());
            if(comunicador.enviarMensaje(mensajeChat.get_tio(), mensaje)){
                System.out.println("y devuelto al emisor");
            }
        }
    }

}
