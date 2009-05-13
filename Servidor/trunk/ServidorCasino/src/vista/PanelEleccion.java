/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package vista;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 *
 * @author Fiutten
 */
class PanelEleccion extends JPanel {

    private ButtonGroup grupo;
    private JRadioButton uno;
    private JRadioButton dos;
    private JRadioButton tres;

    public PanelEleccion() {
        super();
        uno = new JRadioButton("Clientes: ");
        dos = new JRadioButton("Salas: ");
        tres = new JRadioButton("Partidas: ");
        grupo = new ButtonGroup();
        grupo.add(uno);
        grupo.add(dos);
        grupo.add(tres);
        add(uno);
        add(dos);
        add(tres);
    }

    public int getSeleccionado() {
        if (uno.isSelected()) return 1;
        if (dos.isSelected()) return 2;
        if (tres.isSelected()) return 3;
        return -1;
    }
}
