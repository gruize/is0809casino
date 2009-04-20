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
import modelo.GestorJuegosServidor;
import modelo.GestorUsuarios;
import modelo.MensajeJugada;
import java.util.Vector;
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
        chat.start();
        GestorJuegosServidor.getInstance(this).start();
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
     public void enviarMensajeJugada(int id,MensajeJugada mensaje){
       comunicador.enviarMensaje(id,mensaje);
        }
    public int Login(Serializable mensaje){
        Vector<String> datos=(Vector<String>)mensaje;
        int id = GestorUsuarios.getInstancia().hacerLogin(datos.firstElement(), datos.lastElement());
        if(id!=-1){
                GestorUsuarios.getInstancia().agregarJugador(id);
        }
        return id;
    }
    public void mensajeRecibido(int tipo, Serializable mensaje){
        //TODO Este método se invoca cuando se recibe un mensaje
        if (tipo==1){
            MensajeChat mensajeChat = ((MensajeChat)mensaje);
            GestorChatServidor.getInstance(this).dejamensaje(mensajeChat);
            System.out.println(mensajeChat.get_men());
            if(comunicador.enviarMensaje(mensajeChat.get_tio(), mensaje)){
                System.out.println("y devuelto al emisor");
            }}
            else if (tipo==2){
                MensajeJugada  mensajeJugada=((MensajeJugada )mensaje);
                GestorJuegosServidor.getInstance(this).dejamensaje(mensajeJugada);
                //TODO Devolver la confirmacion de la jugada
            }
        }
    

}
