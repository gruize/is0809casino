package servidorcasino;

    public class Jugada {
        int idUsuario;
        int idPartida;
        int tipoJugada;
        Apuesta apuesta;

    public Jugada() {
            }

    public Jugada(int usuario,int partida,int tipojugada,Apuesta apuesta){
        idUsuario=usuario;
        idPartida=partida;
        tipoJugada=tipojugada;
        this.apuesta=apuesta;
        
        
    };

   
    public int getIdPartida() {
        return idPartida;
    }
    public int getIdUsuario() {
        return idUsuario;
    }
    public Apuesta getApuesta() {
        return apuesta;
    }  
   public int getTipoJugada() {
        return tipoJugada;
    }
   public void setIdPartida(int idPartida) {
        this.idPartida = idPartida;
    }
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    public void setTipoApuesta(Apuesta apuesta) {
        this.apuesta = apuesta;
    }
    public void setTipoJugada(int tipoJugada) {
        this.tipoJugada = tipoJugada;
    }

    
}
