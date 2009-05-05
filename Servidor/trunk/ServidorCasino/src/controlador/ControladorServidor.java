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
import modelo.GestorSalas;
import modelo.mensajes.MensajeEstadoRuleta;
import modelo.mensajes.MensajeInfoCliente;
import modelo.mensajes.MensajeInfoMesas;
import modelo.mensajes.MensajeInfoSalas;
import modelo.mensajes.TipoMensaje;
import modelo.mensajes.MensajeMesa;
import modelo.mensajes.MensajeSala;
import modelo.mensajes.objetos.PeticionMesa;
import modelo.mensajes.objetos.PeticionSala;
import org.apache.log4j.Logger;

/**
 *
 * @author Fiutten
 */
public class ControladorServidor {

    private ModeloServidor modelo;
    private Comunicador comunicador;
    private GestorUsuarios usuarios;
    private GestorSalas salas;
    private GestorChatServidor chat;
    //log4j
    private static Logger log = Logger.getLogger(ControladorServidor.class);

    public ControladorServidor(ModeloServidor modeloServidor) {
        modelo = modeloServidor;
        comunicador = new Comunicador(this);
        chat = new GestorChatServidor(this);
        usuarios = GestorUsuarios.getInstancia(this);
        salas = GestorSalas.getInstance(this);
        chat.start();
        GestorJuegosServidor.getInstance(this).start();
    }

    public void inicializar() {
        salas.crearSala(1, "Ruleta 1");
        salas.crearSala(2, "Ruleta 2");
        salas.crearSala(3, "Ruleta 3");
        salas.crearSala(4, "Dados 1");
        log.info("ControladorServidor : constructora : se  han creado 4 salas");
    }

    public void crearMesas(int codigoMesa, String nombreJuego) {
        modelo.crearMesas(codigoMesa,nombreJuego);
    }

    public void crearSalas(int codigoSala, String nombreSala) {
        modelo.crearSala(codigoSala,nombreSala);
    }

    public void borrarSala(int sala) {
        modelo.borrarSala(sala);
    }

    public void borrarMesa(int mesa) {
        modelo.borrarMesa(mesa);
    }


    public void cerrarConexion() throws IOException {
        modelo.cerrarConexion();
        GestorSalas.getInstance(this).borrarSalas();
    }

    public void expulsarJugador(String jugador) {
        modelo.expulsarJugador(jugador);
    }

    public void jugadorDesconectado(int identificador){
        // TODO Realizar las tareas pertinentes en la
        // desconexión del jugador 
    }
    public DefaultListModel getListaUsuarios() {
        return usuarios.getUsuarios();
    }

    public DefaultListModel getListaMesas() {
        return modelo.getListaMesas();
    }

    public DefaultListModel getListaConectados() {
        return modelo.getListaConectados();
    }

    public DefaultListModel getListaSalas() {
        return modelo.getListaSalas();
    }

    public boolean servidorConectado() {
        return modelo.servidorConectado();
    }

    public void verEstadisticas(String usuario) {
        modelo.verEstadisticas(usuario);
    }

    /**
     * Obtiene las salas actuales del casino y se las envÃƒÂ­a al cliente
     * @param idUsuario usuario que acaba de logearse, y recibirÃƒÂ¡ la info de las salas del casino
     */
    public void enviarSalasCasino(int idUsuario) {

        Vector<PeticionSala> salasCasino = GestorSalas.getInstance(this).getInfoSalas();
        System.out.println("Salas:"+salasCasino.toString());
        MensajeInfoSalas mensaje = new MensajeInfoSalas(idUsuario,salasCasino);
        enviarMensajeInfoSalas(idUsuario, mensaje);
        log.info("ControladorServidor : enviarSalasCasino : info de salas enviado al cliente "+idUsuario+". Total salas abiertas "+salasCasino.size());
    }

    /**
     * Obtiene las mesas que hay actualmente en una sala del casino, y se las envia al cliente
     * @param idUsuario usuario que acaba de entrar en una sala, y recibirÃƒÂ¡ la info
     *        de las mesas que hay en ella
     * @param idSala identificador de la sala en la que acaba de entrar
     */
    public void enviarMesasDeUnaSala(int idUsuario, int idSala) {

        Vector<PeticionMesa> mesas = GestorSalas.getInstance(this).getMesas(idSala).getInfoMesas();
        MensajeInfoMesas mensaje = new MensajeInfoMesas(idUsuario,idSala,mesas);
        enviarMensajeInfoMesas(idUsuario, mensaje);
        log.info("ControladorServidor : enviarMesasDeUnaSala : info de mesas de la sala="+idSala+" enviado al cliente "+idUsuario+". Total mesas abiertas "+mesas.size());
    }
    //==================================================================================
    //          ENVIO DE MENSAJES A LOS CLIENTES
    //==================================================================================

    /**
     *
     * @param id identificador del usuario
     * @param mensaje objeto MensajeChat
     */
    public void enviarMensajeChat(int id, MensajeChat mensaje) {
        comunicador.enviarMensaje(id, TipoMensaje.MENSAJE_CHAT, mensaje);
    }

    /**
     * Envia al cliente un mensaje de Jugada
     * @param id identificador del usuario
     * @param mensaje objeto MensajeJugada
     */
    public void enviarMensajeJugada(int id, MensajeJugada mensaje) {
        comunicador.enviarMensaje(id, TipoMensaje.MENSAJE_JUGADA, mensaje);
    }

    /**
     * Envia al cliente un mensaje de  Mesa
     * @param id 3=entrada, 4=salida
     * @param mensaje objeto MensajeMesa
     */
    public void enviarMensajeMesa(int id, MensajeMesa mensaje) {
        comunicador.enviarMensaje(id, TipoMensaje.ENTRADA_MESA, mensaje);
    //no se enviaran las salidas de mesa
    }

    public void enviarMensajeSala(int id, MensajeSala mensaje) {
        comunicador.enviarMensaje(id, TipoMensaje.ENTRADA_SALA, mensaje);
    //no se enviaran las salidas de sala
    }

    /**
     * Envia al cliente un mensaje con la informacion de todas las salas abiertas en el casino
     * @param idUsuario identificador de usuario a quien va dirigido el mensaje
     * @param mensaje
     */
    public void enviarMensajeInfoSalas(int idUsuario, MensajeInfoSalas mensaje) {
        comunicador.enviarMensaje(idUsuario, TipoMensaje.INFO_SALAS, mensaje);

    }

    /**
     * Parar y arrancar la ruleta
     * @param idUsuario
     * @param mensaje
     */
    public void enviarMensajeEstadoRuleta(int idUsuario, MensajeEstadoRuleta mensaje){

        comunicador.enviarMensaje(idUsuario, TipoMensaje.ESTADO_RULETA, mensaje);
    }

    /**
     * Cuando hay que enviarle al cliente su propia informacion:
     * - Al principio, cuando se logea, para tener su login y saldo
     * - Siempre que se actualicen saldos tras una partida
     * @param idUsuario
     * @param mensaje
     */
    public void enviarMensajeInfoCliente(int idUsuario, MensajeInfoCliente mensaje){
        comunicador.enviarMensaje(idUsuario, TipoMensaje.INFO_CLIENTE, mensaje);
    }
    /**
     * Envia al cliente un mensaje con la informacion de todas las mesas abiertas en una sala
     * @param idUsuario identificador de usuario a quien va dirigido el mensaje
     * @param mensaje
     */
    public void enviarMensajeInfoMesas(int idUsuario, MensajeInfoMesas mensaje) {
        comunicador.enviarMensaje(idUsuario, TipoMensaje.INFO_MESAS, mensaje);
        System.out.println("ControladorServidor: info de mesas enviado");

    }

    //==================================================================================
    //          RECEPCION DE MENSAJES DE LOS CLIENTES
    //==================================================================================
    /**
     * Recibe el mensaje del cliente. Comprueba el usuario y lo agrega a una mesa
     * @param mensaje vector que contiene el nombre de usuario y contraseÃƒÂ±a del cliente
     * @return id del usuario (lo recibirÃƒÂ¡ el cliente)
     */
    public int login(Serializable mensaje) {

        Vector<String> datos = (Vector<String>) mensaje;
        int id = GestorUsuarios.getInstancia(this).hacerLogin(datos.firstElement(), datos.lastElement());

        log.info("ControladorServidor : login : usuario=" + datos.firstElement() + " password=" + datos.lastElement() + " -->id=" + id);

        modelo.login(datos.firstElement(), datos.lastElement());

        //EnvÃƒÂ­o la informaciÃƒÂ³n de todas las salas del casino

        //*********************************************************

       // enviarSalasCasino(id);

        return id;
    }

    /**
     * Resto de mensajes que recibe del cliente
     * @param tipo
     * @param mensaje
     */
    public synchronized void mensajeRecibido(int tipo, Serializable mensaje) {

        System.out.println("ControladorServidor : mensajeRecibido : tipo=" + tipo + " mensaje=" + mensaje);
        log.info("ControladorServidor : mensajeRecibido : tipo=" + tipo + " mensaje=" + mensaje);
        /*Tipos de mensajes:
         *  1- Mensaje de Chat
         *  2- Mensaje de Jugada o Informacion de Salas y mesas
         *  3- Mensaje de Entrada en mesa
         *  4- Mensaje de Salida de Mesa
         *  5- Cierre de conexiÃƒÂ³n
         *  6- Mensaje de Entrada en Sala
         *  7- Mensaje de Salida de Sala
         *
         */
        if (tipo == TipoMensaje.MENSAJE_CHAT) {
            MensajeChat mensajeChat = ((MensajeChat) mensaje);
            System.out.println("server " + mensajeChat.get_usuario());
            chat.dejamensaje(mensajeChat);

        } else if (tipo == TipoMensaje.MENSAJE_JUGADA) {
            MensajeJugada mensajeJugada = ((MensajeJugada) mensaje);
            GestorJuegosServidor.getInstance(this).dejamensaje(mensajeJugada);
        //TODO Devolver la confirmacion de la jugada

        } else if (tipo == TipoMensaje.ENTRADA_MESA) {

            MensajeMesa m = (MensajeMesa) mensaje;
            if (usuarios.insertarJugadorEnMesa(m.getUsuario(), m.getMesa())) //Envio mensaje de  confimacion de la entrada en la mesa
            {
                enviarMensajeMesa(m.getUsuario(), m);//necesito saber en quÃƒÂ© mesa se ha insertado el cliente. Quito null y envio mensaje de vuelta
            } else {
                enviarMensajeMesa(m.getUsuario(), m);//TODO mirar porque devuelve false
            }
        } else if (tipo == TipoMensaje.SALIDA_MESA) {
            MensajeMesa m = (MensajeMesa) mensaje;
            usuarios.eliminarJugadorEnMesa(m.getUsuario());
        } else if (tipo == TipoMensaje.CERRAR_CONEXION) {
        } else if (tipo == TipoMensaje.SALIDA_SALA) {
            MensajeSala m = (MensajeSala) mensaje;
            usuarios.eliminarJugadorEnSala(m.getUsuario());
        } else if (tipo == TipoMensaje.INFO_SALAS) {
            MensajeInfoSalas m = (MensajeInfoSalas)mensaje;
            enviarSalasCasino(m.getId());
        } else if (tipo == TipoMensaje.INFO_MESAS) {
            MensajeInfoMesas m = (MensajeInfoMesas)mensaje;
            enviarMesasDeUnaSala(m.getId(),m.getSala());
        }
    }
}
