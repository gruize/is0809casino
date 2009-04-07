package comunicaciones;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket; 
import java.net.UnknownHostException;


public class Comunicador {
    
    ManejadorCliente cliente;

    private String direccion = "192.168.1.2";
    
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.2385BD79-AFF1-6FBA-6249-512873ED0DEE]
    // </editor-fold> 
    private int puerto = 10000;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.BB11C2DF-5446-A2B1-D32E-B437FE09BD3E]
    // </editor-fold> 
    private ObjectInputStream entrada;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.3570D5B9-D050-F1BA-9EAA-1D023DB0A025]
    // </editor-fold> 
    private ObjectOutputStream salida;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.D3D63504-AF24-6D9B-55B2-76855907149C]
    // </editor-fold> 
    private boolean conectado = false;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.4ADC3F63-4027-2EDC-8ACC-A7C704C03630]
    // </editor-fold> 
    public Comunicador () {
        Socket conexion;
        try {
            conexion = new Socket(direccion, puerto);
            salida = new ObjectOutputStream(conexion.getOutputStream());
            entrada = new ObjectInputStream(conexion.getInputStream());
            cliente = new ManejadorCliente(conexion, entrada, salida);
            conectado = true;
        } catch (UnknownHostException ex) {
            System.out.println("Comunicaciones::El servidor no existe o no se puede establecer conexión");
            conectado = false;
        } catch (IOException ex) {
            System.out.println("Comunicaciones::Error en el establecimiento de la conexión con el servidor");
            conectado = false;
        }
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.494D2001-F057-E1E6-4CF7-588C323DF2D3]
    // </editor-fold> 
    public boolean getConectado () {
        return conectado;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.10CD5316-3C4C-54EB-A787-A439F254027E]
    // </editor-fold> 
    public int getPuerto () {
        return puerto;
    }
    

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.97FBE478-D715-4168-6263-9F0496035FF6]
    // </editor-fold> 
    public void enviarMensaje (int identificador, Serializable mensaje) {
        MensajeComunicaciones internMessage = new MensajeComunicaciones();
        internMessage.setRemitente(identificador);
        internMessage.setDestino(0);
        internMessage.setTipo(1);
        internMessage.setMensaje(mensaje);
        if (cliente != null){
            cliente.enviarMensaje(internMessage);
        }
    }

}

