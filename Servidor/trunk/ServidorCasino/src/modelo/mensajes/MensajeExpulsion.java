/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo.mensajes;

import java.io.Serializable;

/**
 *
 * @author Fiutten
 */
public class MensajeExpulsion implements Serializable {

    private int id;

    public MensajeExpulsion(int ID) {
        id = ID;
    }

    public int getId() {
        return id;
    }

    public void setId(int ID) {
        id = ID;
    }

}
