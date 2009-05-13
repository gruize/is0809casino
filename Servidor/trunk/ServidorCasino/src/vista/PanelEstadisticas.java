/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package vista;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author Fiutten
 */
public class PanelEstadisticas extends JPanel {
    
    private JList jEstadisticas;
    private JScrollPane jScroll;

    public PanelEstadisticas(DefaultListModel texto) {
        super();
        setLayout(new BorderLayout());
        jEstadisticas = new JList(texto);
        jEstadisticas.setFont(new Font("Serif", Font.ITALIC, 12));
        jEstadisticas.setBorder(BorderFactory.createEtchedBorder());
        jEstadisticas.setToolTipText("Mesas");
        jScroll = new JScrollPane(jEstadisticas);
        jScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        jScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        add(jScroll,BorderLayout.CENTER);
        setPreferredSize(new Dimension(300,600));
    }

    public JList getEstadisticas() {
        return jEstadisticas;
    }


}
