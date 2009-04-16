/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package vista;

import java.util.Observer;
import java.util.Observable;
import controlador.ControladorCliente;
import javax.swing.*;
import java.awt.event.*;
/**
 *
 * @author david
 */
public class VistaLogin extends JFrame implements Observer  {

    private ControladorCliente controlador;
    private JPanelLogin PanelLogin;
    private OyenteEnviarMensajeLogin enviarMensajeLogin;

    public VistaLogin(ControladorCliente control) {
        super("Cliente Casino");
        controlador = control;
        inicializar();
        ponerOyentes();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(332,174);
		setVisible(true);
        setResizable(false);
        
     }
    private void inicializar() {

        PanelLogin = new JPanelLogin(controlador);
        add(PanelLogin);
    }
    private void ponerOyentes() {

       enviarMensajeLogin = new OyenteEnviarMensajeLogin();

       PanelLogin.getBotonAceptar().addActionListener(enviarMensajeLogin);
    }
    public void update(Observable o, Object arg) {
        //if(obj instanceof
        //Hacer lo que sea.
    }
    class OyenteEnviarMensajeLogin implements ActionListener{

        public void actionPerformed(ActionEvent e) {
         
           if (controlador.conectar(PanelLogin.getUsuario(), PanelLogin.getPassword())){
              System.out.println("conectado");
              dispose();
              VistaCliente vistajugar = new VistaCliente(controlador);
           }
           else{
               //borrar campos
           }
        }

    }
}
