/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GestorChatCliente;

//import InterfazCliente.HiloCliente;
import java.util.Vector;

/**
 * @author David
 */
public class GestorChatCliente extends Thread {

    private Vector<MensajeChat> colaSalida;
    private Vector<MensajeChat> colaEntrada;
    private static GestorChatCliente instance = null;


    public GestorChatCliente() {
        colaEntrada = new Vector<MensajeChat>();
        colaSalida = new Vector<MensajeChat>();
   }

    public static GestorChatCliente getInstance() {
        if (instance == null) {
            instance = new GestorChatCliente();
        }
        return instance;
    }

    public void recibeMensaje(MensajeChat m) {
        colaEntrada.add(m);
    }

    public void enviaMensaje(MensajeChat m) {
        colaSalida.add(m);
    }

    public void run() {
        try {
            MensajeChat recibido, enviar;
            while (true) {
                if (!colaEntrada.isEmpty()) {
                    recibido = new MensajeChat(colaEntrada.firstElement());
                    colaEntrada.remove(0);
                //chat.dejaMensaje(recibido);
                } else if (!colaSalida.isEmpty()) {
                    enviar = new MensajeChat(colaSalida.firstElement());
                    colaSalida.remove(0);
                    //comunicaciones.dejaMensaje(enviar);
                } else {
                    Thread.sleep(5);
                }
            }
        } catch (InterruptedException e) {
        }
    }
}

