/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package casino;

/**
 *
 * @author Administrador
 */
public class PartidaBJ implements Partida {
	 private Jugador [] jugadorespartida ;
	 int nJugadores;
	 int id;
         final int TAM=5;
	 //Cartas [] cartas;
         float saldo[];
         float apuesta[];
         int turno;
        public PartidaBJ(){
            nJugadores=0;
            jugadorespartida=new Jugador [5];
            saldo=new float [TAM];
            apuesta=new float [TAM];
            for (int i=0;i<TAM;i++)jugadorespartida[i]=new Jugador();
            for (int i=0;i<TAM;i++)saldo[i]=0;
            for (int i=0;i<TAM;i++)apuesta[i]=0;
            };
	public PartidaBJ(Jugador j,int Id){
            nJugadores=0;
            id=Id;
            jugadorespartida=new Jugador [TAM];
            saldo=new float [TAM];
            apuesta=new float [TAM];
            for (int i=0;i<TAM;i++)jugadorespartida[i]=new Jugador();
            for (int i=0;i<TAM;i++)saldo[i]=0;
            for (int i=0;i<TAM;i++)apuesta[i]=0;
            nuevoJugador(j);
            
        };
	
	public PartidaBJ(PartidaBJ p){ 
		this.nJugadores=0;
                this.id=p.id;
                jugadorespartida=new Jugador [TAM];
                saldo=new float [TAM];
                apuesta=new float [TAM];
                for (int i=0;i<TAM;i++)saldo[i]=0;
                for (int i=0;i<TAM;i++)apuesta[i]=0;
		for (int i=0;i<(p.nJugadores);i++) nuevoJugador(p.jugadorespartida[i]);
		
		};
	
	public void nuevoJugador(Jugador j){
                nJugadores++;
                jugadorespartida[nJugadores-1]= new Jugador(j);
            
        };
        public boolean pocesarJugada(Jugada j){
            
            int i=0;
            while (jugadorespartida[i].id!=j.idUsuario){i++;}
            
             /*tipos
             1- apuesta
             2- pide carta
             3- pasa
             4- dobla
             Faltan casos por implemetar
             */
            switch (j.tipo ){
                    case 1: return apuestainicial(j)==1;
                                                
                    case 2: int x =(int)(Math.random() * 100) % 52;
                            return true;
                    
                    default: return false;}    
            };
            
            public int apuestainicial(Jugada j){
                int i = turno(j.idUsuario);
                float sal=this.jugadorespartida[i].saldo;
                if (i==turno){
                if (this.jugadorespartida[i].saldo<= j.cantidad){
                    sal-=j.cantidad;
                    return 1;}
                else return -2;//apuesta mas de lo que tiene
                }
                else return -1;
                
                
            
            };
            public boolean pidecarta(Jugada j){
                /*Falta implementarla*/
                if (this.turno == 1){return true;};          
                return true;
            
            };
            
            int turno(int id){
                
            int i=0;
                while (((this.jugadorespartida[i].id)!=id)&& (i<TAM)){i++;};
                if (i==TAM) return -1;
                else return i;
            
            };
}