package comunicaciones;

import java.io.Serializable;


/**
 * Clase contenedora de información de los mensajes controlados
 * por el módulo Comunicaciones
 * @author Alberto Milán
 */ 
public class MensajeComunicaciones implements Serializable{

    private int _destino;

    private int _remitente;

    private int _tipo;

    private Serializable _mensaje;

    /**
     * Constructor de la clase
     */
    public MensajeComunicaciones () {
    }

    public Serializable getMensaje () {
        return _mensaje;
    }

    public void setMensaje (Serializable val) {
        this._mensaje = val;
    }

    public int getRemitente () {
        return _remitente;
    }

    public void setRemitente (int val) {
        this._remitente = val;
    }

    public int getTipo () {
        return _tipo;
    }

    public void setTipo (int val) {
        this._tipo = val;
    }

    public int getDestino () {
        return _destino;
    }

    public void setDestino (int val) {
        this._destino = val;
    }

}

