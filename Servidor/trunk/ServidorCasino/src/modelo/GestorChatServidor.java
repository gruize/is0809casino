package modelo;

import controlador.ControladorServidor;
import java.util.ArrayList;
import java.util.Vector;

public class GestorChatServidor extends Thread {

    private static Vector<MensajeChat> cola;
    private ControladorServidor controlador;
    private static GestorUsuarios usuarios;
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
               if (cola.size() != 0){
                    recibido = new MensajeChat(cola.firstElement());
                    cola.remove(0);
                    mesa = usuarios.getMesa(recibido.get_tio());
                    tios = usuarios.getUsuarios(mesa);
                    for (int i = 0; i < tios.size(); i++) {
                        MensajeChat mensajeChat = new MensajeChat(recibido.get_tio(),recibido.get_mesa(),recibido.get_men(),recibido.get_usuario());
                        controlador.enviarMensajeChat(tios.get(i),mensajeChat);
                    }
                     System.out.println("mensaje tratado");
                } else {
                    Thread.sleep(500);
                }
            }
        } catch (InterruptedException e) {
        }
    }
}
