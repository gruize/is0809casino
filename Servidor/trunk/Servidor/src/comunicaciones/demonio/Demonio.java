package comunicaciones.demonio;

import java.net.*;
import java.util.*;
import java.io.*;

import comunicaciones.conexion.*;

// TODO: hacerla  hilo
/**
 * Clase demonio ejecutable, que inicia un demonio
 * @author Francisco Huertas y Gabriela Ruiz
 * @version 0.1.228
 */
class Demonio {
	// FIXME cuando creemos el demonio tenemos que ver si esServidor es true o false
	/**
	 * Indica si el demonio perteneece a un cliente o un servidor
	 */
	private static boolean esServidor = true;
	
	/**
	 * Tabla de mensajes almacenados del demonio
	 */
	private static TablaMensajes tablaMensajes;

	/**
	 * Tabla de conectores del demonio
	 */
	private static Vector<Conectores> tablaConectores;
	/**
	 * Procedimiento principal del demonio
	 * @param args
	 */
	public static void main( String args[] ) {
        tablaMensajes = new TablaMensajes();
        ServerSocket canal;
        Socket conexion;
        Mensaje msg = new MensajeSistema ();
		tablaConectores = new Vector<Conectores>();
/*		if (!esServidor){
			//FIXME comprobar que no hay que a�adirlo
			tablaConectores.add(new Conectores("server","localhost"));
		}*/
		// TODO: puerto leido en configuraci�n

        // empezamos a escuchar
        try {
        	canal = new ServerSocket(msg.PUERTO);
            while (true) {
                
                //esperamos a que halla una conxion
                conexion = canal.accept();
                hiloConexion nuevaConexion = new hiloConexion(conexion,esServidor,tablaConectores,tablaMensajes);
                nuevaConexion.start();
                
                // TODO close "canal" when close process
                 
                 
            }
        }
        catch (IOException e ) {
            System.out.println( e );
        }
        
    }
}

