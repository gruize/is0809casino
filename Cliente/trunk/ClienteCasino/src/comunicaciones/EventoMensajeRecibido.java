package comunicaciones;

// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.41685546-2104-282C-AFF1-C3B0E5B38C43]
// </editor-fold> 
class EventoMensajeRecibido extends Thread{

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.9FAD60B9-D473-38B4-CB64-E4DD0E350D88]
    // </editor-fold> 
    private MensajeComunicaciones mensaje;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.15174A48-533B-BC17-11DD-5412A51CAC0A]
    // </editor-fold> 
    //private Casino casino;


    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.5AAF560E-EAC6-EDA6-48C2-FFFE852BC153]
    // </editor-fold> 
    public EventoMensajeRecibido (/*Casino casino,*/ MensajeComunicaciones mensaje) {
        this.mensaje = mensaje;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.DE3D6F3C-C47A-3DAA-6DAC-B6EF03F3B834]
    // </editor-fold> 
    public MensajeComunicaciones getMensaje () {
        return mensaje;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.E9A2A315-9AD6-4054-B4FD-8DF38EBBBA0F]
    // </editor-fold> 
    public void setMensaje (MensajeComunicaciones val) {
        this.mensaje = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.6A5D20D8-7646-B3B3-83E5-E0D770557136]
    // </editor-fold> 
    @Override
    public void run () {
        //TODO Aquí va la llamada al controlador central
        System.out.println("Mensaje recibido:" + mensaje.getMensaje().toString());
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.EC042543-728E-860F-3FAD-55A40023FC24]
    // </editor-fold> 
    public void finalize () {
    }

}

