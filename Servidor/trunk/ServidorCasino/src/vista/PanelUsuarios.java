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
public class PanelUsuarios extends JPanel {

    private JLabel jLabelConectados;
    private JList jConectados;
	private JPanel jPanel1;
    private JPanel jPanel2;
    private JScrollPane jScroll;
    private ControladorServidor controlador;

    public PanelUsuarios(ControladorServidor control) {
       setLayout(new BorderLayout());
       controlador = control;
       jPanel1 = new JPanel();
       jPanel2 = new JPanel();
       jLabelConectados = new JLabel("    Clientes del casino:");
       jConectados = new JList(controlador.getListaUsuarios());
       jConectados.setFont(new Font("Serif", Font.ITALIC, 12));
       jConectados.setBorder(BorderFactory.createEtchedBorder());
       jConectados.setToolTipText("Clientes");
       jScroll = new JScrollPane(jConectados);
       jScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
       jScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
       add(jLabelConectados,BorderLayout.NORTH);
       add(jScroll,BorderLayout.CENTER);
       add(jPanel1,BorderLayout.EAST);
       add(jPanel2,BorderLayout.WEST);
    }

    public JList getConectados() {
        return jConectados;
    }

}
