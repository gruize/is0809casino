/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package casino;

/**
 *
 * @author Administrador
 */
public class Jugada {
int idUsuario;
int idPartida;
int tipo;
float cantidad;

public Jugada(int usuario,int partida,int tipojugada,float apuesta){
idUsuario=usuario;
idPartida=partida;
tipo=tipojugada;
cantidad=apuesta;
};
}