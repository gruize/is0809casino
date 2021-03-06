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
import modelo.Jugada;
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
                controlador.inicializar();
                }
		});

	}

}
