package modelo;


/**
 *
 * @author GabiPC
 */
public class Apuesta {

    public enum tipoAp {NUMERO, COLOR, PARIMPAR, DOCENA, FALTAPASA, LINEA, CUADRO}

    /**
    Numero:0,1,2,3,4....,36
    Color: rojo :1 negro:2
    ParImpar: impar:1 par:2
    Docena (Doce numeros contiguos) : 1,2,3
    FaltaPasa(1-18 y 19-36): Falta:1 Pasa:2
    Linea(Toda una columna): 1,2,3
    Cuadro(Cuatro numeros Contiguas): 1:1,2,4,5   2:2,3,5,6     ....  22: 32,33,35,36
     */

    private int casilla;
    //Tipo de casilla a la que se apuesta. Enumerado TipoAp.
    private tipoAp tipo;
    //Dinero apostado
    private double valorApostado;


    public Apuesta(int casilla, tipoAp tipo, double valorApostado) {
        this.casilla = casilla;
        this.tipo = tipo;
        this.valorApostado = valorApostado;
    }

    public int getCasilla() {
        return casilla;
    }

    public void setCasilla(int casilla) {
        this.casilla = casilla;
    }

    public tipoAp getTipo() {
        return tipo;
    }

    public void setTipo(tipoAp tipo) {
        this.tipo = tipo;
    }

    public double getValorApostado() {
        return valorApostado;
    }

    public void setValorApostado(double valorApostado) {
        this.valorApostado = valorApostado;
    }

    public void imprimir(){
    	System.out.println("casilla=  "+casilla);
    	System.out.println("tipo=  "+tipo.toString());
    	System.out.println("dinero=  "+Double.toString(this.valorApostado));
    }
}
