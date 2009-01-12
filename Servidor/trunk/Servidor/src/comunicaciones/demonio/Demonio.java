package comunicaciones.demonio;

import java.net.*;
import java.util.*;
import java.io.*;

import comunicaciones.conexion.*;

// TODO: hacerla  hilo
/**
 * Class Demonio executable, that starts a daemon
 * @author Francisco Huertas and Gabriela Ruiz
 * @version 0.1.228
 */
public class Demonio extends Thread{
	// FIXME cuando creemos el demonio tenemos que ver si esServidor es true o false
	/**
	 * Indicates if the daemon belongs to a client or a server
	 */
	private boolean servidor = false;
	
	/**
	 * Table of messages stored of the daemon.
	 */
	private TablaMensajes tablaMensajes;

	/**
	 * Table of Connectors of the daemon
	 */
	private Vector<Conectores> tablaConectores;
	/**
	 * Principal procedure of the daemon
	 * @param args
	 */
	
	public void run() {
        tablaMensajes = new TablaMensajes();
        ServerSocket canal;
        Socket conexion;
        Mensaje msg = new MensajeSistema ();
		tablaConectores = new Vector<Conectores>();
/*		if (!esServidor){
			//FIXME comprobar que no hay que a�adirlo
			tablaConectores.add(new Conectores("server","localhost"));
		}*/
		// TODO: Cuando parar
        try {
        	canal = new ServerSocket(msg.PUERTO);
            while (true) {
                /**
                 * Waiting a connection
                 */
                conexion = canal.accept();
                hiloConexion nuevaConexion = new hiloConexion(conexion,servidor,tablaConectores,tablaMensajes);
                nuevaConexion.start();
                
                // TODO close "canal" when close process
                 
                 
            }
        }
        catch (IOException e ) {
            System.out.println( e );
        }
        
    }
	public boolean getServidor() {
		return servidor;
	}
	public void setServidor(boolean servidor) {
		this.servidor = servidor;
	}
}

