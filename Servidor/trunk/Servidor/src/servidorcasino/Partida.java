package servidorcasino;
public interface Partida {
    /*Jugador [] jugadorespartida ;
    int nJugadores;
    int id;
    final int TAM=5;
    float saldo[];
    float apuesta[];
    int turno;*/
    public boolean procesarJugada(Jugada j);
    public boolean anadeJugador(Jugador j);
    
}
