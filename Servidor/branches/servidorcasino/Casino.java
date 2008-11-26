package servidorcasino;

public class Casino {
    static int MAX_PARTIDAS=1;
    static int MAX_JUGADORES=1;
    Partida [] partidas;
    int nPartidas;
    Jugador jugadoresActivos [];
    int nJugadores;
    
    public Casino(){
        nPartidas=0;
        nJugadores =0;
        partidas=new Partida[MAX_PARTIDAS];
        jugadoresActivos= new Jugador[MAX_JUGADORES];
     };
    public void anadePartida(Partida p){    	
        partidas[nPartidas]= p;
        nPartidas++;
     };
     
    public int anadeJugador(Jugador j){    	
        jugadoresActivos[nJugadores]=j;
        nJugadores++;
        return nJugadores-1;
     };
    
    public boolean anadeJugadorAPartida(Jugador j,int idPartida){    	
        //TODO Comprobar Que el jugador esta activo en el casino
        return partidas[idPartida].anadeJugador(j);
        
        
     };
     
     
     
    public int creaPartidaRuleta(){
         partidas[nPartidas]=new PartidaRuleta(nPartidas);
         nPartidas++;
         return nPartidas-1;
        }
    public boolean procesarJugada (Jugada j){
        /*TODO : comprobar que la partida y el usuario existen*/
        boolean b =false;
        int i = 0;
        b = partidas[j.getIdPartida()].procesarJugada(j);
        
        return b;

        };
}
