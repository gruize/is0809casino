/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servidorcasino;

import DAO.JugadorDAO;
import Entidades.Cliente;
import InterfazCliente.LoginJugador;
import InterfazCliente.Ruleta;
import Casilla.Numero;
import ConexionBBDD.BBDD;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Chaudhary
 */
public class Servidor {

    // TODO: puerto leido en configuración
    private final int PUERTO = 5036;
    private ServerSocket socketServidor;
    private InputStream entradaDatos;
    private Casino casino;
    private int idPartidaRuleta;
    private BBDD bbdd;
    //Preparado para cuando sean m�s clientes los que jueguen a la vez.
    private ArrayList<InformacionJugadores> info;
   // LoginJugador pantallaLogin = null;
    //Ruleta pantallaRuleta = null;

    public Servidor() {

    	this.socketServidor = null;
    	this.casino = null;
    	this.idPartidaRuleta = 0;
    	this.info = new ArrayList<InformacionJugadores>();
    	
    }

    public void iniciaServidor() {

    	this.casino = new Casino();

    	try {
    		this.bbdd = new BBDD();
    	}
    	catch(Exception e) {
    		//FALLO EN LA BBDD
    	}


        /* HUERTASSSSS mete aqui tu codigo del socket servidor porque es un jaleo.


        /*
        try {

        // Se crea el socket servidor que escuchará alos clientes
        socketServidor = new ServerSocket(PUERTO);

        // Bucle infinito
        while (true) {
        // Se espera y acepta un nuevo cliente
        Socket socketCliente = socketServidor.accept();
        //TODO: incrementar el nº de jugadores activos

        //Crea un canal de entrada asociado al socket
        entradaDatos = socketCliente.getInputStream();

        // Se instancia una clase para atender al cliente y se lanza en
        // un hilo aparte.
        Runnable nuevoCliente = new HiloCliente(socketCliente);
        Thread hilo = new Thread(nuevoCliente);
        hilo.start();


        int dato = 0;
        while ((dato = entradaDatos.read()) != -1) {
        System.out.print((char) dato);
        }

        }

        } catch (IOException ex) {
        //Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        System.out.println(ex);
        }*/

       // crearNuevoJugador();

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

/*    public void crearNuevoJugador() {
        pantallaLogin = new LoginJugador();
        pantallaLogin.registraServidor(this);
        pantallaLogin.muestra();

  		}*/

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
    		
    	}
    	if (correcto) {
    		try {
    			Cliente cliente = bbdd.selectCliente(idUsuario, password);
    			InformacionJugadores infoJugador = new InformacionJugadores();
    			infoJugador.setCodigo(cliente.getCodigo());
    			infoJugador.setSaldo(cliente.getSaldoAct());
    			info.add(infoJugador);
    		}
    		catch(Exception e) {
    			
    		}
    		
        	//int idPartida = casino.creaPartidaRuleta();
        	idPartidaRuleta = casino.creaPartidaRuleta();
        	Jugador j = new Jugador(1, 100); //TODO debería ser algo del estilo: resultado=jugadorDAO.obtenerDatos(idUsuario);

            casino.anadeJugadorAPartida(j, idPartidaRuleta);
            /*
             * Se necesitan sockets para enviar confirmaci�n de aceptaci�n.
             *
            //mostrar el formulario PartidaRuleta
            pantallaRuleta = new Ruleta();
            pantallaRuleta.registraServidor(this);
            pantallaRuleta.muestra();
            pantallaRuleta.actualizaSaldo(j.getSaldo());*/

        }
    	else {
    		//Mandar mensaje al cliente de que debe
    		//registrarse de nuevo o error en login
    	}
    		
    }


    /**
     * RULETA: apuesta a número
     * @param tipoApuesta "numero"
     * @param casilla  numero de la casilla de la ruleta a la que se apuesta
     * @param cantidadApostada cantidad de dinero apostada
     */
    public void nuevaApuestaRuleta(String tipoApuesta, int casilla, int cantidadApostada) {

        ApuestaRuleta apuesta = new ApuestaRuleta(tipoApuesta, casilla, cantidadApostada);

        Jugada jug = new Jugada(1, idPartidaRuleta, 1, apuesta);
        //procesar la jugada
        int resultado = casino.procesarJugada(jug);
        if (resultado == 1) { //mensaje OK al cliente

           // pantallaRuleta.incluirMensaje("Apuesta al " + casilla + " correcta");
           // pantallaRuleta.actualizaTotalApostado();
        } else if (resultado == -1) {
           // pantallaRuleta.incluirMensaje("Apuesta al " + casilla + " NO VALIDA [FALTA SALDO]");
        } else if (resultado == -2) {
           // pantallaRuleta.incluirMensaje("Apuesta al " + casilla + " NO VALIDA [MAX APUESTAS EXCEDIDO]");
        }
    }

    /**
     * RULETA: apuesta a color
     * @param tipoApuesta "PARIMPAR"
     * @param color ROJO o NEGRO
     * @param cantidadApostada
     */
    public void nuevaApuestaRuleta(String tipoApuesta, String color, int cantidadApostada) {
        //crear la jugada: 1, idPArtida, 1, 33, 44
        ApuestaRuleta apuesta = new ApuestaRuleta(tipoApuesta, color, cantidadApostada);

        Jugada jug = new Jugada(1, idPartidaRuleta, 1, apuesta);
        //procesar la jugada
        int j = casino.procesarJugada(jug);
        if (j > -1) //mensaje OK al cliente
        {
            //pantallaRuleta.incluirMensaje("Apuesta al " + color + " correcta");
            //pantallaRuleta.actualizaTotalApostado();
        } else if (j == -1) {
            //pantallaRuleta.incluirMensaje("Apuesta al " + color + " NO VALIDA [FALTA SALDO]");
        } else {
            //pantallaRuleta.incluirMensaje("Numero Maximo de Apuestas  Exedido");
        }
    }

    /**
     * RULETA: Apuesta a docenas
     * @param tipoApuesta 1docena, 2docena o 3docena
     * @param cantidadApostada cantidad que apuesta
     */
    public void nuevaApuestaRuleta(String tipoApuesta,int cantidadApostada) {

        ApuestaRuleta apuesta = new ApuestaRuleta(tipoApuesta, cantidadApostada);
        Jugada jug = new Jugada(1, idPartidaRuleta, 1, apuesta);
        //procesar la jugada
        int resultado = casino.procesarJugada(jug);
        if (resultado > -1) //mensaje OK al cliente
        {
            //pantallaRuleta.incluirMensaje("Apuesta a la " + tipoApuesta + " correcta");
            //pantallaRuleta.actualizaTotalApostado();
        } else if (resultado == -1) {
            //pantallaRuleta.incluirMensaje("Apuesta a la " + tipoApuesta + " NO VALIDA [FALTA SALDO]");
        } else {
            //pantallaRuleta.incluirMensaje("Numero Maximo de Apuestas  Exedido");
        }
    }


    //Creo la jugada de tipo tirada y la manda al servidor
    public int nuevaTiradaRuleta() {
        ApuestaRuleta apuesta = null;
        Jugada jugada = new Jugada(1, idPartidaRuleta, 2, apuesta);
        int saldoActual = casino.procesarJugada(jugada);
        //pantallaRuleta.incluirMensaje("Su saldo actual es de:  " + saldoActual + " Leuros");
        return saldoActual;
    }


    public Numero dameBola() {
        return casino.tiradaPartidaRuleta(idPartidaRuleta);
    }
   
    public void finalizarPartida() {
    	
    	Iterator<InformacionJugadores> itr = info.iterator();
    	while (itr.hasNext())
    	try {
    		InformacionJugadores element = (InformacionJugadores)itr.next(); 
    		Cliente cliente = bbdd.selectCliente(element.getCodigo());
    		cliente.setSaldoAct(element.getSaldo());
    		bbdd.updateCliente(cliente);
    	}
    	catch(Exception e) {
    		
    	}
    }
}
