/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bbdd.pruebasBBDD;

import bbdd.beans.Participantes;
import bbdd.beans.ParticipantesId;
import bbdd.DAO.DAOParticipantes;
import java.util.ArrayList;

import bbdd.gestorBBDD.GestorBBDDImp;
import bbdd.gestorBBDD.InterfazBBDD;
/**
 *
 * @author Ambrin Chaudhary y Joaquin Lopez
 */
public class testParticipantes {

    static InterfazBBDD bbdd = null;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        bbdd = new GestorBBDDImp();
       //borrarParticipante();
        
        getParticipantes();
    }

    private static void borrarParticipante() {
       //  DAOParticipantes dao = new DAOParticipantes();
        // dao.borrarParticipante(dao.getParticipante(3, 21));//borro el jugador de prueba (3) que estaba en la partida de la ruleta (21)
       bbdd.borrarParticipante(bbdd.getParticipante(3, 21));
    }

    /**
     * Obtiene todos los juegos activos del casino
     */
    private static void getParticipantes() {
     
        mostrarDatos(bbdd.getParticipantes());
    }

    private static void insertarParticipante() {
        
        Participantes participante=new Participantes();
        ParticipantesId pId=new ParticipantesId();
        pId.setPartida(21); //meto la partida de la ruleta
        pId.setJugador(2); //cliente 2 (joaquin) está jugando a la partida de la ruleta
                            //si se inserta un cliente q no existe, no hace nada, pero tampoco produce excepción, por lo que no avisa
                            
        participante.setId(pId);
        
        bbdd.insertarParticipante(participante);
        //DAOParticipantes dao=new DAOParticipantes();
        //dao.insertarNuevoParticipante(participante);
        //cuando se inserta un participante, se debería aumentar el nº de jugadores de la partida, sino habrían inconsistencias.
        //tb habría que aumentarlo en la mesa, atributo "jugadores"
    }

    private static void modificarParticipante() {
       //En realidad esta operación no haría falta nunca. Solo se insertan y elimina participantes
        
    }

    private static void mostrarDatos(ArrayList lista) {
        String s = "  ";
        System.out.println("**************  PARTICIPANTES **************");
        for (int i = 0; i < lista.size(); i++) {
            Participantes p = (Participantes) lista.get(i);
            System.out.print("Partida:" + p.getId().getPartida() + s);
            System.out.println("Jugador:" + p.getId().getJugador() + s);

        }
    }

    private static void obtenerJugPorPartida() {
        DAOParticipantes dao = new DAOParticipantes();
        ArrayList lista = dao.getJugadoresPorPartida(21);
        mostrarDatos(lista);
    }
    
    private static void obtenerPartidasPorJugador() {
        DAOParticipantes dao = new DAOParticipantes();
        ArrayList lista = dao.getPartidasPorParticipante(1);
        mostrarDatos(lista);
    }
}
