package comunicaciones;

/**
 * Clase que lanza el evento provocado por la recepción de un mensaje
 * @author Alberto Milán
 */
class EventoMensajeRecibido extends Thread{
 
    private MensajeComunicaciones _mensaje;
 
    //private Casino casino;
 
    /**
     * Constructor de la clase
     * @param mensaje
     */
    public EventoMensajeRecibido (/*Casino casino,*/ MensajeComunicaciones mensaje) {
        this._mensaje = mensaje;
    }
    
    /**
     * Lanzamiento del evento en un hilo concurrente
     */
    @Override
    public void run () {
        //TODO Aquí va la llamada al controlador central
        System.out.println("Mensaje recibido:" + _mensaje.getMensaje().toString());
    }
}

