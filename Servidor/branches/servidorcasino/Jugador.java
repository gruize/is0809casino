package servidorcasino;

public class Jugador {
    int id;
    int saldo;
    public Jugador(){
        id=0;
        saldo=0;
    };
    public Jugador (int i,int s){
        id=i;
        saldo=s;
    };
    public Jugador (Jugador j){
        id=j.getId();
        saldo=j.getSaldo();
    };
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }
    
   
}
