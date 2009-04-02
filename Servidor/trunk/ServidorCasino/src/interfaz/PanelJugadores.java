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
public class PanelJugadores extends JPanel {

    private JLabel jLabelJugadores;
    private JTextArea jJugadores;
    private JScrollPane jScroll;
	private JPanel jPanel1;
    private JPanel jPanel2;

    
    public PanelJugadores() {
       setLayout(new BorderLayout());
       jPanel1 = new JPanel();
       jPanel2 = new JPanel();
       jLabelJugadores = new JLabel("     Jugadores en mesa:");
       jJugadores = new JTextArea();
       jJugadores.setFont(new Font("Serif", Font.ITALIC, 12));
       jJugadores.setLineWrap(true);
       jJugadores.setWrapStyleWord(true);
       jJugadores.setEditable(false);
       jScroll = new JScrollPane(jJugadores);
       jScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
       jScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
       add(jLabelJugadores,BorderLayout.NORTH);
       add(jJugadores,BorderLayout.CENTER);
       add(jPanel1,BorderLayout.EAST);
       add(jPanel2,BorderLayout.WEST);
    }

}
