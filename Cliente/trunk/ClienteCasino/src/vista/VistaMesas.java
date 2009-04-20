/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package vista;

import controlador.ControladorCliente;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author GabiPC
 */
public class VistaMesas extends JFrame implements Observer{

    private JPanel jBotones;
    private JPanel jMesas;
    private JPanel jEntrada;
    private JButton jRefrescar;
    private JButton jSalir;
    private JButton jEntrar;
    private JTextArea jUsuarios;
    private JTextArea jApuestaMin;
    private OyenteRefrescar oyenteRefrescar;
    private OyenteSalir oyenteSalir;
    private OyenteEntrar oyenteEntrar;
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
         jRefrescar = new JButton("Actualizar");
         jSalir = new JButton("Salir");
         jBotones.add(jRefrescar);
         jBotones.add(jSalir);
         add(jBotones,BorderLayout.NORTH);

         jMesas = new JPanel();
         jMesas.setBackground(Color.BLACK);
         jMesas.setLayout(new GridLayout(0, 8));
         add(jMesas,BorderLayout.CENTER);

         jEntrada = new JPanel();
         jUsuarios = new JTextArea("Usuarios conectados");
         jApuestaMin = new JTextArea("Apuesta minima");
         jEntrar = new JButton("Entrar");
         jEntrar.setEnabled(false);
         jEntrada.add(jUsuarios);
         jEntrada.add(jApuestaMin);
         jEntrada.add(jEntrar);
         add(jEntrada,BorderLayout.SOUTH);

         rellenarMesas();
    }

    public void agregarOyentes() {
        oyenteRefrescar = new OyenteRefrescar();
        oyenteSalir = new OyenteSalir();
        oyenteEntrar = new OyenteEntrar();
        jRefrescar.addActionListener(oyenteRefrescar);
        jSalir.addActionListener(oyenteSalir);
        jEntrar.addActionListener(oyenteEntrar);
    }

    public void rellenarMesas() {
        /**
         * Mismo proceso que con las salas
         */
        jMesas.removeAll();
        //int mesas = controlador.getNumeroMesas(sala);
        int mesas = 10;
        for(int i=0;i<mesas;i++) {
            JButtonMesa nuevaMesa;
            if (i < 10){
                nuevaMesa = new JButtonMesa("Mesa0"+i,1,1,1);
                nuevaMesa.setActionCommand("Mesa0"+i);
                nuevaMesa.setIcon(new ImageIcon("./recursos/mesas.jpg"));
                nuevaMesa.setBorder(null);
            }else{
                nuevaMesa = new JButtonMesa("Mesa"+i,1,1,1);
                nuevaMesa.setActionCommand("Mesa"+i);
                nuevaMesa.setIcon(new ImageIcon("./recursos/mesas.jpg"));
                nuevaMesa.setBorder(null);                
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
            jUsuarios.setText("Usuarios conectados en la" + e.getActionCommand());
            jApuestaMin.setText("Apuesta minima necesaria en la " + e.getActionCommand());
            jEntrar.setEnabled(true);
        }

    }

    class OyenteEntrar implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            dispose();
            VistaRuleta vistaRuleta = new VistaRuleta(controlador);
            vistaRuleta.setVisible(true);
        }

    }
    public void update(Observable o, Object arg) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
