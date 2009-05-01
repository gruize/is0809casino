/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;


/**
 *
 * @author GabiPC
 */
public class Apuesta {

    public enum proporcionAp {SIMPLE, DOBLE, CUADRUPLE}

    public enum tipoAp {NUMERO, COLOR, DOCENA, FILA, PARIDAD, MITAD}

    public enum casillaAp {PAR, IMPAR, ROJO, NEGRO, FILA1, FILA2, FILA3, DOCENA1,
                           DOCENA2, DOCENA3, MITAD1, MITAD2}

    //Indica el valor al que se apuesta. Casilla 1, 2, ..., 36, 0, Par, Impar,
    //Rojo, Negro, Fila1, ... Docena1, ... Mitad1...
    private String casilla;
    //Tipo de casilla a la que se apuesta. Numero, docena, fila, color, par_impar, mitad
    private tipoAp tipo;
    private proporcionAp proporcion;
    //Dinero apostado
    private int valorApostado;

    public Apuesta(casillaAp casilla, tipoAp tipo, proporcionAp proporcion, int valorApostado) {
        this.casilla = casilla.toString();
        this.tipo = tipo;
        this.proporcion = proporcion;
        this.valorApostado = valorApostado;
    }

        public Apuesta(int casilla, tipoAp tipo, proporcionAp proporcion, int valorApostado) {
        this.casilla = Integer.toString(casilla);
        this.tipo = tipo;
        this.proporcion = proporcion;
        this.valorApostado = valorApostado;
    }

    public String getCasilla() {
        return casilla;
    }

    public void setCasilla(casillaAp casilla) {
        this.casilla = casilla.toString();
    }

    public void setCasilla(int casilla) {
        this.casilla = Integer.toString(casilla);
    }

    public proporcionAp getProporcion() {
        return proporcion;
    }

    public void setProporcion(proporcionAp proporcion) {
        this.proporcion = proporcion;
    }

    public tipoAp getTipo() {
        return tipo;
    }

    public void setTipo(tipoAp tipo) {
        this.tipo = tipo;
    }

    public int getValorApostado() {
        return valorApostado;
    }

    public void setValorApostado(int valorApostado) {
        this.valorApostado = valorApostado;
    }

}
