package comunicaciones.demonio;

import java.net.*;
import java.util.*;
import java.io.*;

import comunicaciones.conexion.*;



class Demonio {
	// FIXME cuando creemos el demonio tenemos que ver si esServidor es true o false
	private static boolean esServidor = true;
	private static TablaMensajes tablaMensajes;

	private static Vector<Conectores> tablaConectores;
	
	public static void main( String args[] ) {
        tablaMensajes = new TablaMensajes();
        ServerSocket canal;
        Socket conexion;
        Mensaje msg = new MensajeSistema ();
		tablaConectores = new Vector<Conectores>();
/*		if (!esServidor){
			//FIXME comprobar que no hay que añadirlo
			tablaConectores.add(new Conectores("server","localhost"));
		}*/
		// TODO: puerto leido en configuración

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

