package servidorcasino;


public interface Partida {
    Jugador [] jugadorespartida =null;
    int nJugadores=0;
    int id=-1;
    final int TAM=5;
    float saldo[]=null;
    float apuesta[]=null;
    int turno=0;
    int ultimaTirada=0;
    public int procesarJugada(Jugada j);
    public boolean anadeJugador(Jugador j);
    
}
