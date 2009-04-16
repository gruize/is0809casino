/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador;

/**
 *
 * @author GabiPC
 */
public class Apuesta {

    private int cantidadApostada;
    private String valor;

    public Apuesta() {
    }

    public Apuesta(int cantidad, String valor) {
        this.cantidadApostada = cantidad;
        this.valor = valor;
    }

    public int getCantidadApostada() {
        return cantidadApostada;
    }

    public void setCantidadApostada(int cantidadApostada) {
        this.cantidadApostada = cantidadApostada;
    }
    
    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public void imprimir(){
        System.out.println("Cantidad apostada: " + this.getCantidadApostada());
        System.out.println("Valor al que se apuesta: " + this.getValor());
    }

}