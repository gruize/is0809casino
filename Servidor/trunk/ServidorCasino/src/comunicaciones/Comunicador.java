package comunicaciones;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;


// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.438D7310-870E-C8E9-FF3D-3CD2DEFA8B39]
// </editor-fold> 
public class Comunicador extends Thread{

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.FF7C10FD-AA6A-4CE9-A9C7-A2480EB96931]
    // </editor-fold> 
    private AlmacenCliente almacen;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.5010AB07-1288-9BA6-5053-32035B60D816]
    // </editor-fold> 
    private ServerSocket servidor;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.2385BD79-AFF1-6FBA-6249-512873ED0DEE]
    // </editor-fold> 
    private int puerto = 10000;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.80BD15BE-F586-9C2D-0F29-A5B1FBA0EC4D]
    // </editor-fold> 
    private Socket escucha;

    private String nombre;

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
        try {
            almacen = new AlmacenCliente();
            servidor = new ServerSocket(puerto);
            conectado = true;
            System.out.println("Comunicaciones::El servidor esta corriendo en la direccion " + servidor.getInetAddress() +
                               " Puerto: " + puerto);
            this.start();
        } catch (IOException ex) {
            System.out.println("Comunicaciones::El puerto esta ocupado por otro programa.");
            System.out.println("Comunicaciones::Este programa se cerrara ...");
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
    // #[regen=yes,id=DCE.FCF379B0-4E2D-BDD0-1EA8-E7892D27CA1B]
    // </editor-fold> 
    public void run () {
        int identificador = -1;
        while(true){
                try {
                    escucha = servidor.accept();
                } catch (IOException ex) {
                    System.out.println("Comunicaciones::Ha ocurrido un error recibiendo la conexion con el cliente.");
                    System.out.println("Comunicaciones::Este programa se cerrara ...");
                    finalize();
                }
                try {
                    entrada = new ObjectInputStream(escucha.getInputStream());
                    salida = new ObjectOutputStream(escucha.getOutputStream());
                    String usuario = entrada.readUTF();
                    String password = entrada.readUTF();
                    identificador = 1; // Aquí se solicitará el número identificador de usuario
                    salida.writeUTF(Integer.toString(identificador));
                    conectado = true;
                } catch (IOException ex) {
                    conectado = false;
                }

                if(conectado){
                    ManejadorCliente manejador = new ManejadorCliente(escucha, entrada, salida);
                    manejador.setIdentificador(identificador);
                    almacen.addManejadorCliente(identificador,manejador);
                    manejador.setAlmacen(almacen);
                    manejador.start();
                    System.out.println("El cliente " + identificador + " se ha conectado.");
                }
        }
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.F78C2FA6-A636-1E9B-8A0C-0B11908B0F2F]
    // </editor-fold> 
    public void finalize () {
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.97FBE478-D715-4168-6263-9F0496035FF6]
    // </editor-fold> 
    public void enviarMensaje (int identificador, Serializable mensaje) {
        ManejadorCliente destino = almacen.getManejadorCliente(identificador);
        if (destino != null){
            destino.enviarMensaje(mensaje);
        }
    }

}

