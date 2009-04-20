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

    private Hashtable<Integer,Integer> jugadorMesa;
    private Hashtable<Integer,ArrayList<Integer>> mesaJugadores;
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
        }
        else
            correcto = false;
        if (!mesaJugadores.get(mesa).contains(jugador))
            mesaJugadores.get(mesa).add(jugador);
        else
            correcto = false;
        return correcto;
    }
    
    public boolean agregarJugador(int jugador) {
        boolean correcto = true;
        /*if (!jugadorMesa.containsKey(jugador))
            jugadorMesa.put(jugador,null);
        else
            correcto = false;*/
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
