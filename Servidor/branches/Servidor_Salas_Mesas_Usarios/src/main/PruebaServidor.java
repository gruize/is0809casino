/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package main;

import controlador.ControladorServidor;
import vista.VistaServidor;
import vista.SplashScreen;
import java.util.Vector;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import modelo.LogicaJuegos.Jugada;
import modelo.mensajes.MensajeJugada;
import modelo.ModeloServidor;

/**
 *
 * @author Fiutten
 */
public class PruebaServidor {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        SplashScreen sp = new SplashScreen("./recursos/casino.jpg");
        sp.open(1500);
        try {
        	UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Exception e) {}
        try {
          Thread.sleep(1001);
        } catch (InterruptedException e) {e.printStackTrace();}

        SwingUtilities.invokeLater(new Runnable() {
			public void run() {
                ModeloServidor modelo = new ModeloServidor();
                ControladorServidor controlador = new ControladorServidor(modelo);
				VistaServidor vista = new VistaServidor(controlador);
				modelo.addObserver(vista);
               /* Vector<String> datos=new Vector();
                datos.add(0, "Pepito");
                datos.add(1, "pass");
                controlador.login(datos);
                controlador.mensajeRecibido(3, new MensajeJugada(1,1,null));
                controlador.mensajeRecibido(2, new MensajeJugada(1,1,new Jugada(1,1,"NUMERO",1,1)));
                controlador.mensajeRecibido(2, new MensajeJugada(1,1,new Jugada(1,1,"DOCENA",1,1)));
                controlador.mensajeRecibido(4, new MensajeJugada(1,1,new Jugada(1,1,"DOCENA",1,1)));
                */
                }
		});

	}

}
