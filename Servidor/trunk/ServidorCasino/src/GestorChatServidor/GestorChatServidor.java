package GestorChatServidor;

import java.util.Vector;

public class GestorChatServidor extends Thread {

    private Vector<Mensaje> cola;
    private static GestorChatServidor instance = null;

    public GestorChatServidor() {
        cola = new Vector<Mensaje>();
   }

    public static GestorChatServidor getInstance() {
        if (instance == null) {
            instance = new GestorChatServidor();
        }
        return instance;
    }

    public void dejamensaje(Mensaje m) {
        cola.add(m);

    }

    public void run() {
        try {
            Mensaje recibido, enviar;
            Vector<Integer> tios = new Vector<Integer>();
            while (true) {
                if (!cola.isEmpty()) {
                    recibido = new Mensaje(cola.firstElement());
                    cola.remove(0);
                    //mesa = gestorClientes.ObtenerMesa(recibido.get_tio());
                    //tios = gestorClientes.obtenerTios(mesa);
                    for (int i = 0; i < tios.size(); i++) {
                        enviar = new Mensaje(tios.elementAt(i),recibido.get_mesa(), recibido.get_men());
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
