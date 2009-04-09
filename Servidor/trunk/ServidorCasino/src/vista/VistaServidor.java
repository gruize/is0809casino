/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Fiutten
 */

package vista;

import controlador.ControladorServidor;
import java.awt.event.ActionEvent;
import java.util.Observable;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.Observer;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class VistaServidor extends JFrame implements Observer  {

	private PanelLog jPanelLog;
	private PanelSalas jPanelSalas;
	private PanelMesas jPanelMesas;
	private PanelJugadores jPanelJugadores;
    private JPanel jPanelContenedor;
    private ControladorServidor controlador;
    private OyenteVerEstadisticas estadisticas;
    private OyenteExpulsar expulsar;
    private OyenteCerrarVentana cerrarVentana;
    private OyenteListaSalas salas;
    private OyenteListaMesas mesas;
	

    public VistaServidor(ControladorServidor control) {
        super("Administrador del servidor");
        controlador = control;
        inicializar();
        ponerOyentes();
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setExtendedState(MAXIMIZED_BOTH);
		setVisible(true);
        setResizable(false);
    }

    private void inicializar() {
        setLayout(new GridLayout(2,1));
        jPanelContenedor = new JPanel();
        jPanelLog = new PanelLog(controlador);
        jPanelMesas = new PanelMesas(controlador);
        jPanelSalas = new PanelSalas(controlador);
        jPanelJugadores = new PanelJugadores(controlador);
        jPanelContenedor.setLayout(new GridLayout(1,3));
        jPanelContenedor.add(jPanelSalas);
        jPanelContenedor.add(jPanelMesas);
        jPanelContenedor.add(jPanelJugadores);
        add(jPanelContenedor);
        add(jPanelLog);

    }

    private void ponerOyentes() {
        estadisticas = new OyenteVerEstadisticas();
        expulsar = new OyenteExpulsar();
        cerrarVentana = new OyenteCerrarVentana();
        salas = new OyenteListaSalas();
        mesas = new OyenteListaMesas();
        jPanelLog.getVerEstadisticas().addActionListener(estadisticas);
        jPanelLog.getExpulsar().addActionListener(expulsar);
        jPanelSalas.getSalas().addListSelectionListener(salas);
        jPanelMesas.getMesas().addListSelectionListener(mesas);
        addWindowListener(cerrarVentana);
    }

    private void salir() {
        if (JOptionPane.showConfirmDialog(this,"¿Desea abandonar el servidor?",
                "Cierre del servidor",JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION)
            try {
				if(controlador.servidorConectado())
					controlador.cerrarConexion();
			}
            catch (IOException e1) {
                e1.printStackTrace();
			}
            System.exit(0);
        
    }

    public void update(Observable o, Object arg) {
        //if(obj instanceof
        //Hacer lo que sea.
    }

    class OyenteCerrarVentana extends WindowAdapter{

		public void windowClosing(WindowEvent e){
            salir();
		}

	}

    class OyenteVerEstadisticas implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            JList lista = jPanelLog.getConectados().getConectados();
            if (lista.getSelectedValue() != null) {
                controlador.verEstadisticas(lista.getSelectedValue().toString());
                 lista.removeSelectionInterval(lista.getSelectedIndex(),lista.getSelectedIndex());
            }
            else
                JOptionPane.showMessageDialog(null,"Seleccione un cliente en conectados",
                        "Error en selección",JOptionPane.ERROR_MESSAGE);
        }

    }

    class OyenteExpulsar implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            JList lista = jPanelLog.getConectados().getConectados();
            if (lista.getSelectedValue() != null) {
                controlador.expulsarJugador(lista.getSelectedValue().toString());
                lista.removeSelectionInterval(lista.getSelectedIndex(),lista.getSelectedIndex());
            }
            else
                JOptionPane.showMessageDialog(null,"Seleccione un cliente en conectados",
                        "Error en selección",JOptionPane.ERROR_MESSAGE);
        }
    }

    class OyenteListaSalas implements ListSelectionListener {

        public void valueChanged(ListSelectionEvent e) {
            JList lista = jPanelSalas.getSalas();
            if (lista.getSelectedValue() != null) {
                controlador.mostrarMesasAsociadas(lista.getSelectedValue().toString());
            }
        }

    }

    class OyenteListaMesas implements ListSelectionListener {

        public void valueChanged(ListSelectionEvent e) {
            JList lista = jPanelMesas.getMesas();
            if (lista.getSelectedValue() != null) {
                controlador.mostrarJugadoresAsociados(lista.getSelectedValue().toString());
            }
        }

    }
}

