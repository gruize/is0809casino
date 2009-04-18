/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bbdd.gestorBBDD;

import bbdd.beans.Clientes;
import bbdd.beans.Juegos;
import bbdd.beans.Mesas;
import bbdd.beans.Participantes;
import bbdd.beans.Partidas;
import bbdd.beans.Salas;
import bbdd.DAO.*;
import java.util.ArrayList;

/**
 *
 * @author Ambrin Chaudhary y Joaquin Lopez
 */
public class GestorBBDDImp implements InterfazBBDD {

    private DAOClientes daoClientes = null;
    private DAOJuegos daoJuegos = null;
    private DAOSalas daoSalas = null;
    private DAOMesas daoMesas = null;
    private DAOPartidas daoPartidas = null;
    private DAOParticipantes daoParticipantes = null;
    
    /**
     * Constructora. Inicializa los objetos DAO
     */
    public GestorBBDDImp() {
        daoClientes = new DAOClientes();
        daoJuegos = new DAOJuegos();
        daoSalas = new DAOSalas();
        daoMesas = new DAOMesas();
        daoPartidas = new DAOPartidas();
        daoParticipantes = new DAOParticipantes();
    }
    
     /**
     * Comprueba si existe el usuario
     * @param usuario nombre de usuario
     * @param pswd contraseña
     * @return "id" del usuario si existe, y su contraseña es correcta. 
     *         -1 en otro caso
     */
    public int comprobarUsuario(String usuario, String pswd) {
        Clientes cliente = daoClientes.getClientePorUsuario(usuario);
        if (cliente == null) {
            return -1;        
        } else {
            if (!cliente.getPassword().equals(pswd))
                return -1;
            else return cliente.getCodigo();
        }
    }

    public ArrayList getClientes() {
        return daoClientes.getClientes();
    }

    public Clientes getClientePorUsuario(String usuario) {
        return daoClientes.getClientePorUsuario(usuario);
    }

    public Clientes getClientePorCodigo(int codigo) {
        return daoClientes.getClientePorCodigo(codigo);
    }

    public boolean insertarCliente(Clientes cliente) {
        return daoClientes.insertarNuevoCliente(cliente);
    }

    public boolean modificarCliente(Clientes cliente) {

        //TODO hacer que devuelva el resultado
        daoClientes.modificarCliente(cliente);
        return true;        
    }

    public void borrarCliente(Clientes cliente) {
        daoClientes.borrarCliente(cliente);
    }

    public ArrayList getJuegos() {
        return daoJuegos.getJuegosCasino();
    }

    public Juegos getJuegoPorCodigo(int codigo) {
        return daoJuegos.getJuegoPorCodigo(codigo);
    }

    public Juegos getJuegoPorNombre(String nombreJuego) {
        return daoJuegos.getJuegoPorNombre(nombreJuego);
    }

    public boolean insertarJuego(Juegos juego) {
        return daoJuegos.insertarNuevoJuego(juego);
    }

    public boolean modificarJuego(Juegos juego) {
        //TODO hacer que devuelva el resultado
        daoJuegos.modificarJuego(juego);
        return true;
    }

    public void borrarJuego(Juegos juego) {
        daoJuegos.borrarJuego(juego);
    }

    public ArrayList getSalas() {
        return daoSalas.getSalas();
    }

    public Salas getSalaPorCodigo(int codigo) {
        return daoSalas.getSalaPorCodigo(codigo);
    }

    public boolean insertarSala(Salas sala) {
        return daoSalas.insertarNuevaSala(sala);
    }

    public boolean modificarSala(Salas sala) {
        //TODO hacer que devuelva el resultado
        daoSalas.modificarSala(sala);
        
        return true;
    }

    public void borrarSala(Salas sala) {
        daoSalas.borrarSala(sala);
    }

    public ArrayList getMesas() {
        return daoMesas.getMesas();
    }

    public Mesas getMesa(int codigo) {
        return daoMesas.getMesaPorCodigo(codigo);
    }

    public boolean insertarMesa(Mesas mesa) {
        return daoMesas.insertarNuevaMesa(mesa);
    }

    public boolean modificarMesa(Mesas mesa) {
        //TODO hacer que devuelva el resultado
        daoMesas.modificarMesa(mesa);
        return true;        
    }

    public void borrarMesa(Mesas mesa) {
        daoMesas.borrarMesa(mesa);
    }

    public ArrayList getPartidas() {
        return daoPartidas.getPartidas();
    }

    public Partidas getPartida(int codigo) {
        return daoPartidas.getPartidaPorCodigo(codigo);
    }

    public boolean insertarPartida(Partidas partida) {
        return daoPartidas.insertarNuevaPartida(partida);
    }

    public boolean modificarPartida(Partidas partida) {
        //TODO hacer que devuelva el resultado
        daoPartidas.modificarPartida(partida);
        return true;
    }

    public void borrarPartida(Partidas partida) {
        daoPartidas.borrarPartida(partida);
    }

    public ArrayList getParticipantes() {
        return daoParticipantes.getParticipantes();
    }

    public ArrayList getPartidasPorParticipante(int idJugador) {
        return daoParticipantes.getPartidasPorParticipante(idJugador);
    }

    public ArrayList getJugadoresPorPartida(int idPartida) {
        return daoParticipantes.getJugadoresPorPartida(idPartida);
    }

    public boolean insertarParticipante(Participantes participante) {
        return daoParticipantes.insertarNuevoParticipante(participante);
    }

    public boolean modificarParticipante(Participantes participante) {
        //TODO hacer que devuelva el resultado
        daoParticipantes.modificarParticipante(participante);
        return true;
    }

    public void borrarParticipante(Participantes participante) {
        daoParticipantes.borrarParticipante(participante);
    }

    public Participantes getParticipante(int idJug, int idPartida) {
        return daoParticipantes.getParticipante(idJug, idPartida);
    }
}
