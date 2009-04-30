/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import java.util.ArrayList;
import java.util.Hashtable;
import bbdd.gestorBBDD.GestorBBDDImp;
import bbdd.gestorBBDD.InterfazBBDD;
import modelo.LogicaJuegos.Jugador;

import bbdd.beans.Clientes;
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

    private Vector<JugadorConectado> jugadores=null;
    private InterfazBBDD bbdd;



    private static Hashtable<Integer,Integer> jugadorMesa;
    private static Hashtable<Integer,ArrayList<Jugador>> mesaJugadores; 
    private static GestorUsuarios instancia;
    

     //log4j
    private static Logger log = Logger.getLogger(GestorUsuarios.class);


  
    //--------------------------------------------------------------------------
    //          METODOS
    //--------------------------------------------------------------------------

    public static GestorUsuarios getInstancia() {
        if (instancia == null)
              instancia = new GestorUsuarios();
        return instancia;
    }
    
    public GestorUsuarios() {
        
        jugadores=new Vector<JugadorConectado>();
        bbdd = new GestorBBDDImp();

    }

    /**
     * Cuando un jugador se logea y entra en el casino. Aún no ha entrado en sala ni mesa
     * @param idSala
     * @param idMesa
     * @param c
     */
    public void insertarJugador( Clientes c){
        JugadorConectado jugador=new JugadorConectado(c);
       this.jugadores.add(jugador);

       //aún no se inserta nada en BBDD, no se considera Participante porque aún no ha entrado en sala ni mesa
    }


    /**
     * Cuando el jugador entra en una sala.
     * @param idJugador
     * @param idSala
     */
    public void insertarJugadorEnSala(int idJugador, int idSala){

        //buscar el jugador en la lista de jugadores del casino
        int posJugador=getIndiceJugador(idJugador);
        JugadorConectado jugador=this.jugadores.get(posJugador);
        jugador.setIdSala(idSala);
        this.jugadores.add(posJugador, jugador);

        //TODO hay que actualizar algo en BBDD? jugador, sala?
    }

    /**
     * Cuando el jugador selecciona una msea de juego
     * @param idJugador
     * @param idMesa
     */
    public void insertarJugadorEnMesa(int idJugador, int idMesa){

        int posJugador=getIndiceJugador(idJugador);
        JugadorConectado jugador=this.jugadores.get(posJugador);
        jugador.setIdMesa(idMesa);
        this.jugadores.add(posJugador, jugador);

        //TODO hay que actualizar algo en BBDD? jugador, mesa? se le considera ya un participante?

        //TODO enviar el controlador
        //Enviarselo al gestorSalas, y que llame a su gestorMesas y lo incluya en la mesa correspondiente
        GestorSalas.getInstance(null).añadirMesaEnSala(idMesa, jugador.getIdSala(), idJugador);
    }


    /**
     * Cuando en las mesas se resuelve la partida, se mandan actualizar todos los saldos de los jugadores.
     * @param idJugador
     * @param nuevoSaldo
     */
    public void actualizaSaldoJugador(int idJugador, int nuevoSaldo){
        int posJugador=getIndiceJugador(idJugador);
        JugadorConectado jugador=this.jugadores.get(posJugador);
        jugador.actualizaSaldo(nuevoSaldo);

        //actualizar en BBDD
        bbdd.modificarCliente(jugador.getJugador());
        
        //volver a actualizar el vector de jugadores
       this.jugadores.add(posJugador, jugador);

       log.info("GestorUsuarios : actualizaSaldoJugador : jugador="+idJugador+" en mesa="+jugador.getIdMesa()+" se actualiza con saldo="+nuevoSaldo);

    }

    /**
     * Busca la posicion del vector de jugadores donde se encuentra el jugador
     * @return posicion del jugador si está en la lista de jugadores del casino
     *          -1 si no lo encuentra
     */
    public int getIndiceJugador(int idJugador){

        int i=0;
        boolean enc=this.jugadores.get(i).getIdJugador()==idJugador;
        while (!enc && i<jugadores.size()){
            i++;
            enc=this.jugadores.get(i).getIdJugador()==idJugador;
        }

        if (enc)
            return i;
        else return -1; //Error, el usuario no se ha insertado bien previamente, cuando se ha logeado. 

    }





    //=======================================================
    // version anterior
    //=======================================================

    /**
     * Comprueba el login de un usuario
     * @param usuario nombre de usuario
     * @param password contraseña
     * @return identificador del usuario si los datos son correctos, y no estaba ya en la mesa, -1 e.o.c
     */
    public int hacerLogin(String usuario,String password) {
        int id = 0;

        id=bbdd.comprobarUsuario(usuario, password);
        //Si el jugador ya esta conectado devuelve resultado = -1
        if (getIndiceJugador(id)!=-1){
            insertarJugador(bbdd.getClientePorCodigo(id));
        }else
            id = -1;
        
        return id;
    }

    /**
     * Busca un jugador de la lista de jugadores
     * @param idJugador
     */
    public JugadorConectado getJugadorConectado(int idJugador){

        return jugadores.get(getIndiceJugador(idJugador));
    }
    /**
     * TODO hacer
     *
     * Elimina al jugador de la mesa en la que se encontraba.
     * @param jugador
     * @return
     */
    public boolean eliminarJugador(int jugador){
       /*int mesa = this.getMesa(jugador);
       int posicion = posicionJugador(jugador,getUsuarios(mesa));
       this.getUsuarios(mesa).remove(posicion);
       System.out.println("****** Usuario Eliminado de la mesa ********");
       log.info("GestorUsuarios: eliminarJugador : ****** Usuario Eliminado de la mesa ********");
       jugadorMesa.get(jugador);*/

        return true;

    }
     /**
     * Devuelve el índice del jugador de entre todos los
     * jugadores activos de la partida de la ruleta.
     * @param idJugador valor que identifica al jugador
     * @return índice del array de jugadores donde se encuentra el jugador
     */
    private int posicionJugador(int idJugador, ArrayList<Jugador> lista) {
        boolean encontrado = false;
        int index = 0;
        while ((!encontrado) && (index < lista.size())) {
            encontrado = lista.get(index).getId() == idJugador;
            index++;
        }
        return index - 1;


    }
}