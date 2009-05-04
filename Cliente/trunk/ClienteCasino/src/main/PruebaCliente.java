/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package main;

import controlador.ControladorCliente;
import java.io.IOError;
import java.util.Vector;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import modelo.ModeloCliente;
import modelo.NombreJuegos;
import modelo.mensajes.objetos.PeticionSala;
import vista.*;

/**
 *
 * @author Fiutten
 */
public class PruebaCliente {

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
                modelo.setUsuario("Gabi");
                modelo.setSaldo(1000);
                ControladorCliente controlador = new ControladorCliente(modelo);
                VistaRuleta vistalogin =new VistaRuleta(controlador);
                vistalogin.setVisible(true);
			}
		});
	}

}
