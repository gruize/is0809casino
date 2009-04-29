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
    
    private static Vector<Mesas> mesas_bbdd; //mesas que se guardarán en BBDD
    private static Vector<Mesa> mesas_juegos;//cada mesa del casino. Contrendrá la lógica del juego
    private static Hashtable<Integer, Vector<Integer>> jugadores_mesa;//<idMesa, vector<idCliente>>
    private ControladorServidor controlador; //TODO ¿realmente necesito el controlador?

    //log4j
    private static Logger log = Logger.getLogger(GestorMesas.class);

    //singleton
    private static GestorMesas instance = null;

    //para sincronizar con bbdd
    InterfazBBDD bbdd = null;

    //=======================================================================
    // métodos de la clase
    //=======================================================================
    
    public GestorMesas(ControladorServidor c) {

        log.debug("GestorMesas : constructora : init");
        this.controlador = c;
        mesas_bbdd = new Vector<Mesas>();
        jugadores_mesa = new Hashtable<Integer, Vector<Integer>>();

        bbdd = new GestorBBDDImp();

    }

    /**
     * Patron Singleton. Devuelve la instancia de la clase
     * @param c controlador del servidor
     * @return
     */
    public static GestorMesas getInstance(ControladorServidor c){
        if (instance == null) {
            instance = new GestorMesas(c);
            log.info("GestorMesas : getInstance : instancia creada por primera vez");
        }
        return instance;
    }

    /**
     * Crea una nueva mesa, si aún no existe. La insertará en BBDD, y lo guardará en el propio gestor.
     * @param idSala
     * @param idMesa
     * @param nombreMesa
     * @return
     */
    public boolean crearMesa(int idSala, int idMesa, String nombreMesa){

        Mesa mesa_juego;
        Mesas mesa_bbdd;

        //miro que tipo de mesa es, a partir del nombre
        if (nombreMesa.contains("ruleta") || nombreMesa.contains("Ruleta"))
            mesa_juego=new MesaRuleta(controlador,idMesa);
        else {
            //TODO comprobar y crear el resto de mesas

            //TODO quitar, esto es temporal, para no tener valores nulos
            mesa_juego=new MesaRuleta(controlador,idMesa);
        }


        mesa_bbdd=new Mesas();
        mesa_bbdd.setCodigo(idMesa);
        mesa_bbdd.setApuestamax(mesa_juego.apuestaMax);
        mesa_bbdd.setApuestamin(mesa_juego.apuestaMin);
        mesa_bbdd.setPuestos(mesa_juego.puestosMax);

        if (bbdd.insertarMesa(mesa_bbdd)){
            log.info("GestorMesas : crearMesa : Mesa con id="+idMesa+" guardada en BBDD");

            //guardo en el vector de mesas
            mesas_bbdd.add(mesa_bbdd);
            
            //sin jugadores
            jugadores_mesa.put(idMesa, null);
            log.info("GestorMesas : crearMesa : Mesa con id="+idMesa+" guardada en el Gestor de Mesas");
        }

        return true;
    }


    /**
     * Borra todas las mesas que hay activas en el casino. Este paso se ejecuta cuando se quieran
     * borrar todas las salas, ya que el servidor se cierra.
     */
    public void borrarMesas(){

        //eliminar la tabla de mesas-jugadores
        jugadores_mesa.clear();
        jugadores_mesa=null;

        //eliminar todas las mesas de BBDD
        for (int i=0;i<mesas_bbdd.size();i++){
            //borrar en bbdd
            bbdd.borrarMesa(mesas_bbdd.get(i));
        }

        mesas_bbdd.removeAllElements();
        mesas_bbdd=null;

        //eliminar las mesas de los juegos
        mesas_juegos.removeAllElements();
        mesas_juegos=null;
    }


    /**
     * Busca la mesa en el vector de Mesas del casino
     * @param idMesa
     * @return mesa si la ha encontrado. Null en otro caso. 
     */
    public Mesas getMesa(int idMesa){

        Mesas mesa=null;
        int i=0;
        boolean enc=mesas_bbdd.get(i).getCodigo()==idMesa;
        while(!enc && i<mesas_bbdd.size()){
            i++;
            enc=mesas_bbdd.get(i).getCodigo()==idMesa;
        }

        if (enc)
            mesa=mesas_bbdd.get(i);

        return mesa;
    }
    /**
     * Comprueba si un jugador ya está en la mesa
     * @param idMesa
     * @param idJugador
     * @return
     */
    public boolean existeJugadorEnMesa(int idMesa,int idJugador){

        Vector<Integer> jugadores=jugadores_mesa.get(idMesa);
        int i=0;
        boolean enc=jugadores.get(i)==idJugador;
        while (!enc && i<jugadores.size()){
            i++;
            enc=jugadores.get(i)==idJugador;
        }
        return enc;
    }

    
    /**
     * Devuelve la lista de jugadores que están en una mesa
     * @param idMesa
     * @return
     */
    public Vector<Integer> getJugadores_Mesa(int idMesa){
        return jugadores_mesa.get(idMesa);
    }
    /**
     *
     * @param idMesa  mesa en la que se coloca el jugador
     * @param idJugador identificador del jugador
     * @return resultado de la operación.
     *          False si el jugador ya se encontraba en la mesa.
     */
    public boolean colocarJugadorEnMesa(int idMesa, int idJugador){

        if (existeJugadorEnMesa(idMesa, idJugador))
            return false;
        else{
            //obtengo los jugadores que ya están en la mesa
            Vector<Integer> jugadores=getJugadores_Mesa(idMesa);
            if (jugadores==null)
                jugadores=new Vector<Integer>();

            //añado el jugador, y actualizo la mesa
            jugadores.add(idJugador);
            jugadores_mesa.put(idMesa, jugadores);
        }

        return true;
    }


}

 
