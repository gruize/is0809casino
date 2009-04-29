/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

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
    private static Hashtable<Integer,Vector<Integer>> mesas_sala;//<idSala, vector<idMesa>>
    private ControladorServidor controlador; //TODO ¿realmente necesito el controlador?

       //log4j
    private static Logger log = Logger.getLogger(GestorSalas.class);

    //singleton
    private static GestorSalas instance=null;

    //para sincronizar con bbdd
    InterfazBBDD bbdd=null;


    //=====================================================================
    //
    //=====================================================================

    /**
     * Constructora por defecto
     */
    public GestorSalas(ControladorServidor c){

        log.debug("GestorSalas : constructora : init");
        this.controlador=c;
        salas=new Vector<Salas> ();
        mesas_sala=new Hashtable<Integer, Vector<Integer>>();

        bbdd=new GestorBBDDImp();

    }
    
    /**
     * Patron Singleton. Devuelve la instancia de la clase
     * @param c controlador del servidor
     * @return
     */
    public static GestorSalas getInstance(ControladorServidor c){
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
    public void crearSala(int codigoSala, String nombre){

        Salas sala=new Salas();
        sala.setCodigo(codigoSala);
        sala.setNombre(nombre);
        sala.setJuegos(null);//TODO puedo introducir valores nulos en BBDD??

        //Guardo en bbdd (si no existía ya)
        if (bbdd.insertarSala(sala)){
            log.info("GestorSalas : crearSala : Sala con id="+codigoSala+" guardada en BBDD");
            //guardo en mi vector de salas
            salas.add(sala);
            mesas_sala.put(codigoSala, null);//de momento no tengo mesas
            log.info("GestorSalas : crearSala : Sala con id="+codigoSala+" guardada en el Gestor de Salas. Aún no tiene mesas abiertas");
        }
    }


    /**
     * Busca la sala en el vector de salas del casino
     * @param idSala identificador de la sala
     * @return objeto Salas si está en el vector, null en otro caso
     */
    public Salas getSala(int idSala){

        Salas sala=null;
        int i=0;
        boolean enc=salas.get(i).getCodigo()==idSala;
        while (!enc && i<salas.size()){
            i++;
            enc=salas.get(i).getCodigo()==idSala;
        }

        if (enc)
            sala=salas.get(i);


        return sala;
    }


    /**
     * Borra todas las salas del casino, y todas sus mesas asociadas (tambien de la BBDD). Se  invocará cuando se cierre el servidor
     */
    public void borrarSalas(){

        //TODO Borrar todas las mesas de BBDD --> invocar al GestorMesas


        //borro la tabla hash de salas
        mesas_sala.clear();
        mesas_sala=null;


        //borro todas las salas de BBDD
        for (int i=0;i<salas.size();i++){
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
    public Vector<Integer> getMesas_Sala(int idSala){
        return mesas_sala.get(idSala);
    }

    /**
     * Comprueba si la mesa está ya en una sala
     * @param idSala
     * @param idMesa
     * @return true si la mesa está ya asociada a una sala
     *         false en otro caso
     */
    public boolean estaMesaEnSala(int idSala, int idMesa){
        Vector<Integer> mesas=getMesas_Sala(idSala);
        int i=0;
        boolean enc=mesas.get(i)==idMesa;
        while (!enc && i<mesas.size()){
            i++;
            enc=mesas.get(i)==idMesa;
        }

        return enc;
    }

    /**
     * Añade una mesa en una sala
     * @param idSala
     * @param idMesa
     * @return true si se inserta correctamente,
     *         false si la mesa ya estaba en la sala
     */
    public boolean añadirMesaEnSala(int idSala, int idMesa){

        //compruebo si ya está insertada
        if (estaMesaEnSala(idSala, idMesa))
            return false;
        else{
            //obtengo las mesas que ya habían en la sala
            Vector<Integer> mesas=getMesas_Sala(idSala);
            if (mesas==null)
                mesas=new Vector<Integer>();

            //incluyo la mesa
            mesas.add(idMesa);

            //actualizo la tabla hash
            mesas_sala.put(idSala, mesas);

            //No inserto la sala en BBDD, de eso se encarga el GestorMesas


        }

        return true;
    }




    //==========================================================================

    /**
     * Recibe una jugada, y la redirige a la mesa correspondiente
     * @param jugada
     */
    public void procesaMensaje(Jugada jugada) {
        //TODO Identificar la sala segun el mensaje
        /*if (jugada.getTipo().equalsIgnoreCase("infoSALAS")) {
           // devuelveSalas();
        } else if (jugada.getTipo().equalsIgnoreCase("infoMESA")) {
            devuelveMesa(jugada.getMesa());
        } else {
            if (jugada.getTipo().equalsIgnoreCase("tiraBola")) salaRuleta.get(jugada.getMesa()).lanzaBola();
            else salaRuleta.get(jugada.getMesa()).procesaJugada(jugada);
        }*/

        int idSala=jugada.getSala();
        int idMesa=jugada.getMesa();

        //compruebo que la mesa está en la sala. Solo por seguridad...
        if (estaMesaEnSala(idSala, idMesa)){
        //TODO Enviarselo al GestorMesas
        }
    }

}
