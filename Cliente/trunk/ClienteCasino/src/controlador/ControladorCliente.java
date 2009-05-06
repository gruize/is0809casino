/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import modelo.Apuesta;
import modelo.mensajes.TipoMensaje;
import modelo.mensajes.MensajeChat;
import modelo.mensajes.MensajeJugada;
import comunicaciones.Comunicador;
import java.io.Serializable;
import java.util.Vector;
import modelo.Jugada;
import modelo.ModeloCliente;
import modelo.mensajes.MensajeEstadoRuleta;
import modelo.mensajes.MensajeInfoCliente;
import modelo.mensajes.MensajeInfoMesas;
import modelo.mensajes.MensajeInfoSalas;
import modelo.mensajes.MensajeMesa;
import modelo.mensajes.MensajeSala;

/**
 *
 * @author david
 */
public class ControladorCliente {

    private Comunicador comunicador;
    private ModeloCliente modelo;

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



    public void enviarMensajeChat(String mensaje) {
        MensajeChat mensajeChat = new MensajeChat(modelo.getId(), modelo.getSala(),modelo.getMesa(), mensaje, modelo.getUsuario());
        comunicador.enviarMensaje(TipoMensaje.MENSAJE_CHAT, mensajeChat);
    }

    /**
     * EnvÃ­a un mensaje de jugada (apuesta de ruleta, etc) hacia el servidor
     * @param tipo:
     *  2- Mensaje de Jugada o Informacion de Salas y mesas
     * @param mensaje
     */
    public void enviarMensajeJugada(int tipo, MensajeJugada mensaje) {
       comunicador.enviarMensaje(tipo, mensaje);
    }

    public Vector<String> obtenerApuestasAnteriores() {
        Vector<String> strings = new Vector<String>();
        strings.add("Resultado 1");
        strings.add("Resultado 2");
        strings.add("Resultado 3");
        strings.add("Resultado 4");
        strings.add("Resultado 5");
        strings.add("Resultado 6");
        strings.add("Resultado 7");
        strings.add("Resultado 8");
        strings.add("Resultado 9");
        return strings;
    }

    public int obtenerSaldo() {
        return modelo.getSaldo();
    }

    public String obtenerUsuario() {
        return modelo.getUsuario();
    }

    public Vector<String> obtenerUsuariosEnMesa() {
        Vector<String> strings = new Vector<String>();
        strings.add("Jugadores 1");
        strings.add("Jugadores 2");
        strings.add("Jugadores 3");
        strings.add("Jugadores 4");
        strings.add("Jugadores 5");
        strings.add("Jugadores 6");
        strings.add("Jugadores 7");
        strings.add("Jugadores 8");
        strings.add("Jugadores 9");
        return strings;
    }

    /**
     * EnvÃ­a un mensaje de entrada o salida de mesa hacia el servidor
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

    private void enviarMensajeInfoSalas(int tipo,MensajeInfoSalas mensaje) {
        comunicador.enviarMensaje(tipo, mensaje);
    }

    private void enviarMensajeInfoMesas(int tipo,MensajeInfoMesas mensaje) {
        comunicador.enviarMensaje(tipo, mensaje);
    }

    public void pedirNumeroMesas() {
        MensajeInfoMesas mensaje = new MensajeInfoMesas(modelo.getId(),modelo.getSala());
        enviarMensajeInfoMesas(TipoMensaje.INFO_MESAS,mensaje);
    }

    public void pedirNumeroSalas() {
        MensajeInfoSalas mensaje = new MensajeInfoSalas(modelo.getId());
        enviarMensajeInfoSalas(TipoMensaje.INFO_SALAS,mensaje);
    }


    public void realizarApuestaRuleta(Apuesta[] apuesta, int num) {

        int idUsuario = modelo.getId();
        int idMesa = modelo.getMesa();
        int idSala=modelo.getSala();        
        for(int i = 0; i < num; i++){            
            Jugada jugadaAux = new Jugada(idUsuario,idSala,idMesa,apuesta[i].getTipo().toString(),apuesta[i].getCasilla(),(int) apuesta[i].getValorApostado());
            MensajeJugada mensaje = new MensajeJugada(idUsuario,idMesa, jugadaAux);
            enviarMensajeJugada(TipoMensaje.MENSAJE_JUGADA,mensaje);
            /** Util para probar
            System.out.println(idUsuario);
            System.out.println(idMesa);
            System.out.println(idSala);
            System.out.println(apuesta[i].getCasilla());
            System.out.println(apuesta[i].getTipo().toString());
            System.out.println(apuesta[i].getValorApostado());
             */
        }
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


    public void setMesa(int mesaEntrar) {
        modelo.setMesa(mesaEntrar);
    }

    public void setSala(int salonEntrar) {
        modelo.setSala(salonEntrar);
    }

    /**
     * Cuando el servidor del casino se desconecta
     */
    public void servidorDesconectado(){
      
        modelo.setMesa(-1);
        modelo.setSala(-1);

        //TODO que mas hay que hacer? desconectar comunicaciones?

    }

    //TODO hace lo mismo que cuando se cae el servidor???
    public boolean cerrarConexion(){
        servidorDesconectado();
        return true;
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
            System.out.println("Info salas pedida");
            MensajeInfoSalas mensajeInfoSalas = (MensajeInfoSalas) mensaje;
            modelo.rellenarSalas(mensajeInfoSalas);

        } else if (tipo==TipoMensaje.INFO_MESAS){
            System.out.println("Info mesas pedida");
            MensajeInfoMesas mensajeInfoMesas = (MensajeInfoMesas) mensaje;
            modelo.rellenarMesas(mensajeInfoMesas);

        } else if (tipo==TipoMensaje.INFO_CLIENTE){

            //TODO interfaz: os mandarÃ© la info del propio cliente: os interesa el saldo
            //TODO LLega con el saldo y la ultima Bola Lanzada, para ponerla en la interfaz
            MensajeInfoCliente mensajeIC=(MensajeInfoCliente)mensaje;




        }else if (tipo==TipoMensaje.ESTADO_RULETA){

            //TODO interfaz os mandarÃ© el estado de la ruleta, para que parÃ©is y arranquÃ©is.

            MensajeEstadoRuleta m=(MensajeEstadoRuleta)mensaje;
        }



        else {
            System.err.println("No sÃ© que tipo de mensaje me envÃ­a!! " + tipo);
        }

    }
}
