/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package casino;

/**
 *
 * @author Administrador
 */
public class Casino {
PartidaBJ PartidasBJ [];
int nPartidas;
Jugador jugadoresactivos [];
int nJugadores;
public Casino(){
                nPartidas=0;
                PartidasBJ = new PartidaBJ [10];
                for (int i=0;i<10;i++)PartidasBJ[i]=new PartidaBJ();
                };
public void nuevaPartidaBJ(PartidaBJ p){    	
    PartidasBJ[nPartidas]= new PartidaBJ(p);
    nPartidas++;
	};
public boolean nuevajugada (Jugada j){
    /*Falta comprobar que la partida y el usuario existen*/
    boolean b =false;
    int i = 0;
    b = PartidasBJ[i].pocesarJugada(j);
    return b;
    
    };
}
