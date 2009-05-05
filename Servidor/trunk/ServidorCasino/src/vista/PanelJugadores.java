/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package vista;

import controlador.ControladorServidor;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

/**
 *
 * @author Fiutten
 */
public class PanelJugadores extends JPanel {

    private JLabel jLabelJugadores;
    private JList jJugadores;
	private JPanel jPanel1;
    private JPanel jPanel2;
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
       add(jLabelJugadores,BorderLayout.NORTH);
       add(jJugadores,BorderLayout.CENTER);
       add(jPanel1,BorderLayout.EAST);
       add(jPanel2,BorderLayout.WEST);
    }

    public JList getJugadores() {
        return jJugadores;
    }
}
