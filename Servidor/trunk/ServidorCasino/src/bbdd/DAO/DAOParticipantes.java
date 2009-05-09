/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bbdd.DAO;

import java.sql.SQLException;
import java.util.ArrayList;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import bbdd.beans.Participantes;
/**
 *
 * @author Ambrin Chaudhary y Joaquin Lopez
 */
public class DAOParticipantes {

    //log4j
    private static Logger log = Logger.getLogger(DAOParticipantes.class);

    public DAOParticipantes(){}
    

    /**
     * Inserta un nuevo participante
     * @param participante
     * @return resultado de la operacion
     */
    public boolean insertarNuevoParticipante(Participantes participante) {

        String metodo="insertarNuevoParticipante";
        boolean res = false;

        Session session = null;
        Transaction tx = null;

        try {
            session = HibernateUtil.currentSession();
            tx = session.beginTransaction();

            //guardamos
            session.save(participante);
            
            session.flush();
            tx.commit();

            log.info("DAOParticipantes: "+metodo+": Participante con código " + participante.getId().getJugador() + " INSERTADO OK");
            res = true;

        } catch (org.hibernate.HibernateException he) {
            tx.rollback();
            log.error("DAOParticipantes: "+metodo+": Error de Hibernate: " + he.getMessage());
        } catch (SQLException sqle) {
            tx.rollback();
            log.error("DAOParticipantes: "+metodo+": Error SQLException: " + sqle.getMessage());
        } catch (Exception e) {
            tx.rollback();
            log.error("DAOParticipantes: "+metodo+": Error Exception: " + e.getMessage());
        } finally {
            // Liberamos sesión
            HibernateUtil.closeSession();
           
        }

        return res;
    }

    /**
     * Devuelve el participante con codigo de cliente idJug que está jugando en la partida idPartida  
     * @param idJug
     * @param idPartida
     * @return
     */
    public Participantes getParticipante(int idJug, int idPartida) {

        String metodo="getParticipantePorCodigo";
        Participantes p=null;
        Session session = null;
        Transaction tx = null;

        try {
            session = HibernateUtil.currentSession();
            tx = session.beginTransaction();
            
            p = (Participantes) session.createQuery("from Participantes p where p.id.jugador=? and p.id.partida=?").setInteger(0, idJug).setInteger(1, idPartida).uniqueResult();
            
            session.flush();
            tx.commit();

            log.info("DAOParticipantes: "+metodo+":  Participante " + p.getId().getJugador() + " obtenido");

        } catch (org.hibernate.HibernateException he) {
            tx.rollback();
            log.error("DAOParticipantes: "+metodo+": Error de Hibernate: " + he.getMessage());
        } catch (SQLException sqle) {
            tx.rollback();
            log.error("DAOParticipantes: "+metodo+": Error SQLException: " + sqle.getMessage());
        } catch (Exception e) {
            tx.rollback();
            log.error("DAOParticipantes: "+metodo+": Error Exception: " + e.getMessage());
        } finally {
            // Liberamos sesión
            HibernateUtil.closeSession();
           
        }

        return p;
    }
    
    /**
     * Devuelve todos los jugadores que están participando en alguna partida
     * @return
     */
    public ArrayList getParticipantes() {

        String metodo="getParticipantes";
        ArrayList lista = new ArrayList();
        Session session = null;
        Transaction tx = null;

        try {
            session = HibernateUtil.currentSession();
            tx = session.beginTransaction();
            
            lista = (ArrayList)session.createQuery("from Participantes").list();
            
            session.flush();
            tx.commit();

            log.info("DAOParticipantes: "+metodo+": Se obtienen " + lista.size() + " clientes");

        } catch (org.hibernate.HibernateException he) {
            tx.rollback();
            log.error("DAOParticipantes: "+metodo+": Error de Hibernate: " + he.getMessage());
        } catch (SQLException sqle) {
            tx.rollback();
            log.error("DAOParticipantes: "+metodo+": Error SQLException: " + sqle.getMessage());
        } catch (Exception e) {
            tx.rollback();
            log.error("DAOParticipantes: "+metodo+": Error Exception: " + e.getMessage());
        } finally {
            // Liberamos sesión
            HibernateUtil.closeSession();
            
        }

        return lista;
    }
    
    /**
     * Devuelve todas las partidas en la que está participando un jugador
     * 
     * @param idJugador identificador del jugador
     * @return lista de ids de las partidas en las que está jugando
     */
        public ArrayList getPartidasPorParticipante(int idJugador) {

        String metodo="getPartidasPorParticipante";
        ArrayList lista = new ArrayList();
        Session session = null;
        Transaction tx = null;

        try {
            session = HibernateUtil.currentSession();
            tx = session.beginTransaction();
            
            lista = (ArrayList)session.createQuery("from Participantes p where p.id.jugador=?").setInteger(0,idJugador).list();
            
            session.flush();
            tx.commit();

            log.info("DAOParticipantes: "+metodo+": Se obtienen " + lista.size() + " partidas en las que participa el jugador");

        } catch (org.hibernate.HibernateException he) {
            tx.rollback();
            log.error("DAOParticipantes: "+metodo+": Error de Hibernate: " + he.getMessage());
        } catch (SQLException sqle) {
            tx.rollback();
            log.error("DAOParticipantes: "+metodo+": Error SQLException: " + sqle.getMessage());
        } catch (Exception e) {
            tx.rollback();
            log.error("DAOParticipantes: "+metodo+": Error Exception: " + e.getMessage());
        } finally {
            // Liberamos sesión
            HibernateUtil.closeSession();
           
        }

        return lista;
    }

           /**
     * Devuelve todas los jugadores que están participando en la partida
     * 
     * @param idPartida identificador de la partida
     * @return lista de ids de los jugadores
     */
        public ArrayList getJugadoresPorPartida(int idPartida) {

        String metodo="getJugadoresPorPartida";
        ArrayList lista = new ArrayList();
        Session session = null;
        Transaction tx = null;

        try {
            session = HibernateUtil.currentSession();
            tx = session.beginTransaction();
            
            lista = (ArrayList)session.createQuery("from Participantes p where p.id.partida=?").setInteger(0,idPartida).list();
            
            session.flush();
            tx.commit();

            log.info("DAOParticipantes: "+metodo+": Se obtienen " + lista.size() + " jugadores en la partida "+idPartida);

        } catch (org.hibernate.HibernateException he) {
            tx.rollback();
            log.error("DAOParticipantes: "+metodo+": Error de Hibernate: " + he.getMessage());
        } catch (SQLException sqle) {
            tx.rollback();
            log.error("DAOParticipantes: "+metodo+": Error SQLException: " + sqle.getMessage());
        } catch (Exception e) {
            tx.rollback();
            log.error("DAOParticipantes: "+metodo+": Error Exception: " + e.getMessage());
        } finally {
            // Liberamos sesión
            HibernateUtil.closeSession();
           
        }

        return lista;
    }
        

    /**
     * Borra un participante
     * @param participante participante que se quiere borrar
     * @return resultado de la operación
     */
    public void borrarParticipante(Participantes participante) {

        String metodo = "borrarParticipante";

        Session session = null;
        Transaction tx = null;

        try {
            session = HibernateUtil.currentSession();
            tx = session.beginTransaction();

            session.delete(participante);

            session.flush();
            tx.commit();

            log.info("DAOParticipantes: " + metodo + ": Participante con idJugador " + participante.getId().getJugador() + " e idPartida "+participante.getId().getPartida()+" BORRADO");

        } catch (org.hibernate.HibernateException he) {
            tx.rollback();
            log.error("DAOParticipantes: " + metodo + ": Error de Hibernate: " + he.getMessage());
        } catch (SQLException sqle) {
            tx.rollback();
            log.error("DAOParticipantes: " + metodo + ": Error SQLException: " + sqle.getMessage());
        } catch (Exception e) {
            tx.rollback();
            log.error("DAOParticipantes: " + metodo + ": Error Exception: " + e.getMessage());
        } finally {
            // Liberamos sesión
            HibernateUtil.closeSession();
            
        }

    }

    /**
     * Modifica un participante
     * 
     * @param participante objeto ya modificado localmente
     */
    public void modificarParticipante(Participantes participante) {

        String metodo = "modificarParticipante";

        Session session = null;
        Transaction tx = null;

        try {
            session = HibernateUtil.currentSession();
            tx = session.beginTransaction();

            session.update(participante);

            session.flush();
            tx.commit();

            log.info("DAOParticipantes: " + metodo + ":Cliente  con idJugador " + participante.getId().getJugador() + " e idPartida "+participante.getId().getPartida()+ " MODIFICADO");

        } catch (org.hibernate.HibernateException he) {
            tx.rollback();
            log.error("DAOParticipantes: " + metodo + ": Error de Hibernate: " + he.getMessage());
        } catch (SQLException sqle) {
            tx.rollback();
            log.error("DAOParticipantes: " + metodo + ": Error SQLException: " + sqle.getMessage());
        } catch (Exception e) {
            tx.rollback();
            log.error("DAOParticipantes: " + metodo + ": Error Exception: " + e.getMessage());
        } finally {
            // Liberamos sesión
            HibernateUtil.closeSession();
           
        }

    }


}
