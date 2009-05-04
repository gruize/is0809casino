/**
 *
 * Mensaje que enviarÃ¡ el Servidor, cuando el cliente haya login y Ã©ste se haya validado.
 *
 * Contiene un vector con informaciÃ³n de todas las salas que hay activas en el casino
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
    private int id;

    public MensajeInfoSalas(int id) {
        this.id = id;
    }

    public MensajeInfoSalas(int id,Vector<PeticionSala> salas){
        this.id = id;
        this.salas=salas;
    }

    public Vector getSalas() {
        return salas;
    }

    public void setSalas(Vector salas) {
        this.salas = salas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
