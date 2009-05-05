package comunicaciones;

import controlador.ControladorServidor;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.net.ssl.SSLSocket;

public class ManejadorCliente implements Runnable {

    private int _identificador;
    
    private ControladorServidor _controlador;

    private SSLSocket _cliente;

    private ObjectInputStream _entrada;

    private ObjectOutputStream _salida;

    private AlmacenCliente _almacen;

    private boolean _conectado;

    private Thread _hilo;

 
    public ManejadorCliente () {
    }

    
    public ManejadorCliente (ControladorServidor controlador, SSLSocket cliente, ObjectInputStream in, ObjectOutputStream out) {
        this._controlador = controlador;
        this._cliente = cliente;
        this._entrada = in;
        this._salida = out;
        this._conectado = true;
    }

 
    public AlmacenCliente getAlmacen () {
        return _almacen;
    }


    public void setAlmacen (AlmacenCliente val) {
        this._almacen = val;
    }


    public boolean isConectado () {
        return _conectado;
    }


    public void setIdentificador(int Identificador) {
        this._identificador = Identificador;
    }

    public int getIdentificador() {
        return _identificador;
    }


     /**
     * Envía el mensaje al destino (thread-safe)
     * @param mensaje Mensaje a enviar
     */
    public synchronized boolean enviarMensaje (MensajeComunicaciones mensaje) {
        try {
            // Si se está conectado
            if (_conectado){
                // Se envía el mensaje
                _salida.flush();
                _salida.writeObject(mensaje);
                _salida.flush();
            } else {
                return false;
            }
        } catch (IOException ex) {
            System.out.println("Comunicaciones::Ha ocurrido un error al enviar el mensaje.");
            System.out.println("Comunicaciones::El mensaje se descartará.");
            return false;
        }
        return true;
    }


    public void start () {
        _hilo = new Thread(this);
        _hilo.start();
    }

    @Override
    public void finalize () {
        _hilo = null;
        try {
            // Avisa de la desconexión del cliente
            _controlador.jugadorDesconectado(_identificador);
            //aqui elimina el manejador de clientes de la tabla
            _almacen.removeManejadorCliente(_identificador);
            if (_cliente.isConnected()) {
                _cliente.close();
            }
            
            _conectado = false;
            _entrada = null;
            _salida = null;
           
            
            System.out.println("El cliente con ID " + _identificador + " se ha desconectado.");
            
        } catch (IOException ex) {
            System.out.println("El cliente con ID " + _identificador + " se ha desconectado.");
        }
    }

    @Override
    public void run() {
        //aqui comienza la escucha de mensajes
        while(true){
            try {
                MensajeComunicaciones mensaje = (MensajeComunicaciones) _entrada.readObject();
                new EventoMensajeRecibido(_controlador, mensaje.getTipo(), mensaje);
            } catch (IOException ex) {
                finalize();             
                break;             
            } catch (ClassNotFoundException ex) {
                System.out.println("Comunicaciones::Error en la recepción de datos. Datos incorrectos");
                finalize();
                break;
            }
        }
    }

}

