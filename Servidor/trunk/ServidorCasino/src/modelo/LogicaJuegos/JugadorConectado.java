/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.LogicaJuegos;

import bbdd.beans.Clientes;

/**
 *
 * Contiene toda la información que se guardará (en el Gestor de Usuarios) de los jugadores conectados en el casino
 */
public class JugadorConectado {

    private int idJugador;
    private int idSala; //sala en la que esta jugando actualmente
    private int idMesa; //mesa en la que está jugando actualmente

    public int getIdJugador() {
        return idJugador;
    }

    /**
     * Constructora por defecto
     * @param idCliente
     */
    public JugadorConectado(int idCliente) {
        this.idJugador = idCliente;
        this.idMesa = -1;
        this.idSala = -1;
    }

    public JugadorConectado(Clientes cliente) {
        if (cliente != null){
            this.idJugador = cliente.getCodigo();
        }else {
            System.out.println("MAL MAL MAL");
            this.idJugador = -1;
        }
        this.idMesa = -1;
        this.idSala = -1;

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
}
