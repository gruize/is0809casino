package comunicaciones;

import java.util.Hashtable;


// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.857F6D33-D4AD-892A-1045-16196C4B2256]
// </editor-fold> 
public class AlmacenCliente {

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.77CD0D45-E0BD-813D-7C4F-59AD1BC331BE]
    // </editor-fold> 
    private boolean disponible;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.6265A7DB-1588-2AAA-99E1-7A4EC3E734CD]
    // </editor-fold> 
    private Hashtable<Integer,ManejadorCliente> tabla;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.0B6D0189-BE61-63D5-6D9A-200EF435D630]
    // </editor-fold> 
    public AlmacenCliente () {
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.B8F21B01-1781-2F55-AC29-9F0D916B7110]
    // </editor-fold> 
    public boolean getDisponible (int identificador) {
        return disponible;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.4D603487-1165-7182-EFA2-81C6944BA1D2]
    // </editor-fold> 
    public void setDisponible ( boolean val) {
        this.disponible = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.7F1D5954-1252-A88B-44F7-1095A1A77329]
    // </editor-fold> 
    public void addManejadorCliente (ManejadorCliente cliente) {
        
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.133C0D83-533B-12F0-33A7-71AC6C73A17D]
    // </editor-fold> 
    public void removeManejadorCliente (ManejadorCliente cliente) {
       
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.6D307976-8061-AF35-8D43-32823A3EB896]
    // </editor-fold> 
    public void getManejadorCliente (int identificador) {
        
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.11830AFD-8898-1A44-A3E9-6B1439982B47]
    // </editor-fold> 
    public int tamano () {
        return 0;
    }

}

