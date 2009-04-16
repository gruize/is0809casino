/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package main;

import controlador.ControladorCliente;
import vista.VistaCliente;
import vista.VistaLogin;
import vista.SplashScreen;
import java.io.File;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import modelo.ModeloCliente;
import comunicaciones.*;

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

                ModeloCliente modelo = new ModeloCliente();
                ControladorCliente controlador = new ControladorCliente(modelo);
                Comunicador c = new Comunicador(controlador);
				modelo.setComunicaciones(c);
                VistaLogin vistalogin =new VistaLogin(controlador);
                VistaCliente vistajugar = new VistaCliente(controlador);
                //new Thread1("Recojo mensajes de comunicaciones").start();
               
                //Comunicador c = new Comunicador(new ControladorCliente(new ModeloCliente()));
			}
		});
	}

}
