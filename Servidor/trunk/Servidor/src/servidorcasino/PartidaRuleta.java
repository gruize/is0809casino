/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servidorcasino;
import java.util.*;
import Casilla.*;

/**
 *
 * @author Administrador
 */
public class PartidaRuleta implements Partida {
    
    final int TAM_MAX=5;    
    int id;    
    int nJugadores;
    ArrayList <ApuestaRuleta>  apuestas;
    int nApuestas;
    ArrayList <Jugador> jugadoresPartida;
    ArrayList numeros;
    int ultimaBola;
    CreaRuleta ruleta;

    public PartidaRuleta(int id) {
        this.id = id;
        jugadoresPartida=new ArrayList <Jugador>(); 
        nJugadores=0;
        nApuestas=0;
        apuestas=new ArrayList <ApuestaRuleta> ();
        
        ruleta = new CreaRuleta();
        ruleta.InicializarRuleta();
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
    
    public int procesarJugada(Jugada j){
            
    int i=0;
    /*Tipos dejugada:
    *  1- Realizar una apuesta
    *  2- Terminar de apostar-> Lanzar la bola
    */                  
    switch (j.getTipoJugada() ){
        case 1: return colocarApuesta(j);
        case 2: ultimaBola=lanzarBola();
                int ganancias=comprobarApuestas(ultimaBola);
                int posicionJugador=posicionJugador(j.getIdUsuario());
                int saldoNuevo=ganancias+jugadoresPartida.get(posicionJugador).getSaldo();
                jugadoresPartida.get(posicionJugador).setSaldo(saldoNuevo);
                /*Mandar mensaje al cliente con el resultado de la tirada y de sus apuestas.*/
                return saldoNuevo;
        default: return 0;
        }
        
    }

    private int colocarApuesta(Jugada jugada){
        int posicionJugador=posicionJugador(jugada.getIdUsuario());
        if (nApuestas<TAM_MAX){
            int saldoJugador=jugadoresPartida.get(posicionJugador).getSaldo();
            if ((jugada.getApuesta().get_cantidad())<= saldoJugador){
                apuestas.add((ApuestaRuleta)jugada.getApuesta());
                nApuestas++;
                jugadoresPartida.get(posicionJugador).setSaldo(saldoJugador-jugada.getApuesta().get_cantidad());
                return 1;
            }
            else return -1;
        } 
        return -2;
    }
       
    private int lanzarBola(){
        return (int) Math.round((Math.random() * 36));
    }
    
    private int comprobarApuestas(int bolaLanzada){
    //TODO ir comprobando las apuestas del jugador e ir aumentando su saldo si corresponde
        Numero bola =ruleta.getNumero(bolaLanzada);
        int saldoParcial=0;
        for (int i =0;i<apuestas.size();i++){
           
         saldoParcial =saldoParcial+ apuestaGanadora(apuestas.get(i),bolaLanzada,bola);
         
         
                 } 
        borrarApuestas();
        return saldoParcial;
    }
    private int apuestaGanadora(ApuestaRuleta apuesta,int bolalanzada,Numero casillaBola){
        
       if ((apuesta.get_tipo().equals("numero"))&&(apuesta.get_casilla()==bolalanzada)) return apuesta.get_cantidad()*36;
       else if ((apuesta.get_tipo().equals("PARIMPAR"))&&(apuesta.get_color().equals(casillaBola.getColor())))return apuesta.get_cantidad()*2;
        return 0;
    }
    
      void borrarApuestas(){
       int tam = apuestas.size();
       for (int i =0;i<tam;i++){
       apuestas.remove(0);
       nApuestas=0;
       }

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
    public Numero getUltimaBola(){
    return ruleta.getNumero(this.ultimaBola);
    }

}
