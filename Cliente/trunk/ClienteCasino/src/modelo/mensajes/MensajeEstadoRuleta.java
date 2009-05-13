/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo.mensajes;

/**
 *
 * @author Chaudhary
 */
public class MensajeEstadoRuleta implements java.io.Serializable{

    private boolean parado=false;
    private int bola;

    public MensajeEstadoRuleta(){
        bola = -1;
    }

    public int getBola() {
        return bola;
    }

    public void setBola(int bola) {
        this.bola = bola;
    }

    public boolean isParado() {
        return parado;
    }

    public void setParado(boolean parado) {
        this.parado = parado;
    }

    
}
