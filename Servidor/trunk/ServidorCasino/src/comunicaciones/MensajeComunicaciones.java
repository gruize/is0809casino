package comunicaciones;

import java.io.Serializable;


// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.15C7BD5C-857E-7150-C933-5981CF17CF51]
// </editor-fold> 
public class MensajeComunicaciones {

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.E0E12A89-8815-8963-8B10-46EBA1F69410]
    // </editor-fold> 
    private int remitente;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.53735084-216B-A82F-550A-EC225A71A600]
    // </editor-fold> 
    private int tipo;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.1D5457D8-1954-A0A7-5E01-C8FDE5DE0845]
    // </editor-fold> 
    private Serializable mensaje;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.B2DC9E88-B194-F3BC-8B57-7DD1ADA7D3D7]
    // </editor-fold> 
    private int destino;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.59C805A8-3AE2-9FCD-870E-CCB10D19CB11]
    // </editor-fold> 
    public MensajeComunicaciones (int remitente, int destino, Serializable mensaje) {
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.2905F741-E1C7-A41A-CDA7-679F174F6641]
    // </editor-fold> 
    public Serializable getMensaje () {
        return mensaje;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.1B65D68B-0B8D-9D51-0574-F192C922F5EF]
    // </editor-fold> 
    public void setMensaje (Serializable val) {
        this.mensaje = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.746DA647-D933-E5EA-A558-08B29C9240E7]
    // </editor-fold> 
    public int getRemitente () {
        return remitente;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.406CF76C-16E1-D9EA-D951-7C58BDB2AC4A]
    // </editor-fold> 
    public void setRemitente (int val) {
        this.remitente = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.D8E4E385-9EEA-F94D-8B82-94B5094940C8]
    // </editor-fold> 
    public int getTipo () {
        return tipo;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.707BA227-6BAE-B539-CACA-4EFC118D5E18]
    // </editor-fold> 
    public void setTipo (int val) {
        this.tipo = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.57C14B10-7BA9-B2E6-6FE0-86674D4D5FE6]
    // </editor-fold> 
    public int compareTo () {
        return 0;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.20144E66-4850-C897-4F74-18A26A952C74]
    // </editor-fold> 
    public int getDestino () {
        return destino;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.FE8CB343-7EFA-5A30-4142-8C3039120877]
    // </editor-fold> 
    public void setDestino (int val) {
        this.destino = val;
    }

}

