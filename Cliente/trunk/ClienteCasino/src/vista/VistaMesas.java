/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package vista;

import controlador.ControladorCliente;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author GabiPC
 */
public class VistaMesas extends JFrame implements Observer{

    private int sala;
    private JPanel jBotones;
    private JPanel jMesas;
    private JButton jRefrescar;
    private JButton jSalir;
    private OyenteRefrescar oyenteRefrescar;
    private OyenteSalir oyenteSalir;
    private ControladorCliente controlador;

    public VistaMesas(ControladorCliente control) {
        super("Mesas disponibles en la sala");
        controlador = control;
        inicializar();
        agregarOyentes();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1024,768);
		setVisible(true);
        setResizable(false);
    }

      public void inicializar() {
         setLayout(new BorderLayout());
         jBotones = new JPanel();
         jMesas = new JPanel();
         jRefrescar = new JButton("Actualizar");
         jSalir = new JButton("Salir");
         jBotones.add(jRefrescar);
         jBotones.add(jSalir);
         jMesas.setBackground(Color.BLACK);
         jMesas.setLayout(new FlowLayout(FlowLayout.LEFT));
         add(jBotones,BorderLayout.NORTH);
         add(jMesas,BorderLayout.CENTER);
         rellenarMesas();
    }

    public void agregarOyentes() {
        oyenteRefrescar = new OyenteRefrescar();
        oyenteSalir = new OyenteSalir();
        jRefrescar.addActionListener(oyenteRefrescar);
        jSalir.addActionListener(oyenteSalir);
    }

    public void rellenarMesas() {
        /**
         * Mismo proceso que con las salas
         */
        jMesas.removeAll();
        int mesas = controlador.getNumeroMesas(sala);
        for(int i=0;i<mesas;i++) {
            JButtonMesa nuevaMesa;
            if (i < 10){
                nuevaMesa = new JButtonMesa("Mesa0"+i,1,1,1);
                nuevaMesa.setActionCommand("Sala"+sala+"Mesa0"+i);
            }else{
                nuevaMesa = new JButtonMesa("Mesa"+i,1,1,1);
                nuevaMesa.setActionCommand("Sala"+sala+"Mesa"+i);
            }
            jMesas.add(nuevaMesa);
            nuevaMesa.addActionListener(new OyenteMesas());
        }

    }

    class OyenteRefrescar implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            rellenarMesas();
        }
    }

    class OyenteSalir implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            try {
                salir();
            } catch (IOException ex) {
                Logger.getLogger(VistaMesas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    private void salir() throws IOException {
        if (JOptionPane.showConfirmDialog(this,"¿Desea abandonar el juego?",
                "Cierre del juego",JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION)
            try {
				if(controlador.desconectar()){
					controlador.desconectarCliente();
                    System.exit(0);
                }
			}
            catch (IOException e1) {
                e1.printStackTrace();
			}


    }

    class OyenteMesas implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            dispose();
            String idsalamesa = e.getActionCommand();
            VistaCliente vistaCliente = new VistaCliente(controlador,idsalamesa);
            vistaCliente.setVisible(true);
        }

    }

    public void update(Observable o, Object arg) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
