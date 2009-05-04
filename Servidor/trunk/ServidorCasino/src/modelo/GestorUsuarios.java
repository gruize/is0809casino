/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import bbdd.gestorBBDD.GestorBBDDImp;
import bbdd.gestorBBDD.InterfazBBDD;

import bbdd.beans.Clientes;
import controlador.ControladorServidor;
import java.util.Vector;
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
    private Vector<JugadorConectado> jugadores = null;
    private InterfazBBDD bbdd;
    private ControladorServidor controlador;

    //PatrÃ³n Singleton
    private static GestorUsuarios instancia;

    //log4j
    private static Logger log = Logger.getLogger(GestorUsuarios.class);

    //--------------------------------------------------------------------------
    //          METODOS
    //--------------------------------------------------------------------------
    public static GestorUsuarios getInstancia(ControladorServidor c) {
        if (instancia == null) {
            instancia = new GestorUsuarios(c);
        }
        return instancia;
    }

    public GestorUsuarios(ControladorServidor c) {

        this.jugadores = new Vector<JugadorConectado>();
        this.controlador = c;
        this.bbdd = new GestorBBDDImp();

    }

    //======================================================================
    //          INSERTAR JUGADOR
    //======================================================================
    /**
     * Comprueba el login de un usuario
     * @param usuario nombre de usuario
     * @param password contraseÃ±a
     * @return identificador del usuario si los datos son correctos, y no estaba ya en la mesa, -1 e.o.c
     */
    public int hacerLogin(String usuario, String password) {
        int id = -1;

        id = bbdd.comprobarUsuario(usuario, password);
        //Si el jugador aun no estÃ¡ conectado devuelve resultado = -1
        if (getIndiceJugador(id) == -1) {
            insertarJugador(bbdd.getClientePorCodigo(id));
            log.info("GestorUsuarios : hacerLogin : Jugador con id=" + id + " logeado en el casino");
        } else { //ya estÃ¡ conectado, devuelvo -1 hacia el comunicador
            id = -1;
        }

        return id;
    }

    /**
     * Cuando un jugador se logea y entra en el casino. AÃºn no ha entrado en sala ni mesa
     * @param idSala
     * @param idMesa
     * @param c
     */
    public void insertarJugador(Clientes c) {
        JugadorConectado jugador = new JugadorConectado(c);
        this.jugadores.add(jugador);

        //aÃºn no se inserta nada en BBDD, no se considera Participante porque aÃºn no ha entrado en sala ni mesa
    }

    /**
     * Cuando el jugador entra en una sala.
     * @param idJugador
     * @param idSala
     */
    public void insertarJugadorEnSala(int idJugador, int idSala) {

        //buscar el jugador en la lista de jugadores del casino
        int posJugador = getIndiceJugador(idJugador);
        JugadorConectado jugador = this.jugadores.get(posJugador);
        jugador.setIdSala(idSala);
        this.jugadores.add(posJugador, jugador);


        log.info("GestorUsuarios : insertarJugadorEnSala : Jugador=" + idJugador + " insertado en sala=" + idSala);
    }

    /**
     * Cuando el jugador selecciona una msea de juego
     * @param idJugador
     * @param idMesa
     */
    public boolean insertarJugadorEnMesa(int idJugador, int idMesa) {

        getJugadorConectado(idJugador).setIdMesa(idMesa);

        //TODO hay que actualizar algo en BBDD? jugador, mesa? se le considera ya un participante?

        //Enviarselo al gestorSalas, y que llame a su gestorMesas y lo incluya en la mesa correspondiente
        return GestorSalas.getInstance(controlador).añadirMesaEnSala(idMesa, getJugadorConectado(idJugador).getIdSala(), idJugador);

    }

    //=======================================================================
    //              getters
    //=======================================================================
    /**
     * Busca la posicion del vector de jugadores donde se encuentra el jugador
     * @return posicion del jugador si estÃ¡ en la lista de jugadores del casino
     *          -1 si no lo encuentra
     */
    public int getIndiceJugador(int idJugador) {

        try {
            if (this.jugadores != null && this.jugadores.size() > 0) {

                int i = 0;
                boolean enc = false;
                while (!enc && i < jugadores.size()) {
                    enc = this.jugadores.get(i).getIdJugador() == idJugador;
                    i++;
                }

                if (enc) {
                    return i-1;
                } else {
                    return -1; //el usuario aÃºn no estÃ¡ registrado
                }
            } else {//es el primer jugador del casino, tampoco se ha insertado aÃºn
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

        //Si todavÃ­a no ha salido de  mesa o sala
        if (getJugadorConectado(idJugador).getIdMesa() != -1) {
            eliminarJugadorEnMesa(idJugador);
        }
        if (getJugadorConectado(idJugador).getIdSala() != -1) {
            eliminarJugadorEnSala(idJugador);
        }

        //eliminar de la lista de jugadores conectados
        this.jugadores.remove(getJugadorConectado(idJugador));

        log.info("GestorUsuarios : desconectarJugador : Jugador=" + idJugador + " desconectado correctamente");
        return true;
    }

    /**
     * Para el mÃ³dulo de chat. Se necesitan conocer todos los jugadores que estÃ¡n en una mesa
     *
     *
     */
    public Vector<Clientes> getJugadoresMesa(int idSala, int idMesa) {
        return GestorSalas.getInstance(controlador).getMesas(idSala).getJugadores_Mesa(idMesa);
    }
}