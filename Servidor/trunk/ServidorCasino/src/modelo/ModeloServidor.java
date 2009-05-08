/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import java.io.IOException;
import java.util.Observable;
import javax.swing.DefaultListModel;
import modelo.mensajes.MensajeChat;

/**
 *
 * @author Fiutten
 */
public class ModeloServidor extends Observable {


    private DefaultListModel listaConectados;
    private DefaultListModel listaSalas;
    private DefaultListModel listaMesas;

    public ModeloServidor() {
        listaConectados = new DefaultListModel();
        listaSalas = new DefaultListModel();
        listaMesas = new DefaultListModel();
    }

    public void borrarSala(int sala) {
        listaSalas.remove(sala);
    }

    public void borrarMesa(int mesa) {
        listaMesas.remove(mesa);
    }

    public void crearMesas(int codigoMesa, String nombreJuego) {
        String mesa = "CODIGO MESA: "+codigoMesa+"      NOMBRE SALA: "+nombreJuego;
        listaMesas.addElement(mesa);
        String texto = "Nueva mesa con codigo: "+codigoMesa+" donde se juega: '"+nombreJuego+
                "' creada. \n";
        MensajeLog mensaje = new MensajeLog(texto);
        setChanged();
        notifyObservers(mensaje);
    }

    public void crearSala(int codigoSala, String nombreSala) {
        String sala = "CODIGO SALA: "+codigoSala+"      NOMBRE SALA: "+nombreSala;
        listaSalas.addElement(sala);
        String texto = "Nueva sala con codigo: "+codigoSala+" y nombre: '"+nombreSala+
                "' creada. \n";
        MensajeLog mensaje = new MensajeLog(texto);
        setChanged();
        notifyObservers(mensaje);
    }

    public void login(String usuario, String password) {
        listaConectados.addElement(usuario);
        String texto = "Nuevo usuario: "+usuario+" con password: "+password+
                " conectado. \n";
        MensajeLog mensaje = new MensajeLog(texto);
        setChanged();
        notifyObservers(mensaje);
    }

    public void cerrarConexion() throws IOException {

    }

    public void cerrarJugador(String jugador) {
        listaConectados.removeElement(jugador);
        String texto = "Usuario desconectado: "+jugador+"\n";
        MensajeLog mensaje = new MensajeLog(texto);
        setChanged();
        notifyObservers(mensaje);
    }

    public DefaultListModel getListaConectados() {
        return listaConectados;
    }

    public DefaultListModel getListaMesas() {
        return listaMesas;
    }

    public DefaultListModel getListaSalas() {

        return listaSalas;
    }

    public boolean servidorConectado() {
        return true;
    }

    public boolean tratarMensaje(MensajeChat mensajeChat) {
        String texto = mensajeChat.get_men();
        boolean resultado = true;
        if (texto.trim().contains("gilipollas"))
                resultado = false;
        else if (texto.trim().contains("cabron"))
                resultado = false;
        else if (texto.trim().contains("cabrones"))
                resultado = false;
        else if (texto.trim().contains("puta"))
                resultado = false;
        else if (texto.trim().contains("putas"))
                resultado = false;
        else if (texto.trim().contains("zorra"))
                resultado = false;
        else if (texto.trim().contains("zorras"))
                resultado = false;
        else if (texto.trim().contains("hijodeputa"))
                resultado = false;
        else if (texto.trim().contains("hijoputa"))
                resultado = false;
        return resultado;
    }

    public void verEstadisticas(String usuario) {
        
    }

}
