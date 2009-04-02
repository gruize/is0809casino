/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Fiutten
 */

package interfaz;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;

public class InterfazGraficaServidor extends JFrame {

	private static InterfazGraficaServidor jFrameMain;
	private PanelLog jPanelLog;
	private PanelSalas jPanelSalas;
	private PanelMesas jPanelMesas;
	private PanelJugadores jPanelJugadores;
    private JPanel jPanelContenedor;
	
	/**
	 * This method initializes jFrameMain
	 *
	 * @return javax.swing.JFrame
	 */

    public static InterfazGraficaServidor getInstancia() {

        if (jFrameMain == null) {
            jFrameMain = new InterfazGraficaServidor();
        }
        return jFrameMain;
    }

    public InterfazGraficaServidor() {
        super("Administrador del servidor");
        inicializar();
        addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent evento){
				salir();
			}
		});
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setExtendedState(MAXIMIZED_BOTH);
		setVisible(true);
        setResizable(false);
    }

    private void inicializar() {
        setLayout(new GridLayout(2,1));
        jPanelContenedor = new JPanel();
        jPanelLog = new PanelLog();
        jPanelMesas = new PanelMesas();
        jPanelSalas = new PanelSalas();
        jPanelJugadores = new PanelJugadores();
        jPanelContenedor.setLayout(new GridLayout(1,3));
        jPanelContenedor.add(jPanelSalas);
        jPanelContenedor.add(jPanelMesas);
        jPanelContenedor.add(jPanelJugadores);
        add(jPanelContenedor);
        add(jPanelLog);

    }

    private void salir() {
        if (JOptionPane.showConfirmDialog(this,"¿Desea abandonar el servidor?",
                "Cierre del servidor",JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION)
                System.exit(0);
        
    }
    
	/**
	 * This method initializes jContentPane
	 *
	 * @return javax.swing.JPanel
	 */
	/*private JPanel getJContentPane() {
		if (jContentPane == null) {
			jLabelLog = new JLabel();
			jLabelLog.setText("Log del servidor");
			jLabelListadeMesas = new JLabel();
			jLabelListadeMesas.setText("Lista de Mesas");
			jLabelListadeSalas = new JLabel();
			jLabelListadeSalas.setText("Lista de Salas");
			jContentPane = new JPanel();
			jContentPane.setPreferredSize(new Dimension(800, 600));
			jContentPane.setLayout(null);
			jContentPane.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
			jContentPane.add(getJPanelLog(), null);
			jContentPane.add(getJPanelSalas(), null);
			jContentPane.add(getJPanelMesas(), null);
			jContentPane.add(getJPanelUsuarios(), null);
			jContentPane.add(jLabelListadeSalas, null);
			jContentPane.add(jLabelListadeMesas, null);
			jContentPane.add(jLabelLog, null);
			jContentPane.setVisible(true);
		}
		return jContentPane;
	}*/

	/**
	 * This method initializes jPanelLog
	 *
	 * @return javax.swing.JPanel
	 */
	/*private JPanel getJPanelLog() {
		if (jPanelLog == null) {
            jPanelLog = new PanelLog();
			jPanelLog.setBounds(new Rectangle(23, 406, 568, 161));
			jPanelLog.setVisible(true);
		}
		return jPanelLog;
	}*/

	/**
	 * This method initializes jPanelSalas
	 *
	 * @return javax.swing.JPanel
	 */
	/*private JPanel getJPanelSalas() {
		if (jPanelSalas == null) {
			jPanelSalas = new JPanel();
			jPanelSalas.setLayout(new GridBagLayout());
			jPanelSalas.setBounds(new Rectangle(337, 25, 248, 348));
		}
		return jPanelSalas;
	}*/

	/**
	 * This method initializes jPanelMesas
	 *
	 * @return javax.swing.JPanel
	 */
	/*private JPanel getJPanelMesas() {
		if (jPanelMesas == null) {
			jPanelMesas = new JPanel();
			jPanelMesas.setLayout(new GridBagLayout());
			jPanelMesas.setBounds(new Rectangle(16, 25, 309, 342));
		}
		return jPanelMesas;
	}*/

	/**
	 * This method initializes jPanelUsuarios
	 *
	 * @return javax.swing.JPanel
	 */
	/*private JPanel getJPanelUsuarios() {
		if (jPanelUsuarios == null) {
			jPanelUsuarios = new JPanel();
			jPanelUsuarios.setBounds(new Rectangle(599, 2, 195, 570));
			jPanelUsuarios.setVisible(true);
			jPanelUsuarios.setLayout(null);
			jPanelUsuarios.add(getJButtonExpulsar(), null);
			jPanelUsuarios.add(getJButtonVerEstadisticas(), null);
			jPanelUsuarios.add(getJList(), null);
		}
		return jPanelUsuarios;
	}*/

	/**
	 * This method initializes jButtonExpulsar
	 *
	 * @return javax.swing.JButton
	 */
	/*private JButton getJButtonExpulsar() {
		if (jButtonExpulsar == null) {
			jButtonExpulsar = new JButton();
			jButtonExpulsar.setBounds(new Rectangle(12, 417, 168, 49));
			jButtonExpulsar.setText("Expulsar jugador");
		}
		return jButtonExpulsar;
	}*/

	/**
	 * This method initializes jButtonVerEstadisticas
	 *
	 * @return javax.swing.JButton
	 */
	/*private JButton getJButtonVerEstadisticas() {
		if (jButtonVerEstadisticas == null) {
			jButtonVerEstadisticas = new JButton();
			jButtonVerEstadisticas.setBounds(new Rectangle(17, 357, 163, 52));
			jButtonVerEstadisticas.setText("Ver Estadisticas");
		}
		return jButtonVerEstadisticas;
	}*/

	/**
	 * This method initializes jList
	 *
	 * @return javax.swing.JList
	 */
	/*private JList getJList() {
		if (jList == null) {
			jList = new JList();
			jList.setBounds(new Rectangle(20, 4, 162, 342));
			jList.setToolTipText("-Lista de Jugadores");
		}
		return jList;
	}*/

}
