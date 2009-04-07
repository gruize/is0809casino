/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package GestorLoginCliente;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author David
 */
public class GestorLoginCliente{

    MensajeLogin Mensaje;

    public GestorLoginCliente(MensajeLogin Mensaje) {
        this.Mensaje = Mensaje;
    }

    public void enviarMensaje(MensajeLogin Mensaje){
        try {
            //servidor.enviar(Mensaje);
            Thread.sleep(5);
        } catch (InterruptedException ex) {
                Logger.getLogger(GestorLoginCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int recibirMensaje(MensajeLogin m){
        switch (m.getId()){
            case 0 :
                    //sacar error 0
                   return m.getId();
            case -1:
                    //sacar error -1
                    return m.getId();

            default:
                   //devolver id
                   return m.getId();

        }

    }




}

