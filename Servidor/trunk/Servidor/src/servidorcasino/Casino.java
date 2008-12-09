package servidorcasino;
import Casilla.Numero;

public class Casino {

    private int MAX_PARTIDAS=1;
    private int MAX_JUGADORES=1;
    private Partida [] partidas;
    private int nPartidas;
    private Jugador jugadoresActivos [];
    private int nJugadores;

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

    public Numero tiradaPartidaRuleta(int idPart){

    return partidas[idPart].getUltimaBola();

    }

    public int creaPartidaRuleta(){
         partidas[nPartidas]=new PartidaRuleta(nPartidas);
         nPartidas++;
         return nPartidas-1;
        }

    //No entiendo nada de lo que se hace aqui.Hay una llamada a una interfaz.
    //El metodo no esta implementado y �la interfaz la implementa alguna clase?
    //No la he encontrado al menos.Explicarlo a quien le corresponda o si esta sin
    // acabar terminarlo cuando podais.
    public int procesarJugada (Jugada j){
        /*TODO : comprobar que la partida y el usuario existen*/

        int i = 0;
        i = partidas[j.getIdPartida()].procesarJugada(j);

        return i;

        };
}
