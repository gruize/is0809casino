/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.LogicaJuegos;

import java.util.ArrayList;
import java.util.Hashtable;
import javax.swing.DefaultListModel;

/**
 *
 * @author Jaime Guimera
 */
public class GestorSalas {

    Hashtable<Integer, MesaRuleta> salaRuleta;

    public GestorSalas() {
    }

    private void addMesaRuleta() {
    }

    public DefaultListModel getListaMesas() {
        DefaultListModel lista = new DefaultListModel();
        lista.addElement("PEPE2");
        return lista;
    }

    public DefaultListModel getListaSalas() {
        DefaultListModel lista = new DefaultListModel();
        lista.addElement("Sala Ruleta");
        return lista;
    }
}
