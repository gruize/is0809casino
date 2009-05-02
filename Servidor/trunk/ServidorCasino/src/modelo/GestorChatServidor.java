package modelo;

import modelo.mensajes.MensajeChat;
import controlador.ControladorServidor;
import java.util.ArrayList;
import java.util.Vector;
import modelo.LogicaJuegos.Jugador;

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
            MensajeChat recibido;
            ArrayList<Jugador> tios = new ArrayList<Jugador>();
            usuarios = GestorUsuarios.getInstancia(this.controlador);
            int mesa = 0;
            while (true) {
               if (cola.size() != 0){
                    recibido = cola.firstElement();
                    cola.remove(0);
                    //mesa = usuarios.getMesa(recibido.get_tio());
                    mesa=recibido.get_mesa();
                    //tios = usuarios.getUsuarios(mesa);
                    tios= usuarios.getJugadoresMesa(recibido.get_sala(),mesa);
                    for (int i = 0; i < tios.size(); i++) {
                        MensajeChat mensajeChat = new MensajeChat(recibido.get_tio(),recibido.get_mesa(),recibido.get_men(),recibido.get_usuario());
                        controlador.enviarMensajeChat(tios.get(i).getId(),mensajeChat);
                    }
                     System.out.println("mensaje tratado");
                } else {
                    Thread.sleep(500);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
