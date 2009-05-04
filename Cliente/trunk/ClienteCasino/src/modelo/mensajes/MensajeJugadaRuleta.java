/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo.mensajes;

import modelo.Apuesta;

/**
 *
 * @author GabiPC
 */
public class MensajeJugadaRuleta extends MensajeJugada{

    private Apuesta apuesta;

    public MensajeJugadaRuleta(int usuario, int sala, int mesa, Apuesta apuesta) {
        super(usuario, sala, mesa);
        this.apuesta = apuesta;
    }

    public Apuesta getApuesta() {
        return apuesta;
    }

    public void setApuesta(Apuesta apuesta) {
        this.apuesta = apuesta;
    }    

}
