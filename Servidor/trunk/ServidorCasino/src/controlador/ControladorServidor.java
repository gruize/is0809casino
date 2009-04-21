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
import modelo.LogicaJuegos.logicaRuleta.GestorSalas;
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
        GestorUsuarios usuarios = new GestorUsuarios();
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
    public int Login(Serializable mensaje){
        Vector<String> datos=(Vector<String>)mensaje;
        int id = GestorUsuarios.getInstancia().hacerLogin(datos.firstElement(), datos.lastElement());
        if(id!=-1){
                GestorUsuarios.getInstancia().agregarJugador(id);
                //temporal hasta que haya mensajes de seleccion de mesa van a la mesa 1
                GestorUsuarios.getInstancia().colocarJugador(id, 1);
        }
        return id;
    }
    public synchronized void mensajeRecibido(int tipo, Serializable mensaje){
        /*Tipos de mensajes:
         *  1- Mensaje de Char
         *  2- Mensaje de Jugada o Informacion de Salas y mesas
         *  3- Mensaje de Entrada o salida de mesa
         * */
        if (tipo==1){
            MensajeChat mensajeChat = ((MensajeChat)mensaje);
            GestorChatServidor.getInstance(this).dejamensaje(mensajeChat);
        }
            else if (tipo==2){
                MensajeJugada  mensajeJugada=((MensajeJugada )mensaje);
                GestorJuegosServidor.getInstance(this).dejamensaje(mensajeJugada);
                //TODO Devolver la confirmacion de la jugada
            }
            else if (tipo==3){
                MensajeJugada mensaje2= (MensajeJugada)mensaje;
                int saldo=100;
                //TODO Sacar el saldo de la base de DAtos.Y obtener la sala
                GestorSalas.getInstance(this).addJugador(1, mensaje2.getMesa(),mensaje2.getUsuario(),saldo);
            }
        }
    

}
