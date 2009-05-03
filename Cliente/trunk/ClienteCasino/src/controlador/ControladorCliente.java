/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import modelo.mensajes.TipoMensaje;
import modelo.mensajes.MensajeChat;
import modelo.mensajes.MensajeJugada;
import comunicaciones.Comunicador;
import java.io.IOException;
import java.io.Serializable;
import java.util.Vector;
import modelo.*;
import modelo.mensajes.MensajeEstadoRuleta;
import modelo.mensajes.MensajeInfoCliente;
import modelo.mensajes.MensajeInfoMesas;
import modelo.mensajes.MensajeInfoSalas;
import modelo.mensajes.MensajeMesa;
import modelo.mensajes.MensajeSala;
import modelo.mensajes.objetos.PeticionMesa;
import modelo.mensajes.objetos.PeticionSala;

/**
 *
 * @author david
 */
public class ControladorCliente {

    private Comunicador comunicador;
    private ModeloCliente modelo;
    private Vector<PeticionSala> peticionSala;
    private Vector<PeticionMesa> peticionMesas;

    public ControladorCliente(ModeloCliente model) {
        comunicador = new Comunicador(this);
        modelo = model;
    }

    public ModeloCliente getModelo() {
        return modelo;
    }

    public boolean conectar(String usuario, String password) {
        if (comunicador != null) {
            if (comunicador.abreConexion(usuario, password)) {
                modelo.setId(comunicador.getIdentificador());
                modelo.setUsuario(usuario);
                return true;
            }
        }
        return false;
    }

    public boolean cerrarConexion() {
        //return modelo.cerrarConexion();
        return true;
    }

    public void enviarMensajeChat(String mensaje) {
        MensajeChat mensajeChat = new MensajeChat(modelo.getId(), 1, mensaje, modelo.getUsuario());
        comunicador.enviarMensaje(TipoMensaje.MENSAJE_CHAT, mensajeChat);
    }

    /**
     * Envía un mensaje de jugada (apuesta de ruleta, etc) hacia el servidor
     * @param tipo: 
     *  2- Mensaje de Jugada o Informacion de Salas y mesas
     * @param mensaje
     */
    public void enviarMensajeJugada(int tipo, MensajeJugada mensaje) {
       comunicador.enviarMensaje(tipo, mensaje);
    }

    public int obtenerSaldo() {
        return modelo.getSaldo();
    }

    public String obtenerUsuario() {
        return modelo.getUsuario();
    }

    /**
     * Envía un mensaje de entrada o salida de mesa hacia el servidor
     * @param tipo:
     *   *  3- Mensaje de Entrada en mesa
     *   *  4- Mensaje de Salida de Mesa
     * @param mensaje objeto MensajeJugada
     */
    private void enviarMensajeMesa(int tipo, MensajeMesa mensaje) {
        comunicador.enviarMensaje(tipo, mensaje);
    }

    /**
     *
     * @param tipo:
     *   *  3- Mensaje de Entrada en Sala
     *   *  4- Mensaje de Salida de Sala
     * @param mensaje
     */
    private void enviarMensajeSala(int tipo, MensajeSala mensaje){
        comunicador.enviarMensaje(tipo, mensaje);
    }

    public Vector<PeticionMesa> getPeticionMesas() {
        return peticionMesas;
    }

    public void setPeticionMesas(Vector<PeticionMesa> peticionMesas) {
        this.peticionMesas = peticionMesas;
    }

    public Vector<PeticionSala> getPeticionSala() {
        return peticionSala;
    }

    public void setPeticionSala(Vector<PeticionSala> peticionSala) {
        this.peticionSala = peticionSala;
    }



    /**
     * 
     * @param cantidadApostada  cantidad de dinero apostada en la casilla
     * @param valor nombre de la casilla sobre la que ha apostado
     */
    public void realizarApuesta(int cantidadApostada, String valor, String tipo) {

        int idUsuario = modelo.getId();
        int idMesa = modelo.getMesa();
        int idSala=modelo.getSala();
        String tipoApuesta = tipo; //valores posibles (definirlos en la vista ruleta): Numero,Color,ParImpar, Docena, Linea,FaltaPasa....
        int casilla = 0;//casilla a la q se apuesta: al 21, al Rojo , a la 2º Docena,Falta, Par ...
        try { //TODO hacerlo bien
            casilla = Integer.parseInt(valor);
        } catch (ClassCastException e) {
            casilla = 1;
        }


        //crear el objeto Jugada 
        Jugada jugada = new Jugada(idUsuario, idSala, idMesa, tipoApuesta, casilla, cantidadApostada);
        System.out.println("Jugada RULETA: usuario=" + idUsuario + " mesa=" + idMesa + " tipoApuesta=" + tipoApuesta + " casilla:" + casilla + " cantidadApostada:" + cantidadApostada);

        //crear el objeto MensajeJugada 
        MensajeJugada mensajeJugada = new MensajeJugada(idUsuario, idMesa, jugada);

        //enviar el mensaje hacia el servidor. 
        enviarMensajeJugada(TipoMensaje.MENSAJE_JUGADA, mensajeJugada);

    }

    /**
     * El usuario selecciona entrar en una mesa. Hay que enviar la solicitud al servidor
     *
     * @param idMesa identificador de la mesa
     */
    public void solicitudEntrarEnMesa(int idMesa) {

        //crear el objeto MensajeMesa (idUsuario, idMesa, idSala)
        MensajeMesa mensajeMesa = new MensajeMesa(modelo.getId(), idMesa, modelo.getSala());

        //enviar el mensaje hacia el servidor
        enviarMensajeMesa(TipoMensaje.ENTRADA_MESA, mensajeMesa);
    }

    public void solicitudEntrarSala(int idSala){

        //crear el objeto MensajeSala(idUsuario, isSala)
        MensajeSala mensajeSala=new MensajeSala(modelo.getId(),idSala);

        //enviar el mensaje al servidor
        enviarMensajeSala(TipoMensaje.ENTRADA_SALA, mensajeSala);
    }
    /**
     * El usuario selecciona salir de Mesa
     */
    public void salirDeMesa() {

        //crear el objeto MensajeMesa (idUsuario, idMesa, isSala)
        MensajeMesa mensajeMesa = new MensajeMesa(modelo.getId(), modelo.getMesa(), modelo.getSala());

        //enviar el mensaje hacia el servidor
        enviarMensajeMesa(TipoMensaje.SALIDA_MESA, mensajeMesa);
    }

    /**
     * Cuando el servidor manda un mensaje al cliente. 
     * @param tipo tipo del mensaje (1=chat, 2=MensajeJugada, 3=EntradaMesa, 4=salidaMesa)
     * @param mensaje
     */
    public synchronized void mensajeRecibido(int tipo, Serializable mensaje) {

        System.out.println("ControladorCliente : mensajeRecibido : tipo="+tipo+" mensaje="+mensaje.toString());
        if (tipo == TipoMensaje.MENSAJE_CHAT) {
            MensajeChat m = (MensajeChat) mensaje;
            modelo.addmensajechat(m);
            
        } else if (tipo == TipoMensaje.MENSAJE_JUGADA) {
            MensajeJugada mensajeJugada = (MensajeJugada) mensaje;
            modelo.addMensajeJugada(mensajeJugada);

        } else if (tipo == TipoMensaje.ENTRADA_MESA) {

            //El servidor me confirma la entrada en la mesa
            MensajeMesa mensajeMesa = (MensajeMesa) mensaje;
            //actualizar el modelo
            modelo.setMesa(mensajeMesa.getMesa());

        } else if (tipo == TipoMensaje.ENTRADA_SALA) {

            //el servidor confirma la entrada en la sala
            MensajeSala mensajeSala = (MensajeSala) mensaje;

            //actualizar el modelo
            modelo.setSala(mensajeSala.getSala());

        } else if (tipo== TipoMensaje.INFO_SALAS){           
            MensajeInfoSalas mensajeIS = (MensajeInfoSalas) mensaje;
            setPeticionSala(mensajeIS.getSalas());
        }else if (tipo==TipoMensaje.INFO_MESAS){
            MensajeInfoMesas mensajeIM = (MensajeInfoMesas) mensaje;
            setPeticionMesas(mensajeIM.getMesas());

        } else if (tipo==TipoMensaje.INFO_CLIENTE){
            
            //TODO interfaz: os mandaré la info del propio cliente: os interesa el saldo
            MensajeInfoCliente mensajeIC=(MensajeInfoCliente)mensaje;




        }else if (tipo==TipoMensaje.ESTADO_RULETA){
            
            //TODO interfaz os mandaré el estado de la ruleta, para que paréis y arranquéis.

            MensajeEstadoRuleta m=(MensajeEstadoRuleta)mensaje;
        }



        else {
            System.err.println("No sé que tipo de mensaje me envía!! " + tipo);
        }

    }
}
