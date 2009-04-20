/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import modelo.GestorJuegosServidor;
import java.io.IOException;
import java.util.Observable;
import javax.swing.DefaultListModel;

/**
 *
 * @author Fiutten
 */
public class ModeloServidor extends Observable {
    
    public ModeloServidor() {
        
    }

    public void cerrarConexion() throws IOException {
        
    }

    public void expulsarJugador(String jugador) {
        
    }

    public DefaultListModel getListaConectados() {
        DefaultListModel lista = new DefaultListModel();
        lista.addElement("PEPE");
        lista.addElement("PEPON");
        return lista;
    }

    public DefaultListModel getListaJugadores() {
       DefaultListModel lista = new DefaultListModel();
        lista.addElement("PEPE1");
        return lista;
    }

    public DefaultListModel getListaMesas() {
        DefaultListModel lista = new DefaultListModel();
        lista.addElement("MESA 1");
        return lista;

    }

    public DefaultListModel getListaSalas() {
       DefaultListModel lista = new DefaultListModel();
        lista.addElement("Sala Ruleta");
        return lista;
    }

    public void mostrarJugadoresAsociados(String mesa) {
        System.out.println("lk");
    }

    public void mostrarMesasAsociadas(String sala) {
        System.out.println("JAJA");
    }

    public boolean servidorConectado() {
        return true;
    }

    public void verEstadisticas(String usuario) {
        
    }

}
