package comunicaciones;

import java.util.Hashtable;


public class AlmacenCliente {

    private Hashtable<Integer,ManejadorCliente> tabla;

    public AlmacenCliente () {
        tabla = new Hashtable<Integer, ManejadorCliente>();
    }

    public void addManejadorCliente (int identificador, ManejadorCliente cliente) {
        tabla.put(identificador, cliente);
    }

    public void removeManejadorCliente (int identificador) {
        if (tabla.containsKey(identificador)){
            tabla.remove(tabla.get(identificador));
        }
    }

    public ManejadorCliente getManejadorCliente (int identificador) {
        if (tabla.containsKey(identificador)){
            return tabla.get(identificador);
        } else return null;
    }

    public int tamano () {
        return tabla.size();
    }

}

