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
    // #[regen=yes,id=DCE.78E250D8-1D1F-EA7F-15F0-401DF8BE9F4A]
    // </editor-fold> 
    private String nombre;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.1F493420-DE3B-013B-F790-3C62421CC8C0]
    // </editor-fold> 
    private ObjectInputStream entrada;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.2FF58A07-C8C7-E154-205D-1CB08AE382E1]
    // </editor-fold> 
    private ObjectOutputStream salida;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.4208F6E1-899E-6892-57AF-D110354ADC4D]
    // </editor-fold> 
    private AlmacenCliente almacen;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.4D72BB13-867E-2B3F-4983-636246909485]
    // </editor-fold> 
    private boolean disponible;

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
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.48D03DA0-027A-7FEC-3776-D1EFDE3955AC]
    // </editor-fold> 
    public AlmacenCliente getAlmacen () {
        return almacen;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.B0116D22-E243-3941-DDA2-928420E60C41]
    // </editor-fold> 
    public void setAlmacen (AlmacenCliente val) {
        this.almacen = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.5BBFB033-6FA6-DA5B-85B6-CB88C78F2A50]
    // </editor-fold> 
    public boolean getDisponible () {
        return disponible;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.59196C3D-6305-672D-8DB8-01243AD88631]
    // </editor-fold> 
    public ObjectInputStream getEntrada () {
        return entrada;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.B5168CE1-4EFF-94A3-B049-7CAC1C699B76]
    // </editor-fold> 
    public void setEntrada (ObjectInputStream val) {
        this.entrada = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.174D23C0-BA1E-21AC-9515-E7E1B51766D6]
    // </editor-fold> 
    public String getNombre () {
        return nombre;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.F3990E53-090B-FF3B-7021-C2F1D635245F]
    // </editor-fold> 
    public void setNombre (String val) {
        this.nombre = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.02A4630C-FF2E-76E5-B865-AC51E9A92F50]
    // </editor-fold> 
    public ObjectOutputStream getSalida () {
        return salida;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.D5D8EB7A-FEC6-C12A-D71E-1242E249EC88]
    // </editor-fold> 
    public void setSalida (ObjectOutputStream val) {
        this.salida = val;
    }

    public void setIdentificador(int Identificador) {
        this.Identificador = Identificador;
    }

    public int getIdentificador() {
        return Identificador;
    }


    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.EB9E3F4F-309A-14DA-D58C-B240BCAE50C6]
    // </editor-fold> 
    public synchronized void enviarMensaje (Serializable mensaje) {
        //aqui sincronizo el acceso a este metodo
        while(!disponible){
            try {
                wait();
            } catch (InterruptedException ex) {
                System.out.println("Sistema interrumpido");
            }
        }

        //defino el metodo como ocupado y notifico a todos los sub procesos
        disponible = false;
        notify();

        try {
            //aqui envio el mensaje al cliente
            salida.writeObject(mensaje);
            salida.flush();
        } catch (IOException ex) {
            System.out.println("Ha ocurrido un error al enviar el mensaje.");
            System.out.println("El mensaje se descartara.");
        }

        //defino el metodo como desocupado y notifico a todos los subprocesos
        disponible = true;
        notify();
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
        //aqui comienza la escucha de mensajes
        while(true){
            try {
                //aqui obtengo el mensaje y su contenidp
                MensajeComunicaciones mensaje = (MensajeComunicaciones) entrada.readObject();
                //aqui gestiono el mensaje
                EventoMensajeRecibido nuevo = new EventoMensajeRecibido(mensaje);
            } catch (IOException ex) {
                finalize();
                break;
            } catch (NullPointerException ex) {
                finalize();
                break;
            } catch (ClassNotFoundException ex) {
                finalize();
                break;
            }
        }
    }

}

