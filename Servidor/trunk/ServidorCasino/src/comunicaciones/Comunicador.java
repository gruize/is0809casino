package comunicaciones;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;


// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.438D7310-870E-C8E9-FF3D-3CD2DEFA8B39]
// </editor-fold> 
public class Comunicador {

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
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.91681810-5A6D-3221-69D7-303F969B8160]
    // </editor-fold> 
    public AlmacenCliente getAlmacen () {
        return almacen;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.96520FB0-AC74-69F4-6B2A-6F48FA8D8662]
    // </editor-fold> 
    public void setAlmacen (AlmacenCliente val) {
        this.almacen = val;
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
    // #[regen=yes,regenBody=yes,id=DCE.ECBDFE3E-1860-3843-218A-0C8F9756655F]
    // </editor-fold> 
    public void setPuerto (int val) {
        this.puerto = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.AD3EE3C7-A87D-A948-F884-4E0E14D996A6]
    // </editor-fold> 
    public ServerSocket getServidor () {
        return servidor;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.E366AF8F-FAEC-95D0-ADE3-78BF776F86E7]
    // </editor-fold> 
    public void setServidor (ServerSocket val) {
        this.servidor = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.FCF379B0-4E2D-BDD0-1EA8-E7892D27CA1B]
    // </editor-fold> 
    public void run () {
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.F78C2FA6-A636-1E9B-8A0C-0B11908B0F2F]
    // </editor-fold> 
    public void finalize () {
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.97FBE478-D715-4168-6263-9F0496035FF6]
    // </editor-fold> 
    public void enviarMensaje (MensajeComunicaciones mensaje) {
    }

}

