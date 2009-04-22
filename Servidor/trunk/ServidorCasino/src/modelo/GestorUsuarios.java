/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import java.util.ArrayList;
import java.util.Hashtable;

/**
 *
 * @author Fiutten
 */
public class GestorUsuarios {

    private static Hashtable<Integer,Integer> jugadorMesa;
    private static Hashtable<Integer,ArrayList<Integer>> mesaJugadores;
    private static GestorUsuarios instancia;

    public static GestorUsuarios getInstancia() {
        if (instancia == null)
              instancia = new GestorUsuarios();
        return instancia;
    }
    
    public GestorUsuarios() {
        jugadorMesa = new Hashtable<Integer,Integer>();
        mesaJugadores = new Hashtable<Integer,ArrayList<Integer>>();
    }

    public int getMesa(int usuario) {
        if (jugadorMesa.containsKey(usuario)) {
            return jugadorMesa.get(usuario);
        }
        return -1;
    }

    public ArrayList<Integer> getUsuarios(int mesa) {
        ArrayList<Integer> jugadores = null;
        if (mesaJugadores.containsKey(mesa)) {
            jugadores = mesaJugadores.get(mesa);
        }
        return jugadores;
    }

    //Permite que un jugador este en mas de una mesa pero solo
    //una vez por mesa.
    public boolean colocarJugador(int jugador,int mesa) {
        boolean correcto = true;
        if (jugadorMesa.containsKey(jugador)) {
            jugadorMesa.remove(jugador);
            jugadorMesa.put(jugador,mesa);
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
            ArrayList<Integer> jugadores = new ArrayList<Integer>();
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
        int aleatorio = (int)(Math.random()*100);
        //Si el jugador ya esta conectado devuelve resultado = 0
        if (jugadorMesa.containsKey(id))
            resultado = -1;
        return aleatorio;
    }
}