package comunicaciones;


import controlador.ControladorServidor;

 
class EventoMensajeRecibido extends Thread{
    
    private int _tipo;

    private MensajeComunicaciones _mensaje;

    private ControladorServidor _controlador;


    public EventoMensajeRecibido (ControladorServidor controlador, int tipo, MensajeComunicaciones mensaje) {
        this._controlador = controlador;
        this._mensaje = mensaje;
        this._tipo = tipo;
        this.start();
    }

    
    @Override
    public void run () {
        //TODO Aquí va la llamada al controlador central
        System.out.println("Mensaje recibido:" + _mensaje.getMensaje().toString());
         _controlador.mensajeRecibido(_tipo, _mensaje.getMensaje());
    }

}

