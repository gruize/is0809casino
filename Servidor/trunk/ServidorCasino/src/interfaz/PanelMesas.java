/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package interfaz;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author Fiutten
 */
public class PanelMesas extends JPanel {

    private JLabel jLabelMesas;
    private JTextArea jMesas;
    private JScrollPane jScroll;
	private JPanel jPanel1;
    private JPanel jPanel2;
    
    public PanelMesas() {
       setLayout(new BorderLayout());
       jPanel1 = new JPanel();
       jPanel2 = new JPanel();
       jLabelMesas = new JLabel("     Mesas en sala:");
       jMesas = new JTextArea();
       jMesas.setFont(new Font("Serif", Font.ITALIC, 12));
       jMesas.setLineWrap(true);
       jMesas.setWrapStyleWord(true);
       jMesas.setEditable(false);
       jScroll = new JScrollPane(jMesas);
       jScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
       jScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
       add(jLabelMesas,BorderLayout.NORTH);
       add(jMesas,BorderLayout.CENTER);
       add(jPanel1,BorderLayout.EAST);
       add(jPanel2,BorderLayout.WEST);

    }
}
