/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servidorcasino;
import java.util.*;

/**
 *
 * @author Administrador
 */
public class PartidaRuleta implements Partida {
    
    final int TAM_MAX=5;    
    int id;    
    //Jugador [] jugadoresPartida ;
    int nJugadores;
    ArrayList <ApuestaRuleta>  apuestas;
    int nApuestas;
    ArrayList <Jugador> jugadoresPartida;

   

    public PartidaRuleta(int id) {
        this.id = id;
        jugadoresPartida=new ArrayList <Jugador>(); 
        nJugadores=0;
        nApuestas=0;
        apuestas=new ArrayList <ApuestaRuleta> ();
        
    }

    public ArrayList <ApuestaRuleta> getApuestas() {
        return apuestas;
    }

    public int getId() {
        return id;
    }

   
    public ArrayList<Jugador> getJugadoresPartida() {
        return jugadoresPartida;
    }
   
    public int getNJugadores() {
        return nJugadores;
    }
    
    public int getNApuestas() {
        return nApuestas;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public void setNJugadores(int nJugadores) {
        this.nJugadores = nJugadores;
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
        case 2: int numero=lanzarBola();
                comprobarApuestas(numero);
                /*Mandar mensaje al cliente con el resultado de la tirada y de sus apuestas.*/
                return true;
        default: return false;
        }
        
    }

    private boolean colocarApuesta(Jugada jugada){
        int posicionJugador=posicionJugador(jugada.getIdUsuario());
        if (nApuestas<TAM_MAX){
            int saldoJugador=jugadoresPartida.get(posicionJugador).getSaldo();
            if (jugada.getCantidad()<= saldoJugador){
                apuestas.add(nApuestas, new ApuestaRuleta(jugada.getTipoJugada(),jugada.getTipoApuesta(),jugada.getCantidad()));
                nApuestas++;
                jugadoresPartida.get(posicionJugador).setSaldo(saldoJugador-jugada.getCantidad());
                return true;
            }
        } 
        return false;
    }
       
    private int lanzarBola(){
        return (int) Math.round((Math.random() * 36));
    }
    
    private void comprobarApuestas(int bolaLanzada){
    //TODO ir comprobando las apuestas del jugador e ir aumentando su saldo si corresponde
        
    }
    private int posicionJugador(int idJugador){
        boolean encontrado =false;
        int index=0;
        while ((!encontrado)&&(index<jugadoresPartida.size())){
            encontrado=jugadoresPartida.get(index).getId()==idJugador;
            index++;
        }
        return index-1;
    
    
    }
    public boolean anadeJugador(Jugador j){
        //TODO  comprobar que hay hueco para el jugador en la partida
        this.jugadoresPartida.add(nJugadores, j);
        nJugadores++;
        return true;
    
    } 
    

}
