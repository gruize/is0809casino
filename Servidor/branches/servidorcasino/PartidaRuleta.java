/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servidorcasino;

/**
 *
 * @author Administrador
 */
public class PartidaRuleta implements Partida {
    
    final int TAM_MAX=5;    
    int id;    
    Jugador [] jugadoresPartida ;
    int nJugadores;
    ApuestaRuleta apuestas[];
    int nApuestas;

   

    public PartidaRuleta(int id) {
        this.id = id;
        jugadoresPartida=new Jugador[TAM_MAX];
        nJugadores=0;
        nApuestas=0;
        apuestas=new ApuestaRuleta[TAM_MAX];
    }

    public ApuestaRuleta[] getApuestas() {
        return apuestas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Jugador[] getJugadoresPartida() {
        return jugadoresPartida;
    }
   
    public int getNJugadores() {
        return nJugadores;
    }

    public void setNJugadores(int nJugadores) {
        this.nJugadores = nJugadores;
    }
    
    public int getNApuestas() {
        return nApuestas;
    }

    public void setNApuestas(int nApuestas) {
        this.nApuestas = nApuestas;
    }            
    public boolean procesarJugada(Jugada j){
            
            int i=0;
            /*Tipos dejugada:
             *  1- Realizar una apuesta
             *  2- Terminar de apostar-> Lanzar la bola
             */                  
            switch (j.getTipoJugada() ){
                    case 1: return colocarApuesta(j);
                                                
                    case 2:  int numero=lanzarBola();
                                
                            return true;
                    
                    default: return false;}
            
                
              
            }

    private boolean colocarApuesta(Jugada jugada){
        
        if (nApuestas<TAM_MAX){
            apuestas[nApuestas]=new ApuestaRuleta(jugada.getTipoJugada(),jugada.getTipoApuesta(),jugada.getCantidad());
            nApuestas++;
            return true;
           
        } 
        return false;
    }
       
    private int lanzarBola(){
    return (int) Math.round((Math.random() * 36));
    }
    
    public boolean anadeJugador(Jugador j){
        //TODO  comprobar que hay hueco para el jugador en la partida
        this.jugadoresPartida[nJugadores]=j;
        nJugadores++;
        return true;
    
    } 
    

}
