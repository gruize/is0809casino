/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servidorcasino;

import DAO.JugadorDAO;
import InterfazCliente.LoginJugador;
import InterfazCliente.Ruleta;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

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

    public Servidor() {
    }

    public void iniciaServidor() {
        casino = new Casino();
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

     crearNuevoJugador();

    }

    /**
     * Sobrecarga del método de finalización del hilo del servidor 
     * para poder cerrar el socket del servidor.
     */
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
        if (comprobarJugador(idUsuario, password)) {
            //int idPartida = casino.creaPartidaRuleta();
            idPartidaRuleta = casino.creaPartidaRuleta();
            Jugador j = new Jugador(1, 100); //TODO debería ser algo del estilo: j=jugadorDAO.obtenerDatos(idUsuario);

            casino.anadeJugadorAPartida(j, idPartidaRuleta);

            //mostrar el formulario PartidaRuleta
            pantallaRuleta = new Ruleta();
            pantallaRuleta.registraServidor(this);
            pantallaRuleta.muestra();

        }
    }

    /**
     * PETICION DEL CLIENTE: el jugador selecciona una jugada: apuesta o lanzar bola
     * @param tipojugada
     * @param cantidadApostada
     * @param tipoapuesta
     */
    //para los números
    public void nuevaJugada(String tipoApuesta, int cantidadApostada, int casilla) {
        //crear la jugada: 1, idPArtida, 1, 33, 44
        ApuestaRuleta apuesta=new ApuestaRuleta(tipoApuesta, casilla,cantidadApostada);
        
        Jugada jug = new Jugada(1, idPartidaRuleta, tipoApuesta, cantidadApostada, casilla);
        //procesar la jugada
        if (casino.procesarJugada(jug)) //mensaje OK al cliente
        {
            pantallaRuleta.incluirMensaje("Apuesta al " + casilla + " correcta");
        } else {
            pantallaRuleta.incluirMensaje("Apuesta al " + casilla + " NO VALIDA [FALTA SALDO]");
        }
    }

    //para los colores
        public void nuevaJugada(String tipoApuesta, String color, int cantidadApostada) {
        //crear la jugada: 1, idPArtida, 1, 33, 44
        ApuestaRuleta apuesta=new ApuestaRuleta(tipoApuesta, casilla,cantidadApostada);
        
        Jugada jug = new Jugada(1, idPartidaRuleta, tipoApuesta, cantidadApostada, casilla);
        //procesar la jugada
        if (casino.procesarJugada(jug)) //mensaje OK al cliente
        {
            pantallaRuleta.incluirMensaje("Apuesta al " + casilla + " correcta");
        } else {
            pantallaRuleta.incluirMensaje("Apuesta al " + casilla + " NO VALIDA [FALTA SALDO]");
        }
    }
        
    /**
     * PETICION DEL CLIENTE: el jugador introduce sus datos y pulsa Aceptar
     * Comprobar, accediendo a la BBBDD, que el jugador está dado de alta en el sistema
     * @param idUsuario nombre de ususario del jugador
     * @param password contraseña del jugador
     * @return
     */
    public boolean comprobarJugador(String idUsuario, String password) {
        JugadorDAO jugadorDAO = new JugadorDAO();
        return jugadorDAO.comprobarJugador(idUsuario, password);
    }
}
