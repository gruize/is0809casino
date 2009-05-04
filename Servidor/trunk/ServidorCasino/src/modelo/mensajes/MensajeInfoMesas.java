/**
 *
 * Mensaje que enviarÃ¡ el Servidor, cuando el cliente seleccione una sala y el servidor haya introducido al jugador en ella.
 *
 * Contiene un vector con informaciÃ³n de todas las mesas que hay activas para la sala seleccionada
 *
 */
package modelo.mensajes;

import java.io.Serializable;
import java.util.Vector;
import modelo.mensajes.objetos.PeticionMesa;
/**
 *
 * @author Chaudhary
 */
public class MensajeInfoMesas implements Serializable {

    private Vector<PeticionMesa> mesas;
    private int sala;
    private int id;

    public MensajeInfoMesas(int id,int sala) {
        this.id = id;
        this.sala = sala;
    }
    public MensajeInfoMesas(int id,int sala,Vector<PeticionMesa> mesas){
        this.id = id;
        this.sala = sala;
        this.mesas=mesas;
    }

    public Vector getMesas() {
        return mesas;
    }

    public void setMesas(Vector mesas) {
        this.mesas = mesas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSala() {
        return sala;
    }

    public void setSala(int sala) {
        this.sala = sala;
    }


}
