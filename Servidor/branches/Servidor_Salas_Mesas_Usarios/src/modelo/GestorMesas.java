/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import bbdd.beans.Mesas;
import bbdd.gestorBBDD.GestorBBDDImp;
import bbdd.gestorBBDD.InterfazBBDD;
import controlador.ControladorServidor;
import java.util.Hashtable;
import java.util.Vector;
import modelo.LogicaJuegos.Mesa;
import modelo.LogicaJuegos.logicaRuleta.MesaRuleta;
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
    private int idSala; //sala a la que pertenecen estas mesas
    private Vector<Mesas> mesas_bbdd; //mesas que se guardarán en BBDD
    private Vector<Mesa> mesas_juegos;//cada mesa del casino. Contrendrá la lógica del juego
    private Hashtable<Integer, Vector<Integer>> jugadores_mesa;//<idMesa, vector<idCliente>> ¿TODO lo guarda el gestor, o cada mesa de juego?
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
    public GestorMesas(ControladorServidor c, int idSala, String nSala) {

        log.debug("GestorMesas : constructora : init");
        this.controlador = c;
        this.mesas_bbdd = new Vector<Mesas>();
        this.jugadores_mesa = new Hashtable<Integer, Vector<Integer>>();
        this.nombreJuego = nSala;
        this.idSala = idSala;

        this.bbdd = new GestorBBDDImp();

    //Abrir la primera mesa


    }

    /**
     * Crea una nueva mesa, si aún no existe. La insertará en BBDD, y lo guardará en el propio gestor.
     * 
     * @param idMesa
     * @return
     */
    public boolean crearMesa(int idMesa) {

        Mesa mesa_juego;
        Mesas mesa_bbdd;

        //miro que tipo de mesa es, a partir del nombre
        if (this.nombreJuego.contains("ruleta") || this.nombreJuego.contains("Ruleta")) {
            mesa_juego = new MesaRuleta(controlador, idMesa);
        } else {
            //TODO comprobar y crear el resto de mesas

            //TODO quitar, esto es temporal, para no tener valores nulos
            mesa_juego = new MesaRuleta(controlador, idMesa);
        }

/*
 *  TODO que lo haga cada mesa!
        mesa_bbdd = new Mesas();
        mesa_bbdd.setCodigo(idMesa);
        mesa_bbdd.setApuestamax(mesa_juego.apuestaMax);
        mesa_bbdd.setApuestamin(mesa_juego.apuestaMin);
        mesa_bbdd.setPuestos(mesa_juego.puestosMax);
        mesa_bbdd.setSalas(GestorSalas.getInstance(controlador).getSala(this.idSala));

        if (bbdd.insertarMesa(mesa_bbdd)) {
            log.info("GestorMesas : crearMesa : Mesa con id=" + idMesa + " guardada en BBDD");

            //guardo en el vector de mesas
            mesas_bbdd.add(mesa_bbdd);

            //sin jugadores
            jugadores_mesa.put(idMesa, null);
            log.info("GestorMesas : crearMesa : Mesa con id=" + idMesa + " guardada en el Gestor de Mesas");
        }*/

        return true;
    }

    /**
     * Borra todas las mesas que hay activas en el casino. Este paso se ejecuta cuando se quieran
     * borrar todas las salas, ya que el servidor se cierra.
     */
    public void borrarMesas() {

        //eliminar la tabla de mesas-jugadores
        jugadores_mesa.clear();
        jugadores_mesa = null;

        //eliminar todas las mesas de BBDD
        for (int i = 0; i < mesas_bbdd.size(); i++) {
            //borrar en bbdd
            bbdd.borrarMesa(mesas_bbdd.get(i));
        }

        mesas_bbdd.removeAllElements();
        mesas_bbdd = null;

        //eliminar las mesas de los juegos
        mesas_juegos.removeAllElements();
        mesas_juegos = null;
    }

    /**
     * Busca la mesa en el vector de Mesas del casino
     * @param idMesa
     * @return mesa si la ha encontrado. Null en otro caso. 
     */
    public Mesas getMesaBBDD(int idMesa) {

        Mesas mesa = null;
        int i = 0;
        boolean enc = mesas_bbdd.get(i).getCodigo() == idMesa;
        while (!enc && i < mesas_bbdd.size()) {
            i++;
            enc = mesas_bbdd.get(i).getCodigo() == idMesa;
        }

        if (enc) {
            mesa = mesas_bbdd.get(i);
        }

        return mesa;
    }

    
    /**
     * Busca la mesa de juego a partir de su id
     * @param idMesa
     * @return
     */
    public Mesa getMesaJuego(int idMesa) {

        Mesa mesa_juego = null;
        int i = 0;
        boolean enc = mesas_bbdd.get(i).getCodigo() == idMesa;
        while (!enc && i < mesas_bbdd.size()) {
            i++;
            enc = mesas_bbdd.get(i).getCodigo() == idMesa;
        }

        if (enc) {
            mesa_juego = mesas_juegos.get(i);
        }

        return mesa_juego;
    }

    /**
     * Comprueba si la mesa ya existe, es decir, ya está abierta en el casino
     * @return
     */
    public boolean existeMesa(int idMesa) {

        int i = 0;
        boolean enc = mesas_bbdd.get(i).getCodigo() == idMesa;
        while (!enc && i < mesas_bbdd.size()) {
            i++;
            enc = mesas_bbdd.get(i).getCodigo() == idMesa;
        }

        return enc;
    }

    /**
     * Comprueba si un jugador ya está en la mesa
     * @param idMesa
     * @param idJugador
     * @return
     */
    public boolean existeJugadorEnMesa(int idMesa, int idJugador) {

        Vector<Integer> jugadores = jugadores_mesa.get(idMesa);
        int i = 0;
        boolean enc = jugadores.get(i) == idJugador;
        while (!enc && i < jugadores.size()) {
            i++;
            enc = jugadores.get(i) == idJugador;
        }
        return enc;
    }

    /**
     * Devuelve la lista de jugadores que están en una mesa
     * @param idMesa
     * @return
     */
    public Vector<Integer> getJugadores_Mesa(int idMesa) {
        return jugadores_mesa.get(idMesa);
    }

    /**
     *
     * @param idMesa  mesa en la que se coloca el jugador
     * @param idJugador identificador del jugador
     * @return resultado de la operación.
     *          False si el jugador ya se encontraba en la mesa.
     */
    public boolean colocarJugadorEnMesa(int idMesa, int idJugador) {

        if (existeJugadorEnMesa(idMesa, idJugador)) {
            return false;
        } else {
            //obtengo los jugadores que ya están en la mesa
            Vector<Integer> jugadores = getJugadores_Mesa(idMesa);
            if (jugadores == null) {
                jugadores = new Vector<Integer>();
            }

            //añado el jugador, y actualizo la mesa
            jugadores.add(idJugador);
            jugadores_mesa.put(idMesa, jugadores);
        }

        return true;
    }

    /**
     * Devuelve un vector con los indices de todas las mesas
     * @return Vector<idMesa>
     */
    public Vector<Integer> getIndiceMesas() {

        Vector<Integer> indMesas = new Vector<Integer>();
        for (int i = 0; i < mesas_bbdd.size(); i++) {
            indMesas.add(mesas_bbdd.get(i).getCodigo());
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
}

 
