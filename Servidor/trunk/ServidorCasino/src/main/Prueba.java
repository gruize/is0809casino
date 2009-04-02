/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package main;

import interfaz.InterfazGraficaServidor;
import interfaz.SplashScreen;
import java.io.File;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 *
 * @author Fiutten
 */
public class Prueba {

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
				InterfazGraficaServidor.getInstancia();
			}
		});
	}

}
