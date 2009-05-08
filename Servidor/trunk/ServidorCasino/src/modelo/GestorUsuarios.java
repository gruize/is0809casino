/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import bbdd.gestorBBDD.GestorBBDDImp;
import bbdd.gestorBBDD.InterfazBBDD;

import bbdd.beans.Clientes;
import controlador.ControladorServidor;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.DefaultListModel;
import modelo.LogicaJuegos.JugadorConectado;
import org.apache.log4j.Logger;

/**
 *
 * @author Fiutten
 */
public class GestorUsuarios {

    //--------------------------------------------------------------------------
    //          ATRIBUTOS
    //--------------------------------------------------------------------------
    private static Vector<JugadorConectado> jugadores = null;
    private InterfazBBDD bbdd;
    private ControladorServidor controlador;
    private static DefaultListModel listaUsuarios;
    //PatrÃƒÂ³n Singleton
    private static GestorUsuarios instancia;

    //log4j
    private static Logger log = Logger.getLogger(GestorUsuarios.class);

    //--------------------------------------------------------------------------
    //          METODOS
    //--------------------------------------------------------------------------
    public static GestorUsuarios getInstancia(ControladorServidor c) {
        if (instancia == null) {
            instancia = new GestorUsuarios(c);
            listaUsuarios = new DefaultListModel();
        }
        return instancia;
    }

    public GestorUsuarios(ControladorServidor c) {

        jugadores = new Vector<JugadorConectado>();
        this.controlador = c;
        this.bbdd = new GestorBBDDImp();

    }

    public DefaultListModel getUsuarios() {
        ArrayList usuarios = this.bbdd.getClientes();
        for (int i = 0; i < usuarios.size(); i++) {
            Clientes jugador = (Clientes) usuarios.get(i);
            listaUsuarios.addElement(jugador.getUsuario());
        }
        return listaUsuarios;
    }

    //======================================================================
    //          INSERTAR JUGADOR
    //======================================================================
    /**
     * Comprueba el login de un usuario
     * @param usuario nombre de usuario
     * @param password contraseÃƒÂ±a
     * @return identificador del usuario si los datos son correctos, y no estaba ya en el casino, -1 e.o.c
     */
    public int hacerLogin(String usuario, String password) {
        int id = -1;

        id = bbdd.comprobarUsuario(usuario, password);
        //Si el jugador aun no estÃƒÂ¡ conectado devuelve resultado = -1
        if (getIndiceJugador(id) == -1) {
            if (!listaUsuarios.contains(usuario))
                listaUsuarios.addElement(usuario);
            insertarJugador(bbdd.getClientePorCodigo(id));
            log.info("GestorUsuarios : hacerLogin : Jugador con id=" + id + " logeado en el casino");
        } else { //ya estÃƒÂ¡ conectado, devuelvo -1 hacia el comunicador
            id = -1;
        }

        return id;
    }

    /**
     * Cuando un jugador se logea y entra en el casino. AÃƒÂºn no ha entrado en sala ni mesa
     * @param idSala
     * @param idMesa
     * @param c
     */
    public void insertarJugador(Clientes c) {
        JugadorConectado jugador = new JugadorConectado(c);
        jugadores.add(jugador);

    //aÃƒÂºn no se inserta nada en BBDD, no se considera Participante porque aÃƒÂºn no ha entrado en sala ni mesa
    }

    /**
     * Cuando el jugador entra en una sala.
     * @param idJugador
     * @param idSala
     */
    public void insertarJugadorEnSala(int idJugador, int idSala) {

        //buscar el jugador en la lista de jugadores del casino
        int posJugador = getIndiceJugador(idJugador);
        JugadorConectado jugador = jugadores.get(posJugador);
        jugador.setIdSala(idSala);
        jugadores.add(posJugador, jugador);


        log.info("GestorUsuarios : insertarJugadorEnSala : Jugador=" + idJugador + " insertado en sala=" + idSala);
    }

    /**
     * Cuando el jugador selecciona una msea de juego
     * @param idJugador
     * @param idMesa
     */
    public boolean insertarJugadorEnMesa(int idJugador, int idMesa) {

        getJugadorConectado(idJugador).setIdMesa(idMesa);


        //Enviarselo al gestorSalas, y que llame a su gestorMesas y lo incluya en la mesa correspondiente
        if (GestorSalas.getInstance(controlador).insertarJugadorEnMesa(getJugadorConectado(idJugador).getIdSala(),idMesa, idJugador)) {
            log.info("GestorUsuarios : insertarJugadorEnMesa : Jugador=" + idJugador + " insertado en mesa=" + idMesa);
            return true;
        } else {
            log.info("GestorUsuarios : insertarJugadorEnMesa : Jugador=" + idJugador + " NO se ha insertado en mesa=" + idMesa);
            return false;
        }
    }

    //=======================================================================
    //              getters
    //=======================================================================
    /**
     * Busca la posicion del vector de jugadores donde se encuentra el jugador
     * @return posicion del jugador si estÃƒÂ¡ en la lista de jugadores del casino
     *          -1 si no lo encuentra
     */
    public int getIndiceJugador(int idJugador) {

        try {
            if (jugadores != null && jugadores.size() > 0) {

                int i = 0;
                boolean enc = false;
                while (!enc && i < jugadores.size()) {
                    enc = jugadores.get(i).getIdJugador() == idJugador;
                    i++;
                }

                if (enc) {
                    return i - 1;
                } else {
                    return -1; //el usuario aÃƒÂºn no estÃƒÂ¡ registrado
                }
            } else {//es el primer jugador del casino, tampoco se ha insertado aÃƒÂºn
                return -1;
            }

        } catch (Exception e) {
            log.error("GestorUsuarios : getIndiceJugador : error al buscar jugador. " + e.getMessage());
            return -1;
        }
    }

    /**
     * Busca un jugador de la lista de jugadores
     * @param idJugador
     */
    public JugadorConectado getJugadorConectado(int idJugador) {

        return jugadores.get(getIndiceJugador(idJugador));
    }

    //======================================================================
    //          ELIMINAR JUGADOR
    //======================================================================
    /**
     * TODO hacer
     *
     * Elimina al jugador de la mesa en la que se encontraba.
     * @param jugador
     * @return
     */
    public boolean eliminarJugadorEnMesa(int idJugador) {

        JugadorConectado j = getJugadorConectado(idJugador);
        //GestorSalas -> GestorMesas y que borre en de la mesa correspondiente
        GestorSalas.getInstance(controlador).eliminarJugadorDeMesa(j.getIdSala(), j.getIdMesa(), idJugador);

        //modificar el usuario
        getJugadorConectado(idJugador).setIdMesa(-1);

        return true;

    }

    /**
     * Elimina el jugador de una sala. No se llama al gestor de salas, solo se modifica
     * el jugador de esta clase
     * @param idJugador
     */
    public void eliminarJugadorEnSala(int idJugador) {
        getJugadorConectado(idJugador).setIdSala(-1);
    }

    /**
     * Cuando el jugador se desconecta del casino.
     * @return
     */
    public boolean desconectarJugador(int idJugador) {

        //Si todavÃƒÂ­a no ha salido de  mesa o sala
        if (getJugadorConectado(idJugador).getIdMesa() != -1) {
            eliminarJugadorEnMesa(idJugador);
        }
        if (getJugadorConectado(idJugador).getIdSala() != -1) {
            eliminarJugadorEnSala(idJugador);
        }

        //eliminar de la lista de jugadores conectados
        jugadores.remove(getJugadorConectado(idJugador));

        log.info("GestorUsuarios : desconectarJugador : Jugador=" + idJugador + " desconectado correctamente");
        return true;
    }

    /**
     * Para el mÃƒÂ³dulo de chat. Se necesitan conocer todos los jugadores que estÃƒÂ¡n en una mesa
     *
     *
     */
    public Vector<Clientes> getJugadoresMesa(int idSala, int idMesa) {
        return GestorSalas.getInstance(controlador).getMesas(idSala).getJugadores_Mesa(idMesa);
    }

    /**
     * Busca en BBDD el nombre de un cliente a partir de su Id
     * @param idJugador
     * @return nombre de usuario (login)
     */
    public String getNombreUsuario(int idJugador) {
        return bbdd.getClientePorCodigo(idJugador).getUsuario();
    }

    public int getIdUsuario(String usuario) {
        return bbdd.getClientePorUsuario(usuario).getCodigo();
    }
}