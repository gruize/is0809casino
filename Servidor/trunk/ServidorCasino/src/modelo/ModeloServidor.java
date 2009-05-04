/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import java.io.IOException;
import java.util.Observable;
import javax.swing.DefaultListModel;

/**
 *
 * @author Fiutten
 */
public class ModeloServidor extends Observable {


    private DefaultListModel listaConectados;
    private DefaultListModel listaJugadores;
    private DefaultListModel listaSalas;
    private DefaultListModel listaMesas;

    public ModeloServidor() {
        listaConectados = new DefaultListModel();
        listaJugadores = new DefaultListModel();
        listaSalas = new DefaultListModel();
        listaMesas = new DefaultListModel();
    }

    public void login(String usuario, String password) {
        listaConectados.addElement(usuario);
        MensajeLog mensaje = new MensajeLog(usuario,password);
        setChanged();
        notifyObservers(mensaje);
    }



    public void cerrarConexion() throws IOException {

    }

    public void expulsarJugador(String jugador) {

    }

    public DefaultListModel getListaConectados() {
        return listaConectados;
    }

    public DefaultListModel getListaJugadores() {
        return listaJugadores;
    }

    public DefaultListModel getListaMesas() {
        return listaMesas;
    }

    public DefaultListModel getListaSalas() {

        return listaSalas;
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
