package comunicaciones;

import controlador.ControladorCliente;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket; 
import java.net.UnknownHostException;

/**
 * Clase que abstrae la comunicación a cualquier módulo superior
 * @author Alberto Milán
 */
public class Comunicador {
    
    private ManejadorCliente _cliente;

    private String _direccion = "192.168.1.2";
        
    private int _puerto = 10000;
    
    private int _identificador;
    
    private ControladorCliente _controlador;
     
    /**
     * Constructor público
     */
    public Comunicador (ControladorCliente controlador) {
        _controlador = controlador;
    }
    
    /**
     * Abre la conexión con el servidor
     * @return true si la conexión ha sido realizada
     */
    public boolean abreConexion (String usuario, String password){
        boolean conectado;
        Socket conexion;
        try {
            conexion = new Socket(_direccion, _puerto);
            ObjectOutputStream salida = new ObjectOutputStream(conexion.getOutputStream());
            ObjectInputStream entrada = new ObjectInputStream(conexion.getInputStream());
            _cliente = new ManejadorCliente(_controlador, conexion, entrada, salida, usuario, password);
            _identificador = _cliente.getIdentificador();
            conectado = true;
        } catch (UnknownHostException ex) {
            System.out.println("Comunicaciones::El servidor no existe o no se puede establecer conexión");
            conectado = false;
        } catch (IOException ex) {
            System.out.println("Comunicaciones::Error en el establecimiento de la conexión con el servidor");
            conectado = false;
        }
        return conectado;
    }
    
    /**
     * Cierra la conexión con el servidor
     */
    public void cierraConexion() {
        _cliente.desconectar();
        _cliente = null;
        _identificador = -1;
    }
    
    /**
     * Accesor de la dirección del servidor
     * @return Dirección del servidor
     */
    public String getDireccion () {
        return _direccion;
    }
    
    /**
     * Accesor del puerto de conexión
     * @return Número de puerto
     */
    public int getPuerto () {
        return _puerto;
    }

    /**
     * Accesor del estado de la conexión
     * @return true si la conexión está en funcionamiento
     */
    public boolean isConectado () {
        return _cliente.isConectado();
    }
    
    /**
     * Envía un mensaje al servidor
     * @param tipo Módulo destino del mensaje
     * @param mensaje Dato serializable a enviar
     */
    public boolean enviarMensaje (int tipo, Serializable mensaje) {
        MensajeComunicaciones temp = new MensajeComunicaciones();
        temp.setRemitente(_identificador);
        temp.setDestino(0); // El servidor posee identificador 0
        temp.setTipo(tipo);
        temp.setMensaje(mensaje);
        if (_cliente != null && _cliente.isConectado()){
            return _cliente.enviarMensaje(temp);
        }
        else return false;
    }

}

