/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import modelo.LogicaJuegos.Jugada;
import bbdd.beans.Clientes;
import bbdd.beans.Salas;
import bbdd.gestorBBDD.GestorBBDDImp;
import bbdd.gestorBBDD.InterfazBBDD;
import controlador.ControladorServidor;
import java.util.Hashtable;
import java.util.Stack;
import java.util.Vector;
import modelo.LogicaJuegos.Mesa;
import modelo.NombreJuegos;
import modelo.LogicaJuegos.logicaRuleta.MesaRuleta;
import modelo.mensajes.objetos.PeticionMesa;
import org.apache.log4j.Logger;

/**
 *
 * @author Chaudhary
 */
public class GestorMesas {


    //=======================================================================
    // atributos de la clase
    //=======================================================================
    private String nombreJuego = ""; //juegos que se jugarán en las mesas: Ruleta, Datos, ..
    private Salas sala; //sala a la que pertenecen estas mesas    
    private Vector<Mesa> mesas;//cada mesa del casino. Contrendrá la lógica del juego
    //private Hashtable<Integer, Vector<Integer>> jugadores_mesa;//<idMesa, vector<idCliente>> TODO que lo guarde cada mesa
    private ControladorServidor controlador; //TODO ¿realmente necesito el controlador?

    //log4j
    private static Logger log = Logger.getLogger(GestorMesas.class);

    //para sincronizar con bbdd
    InterfazBBDD bbdd = null;

    //contador para identificar de forma única todas las mesas
    private static int codigoMesa;

    //=======================================================================
    // métodos de la clase
    //=======================================================================
    /**
     * Constructora
     * @param c controlador del servidor
     * @param nSala nombre de los juegos que se jugarán en todas estas mesas, correspondientes a una sala
     */
    public GestorMesas(ControladorServidor c, Salas sala) {

        log.debug("GestorMesas : constructora : init");
        this.controlador = c;
        this.sala = sala;
        this.mesas = new Vector<Mesa>();
        this.nombreJuego = sala.getNombre();

        this.bbdd = new GestorBBDDImp();

        //Abrir la primera mesa
        codigoMesa++;
        crearMesa(codigoMesa);


    }

    /**
     * Crea una nueva mesa, si aún no existe. La insertará en BBDD, y lo guardará en el propio gestor.
     * 
     * @param idMesa
     * @return
     */
    public boolean crearMesa(int idMesa) {

        Mesa mesa_juego;

        //miro que tipo de mesa es, a partir del nombre
        //TODO mirar Juegos.java que iba a hacer gabi
        if (this.nombreJuego.contains("ruleta") || this.nombreJuego.contains("Ruleta")) {
            mesa_juego = new MesaRuleta(idMesa, this.sala);
        } else {
            //TODO comprobar y crear el resto de mesas

            //TODO quitar, esto es temporal, para no tener valores nulos
            mesa_juego = new MesaRuleta(idMesa, this.sala);
        }

        mesas.add(mesa_juego);
        log.info("GestorMesas : crearMesa : Mesa con id=" + idMesa + " creada y guardada en BBDD");

        return true;


    }

    /**
     * Borra todas las mesas que hay activas en el casino. Este paso se ejecuta cuando se quieran
     * borrar todas las salas, ya que el servidor se cierra.
     */
    public void borrarMesas() {

        //eliminar todas las mesas de BBDD
        for (int i = 0; i < mesas.size(); i++) {
            //borrar en bbdd
            bbdd.borrarMesa(mesas.get(i).getMesaBBDD());
        }

        //eliminar las mesas de los juegos
        mesas.removeAllElements();
        mesas = null;
    }

    /**
     * Busca la mesa de juego a partir de su id
     * @param idMesa
     * @return
     */
    public Mesa getMesaJuego(int idMesa) {

        Mesa mesa_juego = null;
        int i = 0;
        boolean enc = mesas.get(i).getCodigoMesa() == idMesa;
        while (!enc && i < mesas.size()) {
            i++;
            enc = mesas.get(i).getCodigoMesa() == idMesa;
        }

        if (enc) {
            mesa_juego = mesas.get(i);
        }

        return mesa_juego;
    }

    /**
     * Comprueba si la mesa ya existe, es decir, ya está abierta en el casino
     * @return
     */
    public boolean existeMesa(int idMesa) {
        return getMesaJuego(idMesa) != null;
    }

    //========================================================================
    //              JUGADORES DE LAS MESAS
    //========================================================================
    /**
     * Comprueba si un jugador ya está en la mesa
     * @param idMesa
     * @param idJugador
     * @return
     */
    public boolean existeJugadorEnMesa(int idMesa, int idJugador) {
        return getMesaJuego(idMesa).existeJugadorEnMesa(idJugador);
    }

    /**
     * Devuelve la lista de jugadores que están en una mesa
     * @param idMesa
     * @return
     */
    public Vector<Clientes> getJugadores_Mesa(int idMesa) {
        return getMesaJuego(idMesa).getJugadores_Mesa();
    }

    /**
     *
     * @param idMesa  mesa en la que se coloca el jugador
     * @param idJugador identificador del jugador
     * @return resultado de la operación.
     *          False si el jugador ya se encontraba en la mesa.
     */
    public boolean colocarJugadorEnMesa(int idMesa, int idJugador) {
        return getMesaJuego(idMesa).colocarJugador(bbdd.getClientePorCodigo(idJugador));

    }

    public boolean eliminarJugadorDeMesa(int idMesa, int idJugador) {
        return getMesaJuego(idMesa).eliminarJugador(idJugador);
    }

    /**
     * Devuelve un vector con los indices de todas las mesas
     * @return Vector<idMesa>
     */
    public Vector<Integer> getIndiceMesas() {

        Vector<Integer> indMesas = new Vector<Integer>();
        for (int i = 0; i < mesas.size(); i++) {
            indMesas.add(mesas.get(i).getCodigoMesa());
        }

        return indMesas;
    }

    /**
     * Envía la jugada a la mesa a la que va destinada
     * @param jugada
     */
    public void procesarMensajeJugada(Jugada jugada) {
        int idMesa = jugada.getMesa();

        //mandarselo a la mesa de juego correspondiente
        getMesaJuego(idMesa).procesaJugada(jugada);
    }

    //==========================================================
    /**
     * Cuando al cliente hay que enviarle la informacion de las mesas de una sala
     * @return
     */
    public Vector<PeticionMesa> getInfoMesas() {

        Vector<PeticionMesa> infoMesas = new Vector<PeticionMesa>();
        for (int i = 0; i < mesas.size(); i++) {
            int idMesa = mesas.get(i).getCodigoMesa();
            double apuestaMin = mesas.get(i).getApuestaMin();
            int nJugadores = mesas.get(i).getJugadores_Mesa().size();
            NombreJuegos nombreJuegoMesa;
            if (sala.getNombre().toUpperCase().contains(NombreJuegos.RULETA.toString())) {
                nombreJuegoMesa = NombreJuegos.RULETA;
            } else {
                nombreJuegoMesa = NombreJuegos.DADOS;
            }

            infoMesas.add(new PeticionMesa(idMesa, nombreJuegoMesa, apuestaMin, nJugadores));

        }

        return infoMesas;
    }
}

 
