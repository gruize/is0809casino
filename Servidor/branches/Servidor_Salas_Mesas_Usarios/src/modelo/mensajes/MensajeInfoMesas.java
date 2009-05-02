/**
 *
 * Mensaje que enviará el Servidor, cuando el cliente seleccione una sala y el servidor haya introducido al jugador en ella.
 *
 * Contiene un vector con información de todas las mesas que hay activas para la sala seleccionada
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

    public MensajeInfoMesas(Vector<PeticionMesa> mesas){
        this.mesas=mesas;
    }

    public Vector getMesas() {
        return mesas;
    }

    public void setMesas(Vector mesas) {
        this.mesas = mesas;
    }

    
}
