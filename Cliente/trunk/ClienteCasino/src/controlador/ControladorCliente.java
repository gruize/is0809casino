/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador;

import comunicaciones.Comunicador;
import java.io.IOException;
import java.io.Serializable;
import modelo.*;
/**
 *
 * @author david
 */
public class ControladorCliente {


    private Comunicador comunicador;
    private ModeloCliente modelo;

    public ControladorCliente(ModeloCliente model){
        comunicador = new Comunicador(this);
        modelo = model;
    }

    public ModeloCliente getModelo(){
        return modelo;
    }

    public boolean conectar(String usuario,String password) {
         if (comunicador!=null){
            if(comunicador.abreConexion(usuario, password)){
             modelo.setId(comunicador.getIdentificador());
             modelo.setUsuario(usuario);
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
        MensajeChat mensajeChat = new MensajeChat(modelo.getId(),1,mensaje,modelo.getUsuario());
        comunicador.enviarMensaje(1,mensajeChat);
        //TODO poner TipoMensaje.MENSAJE_CHAT en lugar de 1
    }
    
    /**
     * Envía un mensaje de jugada (apuesta de ruleta, etc) hacia el servidor
     * @param tipo: 
         *  2- Mensaje de Jugada o Informacion de Salas y mesas
         *  3- Mensaje de Entrada en mesa
         *  4- Mensaje de Salida de Mesa
     * @param mensaje
     */
    public void enviarMensajeJugada(int tipo, MensajeJugada mensaje){
       comunicador.enviarMensaje(tipo, mensaje); 
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

    /**
     * 
     * @param totalApostado  lo que lleva apostado en la ronda ????  
     * @param valor lo que se acaba de apostar en una casilla ????
     */
    public void realizarApuesta(int totalApostado, String valor, String tipo) {
        //modelo.realizarApuesta(totalApostado,valor);
        //Apuesta apuestaRealizada = new Apuesta(totalApostado,valor);
        //TODO:Enviar la apuesta al servidor
        //apuestaRealizada.imprimir();
        
        int idUsuario=modelo.getId();
        int idMesa=modelo.getMesa();
        String tipoApuesta=tipo; //TODO cómo obtengo tipoApuesta?? valores: Numero,Color,ParImpar, Docena, Linea,FaltaPasa....
        int casilla=1; //TODO casilla a la q se apuesta: al 21, al Rojo , a la 2º Docena,Falta, Par ...
        int cantidadApostada=totalApostado; //TODO es totalApostado??? 
        
        //crear el objeto Jugada 
        Jugada jugada=new Jugada(idUsuario, idMesa, tipoApuesta,casilla,cantidadApostada);
        
        //crear el objeto MensajeJugada 
        MensajeJugada mensajeJugada=new MensajeJugada(idUsuario,idMesa,jugada);
        
        //enviar el mensaje hacia el servidor. 
        enviarMensajeJugada(TipoMensaje.MENSAJE_JUGADA, mensajeJugada);
        
    }
    
    /**
     * El usuario selecciona entrar en una mesa. Hay que enviar la solicitud al servidor
     *
     * @param idMesa identificador de la mesa
     */
    public void solicitudEntrarEnMesa(int idMesa){        
        
        //crear el objeto MensajeJugada (idUsuario, idMesa, Jugada)
        MensajeJugada mensajeJugada=new MensajeJugada(modelo.getId(),idMesa,null);
        
        //enviar el mensaje hacia el servidor
        enviarMensajeJugada(TipoMensaje.ENTRADA_MESA, mensajeJugada);
    }
    
    /**
     * El servidor ha incluido al jugador en la mesa. Hay que actualizar el modelo
     * 
     * @param mesa identificador de Mesa
     */
    public void confirmacionEntradaEnMesa(int mesa){
        modelo.setMesa(mesa);
    }
    
    /**
     * El usuario selecciona salir de Mesa
     */
    public void salirDeMesa(){
        
        //crear el objeto MensajeJugada (idUsuario, idMesa, Jugada)
        MensajeJugada mensajeJugada=new MensajeJugada(modelo.getId(),modelo.getMesa(),null);
        
        //enviar el mensaje hacia el servidor
        enviarMensajeJugada(TipoMensaje.SALIDA_MESA, mensajeJugada);
    }
    
    /**
     * Cuando el servidor manda un mensaje al cliente. 
     * @param tipo tipo del mensaje (1=chat, 2=MensajeJugada, 3=EntradaChat, 4=salidaMesa)
     * @param mensaje
     */
    public synchronized void mensajeRecibido(int tipo, Serializable mensaje){
        //TODO Este método se invoca cuando se recibe un mensaje
       if (tipo == 1){
            MensajeChat m=(MensajeChat)mensaje;
            modelo.addmensajechat(m);
        }
        else if (tipo == 2) {
           //MensajeJugada
            MensajeJugada mensajeJugada=(MensajeJugada)mensaje;
            
            /*
             * Puedo obtener...
             *              * 
             * Para la ruleta:
             *  - mensaje diciendo que ya no se puede apostar más porque se va a lanzar la bola
             *  - mensaje de actualizacion de saldo, tras el lanzamiento de la bola
             * 
             * Para los dados: 
             * 
             */
        }else if (tipo==TipoMensaje.ENTRADA_MESA){      
            
           //El servidor me confirma la entrada en la mesa
            MensajeJugada mensajeJugada=(MensajeJugada)mensaje;            
            //actualizar el modelo
            confirmacionEntradaEnMesa(mensajeJugada.getMesa());
            
        }else{
           System.err.println("No sé que tipo de mensaje me envía!! "+tipo);
        }

    }

}
