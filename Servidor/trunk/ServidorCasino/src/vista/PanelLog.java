/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package vista;

import controlador.ControladorServidor;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author Fiutten
 */
public class PanelLog extends JPanel {

    private JLabel jLabelLog;
    private JTextArea jLog;
    private JScrollPane jScroll;
    private PanelConectados jConectados;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JPanel jPanel4;
    private JButton jExpulsar;
	private JButton jVerEstadisticas;
    private ControladorServidor controlador;

    public PanelLog(ControladorServidor control) {
       setLayout(new GridLayout(1,3));
       controlador = control;
       jConectados = new PanelConectados(controlador);
       jPanel2 = new JPanel();
       jPanel3 = new JPanel();
       jPanel4 = new JPanel();
       jExpulsar = new JButton("Expulsar");
       jVerEstadisticas = new JButton("Estadisticas");
       jLabelLog = new JLabel("  Log:   ");

       jLog = new JTextArea();
       jLog.setFont(new Font("Serif", Font.ITALIC, 12));
       jLog.setText("*********INICIANDO EL SERVIDOR*********\n");
       jLog.setLineWrap(true);
       jLog.setWrapStyleWord(true);
       jLog.setEditable(false);
       jLog.setBorder(BorderFactory.createEtchedBorder());
       jScroll = new JScrollPane(jLog);
       jScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
       jScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
       
       jPanel3.setLayout(new FlowLayout());
       jExpulsar.setPreferredSize(new Dimension(120,30));
       jVerEstadisticas.setPreferredSize(new Dimension(160,30));
       jPanel3.add(jExpulsar);
       jPanel3.add(jVerEstadisticas);
       jPanel2.setLayout(new BorderLayout());
       jPanel2.add(jLabelLog,BorderLayout.NORTH);
       jPanel2.add(jScroll,BorderLayout.CENTER);
       jPanel2.add(jPanel4,BorderLayout.SOUTH);
       add(jConectados);
       add(jPanel2);
       add(jPanel3);

    }

    public JTextArea getLog() {
        return jLog;
    }

    public JScrollPane getScroll() {
        return jScroll;
    }

    public JButton getVerEstadisticas() {
        return jVerEstadisticas;
    }

    public JButton getExpulsar() {
        return jExpulsar;
    }

    public PanelConectados getConectados() {
        return jConectados;
    }
}
