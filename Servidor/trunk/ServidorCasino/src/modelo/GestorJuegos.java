/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import javax.swing.DefaultListModel;
import modelo.LogicaJuegos.GestorSalas;

/**
 *
 * @author Jaime Guimera
 */
public class GestorJuegos {

    private static GestorJuegos instancia;
    private GestorSalas gestorSalas;

    public static GestorJuegos getInstancia() {
        if (instancia == null) {
            instancia = new GestorJuegos();
        }
        return instancia;
    }

    public GestorJuegos() {
        gestorSalas= new GestorSalas();
    }
    public DefaultListModel getMesas(){
    return gestorSalas.getListaMesas();
    }
    public DefaultListModel getSalas(){
    return gestorSalas.getListaSalas();
    }
}
