/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package vista;

import controlador.ControladorServidor;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author Fiutten
 */
public class PanelSalas extends JPanel {

    private JLabel jLabelSalas;
    private JList jSalas;
	private JPanel jPanel1;
    private JPanel jPanel2;
    private JScrollPane jScroll;
    private ControladorServidor controlador;
    
    public PanelSalas(ControladorServidor control) {
       setLayout(new BorderLayout());
       controlador = control;
       jPanel1 = new JPanel();
       jPanel2 = new JPanel();
       jLabelSalas = new JLabel("    Salas disponibles:");
       jSalas = new JList(controlador.getListaSalas());
       jSalas.setFont(new Font("Serif", Font.ITALIC, 12));
       jSalas.setBorder(BorderFactory.createEtchedBorder());
       jSalas.setToolTipText("Salas");
       jScroll = new JScrollPane(jSalas);
       jScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
       jScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
       add(jLabelSalas,BorderLayout.NORTH);
       add(jScroll,BorderLayout.CENTER);
       add(jPanel1,BorderLayout.EAST);
       add(jPanel2,BorderLayout.WEST);
    }

    public JList getSalas() {
        return jSalas;
    }
}
