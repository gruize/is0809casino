/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import bbdd.beans.Juegos;
import bbdd.beans.Mesas;
import bbdd.beans.Partidas;
import bbdd.beans.Salas;
import bbdd.gestorBBDD.GestorBBDDImp;
import bbdd.gestorBBDD.InterfazBBDD;
import controlador.ControladorServidor;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Vector;
import javax.swing.DefaultListModel;
import modelo.LogicaJuegos.Mesa;
import modelo.mensajes.objetos.PeticionSala;
import org.apache.log4j.Logger;

/**
 *
 * @author Chaudhary
 */
public class GestorSalas {

    private static Vector<Salas> salas;
    private static Hashtable<Integer, GestorMesas> mesas_sala;//<idSala, GestorMesas>
    private ControladorServidor controlador;

    //log4j
    private static Logger log = Logger.getLogger(GestorSalas.class);

    //singleton
    private static GestorSalas instance = null;

    //para sincronizar con bbdd
    private InterfazBBDD bbdd = null;


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

    public DefaultListModel estadisticasPartidas() {
        DefaultListModel texto = new DefaultListModel();
        texto.addElement("PARTIDAS: ");
        ArrayList partidas = this.bbdd.getPartidas();
        for(int i=0;i<partidas.size();i++) {
            Partidas partida = (Partidas) partidas.get(i);
            texto.addElement("");
            texto.addElement(" ------------------");
            texto.addElement("Codigo:"+partida.getCodigo());
          
            texto.addElement("Jugadores maximos: "+partida.getNumjugadores());
            texto.addElement("Ganador: "+partida.getGanador());
            int codigo = partida.getMesas().getCodigo();
            ArrayList listaSalas = this.bbdd.getSalas();
            Mesas mesaBBDD = null;
            boolean encontrado = false;
            for(int j=0;j<listaSalas.size() && !encontrado;j++) {
                Salas sala = (Salas)listaSalas.get(j);
                Vector<Integer> posiblesMesas = mesas_sala.get(sala.getCodigo()).getIndiceMesas();
                if (posiblesMesas.contains(codigo)) {
                    Mesa mesa = mesas_sala.get(sala.getCodigo()).getMesaJuego(codigo);
                    mesaBBDD = mesa.getMesaBBDD();
                    encontrado = true;
                }
            }
            texto.addElement("Jugadores: "+mesaBBDD.getJugadores());
            texto.addElement("Mesa de juego: "+ mesaBBDD.getCodigo());
            texto.addElement("Tipo de juego: "+ mesaBBDD.getSalas().getJuegos().getNombre());
        }
        return texto;
    }

    public DefaultListModel estadisticasSalas() {
        DefaultListModel texto = new DefaultListModel();
        texto.addElement("SALAS: ");
        ArrayList listaSalas = this.bbdd.getSalas();
        for(int i=0;i<listaSalas.size();i++) {
            Salas sala = (Salas) listaSalas.get(i);
            texto.addElement("");
            texto.addElement(" ------------------");
            texto.addElement("Codigo: "+sala.getCodigo());
            texto.addElement("Nombre: "+sala.getNombre());
            texto.addElement("Mesas en propiedad: ");
            Vector<Integer> indiceMesas = mesas_sala.get(sala.getCodigo()).getIndiceMesas();
            ArrayList listaMesas = this.bbdd.getMesas();
            for(int j=0;j<listaMesas.size();j++) {
                Mesas mesa = (Mesas) listaMesas.get(j);
                if (indiceMesas.contains(mesa.getCodigo())) {
                    texto.addElement("");
                    texto.addElement("Codigo: "+mesa.getCodigo());
                    texto.addElement("Puestos:"+mesa.getPuestos());
                    texto.addElement("Numero de jugadores total: "+mesa.getJugadores());
                    texto.addElement("Apuesta minima: "+mesa.getApuestamin());
                }
            }
        }
        return texto;
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
        sala.setJuegos(dameJuegoAsociado(nombreSala));// NO puedo introducir valores nulos en BBDD
        //Guardo en bbdd (si no existÃƒÂ­a ya)
        if (bbdd.insertarSala(sala)) {
           
            controlador.crearSalas(codigoSala,nombreSala);
            log.info("GestorSalas : crearSala : Sala con id=" + codigoSala + " guardada en BBDD");
            //guardo en mi vector de salas
            salas.add(sala);
            mesas_sala.put(codigoSala, new GestorMesas(controlador, sala));//se crearÃƒÂ¡ una mesa
            log.info("GestorSalas : crearSala : Sala con id=" + codigoSala + " guardada en el Gestor de Salas. AÃƒÂºn no tiene mesas abiertas");
        }
    }

    /**
     * Dependiendo del nombre de la sala, identifica el juego que se jugará en ella.
     * Si la sala es "Ruleta x", asocia el juego de la Ruleta
     * Si la sala es "Dados x", asocia el juego de los Dados.
     * @param nombreSala
     * @return
     */
    private Juegos dameJuegoAsociado(String nombreSala) {
        //TODO el resto de juegos. Comprobar el nombre por una clase que subiÃƒÂ³ Gabi
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

    /**
     * Busca en BBDD el juego de la Ruleta. Si no está creado, lo crea
     * @return
     */
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

    /**
     * Busca en BBDD el juego de los Dados Si no está creado, lo crea
     * @return
     */
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
     * @return objeto Salas si estÃƒÂ¡ en el vector, null en otro caso
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
     * Borra todas las salas del casino, y todas sus mesas asociadas (tambien de la BBDD). Se  invocarÃƒÂ¡ cuando se cierre el servidor
     */
    public void borrarSalas() {

       //Al borrar salas, se borran las mesas y las partidas que estan asociadas. 
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
     * Devuelve un listado con los id de las mesas que estÃƒÂ¡n en una sala en concreto
     *
     * @param idSala id de la sala cuyas mesas se quieren obtener
     */
    public Vector<Integer> getMesas_Sala(int idSala) {
        return mesas_sala.get(idSala).getIndiceMesas();
    }

    /**
     * Comprueba si la mesa estÃƒÂ¡ ya en una sala
     * @param idSala
     * @param idMesa
     * @return true si la mesa estÃƒÂ¡ ya asociada a una sala
     *         false en otro caso
     */
    private boolean estaMesaEnSala(int idSala, int idMesa) {
        try {
            return mesas_sala.get(idSala).existeMesa(idMesa);
        } catch (Exception e) {

            //saltarÃƒÂ¡ un nullpointer cuando la sala no estÃƒÂ© abierta
            log.error("GestorSalas : estaMesaEnSala : error al buscar sala="+idSala+" y mesa="+idMesa+" -->"+e.getMessage());
            return false;
        }
    }

    /**
     * Inserta una mesa en una sala
     * @param idSala
     * @param idMesa
     * @return true si se inserta correctamente,
     *         false si la mesa ya estaba en la sala
     */
    public boolean insertarMesaEnSala(int idSala, int idMesa, int idJugador) {

        //compruebo si ya estÃƒÂ¡ insertada
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
     * @return resultado de la operaciÃƒÂ³n
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


        log.debug("GestorSalas : procesaMensaje : jugada de la sala " + idSala + " en la mesa " + idMesa);
        //compruebo que la mesa esta en la sala. Solo por seguridad...
        if (estaMesaEnSala(idSala, idMesa)) {
            //enviarselo al GestorMesas
            mesas_sala.get(idSala).procesarMensajeJugada(jugada);
        }
        else {
           log.error("GestorSalas : procesaMensaje : jugada de la sala " + idSala + " en la mesa " + idMesa+" la mesa no estÃ¡ en la sala!!!");

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

            //aÃƒÂ±ado al vector
            infoSalas.add(new PeticionSala(idSala, nombreJuego, nMesas));

        }

        return infoSalas;

    }
}
