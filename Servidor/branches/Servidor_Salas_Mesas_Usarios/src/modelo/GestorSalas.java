/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import modelo.LogicaJuegos.Jugada;
import bbdd.beans.Salas;
import bbdd.gestorBBDD.GestorBBDDImp;
import bbdd.gestorBBDD.InterfazBBDD;
import controlador.ControladorServidor;
import java.util.Hashtable;
import java.util.Vector;
import org.apache.log4j.Logger;

/**
 *
 * @author Chaudhary
 */
public class GestorSalas {

    private static Vector<Salas> salas;
    private static Hashtable<Integer, GestorMesas> mesas_sala;//<idSala, GestorMesas>
    private ControladorServidor controlador; //TODO ¿realmente necesito el controlador?

    //log4j
    private static Logger log = Logger.getLogger(GestorSalas.class);

    //singleton
    private static GestorSalas instance = null;

    //para sincronizar con bbdd
    InterfazBBDD bbdd = null;


    //=====================================================================
    //
    //=====================================================================
    /**
     * Constructora por defecto
     */
    public GestorSalas(ControladorServidor c) {

        log.debug("GestorSalas : constructora : init");
        this.controlador = c;
        salas = new Vector<Salas>();
        mesas_sala = new Hashtable<Integer, GestorMesas>();

        bbdd = new GestorBBDDImp();

    }

    /**
     * Patron Singleton. Devuelve la instancia de la clase
     * @param c controlador del servidor
     * @return
     */
    public static GestorSalas getInstance(ControladorServidor c) {
        if (instance == null) {
            instance = new GestorSalas(c);
            log.info("GestorSalas : getInstance : instancia creada por primera vez");
        }
        return instance;
    }

    /**
     * Crea una nueva sala. La guarda en BBDD y en el propio gestor de salas
     * @param codigoSala
     * @param nombre
     */
    public void crearSala(int codigoSala, String nombreSala) {

        Salas sala = new Salas();
        sala.setCodigo(codigoSala);
        sala.setNombre(nombreSala);
        sala.setJuegos(null);//TODO puedo introducir valores nulos en BBDD??

        //Guardo en bbdd (si no existía ya)
        if (bbdd.insertarSala(sala)) {
            log.info("GestorSalas : crearSala : Sala con id=" + codigoSala + " guardada en BBDD");
            //guardo en mi vector de salas
            salas.add(sala);
            mesas_sala.put(codigoSala, new GestorMesas(controlador, sala));//se creará una mesa
            log.info("GestorSalas : crearSala : Sala con id=" + codigoSala + " guardada en el Gestor de Salas. Aún no tiene mesas abiertas");
        }
    }

    /**
     * Busca la sala en el vector de salas del casino
     * @param idSala identificador de la sala
     * @return objeto Salas si está en el vector, null en otro caso
     */
    public Salas getSala(int idSala) {

        Salas sala = null;
        int i = 0;
        boolean enc = salas.get(i).getCodigo() == idSala;
        while (!enc && i < salas.size()) {
            i++;
            enc = salas.get(i).getCodigo() == idSala;
        }

        if (enc) {
            sala = salas.get(i);
        }


        return sala;
    }

    /**
     * Borra todas las salas del casino, y todas sus mesas asociadas (tambien de la BBDD). Se  invocará cuando se cierre el servidor
     */
    public void borrarSalas() {

        //Borrar todas las mesas de BBDD --> invocar al GestorMesas
        for (int i = 0; i < mesas_sala.size(); i++) {
            mesas_sala.get(i).borrarMesas();
        }

        //borro la tabla hash de salas
        mesas_sala.clear();

        //borro todas las salas de BBDD
        for (int i = 0; i < salas.size(); i++) {
            bbdd.borrarSala(salas.get(i));
        }

        //borro las salas
        salas.removeAllElements();

    }

    /**
     * Devuelve un listado con los id de las mesas que están en una sala en concreto
     *
     * @param idSala id de la sala cuyas mesas se quieren obtener
     */
    public Vector<Integer> getMesas_Sala(int idSala) {
        return mesas_sala.get(idSala).getIndiceMesas();
    }

    /**
     * Comprueba si la mesa está ya en una sala
     * @param idSala
     * @param idMesa
     * @return true si la mesa está ya asociada a una sala
     *         false en otro caso
     */
    private boolean estaMesaEnSala(int idSala, int idMesa) {

        return mesas_sala.get(idSala).existeMesa(idMesa);

    }

    /**
     * Añade una mesa en una sala
     * @param idSala
     * @param idMesa
     * @return true si se inserta correctamente,
     *         false si la mesa ya estaba en la sala
     */
    public boolean añadirMesaEnSala(int idSala, int idMesa, int idJugador) {

        //compruebo si ya está insertada
        if (estaMesaEnSala(idSala, idMesa)) {
            return false;
        } else {

            //No inserto la sala en BBDD, de eso se encarga el GestorMesas

            mesas_sala.get(idSala).crearMesa(idMesa);
        }

        return true;
    }

    /**
     * Inserta un jugador en la mesa correspondiente
     * @param idSala
     * @param idMesa
     * @param idJugador
     * @return resultado de la operación
     */
    public boolean insertarJugadorEnMesa(int idSala, int idMesa, int idJugador) {
        return mesas_sala.get(idSala).colocarJugadorEnMesa(idMesa, idJugador);
    }

    /**
     * Elimina un jugador de la mesa en la que se hayaba jugando
     * @param idSala
     * @param idMesa
     * @param idJugador
     * @return
     */
    public boolean eliminarJugadorDeMesa(int idSala, int idMesa, int idJugador) {
        return mesas_sala.get(idSala).eliminarJugadorDeMesa(idMesa, idJugador);
    }

    public GestorMesas getMesas(int idSala) {
        return mesas_sala.get(idSala);
    }
    //==========================================================================

    /**
     * Recibe una jugada, y la redirige a la mesa correspondiente
     * @param jugada
     */
    public void procesaMensaje(Jugada jugada) {

        int idSala = jugada.getSala();
        int idMesa = jugada.getMesa();

        //compruebo que la mesa está en la sala. Solo por seguridad...
        if (estaMesaEnSala(idSala, idMesa)) {
            //enviarselo al GestorMesas
            mesas_sala.get(idSala).procesarMensajeJugada(jugada);
        }
    }
}
