/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import controlador.ControladorServidor;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.DefaultListModel;
import modelo.LogicaJuegos.logicaRuleta.GestorSalas;

/**
 *
 * @author Administrador
 */
public class GestorJuegosServidor extends Thread {

    private Vector<MensajeJugada> cola;
    private ControladorServidor controlador;
    private GestorUsuarios usuarios;
    private static GestorJuegosServidor instance = null;
    private GestorSalas gestorSalas;

    public GestorJuegosServidor(ControladorServidor c) {
        cola = new Vector<MensajeJugada>();
        controlador = c;
        gestorSalas = GestorSalas.getInstance(c);
    }

    public static GestorJuegosServidor getInstance(ControladorServidor c) {
        if (instance == null) {
            instance = new GestorJuegosServidor(c);
        }
        return instance;
    }

    public void dejamensaje(MensajeJugada m) {
        cola.add(m);
    }

    public void run() {
        try {
            MensajeJugada recibido, enviar, aux;
            ArrayList<Integer> tios = new ArrayList<Integer>();
            usuarios = GestorUsuarios.getInstancia();
            int mesa = 0;
            while (true) {
                if (!cola.isEmpty()) {
                    recibido = new MensajeJugada(cola.firstElement());
                    cola.remove(0);
                    gestorSalas.procesaMensaje(recibido.getJugada());
                } else {
                    Thread.sleep(5);
                }
            }
        } catch (InterruptedException e) {
        }
    }

    public DefaultListModel getMesas() {
        return gestorSalas.getListaMesas();
    }

    public DefaultListModel getSalas() {
        return gestorSalas.getListaSalas();
    }
}