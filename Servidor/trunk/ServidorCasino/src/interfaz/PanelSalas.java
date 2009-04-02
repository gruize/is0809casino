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
public class PanelSalas extends JPanel {

    private JLabel jLabelSalas;
    private JTextArea jSalas;
    private JScrollPane jScroll;
	private JPanel jPanel1;
    private JPanel jPanel2;
    
    public PanelSalas() {
       setLayout(new BorderLayout());
       jPanel1 = new JPanel();
       jPanel2 = new JPanel();
       jLabelSalas = new JLabel("    Salas disponibles:");
       jSalas = new JTextArea();
       jSalas.setFont(new Font("Serif", Font.ITALIC, 12));
       jSalas.setLineWrap(true);
       jSalas.setWrapStyleWord(true);
       jSalas.setEditable(false);
       jScroll = new JScrollPane(jSalas);
       jScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
       jScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
       add(jLabelSalas,BorderLayout.NORTH);
       add(jSalas,BorderLayout.CENTER);
       add(jPanel1,BorderLayout.EAST);
       add(jPanel2,BorderLayout.WEST);

    }
}
