/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo.LogicaJuegos;

import bbdd.beans.Clientes;

/**
 *
 * Contiene toda la información que se guardará de los jugadores conectados en el casino
 */
public class JugadorConectado {

    private int idJugador;
private Clientes jugador; //objeto que se guardará en BBDD --> necesitaremos actualizar su saldo


//TODO realmente necesito saber la sala y la mesa?? eso ya me lo podría decir el GestorSalas y GestorMesas
    private int idSala; //sala en la que esta jugando actualmente
    private int idMesa; //mesa en la que está jugando actualmente
    
      public int getIdJugador() {
        return idJugador;
    }

    /**
     * Constructora por defecto
     * @param idCliente
     */
    public JugadorConectado(int idCliente){
        this.idJugador=idCliente;
    }

    public JugadorConectado(Clientes cliente){
        this.idJugador=cliente.getCodigo();
        this.jugador=cliente;
    }

    public int getIdMesa() {
        return idMesa;
    }

    public void setIdMesa(int idMesa) {
        this.idMesa = idMesa;
    }

    public int getIdSala() {
        return idSala;
    }

    public void setIdSala(int idSala) {
        this.idSala = idSala;
    }

    public Clientes getJugador() {
        return jugador;
    }

    public void setJugador(Clientes jugador) {
        this.jugador = jugador;
    }

    /**
     * TODO saldo no debe ser double?? 
     * @param nuevoSaldo
     */
    public void actualizaSaldo(int nuevoSaldo){
        this.jugador.setSaldo(nuevoSaldo);
        //el gestor de usuarios se encargará de actualizarlo en bbdd
    }

    /**
     * Devuelve el saldo de un jugador
     * @return
     */
    public int getSaldoJugador(){
        return this.jugador.getSaldo();
    }


}
