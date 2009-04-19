/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package vista;

import controlador.ControladorCliente;
import javax.swing.*;
import java.awt.event.*;
/**
 *
 * @author david
 */
public class VistaLogin extends JFrame {

    private ControladorCliente controlador;
    private JPanelLogin PanelLogin;
    private OyenteEnviarMensajeLogin enviarMensajeLogin;
    private OyenteCancelarLogin cancelarLogin;

    public VistaLogin(ControladorCliente control) {
        super("Cliente Casino");
        controlador = control;
        inicializar();
        ponerOyentes();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(332,194);
        setLocation(400,300);
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
       cancelarLogin = new OyenteCancelarLogin();
       PanelLogin.getBotonCancelar().addActionListener(cancelarLogin);
    }
    
    class OyenteEnviarMensajeLogin implements ActionListener{
        public void actionPerformed(ActionEvent e) {
           //TODO: Quitar el comentario y revisar el metodo.
            if (controlador.conectar(PanelLogin.getUsuario(), PanelLogin.getPassword())){
              System.out.println("conectado");
              dispose();
              VistaSalas vistaSala = new VistaSalas(controlador);
              vistaSala.setVisible(true);
           }
           else{
               JOptionPane.showMessageDialog(null,"Usuario incorrecto","Error de usuario",JOptionPane.ERROR_MESSAGE);
               PanelLogin.getCampoUsuario().setText("");
               PanelLogin.getCampoPassword().setText("");
           }
        }

    }

    class OyenteCancelarLogin implements ActionListener{

        public void actionPerformed(ActionEvent e) {            
            System.out.println("Error de usuario en Login: Cancelado el login sin conectar");
            System.exit(0);
        }

    }
}
