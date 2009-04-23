/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.LogicaJuegos.logicaRuleta;

import controlador.ControladorServidor;
import modelo.Jugada;
import modelo.LogicaJuegos.*;
import java.util.Vector;

/**
 *
 * @author Jaime Guimera
 */
public class MesaRuleta implements Mesa {

    int id = 0;
    int nJugadores = 0;
    Vector<Jugada> apuestas = null; //lista de apuestas de la mesa
    int nApuestas = 0;
    Vector<Jugador> jugadoresMesa = null; //lista de jugadores de la mesa
    Vector numeros = null;
    int ultimaBola = 0;
    ControladorServidor controlador;
    CreaRuleta ruleta;
    boolean flag=true; //Si Flag=true se admiten apuestas si Flag = false no se admiten apuestas

    public MesaRuleta(ControladorServidor c) {
        controlador = c;
        apuestas = new Vector();
        jugadoresMesa = new Vector();
        ruleta = new CreaRuleta();
        ruleta.InicializarRuleta();
    }

    public boolean procesaJugada(Jugada j) {
        System.out.println("Mensaje procesado por la Mesa");
        if (this.colocarApuesta(j) == 1) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Si la apuesta es v√°lida para el jugador (si este tiene saldo suficiente), se le guarda en
     * el array de apuestas
     * @param jugada
     * @return 1 si la apuesta es correcta, -1 si no le queda saldo al jugador
     */
    private int colocarApuesta(Jugada jugada) {
        int posicionJugador = posicionJugador(jugada.getUsuario());
        int saldoJugador = jugadoresMesa.get(posicionJugador).getSaldo();
        if ((jugada.getCantidad()) <= saldoJugador) {
            apuestas.add(jugada);
            nApuestas++;
            jugadoresMesa.get(posicionJugador).setSaldo(saldoJugador - jugada.getCantidad());

            return 1;
        } else {
            return -1;
        }

    }

    /**
     * Devuelve el √≠ndice del jugador de entre todos los
     * jugadores activos de la partida de la ruleta.
     * @param idJugador valor que identifica al jugador
     * @return √≠ndice del array de jugadores donde se encuentra el jugador
     */
    private int posicionJugador(int idJugador) {
        boolean encontrado = false;
        int index = 0;
        while ((!encontrado) && (index < jugadoresMesa.size())) {
            encontrado = jugadoresMesa.get(index).getId() == idJugador;
            index++;
        }
        return index - 1;


    }
    //Lanza una bola y comprueba todas las apuestas de los jugadores.

    public void lanzaBola() {
        flag=false;
        ultimaBola =(int) Math.round((Math.random() * 36));
        comprobarApuestas(ultimaBola);
        flag=true;
        }
    //AÒade un Jugadora la mesa

    public boolean addJugador(Jugador j) {
        //TODO Comprobar que no este ya en la mesa
        jugadoresMesa.add(j);
        return true;
    }

    /**
     * Recorre todas las apuestas de la mesa, y comprueba si han resultado premiadas
     * @param bolaLanzada n˙mero de la ruleta donde ha caÌdo la bola
     * @return
     */
    private void comprobarApuestas(int bolaLanzada) {

        Numero bola = ruleta.getNumero(bolaLanzada);
        int saldo;
        for (int i = 0; i < apuestas.size(); i++) {
            Jugada apuesta=apuestas.get(i);
            int posicion=posicionJugador(apuesta.getUsuario());
            saldo = jugadoresMesa.get(posicion).getSaldo();
            saldo = saldo+apuestaGanadora(apuesta, bola);
            jugadoresMesa.get(posicion).setSaldo(saldo);

        }
        apuestas.removeAllElements();
        enviarSaldos();
        
    }

    /**
     * Comprueba si la apuesta que hizo el jugador ha resultado premiada o no, a partir de la
     * bola de la ruleta
     * @param apuesta del jugador
     * @param casillaBola casilla de la ruleta que ha resultado seleccionada
     * @return lo que el jugador gana
     *
     */
    private int apuestaGanadora(Jugada apuesta, Numero casillaBola) {
        String tipo = apuesta.getTipo();
        if (casillaBola.getNumero() != 0) {
            //apuesta a N⁄MERO
            if ((tipo.equals("numero")) && (apuesta.getCasilla() == casillaBola.getNumero())) {
                return apuesta.getCantidad() * 36;
            //apuesta a COLOR (0=>Negro, 1 =>ROJO
            } else if (tipo.equalsIgnoreCase("COLOR")) {
               if ((apuesta.getCasilla()==1)&&casillaBola.getColor().equalsIgnoreCase("ROJO")) return apuesta.getCantidad() * 2;
               else if ((apuesta.getCasilla()==0)&&casillaBola.getColor().equalsIgnoreCase("NEGRO"))return apuesta.getCantidad() * 2;
            //apuesta a 1™ DOCENA
            } else  if (tipo.equals("1docena") && casillaBola.getNumero() >= 1 && casillaBola.getNumero() <= 12) {
            return apuesta.getCantidad() * 3;
        //apeusta a 2™ DOCENA
        } else if (tipo.equals("2docena") && casillaBola.getNumero() > 12 && casillaBola.getNumero() <= 24) {
            return apuesta.getCantidad() * 3;
        //apuesta a 3™ DOCENA
        } else if (tipo.equals("3docena") && casillaBola.getNumero() > 24 && casillaBola.getNumero() <= 36) {
            return apuesta.getCantidad() * 3;

        }
    }
    else

    {//la bola lanzada es CERO: si la apuesta es al color se devuelte la mitad.
        if (apuesta.getTipo().equals("COLOR")) {
            return apuesta.getCantidad() / 2;
        } else if (apuesta.getTipo().equals("numero") && (apuesta.getCasilla() == casillaBola.getNumero())) {
            return apuesta.getCantidad() * 36;
        }
    }
    return 0;
    }
    //Envia los saldos nuevos a los jugadores de la mesa
    void enviarSaldos(){}
}
