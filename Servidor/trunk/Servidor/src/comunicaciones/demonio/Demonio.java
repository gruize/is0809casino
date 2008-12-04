package comunicaciones.demonio;

import java.net.*;
import java.util.*;
import java.io.*;


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
			
		}
		// TODO: puerto leido en configuraci�n
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
        // Abrimos una conexión con breogan en el puerto 4321
    }
}
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*package conector;

import java.awt.*;
import java.net.*;
import java.io.*;

class conector {
    public static void main( String args[] ) throws IOException {
        String datos = "pepitogrillo";
        Socket conexion;
        OutputStream salidaDatos;
        final int PUERTO = 10809;
        final String SERVER = "localhost";

        // Abrimos una conexión con breogan en el puerto 4321
        try {
            conexion = new Socket( SERVER,PUERTO);
            salidaDatos = conexion.getOutputStream();
            for (int i = 0; i < datos.length();i++)
                salidaDatos.write((byte)datos.charAt(i));
        

            conexion.close();
        } catch( IOException e ) {
            System.out.println( e );
        }
    }
}*/