package comunicaciones;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;


// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.651C51D0-93D7-2EE0-554F-77DB57D4E63A]
// </editor-fold> 
public class ManejadorCliente implements Runnable {

    private int Identificador;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.9571CF2A-135D-6627-02A4-085DCDC43BF1]
    // </editor-fold> 
    private Socket cliente;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.1F493420-DE3B-013B-F790-3C62421CC8C0]
    // </editor-fold> 
    private ObjectInputStream entrada;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.2FF58A07-C8C7-E154-205D-1CB08AE382E1]
    // </editor-fold> 
    private ObjectOutputStream salida;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.4D72BB13-867E-2B3F-4983-636246909485]
    // </editor-fold> 
    private boolean conectado;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.E3FC8A3C-4EB5-02A1-05D0-5E178B65A273]
    // </editor-fold> 
    private Thread hilo;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.8440B2D2-F51F-9082-E074-F4509625D958]
    // </editor-fold> 
    public ManejadorCliente () {
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker ">
    // #[regen=yes,id=DCE.8440B2D2-F51F-9082-E074-F4509625D958]
    // </editor-fold>
    public ManejadorCliente (Socket cliente, ObjectInputStream in, ObjectOutputStream out) {
        this.cliente = cliente;
        this.entrada = in;
        this.salida = out;
        this.start();
    }


    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.5BBFB033-6FA6-DA5B-85B6-CB88C78F2A50]
    // </editor-fold> 
    public boolean getConectado () {
        return conectado;
    }

    public void setIdentificador(int Identificador) {
        this.Identificador = Identificador;
    }

    public int getIdentificador() {
        return Identificador;
    }
    
    public void desconectar() {
        try {
            entrada.close();
            salida.close();
            cliente.close();
        } catch (IOException ex) {
            entrada = null;
            salida = null;
            cliente = null;
        }
        conectado = false;
        hilo = null;
    }


    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.EB9E3F4F-309A-14DA-D58C-B240BCAE50C6]
    // </editor-fold> 
    public synchronized void enviarMensaje (Serializable mensaje) {
        try {
            // Se envía el mensaje al cliente
            salida.writeObject(mensaje);
            salida.flush();
        } catch (IOException ex) {
            System.out.println("Comunicaciones::Ha ocurrido un error al enviar el mensaje.");
            System.out.println("Comunicaciones::El mensaje se descartara.");
        }
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.EE74722E-A1AB-1FE2-85D2-157B237896AF]
    // </editor-fold> 
    public void start () {
        hilo = new Thread(this);
        hilo.start();
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.73E381F7-B245-72DE-00A4-6911AC7D4BA2]
    // </editor-fold> 
    @Override
    public void finalize () {
        hilo = null;
    }

    public void run() {
        while(true){
            try {
                MensajeComunicaciones mensaje = (MensajeComunicaciones)entrada.readObject();
                EventoMensajeRecibido nuevoMensaje = new EventoMensajeRecibido(mensaje);
                nuevoMensaje.start();
            } catch (IOException ex) {
                System.out.println("Comunicaciones::Error en la entrada/salida de la conexión");
                conectado = false;
                break;
                
            } catch (ClassNotFoundException ex) {
                System.out.println("Comunicaciones::Error en la recepción de datos. Datos incorrectos");
                conectado = false;
                break;
            }
        }
    }

}

