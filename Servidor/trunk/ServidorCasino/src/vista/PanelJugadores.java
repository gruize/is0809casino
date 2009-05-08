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
public class PanelJugadores extends JPanel {

    private JLabel jLabelJugadores;
    private JList jJugadores;
	private JPanel jPanel1;
    private JPanel jPanel2;
    private JScrollPane jScroll;
    private ControladorServidor controlador;


    public PanelJugadores(ControladorServidor control) {
       setLayout(new BorderLayout());
       controlador = control;
       jPanel1 = new JPanel();
       jPanel2 = new JPanel();
       jLabelJugadores = new JLabel("     Jugadores conectados:");
       jJugadores = new JList(controlador.getListaConectados());
       jJugadores.setFont(new Font("Serif", Font.ITALIC, 12));
       jJugadores.setBorder(BorderFactory.createEtchedBorder());
       jJugadores.setToolTipText("Conectados");
       jScroll = new JScrollPane(jJugadores);
       jScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
       jScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
       add(jLabelJugadores,BorderLayout.NORTH);
       add(jScroll,BorderLayout.CENTER);
       add(jPanel1,BorderLayout.EAST);
       add(jPanel2,BorderLayout.WEST);
    }

    public JList getJugadores() {
        return jJugadores;
    }
}
