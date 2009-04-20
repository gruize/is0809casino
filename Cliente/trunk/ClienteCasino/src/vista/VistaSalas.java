/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package vista;

import controlador.ControladorCliente;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author GabiPC
 */
public class VistaSalas  extends JFrame implements Observer{

    private JPanel jBotones;
    private JPanel jSalas;
    private JPanel jEntrada;
    private JButton jRefrescar;
    private JButton jSalir;
    private JTextArea jMesas;
    private JButton jEntrar;
    private OyenteRefrescar oyenteRefrescar;
    private OyenteSalir oyenteSalir;
    private OyenteEntrada oyenteEntrada;
    private ControladorCliente controlador;
    private JScrollPane scroll;


    public VistaSalas(ControladorCliente control) {
        super("Salas disponibles en el casino");
        controlador = control;
        inicializar();
        agregarOyentes();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1024,768);
		setVisible(true);
        setResizable(false);
    }

    public void inicializar() {
         Color colorCasino = new Color(18,113,4);
         setLayout(new BorderLayout());

         jBotones = new JPanel();
         jBotones.setBackground(colorCasino);
         jRefrescar = new JButton("Actualizar");
         jSalir = new JButton("Salir");
         jBotones.add(jRefrescar);
         jBotones.add(jSalir);
         add(jBotones,BorderLayout.NORTH);

         jSalas = new JPanel();
         jSalas.setLayout(new GridLayout(0, 8));
         jSalas.setBackground(Color.BLACK);
         jSalas.setPreferredSize(new Dimension(114,86));
         jSalas.setBackground(Color.BLACK);
         scroll = new JScrollPane();
         scroll.setBackground(Color.PINK);
         scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
         scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
         scroll.getViewport().setView(jSalas);
         add(scroll,BorderLayout.CENTER);

         jEntrada = new JPanel();
         jEntrada.setBackground(colorCasino);
         jMesas = new JTextArea();
         jMesas.setText("Mesas disponibles");
         jEntrar = new JButton("Entrar");
         jEntrar.setEnabled(false);
         jEntrada.add(jMesas);
         jEntrada.add(jEntrar);
         add(jEntrada, BorderLayout.SOUTH);

         rellenarSalas();
    }

    public void agregarOyentes() {
        oyenteRefrescar = new OyenteRefrescar();
        oyenteSalir = new OyenteSalir();
        oyenteEntrada = new OyenteEntrada();
        jRefrescar.addActionListener(oyenteRefrescar);
        jSalir.addActionListener(oyenteSalir);
        jEntrar.addActionListener(oyenteEntrada);
    }

    public void rellenarSalas() {
        //Preguntar al controlador por el numero de salas que hay
        //El controlador manda un mensaje al servidor
        //El servidor le comunica los datos de las salas
        //Se recibe el mensaje y se cambiaria el estado de la vista
        //En el metodo update se trataria el mensaje y se dibujarian las salas
        /**
         * Eliminar todas las salas existentes y visibles
         */
         jSalas.removeAll();
        /**
         * Generar todas las nuevas salas.
         */
        //int numeroSalasRuleta = controlador.getNumeroSalasRuleta();
        //int numeroSalasDados = controlador.getNumeroSalasDados();
        int numeroSalasRuleta = 6;
        int numeroSalasDados = 1;
        for(int i=0; i < numeroSalasRuleta; i++) {
            JButton nuevaSala = new JButton(new ImageIcon("./recursos/ruletaSala.jpg"));
            nuevaSala.setPreferredSize(new Dimension(114,86));            
            nuevaSala.setName("SalaRuleta"+i);
            nuevaSala.setActionCommand("SalaRuleta"+i);
            jSalas.add(nuevaSala);
            nuevaSala.addActionListener(new OyenteSalas());
        }        
        for(int i=0; i < numeroSalasDados; i++) {
            JButton nuevaSala = new JButton(new ImageIcon("./recursos/dadosSala.jpg"));
            nuevaSala.setPreferredSize(new Dimension(114,86));
            nuevaSala.setName("SalaDados"+i);
            nuevaSala.setActionCommand("SalaDados"+i);
            jSalas.add(nuevaSala);
            nuevaSala.addActionListener(new OyenteSalas());
        }

    }

    class OyenteRefrescar implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            /**
             * Preguntar al controlador por el numero de salas que hay
             * El controlador manda un mensaje al servidor
             * El servidor le comunica los datos de las salas
             * Se recibe el mensaje y se cambiaria el estado de la vista
             */
            rellenarSalas();
        }
    }

    class OyenteSalir implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            salir();
        }

    }

    class OyenteEntrada implements ActionListener {

        public void actionPerformed(ActionEvent e) {
           dispose();
           VistaMesas vistaMesas = new VistaMesas(controlador);
        }

    }
    private void salir() {
        if (JOptionPane.showConfirmDialog(this,"¿Desea abandonar el juego?",
                "Cierre del juego",JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION)
            //try {
				if(controlador.desconectar()){
					//controlador.desconectarCliente();
                    System.exit(0);
                }/**
			}
            catch (IOException e1) {
                e1.printStackTrace();
			}*/
            

    }

    class OyenteSalas implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            //TODO: X hacer
            jMesas.setText("Mesas disponibles en la " + e.getActionCommand());
            jEntrar.setEnabled(true);
        }

    }

    public void update(Observable o, Object arg) {
        //TODO: Por hacer.
    }

}
