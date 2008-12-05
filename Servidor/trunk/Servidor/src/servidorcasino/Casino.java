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
        partidas=new PartidaRuleta[MAX_PARTIDAS];
        jugadoresActivos= new Jugador[MAX_JUGADORES];
     };
    public void anadePartida(PartidaRuleta p){    	
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
     
    public int tiradaPartidaRuleta(int idPart){
        
    return partidas[idPart].ultimaTirada;
    
    }
     
    public int creaPartidaRuleta(){
         partidas[nPartidas]=new PartidaRuleta(nPartidas);
         nPartidas++;
         return nPartidas-1;
        }
    public int procesarJugada (Jugada j){
        /*TODO : comprobar que la partida y el usuario existen*/
      
        int i = 0;
        i = partidas[j.getIdPartida()].procesarJugada(j);
        
        return i;

        };
}
