package comunicaciones.demonio;

import java.net.*;
import java.util.*;
import java.io.*;
import comunicaciones.*;


class Demonio {
	private static boolean esServidor = true;
	// TODO ver porque static
	private static Vector<Conectores> tablaConectores;
	
	public static void main( String args[] ) {
        final int PUERTO = 10809;
        ServerSocket canal;
        Socket conexion;
//        ObjectInputStream entradaDatos;
		tablaConectores = new Vector();
		if (!esServidor){
			tablaConectores.add(new Conectores("server","localhost"));
		}
		// TODO: puerto leido en configuración
        int dato;
        // empezamos a escuchar
        try {
            while (true) {
                canal = new ServerSocket(PUERTO);
                //esperamos a que halla una conxion
                conexion = canal.accept();
                hiloConexion nuevaConexion = new hiloConexion(conexion,esServidor,tablaConectores);
                nuevaConexion.start();
                
                // TODO close "canal" when close process
            }
        }
        catch (IOException e ) {
            System.out.println( e );
        }
        
    }
}

