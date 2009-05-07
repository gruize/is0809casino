package comunicaciones;

import controlador.ControladorServidor;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Vector;
import javax.net.ssl.*;



public class Comunicador extends Thread{
    
    private ControladorServidor _controlador;

    private AlmacenCliente _almacen;

    private SSLServerSocket _servidor;

    private int _puerto = 10000;
 
    private SSLSocket _escucha;

    private ObjectInputStream _entrada;

    private ObjectOutputStream _salida;

    private boolean _conectado = false;
    
    //TODO Eliminar. Variable temporal
    private int identificador;


    public Comunicador (ControladorServidor controlador) {
        this._controlador = controlador;
        try {
            _almacen = new AlmacenCliente();
            SSLServerSocketFactory sslSrvFact = (SSLServerSocketFactory)SSLServerSocketFactory.getDefault();
            _servidor =(SSLServerSocket)sslSrvFact.createServerSocket(_puerto);
            final String[] enabledCipherSuites = { "SSL_DH_anon_WITH_RC4_128_MD5" };
            _servidor.setEnabledCipherSuites(enabledCipherSuites);

            _conectado = true;
            System.out.println("Comunicaciones::El servidor esta corriendo" +
                               " en el puerto: " + _puerto);
            this.start();
        } catch (IOException ex) {
            System.out.println("Comunicaciones::El puerto esta ocupado por otro programa.");
            System.out.println("Comunicaciones::Este programa se cerrara ...");
            _conectado = false;
        }
    }


    public boolean getConectado () {
        return _conectado;
    }

    public int getPuerto () {
        return _puerto;
    }

    @Override
    public void run () {
        identificador = 0;
        while(true){
                try {
                    _escucha = (SSLSocket) _servidor.accept();
                } catch (SSLException ex){
                    ex.printStackTrace();
                } catch (IOException ex) {
                    System.out.println("Comunicaciones::Ha ocurrido un error recibiendo la conexion con el cliente.");
                    System.out.println("Comunicaciones::Este módulo se cerrara ...");
                    this._conectado = false;
                    return;
                }
                try {
                    _entrada = new ObjectInputStream(_escucha.getInputStream());
                    _salida = new ObjectOutputStream(_escucha.getOutputStream());
                    Vector<String> datos = new Vector<String>();
                    String usuario = _entrada.readUTF();
                    String password = _entrada.readUTF();
                    System.out.println("Usuario: " + usuario + " Password: " + password);
                    datos.add(usuario);
                    datos.add(password);
                    identificador = _controlador.login(datos);
                    _salida.flush();
                    _salida.writeUTF(Integer.toString(identificador));
                    _salida.flush();
                    _conectado = true;
                } catch (IOException ex) {
                    _conectado = false;
                }

                if(_conectado){
                    ManejadorCliente manejador = new ManejadorCliente(_controlador, _escucha, _entrada, _salida);
                    manejador.setIdentificador(identificador);
                    _almacen.addManejadorCliente(identificador,manejador);
                    manejador.setAlmacen(_almacen);
                    System.out.println("El cliente " + identificador + " se ha conectado.");
                    manejador.start();
                }
        }
    }


    public boolean enviarMensaje (int identificadorUsuario, int tipo, Serializable mensaje) {
        ManejadorCliente destino = _almacen.getManejadorCliente(identificadorUsuario);
        MensajeComunicaciones temp = new MensajeComunicaciones();
        temp.setRemitente(0);
        temp.setDestino(identificadorUsuario);
        temp.setTipo(tipo);
        temp.setMensaje(mensaje);
        if (destino != null){
            return destino.enviarMensaje(temp);
        }
        else return false;
    }

}


