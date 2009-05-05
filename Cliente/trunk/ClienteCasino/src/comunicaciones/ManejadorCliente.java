package comunicaciones;

import controlador.ControladorCliente;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.net.ssl.SSLSocket;

/**
 * Clase que maneja la conexión particular del cliente
 * @author Alberto Milán
 */
public class ManejadorCliente implements Runnable {

    private int _identificador;

    private SSLSocket _cliente;

    private ObjectInputStream _entrada;

    private ObjectOutputStream _salida;

    private boolean _conectado;

    private ControladorCliente _controlador;
    
    private Thread _hilo;

    /**
     * Constructor por defecto de la clase
     */
    public ManejadorCliente () {
    }

    /**
     * Constructor parametrizado 
     * @param cliente Socket de apertura de conexión
     * @param in Stream de datos de entrada de conexión
     * @param out Stream de datos de salida de conexión
     */
    public ManejadorCliente (ControladorCliente controlador, SSLSocket cliente,
            ObjectInputStream in, ObjectOutputStream out,
            String usuario, String password) {
        this._controlador = controlador;
        this._cliente = cliente;
        this._entrada = in;
        this._salida = out;
        try {
            _salida.flush();
            _salida.writeUTF(usuario);
            _salida.flush();
            _salida.writeUTF(password);
            _salida.flush();
            String identificador = _entrada.readUTF();
            _identificador = Integer.valueOf(identificador);
            _conectado = true;
            // Lanza el hilo de escucha
            this.start();
            System.out.println("Conexión establecida. Identificador = " + _identificador);
        } catch (IOException ex) {
            System.out.println("Comunicaciones::Error en el envío de usuario y contraseña");
            _conectado = false;
            return;
        }
    }

    /**
     * Pregunta el estado de la conexión
     * @return true si la conexión es correcta
     */
    public boolean isConectado () {
        return _conectado;
    }

    /**
     * Accesor del identificador del usuario
     * @return Número que identifica al usuario
     */
    public int getIdentificador() {
        return _identificador;
    }
    
    /**
     * Desconecta al usuario del servidor
     */
    public void desconectar() {
        _identificador = -1;
        _conectado = false;
        _hilo = null;
    }


    /**
     * Envía el mensaje al destino (thread-safe)
     * @param mensaje Mensaje a enviar
     */
    public synchronized boolean enviarMensaje (MensajeComunicaciones mensaje) {
        try {
            // Si se está conectado
            if (_conectado){
                // Se envía el mensaje al servidor
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
        System.out.println("Mensaje " + mensaje.getMensaje().toString() + " enviado.");
        return true;
    }

    /**
     * Lanza el hilo de escucha de la conexión
     */
    public void start () {
        _hilo = new Thread(this);
        _hilo.start();
    }

    /**
     * Finaliza la ejecución del hilo de escucha
     */
    @Override
    public void finalize () {
        _controlador.servidorDesconectado();
        _hilo = null;
        _conectado = false;
    }

    /**
     * Función concurrente que escucha mensajes de la conexión.
     * El objetivo es que no sea bloqueante con respecto al 
     * programa principal.
     */
    @Override
    public void run() {
        while(true){
            try {
                MensajeComunicaciones mensaje = (MensajeComunicaciones)_entrada.readObject();
                new EventoMensajeRecibido(_controlador, mensaje.getTipo(), mensaje);
            } catch (IOException ex) {
                System.out.println("Comunicaciones::Error en la entrada/salida de la conexión");
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

