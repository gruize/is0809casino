/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import java.util.ArrayList;
import java.util.Hashtable;
import modelo.LogicaJuegos.Jugador;

/**
 *
 * @author Fiutten
 */
public class GestorUsuarios {

    private static Hashtable<Integer,Integer> jugadorMesa;
    private static Hashtable<Integer,ArrayList<Jugador>> mesaJugadores;
    private static GestorUsuarios instancia;

    public static GestorUsuarios getInstancia() {
        if (instancia == null)
              instancia = new GestorUsuarios();
        return instancia;
    }
    
    public GestorUsuarios() {
        jugadorMesa = new Hashtable<Integer,Integer>();
        mesaJugadores = new Hashtable<Integer,ArrayList<Jugador>>();
    }

    public int getMesa(int usuario) {
        if (jugadorMesa.containsKey(usuario)) {
            return jugadorMesa.get(usuario);
        }
        return -1;
    }
    //Devuelve el saldo de un jugador en concreto
    public int getSaldoJugador(int usuario, int mesa) {
        int posicion = posicionJugador(usuario,getUsuarios(mesa));
        return  this.getUsuarios(mesa).get(posicion).getSaldo();
    }
      //Actualiza el saldo de un jugador en concreto
    public void setSaldoJugador(int usuario, int mesa,int saldo) {
        int posicion = posicionJugador(usuario,getUsuarios(mesa));
        this.getUsuarios(mesa).get(posicion).setSaldo(saldo);
    }

    public ArrayList<Jugador> getUsuarios(int mesa) {
        ArrayList<Jugador> jugadores = null;
        if (mesaJugadores.containsKey(mesa)) {
            jugadores = mesaJugadores.get(mesa);
        }
        return jugadores;
    }

    //Permite que un jugador este en mas de una mesa pero solo
    //una vez por mesa.
    public boolean colocarJugador(int idJugador,int mesa) {
        boolean correcto = true;
         //TODO Buscar el saldo del Jugador en la BBDD
        int saldo=100;
        Jugador jugador=new Jugador(idJugador,saldo);
        if (jugadorMesa.containsKey(idJugador)) {
            jugadorMesa.remove(idJugador);
            jugadorMesa.put(idJugador,mesa);
            System.out.println("El jugador con id: "+jugador+" se coloca en la mesa "+mesa+" jugador-mesa");
        }
        else{
            correcto = false;
            System.out.println("El jugador con id: "+jugador+" no esta en la lista de usuarios");
            }
        if (mesaJugadores.get(mesa)!=null){
            if (!mesaJugadores.get(mesa).contains(jugador)){
                 mesaJugadores.get(mesa).add(jugador);
                 System.out.println("El jugador con id: "+jugador+" se coloca en la mesa "+mesa+" mesa-listajugadores");
            }
            else{
            System.out.println("El jugador con id: "+jugador+" ya estaba en la mesa "+mesa);
            }
        }
        else
            correcto = false;
        return correcto;
    }
    
    public boolean agregarJugador(int jugador) {
        boolean correcto = true;
        if (!jugadorMesa.containsKey(jugador))
            //por defecto van a la mesa inexistente 0 segun hacen login
            jugadorMesa.put(jugador,0);
        else
            correcto = false;
        return correcto;
    }


    public boolean agregarMesa(int mesa) {
        boolean correcto = true;
        if (!mesaJugadores.containsKey(mesa)) {
            ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
            mesaJugadores.put(mesa,jugadores);
        }
        else
            correcto = false;
        return correcto;
    }

    public int hacerLogin(String usuario,String password) {
        int resultado = 1;
        //cosulta a la base de datos comprobando usuario y password y
        //obteniendo la clave autonumerica del usuario.
        //Sino existe el usuario => resultado = -1
        int id = 1; //Asignar la clave autonumerica obtenida en consulta anterior
        //hasta que me ponga con la bbdd el identificador es aleatorio
        //int aleatorio = (int)(Math.random()*100);
        //Si el jugador ya esta conectado devuelve resultado = 0
        if (jugadorMesa.containsKey(id))
            resultado = -1;
        //Indico en el log un nuevo usuario
        return 1;
    }
    public boolean eliminarJugador(int jugador){
       int mesa = this.getMesa(jugador);
       int posicion = posicionJugador(jugador,getUsuarios(mesa));
       this.getUsuarios(mesa).remove(posicion);
       System.out.println("****** Usuario Eliminado de la mesa ********");
       jugadorMesa.get(jugador);

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