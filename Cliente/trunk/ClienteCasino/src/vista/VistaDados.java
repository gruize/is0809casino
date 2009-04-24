/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package vista;

import controlador.ControladorCliente;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author GabiPC
 */
public class VistaDados extends JFrame implements Observer{

    private ControladorCliente controlador;    

    VistaDados(ControladorCliente control) {
        super("Cliente Casino");
        controlador = control;
        controlador.getModelo().addObserver(this);
        inicializar();
        ponerOyentes();
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e) {
                try {
                    salir();
                } catch (IOException ex) {
                    Logger.getLogger(VistaDados.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        setSize(1024,768);
        setResizable(false);
    }

    public void update(Observable o, Object arg) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private void inicializar() {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    private void ponerOyentes() {
        throw new UnsupportedOperationException("Not yet implemented");
    }
    
    private void salir() throws IOException {
        if (JOptionPane.showConfirmDialog(this,"¿Desea abandonar el juego?",
                "Cierre del juego",JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION){
            try{
				if(controlador.desconectar())
					controlador.desconectarCliente();
			}
            catch (IOException e1) {
                e1.printStackTrace();
			}
            System.exit(0);
        }
    }

}
