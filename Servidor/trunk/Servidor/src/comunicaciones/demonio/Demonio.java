package comunicaciones.demonio;

import java.net.*;
import java.util.*;
import java.io.*;



class Demonio {
	private static boolean esServidor = true;
	private static TablaMensajes tablaMensajes;

	private static Vector<Conectores> tablaConectores;
	
	public static void main( String args[] ) {
        final int PUERTO = 10809;
        tablaMensajes = new TablaMensajes();
        ServerSocket canal;
        Socket conexion;
		tablaConectores = new Vector<Conectores>();
/*		if (!esServidor){
			//FIXME comprobar que no hay que añadirlo
			tablaConectores.add(new Conectores("server","localhost"));
		}*/
		// TODO: puerto leido en configuración

        // empezamos a escuchar
        try {
            while (true) {
                canal = new ServerSocket(PUERTO);
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

