/**
 *
 * Mensaje que enviará el Servidor, cuando el cliente haya login y éste se haya validado.
 *
 * Contiene un vector con información de todas las salas que hay activas en el casino
 *
 */
package modelo.mensajes;

import java.io.Serializable;
import java.util.Vector;
import modelo.mensajes.objetos.PeticionSala;
/**
 *
 * @author Chaudhary
 */
public class MensajeInfoSalas implements Serializable  {

    private Vector<PeticionSala> salas;

    public MensajeInfoSalas(Vector<PeticionSala> salas){
        this.salas=salas;
    }

    public Vector getSalas() {
        return salas;
    }

    public void setSalas(Vector salas) {
        this.salas = salas;
    }



    
}
