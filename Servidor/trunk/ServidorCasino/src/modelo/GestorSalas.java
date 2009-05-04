/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import bbdd.beans.Juegos;
import bbdd.beans.Salas;
import bbdd.gestorBBDD.GestorBBDDImp;
import bbdd.gestorBBDD.InterfazBBDD;
import controlador.ControladorServidor;
import java.util.Hashtable;
import java.util.Vector;
import modelo.mensajes.objetos.PeticionSala;
import org.apache.log4j.Logger;

/**
 *
 * @author Chaudhary
 */
public class GestorSalas {

    private static Vector<Salas> salas;
    private static Hashtable<Integer, GestorMesas> mesas_sala;//<idSala, GestorMesas>
    private ControladorServidor controlador; //TODO Â¿realmente necesito el controlador?

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
        sala.setJuegos(dameJuegoAsociado(nombreSala));// NO puedo introducir valores nulos en BBDD??
        System.out.println("creando sala");
        //Guardo en bbdd (si no existÃ­a ya)
        if (bbdd.insertarSala(sala)) {
            System.out.println("valeee  creando sala");
            log.info("GestorSalas : crearSala : Sala con id=" + codigoSala + " guardada en BBDD");
            //guardo en mi vector de salas
            salas.add(sala);
            mesas_sala.put(codigoSala, new GestorMesas(controlador, sala));//se crearÃ¡ una mesa
            log.info("GestorSalas : crearSala : Sala con id=" + codigoSala + " guardada en el Gestor de Salas. AÃºn no tiene mesas abiertas");
        }
    }

    private Juegos dameJuegoAsociado(String nombreSala) {
        //TODO el resto de juegos. Comprobar el nombre por una clase que subiÃ³ Gabi
        if (nombreSala.contains("Ruleta")) {
            log.debug("GestorSalas : dameJuegoAsociado : Juego de la RULETA, para la sala " + nombreSala);
            return dameJuegoRuleta();
        } else if (nombreSala.contains("Dados")) {
            log.debug("GestorSalas : dameJuegoAsociado : Juego de los DADOS, para la sala " + nombreSala);
            return dameJuegoDados();
        } else {
            return null;
        }

    }

    private Juegos dameJuegoRuleta() {
        Juegos j = bbdd.getJuegoPorNombre("Juego Ruleta");
        if (j == null) {
            //el juego no existe, lo creamos
            Juegos nuevoJuego = new Juegos();
            nuevoJuego.setCodigo(11);
            nuevoJuego.setNombre("Juego Ruleta");
            nuevoJuego.setJugadoresmin(1);
            nuevoJuego.setReglas("No tendo reglas para el juego de  la ruleta");
            bbdd.insertarJuego(nuevoJuego);

            j = nuevoJuego;
        }

        return j;

    }

    private Juegos dameJuegoDados() {
        Juegos j = bbdd.getJuegoPorNombre("Juego Dados");
        if (j == null) {
            //el juego no existe, lo creamos
            Juegos nuevoJuego = new Juegos();
            nuevoJuego.setCodigo(12);
            nuevoJuego.setNombre("Juego Dados");
            nuevoJuego.setJugadoresmin(1);
            nuevoJuego.setReglas("No tengo reglas para el juego de los dados");
            bbdd.insertarJuego(nuevoJuego);

            j = nuevoJuego;
        }

        return j;
    }

    /**
     * Busca la sala en el vector de salas del casino
     * @param idSala identificador de la sala
     * @return objeto Salas si estÃ¡ en el vector, null en otro caso
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
     * Borra todas las salas del casino, y todas sus mesas asociadas (tambien de la BBDD). Se  invocarÃ¡ cuando se cierre el servidor
     */
    public void borrarSalas() {

        //Borrar todas las mesas de BBDD --> invocar al GestorMesas
       /* for (int i = 0; i < mesas_sala.size(); i++) {
            mesas_sala.get(i).borrarMesas();
        }*/

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
     * Devuelve un listado con los id de las mesas que estÃ¡n en una sala en concreto
     *
     * @param idSala id de la sala cuyas mesas se quieren obtener
     */
    public Vector<Integer> getMesas_Sala(int idSala) {
        return mesas_sala.get(idSala).getIndiceMesas();
    }

    /**
     * Comprueba si la mesa estÃ¡ ya en una sala
     * @param idSala
     * @param idMesa
     * @return true si la mesa estÃ¡ ya asociada a una sala
     *         false en otro caso
     */
    private boolean estaMesaEnSala(int idSala, int idMesa) {
        try {
            System.err.println("estaMEsaEnSala : sala="+idSala+" mesa="+idMesa );
            return mesas_sala.get(idSala).existeMesa(idMesa);
        } catch (Exception e) {

            //saltarÃ¡ un nullpointer cuando la sala no estÃ© abierta
            log.error("GestorSalas : estaMesaEnSala : error al buscar sala="+idSala+" y mesa="+idMesa+" -->"+e.getMessage());
            return false;
        }
    }

    /**
     * AÃ±ade una mesa en una sala
     * @param idSala
     * @param idMesa
     * @return true si se inserta correctamente,
     *         false si la mesa ya estaba en la sala
     */
    public boolean añadirMesaEnSala(int idSala, int idMesa, int idJugador) {

        //compruebo si ya estÃ¡ insertada
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
     * @return resultado de la operaciÃ³n
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

        // TODO los de la interfaz me lo estan mandando al reves!!!
        log.debug("GestorSalas : procesaMensaje : jugada de la sala " + idSala + " en la mesa " + idMesa);
        //compruebo que la mesa estÃ¡ en la sala. Solo por seguridad...
        if (estaMesaEnSala(idSala, idMesa)) {
            //enviarselo al GestorMesas
            mesas_sala.get(idSala).procesarMensajeJugada(jugada);
        }
        else {
           log.error("GestorSalas : procesaMensaje : jugada de la sala " + idSala + " en la mesa " + idMesa+" la mesa no está en la sala!!!");

        }
    }

    //==========================================================================

    /**
     * Para cuando haya que mandarle al cliente la info de todas las salas del casino
     * @return
     */
    public Vector<PeticionSala> getInfoSalas(){
        Vector<PeticionSala> infoSalas= new Vector<PeticionSala>();
        for (int i=0; i<salas.size(); i++){
            System.out.println("ok sala"+i);
            int idSala=salas.get(i).getCodigo();
            String nombreSala=salas.get(i).getNombre();
            NombreJuegos nombreJuego;
            if (nombreSala.toUpperCase().contains(NombreJuegos.RULETA.toString()))
                nombreJuego=NombreJuegos.RULETA;
            else
                nombreJuego=NombreJuegos.DADOS;
            int nMesas=getMesas_Sala(idSala).size();

            //aÃ±ado al vector
            infoSalas.add(new PeticionSala(idSala, nombreJuego, nMesas));

        }

        return infoSalas;

    }
}
