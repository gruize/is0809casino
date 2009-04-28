package bbdd.beans;
// Generated 09-mar-2009 10:24:16 by Hibernate Tools 3.2.1.GA


/**
 * Bean de Partida
 */
public class ParticipantesId  implements java.io.Serializable {


     private int partida;
     private int jugador;

    public ParticipantesId() {
    }

    public ParticipantesId(int partida, int jugador) {
       this.partida = partida;
       this.jugador = jugador;
    }
   
    public int getPartida() {
        return this.partida;
    }
    
    public void setPartida(int partida) {
        this.partida = partida;
    }
    public int getJugador() {
        return this.jugador;
    }
    
    public void setJugador(int jugador) {
        this.jugador = jugador;
    }


  /* public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof ParticipantesId) ) return false;
		 ParticipantesId castOther = ( ParticipantesId ) other; 
         
		 return ( (this.getPartida()==castOther.getPartida()) || ( this.getPartida()!=null && castOther.getPartida()!=null && this.getPartida().equals(castOther.getPartida()) ) )
 && ( (this.getJugador()==castOther.getJugador()) || ( this.getJugador()!=null && castOther.getJugador()!=null && this.getJugador().equals(castOther.getJugador()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getPartida() == null ? 0 : this.getPartida().hashCode() );
         result = 37 * result + ( getJugador() == null ? 0 : this.getJugador().hashCode() );
         return result;
   }   
*/

}

