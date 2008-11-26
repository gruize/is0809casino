package servidorcasino;

    public class Jugada {
        int idUsuario;
        int idPartida;
        int tipoJugada;
        int cantidad;
        int tipoApuesta;

    public Jugada() {
            }

    public Jugada(int usuario,int partida,int tipojugada,int cantidadApostada,int tipoapuesta){
        idUsuario=usuario;
        idPartida=partida;
        tipoJugada=tipojugada;
        cantidad=cantidadApostada;
        tipoApuesta=tipoapuesta;
    };

    public int getCantidad() {
        return cantidad;
    }
    public int getIdPartida() {
        return idPartida;
    }
    public int getIdUsuario() {
        return idUsuario;
    }
    public int getTipoApuesta() {
        return tipoApuesta;
    }  
   public int getTipoJugada() {
        return tipoJugada;
    }
   public void setIdPartida(int idPartida) {
        this.idPartida = idPartida;
    }
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    public void setTipoApuesta(int tipoApuesta) {
        this.tipoApuesta = tipoApuesta;
    }
    public void setTipoJugada(int tipoJugada) {
        this.tipoJugada = tipoJugada;
    }

    
}
