/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package vista;

import javax.swing.JButton;

/**
 *
 * @author GabiPC
 */
public class JButtonMesa extends JButton{

    private int idMesa;
    private int numJugadores;
    private int apuesta;

    public JButtonMesa(String nombre,int mesa,int jugadores,int apostar) {
        super(nombre);
        idMesa = mesa;
        numJugadores = jugadores;
        apuesta = apostar;
    }
}
