package comunicaciones;

import controlador.ControladorCliente;

/**
 * Clase que lanza el evento provocado por la recepción de un mensaje
 * @author Alberto Milán
 */
class EventoMensajeRecibido extends Thread{
    
    private int _tipo;
 
    private MensajeComunicaciones _mensaje;
 
    private ControladorCliente _controlador;
 
    /**
     * Constructor de la clase
     * @param mensaje
     */
    public EventoMensajeRecibido (ControladorCliente controlador, int tipo, MensajeComunicaciones mensaje) {
        this._controlador = controlador;
        this._tipo = tipo;
        this._mensaje = mensaje;
        this.start();
    }
    
    /**
     * Lanzamiento del evento en un hilo concurrente
     */
    @Override
    public void run () {
        System.out.println("Mensaje recibido:" + _mensaje.getMensaje().toString());
        _controlador.mensajeRecibido(_tipo, _mensaje.getMensaje());
    }
}

