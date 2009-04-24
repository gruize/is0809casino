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
    private GestorUsuarios usuarios;
    private GestorChatServidor chat;

    public ControladorServidor(ModeloServidor modeloServidor) {
        modelo = modeloServidor;
        comunicador = new Comunicador(this);
        chat = new GestorChatServidor(this);
        chat.start();
        usuarios = new GestorUsuarios();
        //Creamos de momento una mesa 1 por defecto
        usuarios.agregarMesa(1);
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

    public int login(Serializable mensaje){
        Vector<String> datos=(Vector<String>)mensaje;
        int id = GestorUsuarios.getInstancia().hacerLogin(datos.firstElement(), datos.lastElement());
        if(id!=-1){
                //Temporal agrego yo la mesa cuando alguien se loguea
                GestorUsuarios.getInstancia().agregarMesa(1);
                System.out.println("Se crea la mesa 1");
                GestorUsuarios.getInstancia().agregarJugador(id);
                //temporal hasta que haya mensajes de seleccion de mesa van a la mesa 1
                GestorUsuarios.getInstancia().colocarJugador(id, 1);
        }
        modelo.login(datos.firstElement(),datos.lastElement());
        return id;
    }
    public synchronized void mensajeRecibido(int tipo, Serializable mensaje){
        /*Tipos de mensajes:
         *  1- Mensaje de Chat
         *  2- Mensaje de Jugada o Informacion de Salas y mesas
         *  3- Mensaje de Entrada en mesa
         *  4- Mensaje de Salida de Mesa
         * */
        if (tipo==1){
            MensajeChat mensajeChat = ((MensajeChat)mensaje);
            System.out.println("server"+mensajeChat.get_usuario());
            GestorChatServidor.getInstance(this).dejamensaje(mensajeChat);
        }
            else if (tipo==2){
                MensajeJugada  mensajeJugada=((MensajeJugada )mensaje);
                GestorJuegosServidor.getInstance(this).dejamensaje(mensajeJugada);
                //TODO Devolver la confirmacion de la jugada
            }
            else if (tipo==3){
                MensajeJugada mensaje2= (MensajeJugada)mensaje;
                if (GestorUsuarios.getInstancia().colocarJugador(mensaje2.getUsuario(),mensaje2.getMesa()))
                        //Envio mensaje de  confimacion de la entrada en la mesa
                        enviarMensajeJugada(3,null);
                }
                else if (tipo==4){
                MensajeJugada mensaje2= (MensajeJugada)mensaje;
                GestorUsuarios.getInstancia().eliminarJugador(mensaje2.getUsuario());
                        
                }
        }
    

}
