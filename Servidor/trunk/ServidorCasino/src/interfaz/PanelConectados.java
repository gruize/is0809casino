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
public class PanelConectados extends JPanel {

    private JLabel jLabelConectados;
    private JTextArea jConectados;
    private JScrollPane jScroll;
	private JPanel jPanel1;
    private JPanel jPanel2;

    
    public PanelConectados() {
       setLayout(new BorderLayout());
       jPanel1 = new JPanel();
       jPanel2 = new JPanel();
       jLabelConectados = new JLabel("    Conectados:");
       jConectados = new JTextArea();
       jConectados.setFont(new Font("Serif", Font.ITALIC, 12));
       jConectados.setLineWrap(true);
       jConectados.setWrapStyleWord(true);
       jConectados.setEditable(false);
       jScroll = new JScrollPane(jConectados);
       jScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
       jScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
       add(jLabelConectados,BorderLayout.NORTH);
       add(jConectados,BorderLayout.CENTER);
       add(jPanel1,BorderLayout.EAST);
       add(jPanel2,BorderLayout.WEST);
    }

}
