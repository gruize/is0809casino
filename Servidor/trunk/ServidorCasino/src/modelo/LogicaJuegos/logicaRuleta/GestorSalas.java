/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.LogicaJuegos.logicaRuleta;

import modelo.Jugada;
import modelo.mensajes.MensajeJugada;
import controlador.ControladorServidor;
import java.util.Hashtable;
import javax.swing.DefaultListModel;

/**
 *
 * @author Jaime Guimera
 */
public class GestorSalas {

    private static GestorSalas instance = null;
    Hashtable<Integer, MesaRuleta> salaRuleta;
    ControladorServidor c=null;

    public GestorSalas(ControladorServidor c) {
        this.c=c;
        salaRuleta=new Hashtable();
        //Aqui se crea la mesa, pero es temporal
        salaRuleta.put(1, new MesaRuleta(c,1));
    }

    public static GestorSalas getInstance(ControladorServidor c) {
        if (instance == null) {
            instance = new GestorSalas(c);
        }
        return instance;
    }

    public void procesaMensaje(Jugada jugada) {
        //TODO Identificar la sala segun el mensaje
        if (jugada.getTipo().equalsIgnoreCase("infoSALAS")) {
           // devuelveSalas();
        } else if (jugada.getTipo().equalsIgnoreCase("infoMESA")) {
            devuelveMesa(jugada.getMesa());
        } else {
            if (jugada.getTipo().equalsIgnoreCase("tiraBola")) salaRuleta.get(jugada.getMesa()).lanzaBola();
            else salaRuleta.get(jugada.getMesa()).procesaJugada(jugada);
        }
    }

    private void addMesaRuleta() {
    }

    public DefaultListModel getListaMesas(int sala) {
        DefaultListModel lista = new DefaultListModel();
        lista.addElement("PEPE2");
        return lista;
    }

    public DefaultListModel getListaSalas() {
        DefaultListModel lista = new DefaultListModel();
        lista.addElement("Sala Ruleta");
        return lista;
    }

    private void devuelveMesa(int mesa) {
        //Manda la informacion de la mesa solicitada
        //TODO obtener bien los datos de la mesa y rellenar el mensaje en base a esos datos
        c.enviarMensajeJugada(0, new MensajeJugada(1,1,new Jugada(1,1,"infoMesa",4,5)));
        System.out.println("Mensaje Info recibido");
    }

    
   
}
