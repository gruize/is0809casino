/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import modelo.mensajes.MensajeJugada;
import controlador.ControladorServidor;
import java.util.Vector;

/**
 *
 * @author Administrador
 */
public class GestorJuegosServidor extends Thread {

    private static  Vector<MensajeJugada> cola;
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

    @Override
    public void run() {
        try {
            MensajeJugada recibido;
            while (true) {
                if (!cola.isEmpty()) {
                    recibido = new MensajeJugada(cola.firstElement());
                    cola.remove(0);
                    gestorSalas.procesaMensaje(recibido.getJugada());
                } else {
                    Thread.sleep(500);
                }
            }
        } catch (InterruptedException e) {
        }
    }

}