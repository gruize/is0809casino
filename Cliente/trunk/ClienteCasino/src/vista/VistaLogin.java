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
    private OyenteCancelarLogin cancelarLogin;

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
       cancelarLogin = new OyenteCancelarLogin();
       PanelLogin.getBotonCancelar().addActionListener(cancelarLogin);

    }
    public void update(Observable o, Object arg) {
        //if(obj instanceof
        //Hacer lo que sea.
    }
    class OyenteEnviarMensajeLogin implements ActionListener{

        public void actionPerformed(ActionEvent e) {
           //TODO: Quitar el comentario y revisar el metodo.
            if (//controlador.conectar(PanelLogin.getUsuario(), PanelLogin.getPassword())){
              true){
              System.out.println("conectado");
              dispose();
              /**
               * Muestra la vista de las salas, donde el usuario debe seleccionar la sala
               * donde desea jugar.
               */
              VistaSalas vistaSala = new VistaSalas(controlador);
              vistaSala.setVisible(true);
           }
           else{
               /**
                * Se borra el contenido de los campos.
                */
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
