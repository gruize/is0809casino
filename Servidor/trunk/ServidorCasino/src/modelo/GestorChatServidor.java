package modelo;

import controlador.ControladorServidor;
import java.util.ArrayList;
import java.util.Vector;

public class GestorChatServidor extends Thread {

    private Vector<MensajeChat> cola;
    private ControladorServidor controlador;
    private GestorUsuarios usuarios;
    private static GestorChatServidor instance = null;
   


    public GestorChatServidor(ControladorServidor c) {
        cola = new Vector<MensajeChat>();
        controlador = c;
   }

    public static GestorChatServidor getInstance(ControladorServidor c) {
        if (instance == null) {
            instance = new GestorChatServidor(c);
        }
        return instance;
    }

    public void dejamensaje(MensajeChat m) {
        cola.add(m);
    }

    public void run() {
        try {
            MensajeChat recibido, enviar, aux;
            ArrayList<Integer> tios = new ArrayList<Integer>();
            usuarios = GestorUsuarios.getInstancia();
            int mesa = 0;
            while (true) {
                if (!cola.isEmpty()) {
                    recibido = new MensajeChat(cola.firstElement());
                    cola.remove(0);
                    mesa = usuarios.getMesa(recibido.get_tio());
                    tios = usuarios.getUsuarios(mesa);
                    for (int i = 0; i < tios.size(); i++) {
                        enviar = new MensajeChat(tios.get(i),recibido.get_mesa(), recibido.get_men());
                        //controlador.enviarMensaje(enviar);  O comunicaciones.enviarMensaje(enviar);
                    }
                } else {
                    Thread.sleep(5);
                }
            }
        } catch (InterruptedException e) {
        }
    }
}
