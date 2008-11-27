package Comunicacion.Demonio;

import java.net.*;
import java.io.*;


class Demonio {
    
    public static void main( String args[] ) {
        // todo: puerto leido en configuraci�n
        final int PUERTO = 10809;
        ServerSocket canal;
        Socket conexion;
        InputStream entradaDatos;
        int dato;
        // empezamos a escuchar
        try {
            while (true) {
                canal = new ServerSocket(PUERTO);
                //esperamos a que halla una conxion
                conexion = canal.accept();
                
                //leemos lo que tiene
                // guardamos la informacion en la tabla conrrespondiente (hay que hacer sincronized)
                entradaDatos = conexion.getInputStream();
                // los datos se acaban cuando tiene -1
                // ojo con que no hallan llegado los datos
                while ((dato = entradaDatos.read()) !=-1 ){
                    System.out.print( (char)dato );           
                }
                canal.close();
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