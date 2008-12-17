/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servidorcasino;


import ConexionBBDD.BBDD;
import InterfazCliente.LoginJugador;
import InterfazCliente.Ruleta;
import Casilla.Numero;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.util.ArrayList;
import Entidades.Cliente;

/**
 *
 * @author Chaudhary
 */
public class Servidor {

    // TODO: puerto leido en configuración
    final int PUERTO = 5036;
    ServerSocket socketServidor = null;
    InputStream entradaDatos;
    Casino casino = null;
    int idPartidaRuleta = 0;
    LoginJugador pantallaLogin = null;
    Ruleta pantallaRuleta = null;
    private BBDD bbdd;
    //Preparado para cuando sean m�s clientes los que jueguen a la vez.
    private ArrayList<InformacionJugadores> info;

    public Servidor() {
        this.casino = null;
    	this.idPartidaRuleta = 0;
    	this.info = new ArrayList<InformacionJugadores>();
    }

    public void iniciaServidor() {
        
        casino = new Casino();
        try {
    		this.bbdd = new BBDD();
    	}
    	catch(Exception e) {
    		System.out.println("Error en la conexion con la BBDD");
    	}
        crearNuevoJugador();

    }

    /**
     * Sobrecarga del método de finalización del hilo del servidor 
     * para poder cerrar el socket del servidor.
     */
    @Override
    public void finalize() {
        try {
            socketServidor.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.exit(-1);
        }
    }

    public void crearNuevoJugador() {
        pantallaLogin = new LoginJugador();
        pantallaLogin.registraServidor(this);
        pantallaLogin.muestra();

    }

    /**
     * PETICION DEL CLIENTE: el jugador introduce sus datos y pulsa Aceptar. 
     * Si sus datos son correctos, mostrar la Ruleta
     * @param idUsuario nombre de ususario del jugador
     * @param password contraseña del jugador
     */
    public void aceptarJugador(String idUsuario, String password) {
        boolean correcto = false;
        try {
        	correcto = bbdd.comprobarJugador(idUsuario, password);
    	}
    	catch(Exception e) {
    		System.out.println("Error en la comprobacion de los datos del jugador en la BBDD");
    	}
    	if (correcto) {
    		try {
    			Cliente cliente = bbdd.selectCliente(idUsuario, password);
    			InformacionJugadores infoJugador = new InformacionJugadores();
    			infoJugador.setCodigo(cliente.getCodigo());
    			infoJugador.setSaldo(cliente.getSaldoAct());                        
    			info.add(infoJugador);
                        Jugador j = new Jugador(cliente.getCodigo(), cliente.getSaldoAct()); 
                        idPartidaRuleta = casino.creaPartidaRuleta();            
                        casino.anadeJugadorAPartida(j, idPartidaRuleta);
    		}
    		catch(Exception e) {
    		System.out.println("Error en obtencion de los datos del jugador en la BBDD");
    		} 
                
                //Crea el formulario que simula ser un cliente.
                //A la ruleta le paso el Id del usuario que la ha creado
                pantallaRuleta = new Ruleta(info.get(0).getCodigo(),(int)info.get(0).getSaldo());
                pantallaRuleta.registraServidor(this);
                pantallaRuleta.muestra();
               

        }
    }


    /**
     * RULETA: apuesta a número
     * @param tipoApuesta "numero"
     * @param casilla  numero de la casilla de la ruleta a la que se apuesta
     * @param cantidadApostada cantidad de dinero apostada
     */
    public int nuevaApuestaRuleta(int idUsuario ,String tipoApuesta, int casilla, int cantidadApostada) {

        ApuestaRuleta apuesta = new ApuestaRuleta(tipoApuesta, casilla, cantidadApostada);

        Jugada jug = new Jugada(idUsuario, idPartidaRuleta, 1, apuesta);
        //procesar la jugada
        int resultado = casino.procesarJugada(jug);
        if (resultado >-1) { //mensaje OK al cliente

            pantallaRuleta.incluirMensaje("Apuesta al " + casilla + " correcta");
            pantallaRuleta.actualizaTotalApostado(cantidadApostada);
           //pantallaRuleta.actualizaSaldo(cantidadApostada);            
        } else if (resultado == -1) {
            pantallaRuleta.incluirMensaje("Apuesta al " + casilla + " NO VALIDA [FALTA SALDO]");
        } else if (resultado == -2) {
            pantallaRuleta.incluirMensaje("Apuesta al " + casilla + " NO VALIDA [MAX APUESTAS EXCEDIDO]");
        }
        return resultado;
    }

    /**
     * RULETA: apuesta a color y parimpar
     * @param tipoApuesta "PARIMPAR" "COLOR"
     * @param color PAR o IMPAR , ROJO o NEGRO
     * @param cantidadApostada
     */
    public int nuevaApuestaRuleta(int idUsuario,String tipoApuesta, String color, int cantidadApostada) {
        
        ApuestaRuleta apuesta = new ApuestaRuleta(tipoApuesta, color, cantidadApostada);

        Jugada jug = new Jugada(idUsuario, idPartidaRuleta, 1, apuesta);
        //procesar la jugada
        int resultado = casino.procesarJugada(jug);
        if (resultado > -1) //La jugada ha sido aprobada
        {
            pantallaRuleta.incluirMensaje("Apuesta al " + color + " correcta");
            pantallaRuleta.actualizaTotalApostado(cantidadApostada);
            //pantallaRuleta.actualizaSaldo(cantidadApostada);
        } else if (resultado == -1) {
            pantallaRuleta.incluirMensaje("Apuesta al " + color + " NO VALIDA [FALTA SALDO]");
        } else {
            pantallaRuleta.incluirMensaje("Numero Maximo de Apuestas  Exedido");
        }
        return resultado;
    }
    
    /**
     * RULETA: Apuesta a docenas
     * @param tipoApuesta 1docena, 2docena o 3docena
     * @param cantidadApostada cantidad que apuesta
     */
    public int nuevaApuestaRuleta(int idUsuario,String tipoApuesta,int cantidadApostada) {

        ApuestaRuleta apuesta = new ApuestaRuleta(tipoApuesta, cantidadApostada);
        Jugada jug = new Jugada(idUsuario, idPartidaRuleta, 1, apuesta);
        //procesar la jugada
        int resultado = casino.procesarJugada(jug);
        if (resultado > -1) //mensaje OK al cliente
        {
            pantallaRuleta.incluirMensaje("Apuesta a la " + tipoApuesta + " correcta");
            pantallaRuleta.actualizaTotalApostado(cantidadApostada);
          //  pantallaRuleta.actualizaSaldo(cantidadApostada);
        } else if (resultado == -1) {
            pantallaRuleta.incluirMensaje("Apuesta a la " + tipoApuesta + " NO VALIDA [FALTA SALDO]");
        } else {
            pantallaRuleta.incluirMensaje("Numero Maximo de Apuestas  Exedido");
        }
        return resultado;
    }
    
    
    //Creo la jugada de tipo tirada y la manda al Casino
    public int nuevaTiradaRuleta(int idUsuario) {
        ApuestaRuleta apuesta = null;
        Jugada jugada = new Jugada(idUsuario, idPartidaRuleta, 2, apuesta);
        int saldoActual = casino.procesarJugada(jugada);
        pantallaRuleta.incluirMensaje("Su saldo actual es de:  " + saldoActual + " Leuros");
        //TODO aqui habria que conectar con la base de datos y actualizar el saldo del cliente
        try {
            bbdd.updateSaldoCliente(idUsuario,saldoActual);
           
        }
        catch(Exception e) {
    		System.out.println("Error al actualizar el saldo en  la BBDD");
    	}
        return saldoActual;
    }

    /**
     * PETICION DEL CLIENTE: el jugador introduce sus datos y pulsa Aceptar
     * Comprobar, accediendo a la BBBDD, que el jugador está dado de alta en el sistema
     * @param idUsuario nombre de ususario del jugador
     * @param password contraseña del jugador
     * @return
     */

    public Numero dameBola() {
        return casino.tiradaPartidaRuleta(idPartidaRuleta);
    }
}
