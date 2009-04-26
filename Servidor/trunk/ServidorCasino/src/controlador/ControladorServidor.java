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
import modelo.mensajes.MensajeChat;
import modelo.ModeloServidor;
import modelo.GestorJuegosServidor;
import modelo.GestorUsuarios;
import modelo.mensajes.MensajeJugada;
import java.util.Vector;
import modelo.mensajes.TipoMensaje;
import modelo.mensajes.MensajeMesa;
import modelo.mensajes.MensajeSala;
import org.apache.log4j.Logger;

/**
 *
 * @author Fiutten
 */
public class ControladorServidor {

    private ModeloServidor modelo;
    private Comunicador comunicador;
    private GestorUsuarios usuarios;
    private GestorChatServidor chat;
    //log4j
    private static Logger log = Logger.getLogger(ControladorServidor.class);

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
        comunicador.enviarMensaje(id,1,mensaje);
    }

    /**
     * Envia al cliente un mensaje de Jugada
     * @param id =2
     * @param mensaje objeto MensajeJugada
     */
    public void enviarMensajeJugada(int id,MensajeJugada mensaje){
        comunicador.enviarMensaje(id,2, mensaje);
    }

    /**
     * Envia al cliente un mensaje de  Mesa
     * @param id 3=entrada, 4=salida
     * @param mensaje objeto MensajeMesa
     */
    public void enviarMensajeMesa(int id, MensajeMesa mensaje) {
        comunicador.enviarMensaje(id,3, mensaje);
    }

    /**
     * Recibe el mensaje del cliente. Comprueba el usuario y lo agrega a una mesa
     * @param mensaje vector que contiene el nombre de usuario y contraseña del cliente
     * @return id del usuario (lo recibirá el cliente)
     */
    public int login(Serializable mensaje) {

        Vector<String> datos = (Vector<String>) mensaje;
        int id = GestorUsuarios.getInstancia().hacerLogin(datos.firstElement(), datos.lastElement());

        log.info("ControladorServidor:login: usuario=" + datos.firstElement() + " password=" + datos.lastElement() + " -->id=" + id);

        if (id != -1) {
            //Temporal agrego yo la mesa cuando alguien se loguea
            GestorUsuarios.getInstancia().agregarMesa(1);
            System.out.println("Se crea la mesa 1");
            GestorUsuarios.getInstancia().agregarJugador(id);
            //temporal hasta que haya mensajes de seleccion de mesa van a la mesa 1
            GestorUsuarios.getInstancia().colocarJugador(id, 1);
        }
        modelo.login(datos.firstElement(), datos.lastElement());
        return id;
    }

    public synchronized void mensajeRecibido(int tipo, Serializable mensaje) {
        /*Tipos de mensajes:
         *  1- Mensaje de Chat
         *  2- Mensaje de Jugada o Informacion de Salas y mesas
         *  3- Mensaje de Entrada en mesa
         *  4- Mensaje de Salida de Mesa
         *  5- Cierre de conexión
         *  6- Mensaje de Entrada en Sala
         *  7- Mensaje de Salida de Sala
         */
        if (tipo == TipoMensaje.MENSAJE_CHAT) {
            MensajeChat mensajeChat = ((MensajeChat) mensaje);
            System.out.println("server" + mensajeChat.get_usuario());
            GestorChatServidor.getInstance(this).dejamensaje(mensajeChat);

        } else if (tipo == TipoMensaje.MENSAJE_JUGADA) {
            MensajeJugada mensajeJugada = ((MensajeJugada) mensaje);
            GestorJuegosServidor.getInstance(this).dejamensaje(mensajeJugada);
            //TODO Devolver la confirmacion de la jugada

        } else if (tipo == TipoMensaje.ENTRADA_MESA) {
            /*MensajeJugada mensaje2 = (MensajeJugada) mensaje;
            if (GestorUsuarios.getInstancia().colocarJugador(mensaje2.getUsuario(), mensaje2.getMesa())) //Envio mensaje de  confimacion de la entrada en la mesa
            {
                enviarMensajeJugada(3, mensaje2);//Ambrin: necesito saber en qué mesa se ha insertado el cliente. Quito null y envio mensaje de vuelta
            }*/

            MensajeMesa m=(MensajeMesa)mensaje;
            if (GestorUsuarios.getInstancia().colocarJugador(m.getUsuario(), m.getMesa())) //Envio mensaje de  confimacion de la entrada en la mesa
               enviarMensajeMesa(3, m);//Ambrin: necesito saber en qué mesa se ha insertado el cliente. Quito null y envio mensaje de vuelta


        } else if (tipo == TipoMensaje.SALIDA_MESA) {
            /*MensajeJugada mensaje2 = (MensajeJugada) mensaje;
            GestorUsuarios.getInstancia().eliminarJugador(mensaje2.getUsuario());*/
            MensajeMesa m = (MensajeMesa) mensaje;
            GestorUsuarios.getInstancia().eliminarJugador(m.getUsuario());

        } else if (tipo == TipoMensaje.CERRAR_CONEXION) {
            //TODO cierre de conexion
        } else if (tipo == TipoMensaje.ENTRADA_SALA) {
            //TODO gestion de entrada en sala

            MensajeSala m=(MensajeSala)mensaje;

        } else if (tipo == TipoMensaje.SALIDA_SALA) {
            //TODO gestion de salida de sala
            MensajeSala m=(MensajeSala)mensaje;
        }



    }

}
