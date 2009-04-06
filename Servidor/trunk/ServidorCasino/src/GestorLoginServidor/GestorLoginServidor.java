/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package GestorLoginServidor;

/**
 *
 * @author David
 */
public class GestorLoginServidor extends Thread{

    MensajeLogin m;

    public GestorLoginServidor(MensajeLogin m) {
        this.m = m;
    }

    public MensajeLogin getM() {
        return m;
    }

    public void setM(MensajeLogin m) {
        this.m = m;
    }

    public void run(){
        //m.setId(gestorUsuarios.logear(m.getUsuario(),m.getPass()));
        //comunicaciones.enviarMensaje(m);
    }

}
