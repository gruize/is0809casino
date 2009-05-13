/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import bbdd.beans.Clientes;
import comunicaciones.Comunicador;
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
import modelo.mensajes.MensajeExpulsion;
import modelo.mensajes.MensajeInfoCliente;
import modelo.mensajes.MensajeInfoMesas;
import modelo.mensajes.MensajeInfoSalas;
import modelo.mensajes.TipoMensaje;
import modelo.mensajes.MensajeMesa;
import modelo.mensajes.MensajeSala;
import modelo.mensajes.MensajeUsuariosEnMesa;
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
        modelo.crearMesas(codigoMesa, nombreJuego);
    }

    public void crearSalas(int codigoSala, String nombreSala) {
        modelo.crearSala(codigoSala, nombreSala);
    }

    public void borrarSala(int sala) {
        modelo.borrarSala(sala);
    }

    public void borrarMesa(int mesa) {
        modelo.borrarMesa(mesa);
    }

    public void cerrarConexion() {
        try {
            GestorSalas.getInstance(this).borrarSalas();
            System.out.println("salas borradas");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void expulsarManualJugador(String usuario) {
        int id = usuarios.getIdUsuario(usuario);
        enviarMensajeExpulsion(id);

        //le saco de la mesa y sala donde estaba.
        int idSala = usuarios.getJugadorConectado(id).getIdSala();
        int idMesa = usuarios.getJugadorConectado(id).getIdMesa();
        usuarios.desconectarJugador(id);
        //Envío al resto de usuarios de su mesa el listado
        enviarUsuariosEnMesa(idSala, idMesa);
    }

    public void expulsarJugador(int id) {
        enviarMensajeExpulsion(id);
         //le saco de la mesa y sala donde estaba.
        int idSala = usuarios.getJugadorConectado(id).getIdSala();
        int idMesa = usuarios.getJugadorConectado(id).getIdMesa();
        usuarios.desconectarJugador(id);
        //Envío al resto de usuarios de su mesa el listado
        enviarUsuariosEnMesa(idSala, idMesa);
    }

    public void cerrarJugador(String usuario) {
        modelo.cerrarJugador(usuario);
    }

    /**
     * Cuando un cliente se desconecta (sale de la aplicación del casino)
     * @param identificador
     */
    public void jugadorDesconectado(int identificador) {

        try {
            //obtengo la sala y mesa donde estaba
            int idSala = usuarios.getJugadorConectado(identificador).getIdSala();
            int idMesa = usuarios.getJugadorConectado(identificador).getIdMesa();

            //le saco de la sala y mesa
            usuarios.desconectarJugador(identificador);
            //quitarlo de la interfaz del servidor

            cerrarJugador(usuarios.getNombreUsuario(identificador));

            //enviar un mensaje al resto de jugadores de la mesa para que actualicen su lista de jugadores
            enviarUsuariosEnMesa(idSala, idMesa);

            log.info("ControladorServidor : jugadorDesconectado : jugador=" + identificador + " desconectado del casino");



        } catch (Exception e) {
            log.error("ControladorServidor : jugadorDesconectado : no se ha podido desconectar al jugador=" + identificador + ". Motivo: " + e.getMessage());
        }

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

    public DefaultListModel verEstadisticas(int eleccion) {
        DefaultListModel texto = null;
        switch(eleccion) {
            case 1:
                texto = usuarios.estadisticasClientes();
                break;
            case 2:
                texto = salas.estadisticasSalas();
                break;
            case 3:
                texto = salas.estadisticasPartidas();
                break;
        }
        
        /*ArrayList listaSalas = salas.getSalas();
        ArrayList listaPartidas = salas.getPartidas();
        Vector listaMesas ;
        for(int i=0;i<listaSalas.size();i++)
            listaMesas = salas.getMesas(i).getIndiceMesas();*/
        return texto;
    }

    //========================================================================
    //               ENVIO DE MENSAJES A LOS CLIENTES
    //========================================================================
    /**
     * Obtiene las salas actuales del casino y se las envÃƒÂ­a al cliente
     * @param idUsuario usuario que acaba de logearse, y recibirÃƒÂ¡ la info de las salas del casino
     */
    public void enviarSalasCasino(int idUsuario) {

        Vector<PeticionSala> salasCasino = GestorSalas.getInstance(this).getInfoSalas();
        MensajeInfoSalas mensaje = new MensajeInfoSalas(idUsuario, salasCasino);
        enviarMensajeInfoSalas(idUsuario, mensaje);
        log.info("ControladorServidor : enviarSalasCasino : info de salas enviado al cliente " + idUsuario + ". Total salas abiertas " + salasCasino.size());
    }

    /**
     * Obtiene las mesas que hay actualmente en una sala del casino, y se las envia al cliente
     * @param idUsuario usuario que acaba de entrar en una sala, y recibirÃƒÂ¡ la info
     *        de las mesas que hay en ella
     * @param idSala identificador de la sala en la que acaba de entrar
     */
    public void enviarMesasDeUnaSala(int idUsuario, int idSala) {

        Vector<PeticionMesa> mesas = GestorSalas.getInstance(this).getMesas(idSala).getInfoMesas();
        MensajeInfoMesas mensaje = new MensajeInfoMesas(idUsuario, idSala, mesas);
        enviarMensajeInfoMesas(idUsuario, mensaje);
        log.info("ControladorServidor : enviarMesasDeUnaSala : info de mesas de la sala=" + idSala + " enviado al cliente " + idUsuario + ". Total mesas abiertas " + mesas.size());
    }

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

    /**
     * Envía al cliente un mensaje de Sala
     * @param id
     * @param mensaje
     */
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
    public void enviarMensajeEstadoRuleta(int idUsuario, MensajeEstadoRuleta mensaje) {

        comunicador.enviarMensaje(idUsuario, TipoMensaje.ESTADO_RULETA, mensaje);
    }

    /**
     * Cuando hay que enviarle al cliente su propia informacion:
     * - Al principio, cuando se logea, para tener su login y saldo
     * - Siempre que se actualicen saldos tras una partida
     * @param idUsuario
     * @param mensaje
     */
    public void enviarMensajeInfoCliente(int idUsuario, MensajeInfoCliente mensaje) {
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

    private void enviarMensajeExpulsion(int id) {
        MensajeExpulsion mensajeExpulsion = new MensajeExpulsion(id);
        comunicador.enviarMensaje(id, TipoMensaje.EXPULSAR, mensajeExpulsion);
    }

    /**
     * Envía a todos los jugadores de una mesa, un mensaje (MensajeUsuariosEnMesa) con el nombre
     * de usuario de todos los jugadores
     * @param idSala identificador de la sala en la que está la mesa
     * @param idMesa identificador de la mesa
     */
    public void enviarUsuariosEnMesa(int idSala, int idMesa) {

        //Obtengo todos los jugadores que están en la mesa.
        Vector<Clientes> jugadoresMesa = usuarios.getJugadoresMesa(idSala, idMesa);

        //Creo un vector solo con el nombre de los usuarios
        Vector<String> nombreJugadores = new Vector<String>();
        for (int i = 0; i < jugadoresMesa.size(); i++) {
            nombreJugadores.add(jugadoresMesa.get(i).getUsuario());
        }

        //creo el mensaje
        MensajeUsuariosEnMesa mensaje = new MensajeUsuariosEnMesa(nombreJugadores, idMesa);

        //envio a cada jugador el mensaje
        for (int i = 0; i < jugadoresMesa.size(); i++) {
            comunicador.enviarMensaje(jugadoresMesa.get(i).getCodigo(), TipoMensaje.USERS_MESA, mensaje);
        }


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
        int id = usuarios.hacerLogin(datos.firstElement(), datos.lastElement());

        log.info("ControladorServidor : login : usuario=" + datos.firstElement() + " password=" + datos.lastElement() + " -->id=" + id);
        if (id != -1) {
            modelo.login(datos.firstElement(), datos.lastElement());

        }
        return id;
    }

    /**
     * Resto de mensajes que recibe del cliente
     * @param tipo
     * @param mensaje
     */
    public synchronized void mensajeRecibido(int tipo, Serializable mensaje) {

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
            if (modelo.tratarMensaje(mensajeChat)) {
                chat.dejamensaje(mensajeChat);
            } else {
                expulsarJugador(mensajeChat.get_tio());
            }

        } else if (tipo == TipoMensaje.MENSAJE_JUGADA) {
            MensajeJugada mensajeJugada = ((MensajeJugada) mensaje);
            GestorJuegosServidor.getInstance(this).dejamensaje(mensajeJugada);
        //TODO Devolver la confirmacion de la jugada

        } //             MESAS (entradas y salidas)
        else if (tipo == TipoMensaje.ENTRADA_MESA) {

            MensajeMesa m = (MensajeMesa) mensaje;
            if (usuarios.insertarJugadorEnMesa(m.getUsuario(), m.getMesa())) //Envio mensaje de  confimacion de la entrada en la mesa
            {
                enviarMensajeMesa(m.getUsuario(), m);//necesito saber en quÃƒÂ© mesa se ha insertado el cliente. Quito null y envio mensaje de vuelta
            }
            //enviar a todos los clientes conectados a esa mesa un mensaje con la lista de usuarios de la mesa
            enviarUsuariosEnMesa(m.getSala(), m.getMesa());

        } else if (tipo == TipoMensaje.SALIDA_MESA) {

            MensajeMesa m = (MensajeMesa) mensaje;
            usuarios.eliminarJugadorEnMesa(m.getUsuario());

            // enviar a todos los clientes conectados a esa mesa un mensaje con la lista de usuarios de la mesa
            enviarUsuariosEnMesa(m.getSala(), m.getMesa());

        } else if (tipo == TipoMensaje.CERRAR_CONEXION) {
            //TODO que tenfo que hacer?
        } //          SALAS  (entradas y salidas)
        else if (tipo == TipoMensaje.ENTRADA_SALA) {

            MensajeSala m = (MensajeSala) mensaje;
            usuarios.insertarJugadorEnSala(m.getUsuario(), m.getSala());

        } else if (tipo == TipoMensaje.SALIDA_SALA) {

            MensajeSala m = (MensajeSala) mensaje;
            usuarios.eliminarJugadorEnSala(m.getUsuario());

        } else if (tipo == TipoMensaje.INFO_SALAS) {

            MensajeInfoSalas m = (MensajeInfoSalas) mensaje;
            enviarSalasCasino(m.getId());

        } else if (tipo == TipoMensaje.INFO_MESAS) {

            MensajeInfoMesas m = (MensajeInfoMesas) mensaje;
            enviarMesasDeUnaSala(m.getId(), m.getSala());
        }
    }

}
