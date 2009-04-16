package GestorChatServidor;

import java.util.Vector;

public class GestorChatServidor extends Thread {

    private Vector<MensajeChat> cola;
    private static GestorChatServidor instance = null;

    private GestorChatServidor() {
        cola = new Vector<MensajeChat>();
   }

    public static GestorChatServidor getInstance() {
        if (instance == null) {
            instance = new GestorChatServidor();
        }
        return instance;
    }

    public void dejamensaje(MensajeChat m) {
        cola.add(m);
    }

    public void run() {
        try {
            MensajeChat recibido, enviar;
            Vector<Integer> tios = new Vector<Integer>();
            //gestorClientes = gestorClientes.getinstance();
            //comunicaciones = comunicaciones.getinstnace();
            while (true) {
                if (!cola.isEmpty()) {
                    recibido = new MensajeChat(cola.firstElement());
                    cola.remove(0);
                    //mesa = gestorClientes.ObtenerMesa(recibido.get_tio());
                    //tios = gestorClientes.obtenerTios(mesa);
                    for (int i = 0; i < tios.size(); i++) {
                        enviar = new MensajeChat(tios.elementAt(i),recibido.get_mesa(), recibido.get_men());
                        //comunicaciones.enviarMensaje(enviar);
                    }
                } else {
                    Thread.sleep(5);
                }
            }
        } catch (InterruptedException e) {
        }
    }
}
