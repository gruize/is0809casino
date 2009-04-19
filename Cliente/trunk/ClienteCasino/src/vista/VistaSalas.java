/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package vista;

import controlador.ControladorCliente;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
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
import javax.swing.ScrollPaneLayout;

/**
 *
 * @author GabiPC
 */
public class VistaSalas  extends JFrame implements Observer{

    private JPanel jBotones;
    private JPanel jSalas;
    private JButton jRefrescar;
    private JButton jSalir;
    private OyenteRefrescar oyenteRefrescar;
    private OyenteSalir oyenteSalir;
    private ControladorCliente controlador;
    private JScrollPane scroll;

    public VistaSalas(ControladorCliente control) {
        super("Salas disponibles en el casino");
        controlador = control;
        inicializar();
        agregarOyentes();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(300,200);
        setSize(500,500);
		setVisible(true);
        setResizable(false);
    }

    public void inicializar() {
         Color colorCasino = new Color(18,113,4);
         setLayout(new BorderLayout());
         jBotones = new JPanel();
         jBotones.setBackground(colorCasino);
         jSalas = new JPanel();
         jRefrescar = new JButton("Actualizar");
         jSalir = new JButton("Salir");
         jBotones.add(jRefrescar);
         jBotones.add(jSalir);
         jSalas.setBackground(Color.BLACK);         
         add(jBotones,BorderLayout.NORTH);
         add(jSalas,BorderLayout.CENTER);
         jSalas.setBackground(Color.BLACK);
         jSalas.setSize(100,100);
         jSalas.setPreferredSize(new Dimension(100,100));
         scroll = new JScrollPane();
         scroll.setBackground(Color.PINK);
         scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
         scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
         scroll.getViewport().setView(jSalas);
         add(scroll,BorderLayout.CENTER);
         rellenarSalas(50);
    }

    public void agregarOyentes() {
        oyenteRefrescar = new OyenteRefrescar();
        oyenteSalir = new OyenteSalir();
        jRefrescar.addActionListener(oyenteRefrescar);
        jSalir.addActionListener(oyenteSalir);
    }

    public void rellenarSalas(int numeroSalas) {
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
        //int numeroSalas = controlador.getNumeroSalas();
        for(int i=0; i < numeroSalas; i++) {
            JButton nuevaSala = new JButton(new ImageIcon("./recursos/ruletaSala.jpg"));
            nuevaSala.setPreferredSize(new Dimension(114,86));            
            nuevaSala.setName("Sala"+i);
            jSalas.add(nuevaSala);
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
            rellenarSalas(3);
        }
    }

    class OyenteSalir implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            salir();
        }

    }

    private void salir() {
        if (JOptionPane.showConfirmDialog(this,"¿Desea abandonar el juego?",
                "Cierre del juego",JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION)
            //try {
				if(controlador.desconectar()){
					controlador.desconectarCliente();
                    System.exit(0);
                }/**
			}
            catch (IOException e1) {
                e1.printStackTrace();
			}*/
            

    }

    class OyenteSalas implements ActionListener {

        public void actionPerformed(ActionEvent e) {
           System.out.println("OK oyente");
           dispose();
           VistaMesas vistaMesas = new VistaMesas(controlador);

        }

    }

    public void update(Observable o, Object arg) {
        //TODO: Por hacer.
    }

}
