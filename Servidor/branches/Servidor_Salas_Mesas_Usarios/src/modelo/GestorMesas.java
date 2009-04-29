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


        return true;
    }
}
