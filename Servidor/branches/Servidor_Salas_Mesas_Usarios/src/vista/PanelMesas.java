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
public class PanelMesas extends JPanel {

    private JLabel jLabelMesas;
    private JList jMesas;
    private JScrollPane jScroll;
	private JPanel jPanel1;
    private JPanel jPanel2;
    private ControladorServidor controlador;
    
    public PanelMesas(ControladorServidor control) {
       setLayout(new BorderLayout());
       controlador = control;
       jPanel1 = new JPanel();
       jPanel2 = new JPanel();
       jLabelMesas = new JLabel("     Mesas en sala:");
       jMesas = new JList(controlador.getListaMesas());
       jMesas.setFont(new Font("Serif", Font.ITALIC, 12));
       jMesas.setBorder(BorderFactory.createEtchedBorder());
       jMesas.setToolTipText("Mesas");
       jScroll = new JScrollPane(jMesas);
       jScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
       jScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
       add(jLabelMesas,BorderLayout.NORTH);
       add(jMesas,BorderLayout.CENTER);
       add(jPanel1,BorderLayout.EAST);
       add(jPanel2,BorderLayout.WEST);
    }

    public JList getMesas() {
        return jMesas;
    }
}
