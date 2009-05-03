/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo.mensajes;

/**
 *
 * @author Chaudhary
 */
public class MensajeInfoCliente implements java.io.Serializable {


    private int idUsuario;
    private double saldo;

    public MensajeInfoCliente(){}


        public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }



}
