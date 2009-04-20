/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.LogicaJuegos.logicaRuleta;

import modelo.LogicaJuegos.*;
import modelo.LogicaJuegos.logicaRuleta.MesaRuleta;
import modelo.MensajeJugada;
import controlador.ControladorServidor;
import java.util.ArrayList;
import java.util.Hashtable;
import javax.swing.DefaultListModel;

/**
 *
 * @author Jaime Guimera
 */
public class GestorSalas {

    private static GestorSalas instance=null;
    Hashtable<Integer, MesaRuleta> salaRuleta;


    public GestorSalas(ControladorServidor c) {
    }
    public static GestorSalas getInstance(ControladorServidor c) {
        if (instance == null) {
            instance = new GestorSalas(c);
        }
        return instance;
    }

    public void procesaMensaje(Jugada jugada) {
        //TODO Identificar la sala segun el mensaje
        salaRuleta.get(jugada.getMesa()).procesaJugada(jugada);
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
