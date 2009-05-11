/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import modelo.mensajes.MensajeChat;
import modelo.mensajes.MensajeEstadoRuleta;
import modelo.mensajes.MensajeExpulsion;
import modelo.mensajes.MensajeInfoMesas;
import modelo.mensajes.MensajeInfoSalas;
import modelo.mensajes.MensajeJugada;
import java.util.Observable;
import modelo.mensajes.MensajeInfoCliente;
import modelo.mensajes.MensajeUsuariosEnMesa;
/**
 *
 * @author david
 */
public class ModeloCliente extends Observable{

    private String usuario;
    private int id;
    private int sala;
    private int mesa;
    private double saldo;

    public void actualizaEstadoRuleta(MensajeEstadoRuleta m) {
        setChanged();
        this.notifyObservers(m);
    }

    public void actualizaUsuariosEnMesa(MensajeUsuariosEnMesa mensajeUEM) {
        setChanged();
        this.notifyObservers(mensajeUEM);
    }

    public void actualizarSaldo(MensajeInfoCliente mensajeInfoCliente) {
        setSaldo(mensajeInfoCliente.getSaldo());
        setChanged();
        this.notifyObservers(mensajeInfoCliente);
    }

    public double getSaldo() {
        return saldo;
    }

    public void expulsado(MensajeExpulsion mensajeExpulsion) {
        setChanged();
        this.notifyObservers(mensajeExpulsion);
    }

    public void rellenarMesas(MensajeInfoMesas mensajeInfoMesas) {
        setChanged();
        this.notifyObservers(mensajeInfoMesas);
    }

    public void rellenarSalas(MensajeInfoSalas mensajeInfoSalas) {
        setChanged();
        this.notifyObservers(mensajeInfoSalas);
    }

    public void addmensajechat(MensajeChat mensajeChat){
        setChanged();
        notifyObservers(mensajeChat);
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void modelo(){
        id = 0;
        sala = 0;
        mesa = 0;
    }

    public int getId() {
        return id;
    }

    public int getSala() {
        return sala;
    }

    public int getMesa() {
        return mesa;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setId(int ID) {
        id = ID;
    }

    public void setSala(int sal) {
        sala = sal;
    }

    public void setMesa(int mes) {
        mesa = mes;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * Nuevo MensajeJugada para notificar a los clientes del cambio
     * @param mensaje
     */
    public void addMensajeJugada(MensajeJugada mensaje){
        setChanged();
        notifyObservers(mensaje);
    }

    public void ponerapuesta(){

    }

    public void quitarapuesta(){

    }
}
