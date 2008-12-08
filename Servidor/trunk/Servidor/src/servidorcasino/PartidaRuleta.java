/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servidorcasino;

import java.util.*;
import Casilla.*;

/**
 *
 * @author Administrador
 */
public class PartidaRuleta implements Partida {

    final int TAM_MAX = 5;
    int id;
    int nJugadores;
    ArrayList<ApuestaRuleta> apuestas; //lista de apuestas de la partida
    int nApuestas;
    ArrayList<Jugador> jugadoresPartida; //lista de jugadores de la partida
    ArrayList numeros;
    int ultimaBola;
    CreaRuleta ruleta;

    public PartidaRuleta(int id) {
        this.id = id;
        jugadoresPartida = new ArrayList<Jugador>();
        nJugadores = 0;
        nApuestas = 0;
        apuestas = new ArrayList<ApuestaRuleta>();

        ruleta = new CreaRuleta();
        ruleta.InicializarRuleta();
    }

    public ArrayList<ApuestaRuleta> getApuestas() {
        return apuestas;
    }

    public int getId() {
        return id;
    }

    public ArrayList<Jugador> getJugadoresPartida() {
        return jugadoresPartida;
    }

    public int getNJugadores() {
        return nJugadores;
    }

    public int getNApuestas() {
        return nApuestas;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNJugadores(int nJugadores) {
        this.nJugadores = nJugadores;
    }

    public void setNApuestas(int nApuestas) {
        this.nApuestas = nApuestas;
    }

    public int procesarJugada(Jugada j) {

        int i = 0;
        /*Tipos dejugada:
         *  1- Realizar una apuesta
         *  2- Terminar de apostar-> Lanzar la bola
         */
        switch (j.getTipoJugada()) {
            case 1:
                return colocarApuesta(j);
            case 2:
                ultimaBola = lanzarBola();
                int ganancias = comprobarApuestas(ultimaBola);
                int posicionJugador = posicionJugador(j.getIdUsuario());
                int saldoNuevo = ganancias + jugadoresPartida.get(posicionJugador).getSaldo();
                jugadoresPartida.get(posicionJugador).setSaldo(saldoNuevo);
                /*Mandar mensaje al cliente con el resultado de la tirada y de sus apuestas.*/
                return saldoNuevo;
            default:
                return 0;
        }

    }

    /**
     * Si la apuesta es válida para el jugador (si éste tiene saldo suficiente), se le guarda en 
     * su array de apuestas
     * @param jugada 
     * @return 1 si la apuesta es correcta, -1 si no le queda saldo al jugador, -2 si se excede el nº máximo
     * de apuestas en la ronda
     */
    private int colocarApuesta(Jugada jugada) {
        int posicionJugador = posicionJugador(jugada.getIdUsuario());
        if (nApuestas < TAM_MAX) {
            int saldoJugador = jugadoresPartida.get(posicionJugador).getSaldo();
            if ((jugada.getApuesta().get_cantidad()) <= saldoJugador) {
                apuestas.add((ApuestaRuleta) jugada.getApuesta());
                nApuestas++;
                jugadoresPartida.get(posicionJugador).setSaldo(saldoJugador - jugada.getApuesta().get_cantidad());
                return 1;
            } else {
                return -1;
            }
        }
        return -2;
    }

    /**
     * Lanza la bola de la ruleta de forma aleatoria
     * @return número donde ha caído la bola
     */
    private int lanzarBola() {
        return (int) Math.round((Math.random() * 36));
    }

    /**
     * Recorre todas las apuestas del jugador, y comprueba si han resultado premiadas
     * @param bolaLanzada número de la ruleta donde ha caído la bola
     * @return
     */
    private int comprobarApuestas(int bolaLanzada) {

        Numero bola = ruleta.getNumero(bolaLanzada);
        int saldoParcial = 0;
        for (int i = 0; i < apuestas.size(); i++) {

            saldoParcial = saldoParcial + apuestaGanadora(apuestas.get(i), bola);


        }
        borrarApuestas();
        return saldoParcial;
    }

    /**
     * Comprueba si la apuesta que hizo el jugador ha resultado premiada o no, a partir de la 
     * bola de la ruleta
     * @param apuesta del jugador
     * @param casillaBola casilla de la ruleta que ha resultado seleccionada 
     * @return lo que el jugador gana
     *
     */
    private int apuestaGanadora(ApuestaRuleta apuesta, Numero casillaBola) {
        
        //apuesta a NÚMERO
        if ((apuesta.get_tipo().equals("numero")) && (apuesta.get_casilla() == casillaBola.getNumero())) {
            return apuesta.get_cantidad() * 36;
        //apuesta a COLOR
        } else if ((apuesta.get_tipo().equals("PARIMPAR")) && (apuesta.get_color().equals(casillaBola.getColor()))) {
            return apuesta.get_cantidad() * 2;
        //apuesta a 1ª DOCENA
        } else if (apuesta.get_tipo().equals("1docena") && casillaBola.getNumero() >= 1 && casillaBola.getNumero() <= 12) {
            return apuesta.get_cantidad() * 3;  
        //apeusta a 2ª DOCENA
        } else if (apuesta.get_tipo().equals("2docena") && casillaBola.getNumero() > 12 && casillaBola.getNumero() <= 24) {
            return apuesta.get_cantidad() * 3; 
        //apuesta a 3ª DOCENA
        } else if (apuesta.get_tipo().equals("3docena") && casillaBola.getNumero() > 24 && casillaBola.getNumero() <= 36) {
            return apuesta.get_cantidad() * 3; 

        }
        return 0;
    }

    /**
     * Borra el array de apuestas
     */
    void borrarApuestas() {
        int tam = apuestas.size();
        for (int i = 0; i < tam; i++) {
            apuestas.remove(0);
            nApuestas = 0;
        }

    }

    /**
     * Devuelve el índice del jugador de entre todos los 
     * jugadores activos de la partida de la ruleta. 
     * @param idJugador valor que identifica al jugador
     * @return índice del array de jugadores donde se encuentra el jugador
     */
    private int posicionJugador(int idJugador) {
        boolean encontrado = false;
        int index = 0;
        while ((!encontrado) && (index < jugadoresPartida.size())) {
            encontrado = jugadoresPartida.get(index).getId() == idJugador;
            index++;
        }
        return index - 1;


    }

    /**
     * Inserta un nuevo jugador en la lista de jugadores activos de la partida de Ruleta
     * @param j
     * @return
     */
    public boolean anadeJugador(Jugador j) {
        //TODO  comprobar que hay hueco para el jugador en la partida
        this.jugadoresPartida.add(nJugadores, j);
        nJugadores++;
        return true;

    }

    /**
     * TODO: comprobar si se utiliza
     * @return
     */
    public Numero getUltimaBola() {
        return ruleta.getNumero(this.ultimaBola);
    }
}
