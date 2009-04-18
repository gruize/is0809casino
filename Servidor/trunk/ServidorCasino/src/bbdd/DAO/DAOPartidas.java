/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bbdd.DAO;

import bbdd.beans.Partidas;
import java.sql.SQLException;
import java.util.ArrayList;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Ambrin Chaudhary y Joaquin Lopez
 */
public class DAOPartidas {

    static Logger log = Logger.getLogger(DAOPartidas.class);

    /**
     * Inserta una nueva partida
     * @param partida
     * @return resultado de la operacion
     */
    public boolean insertarNuevaPartida(Partidas partida) {

        String metodo="insertarNuevaPartida";
        boolean res = false;

        Session session = null;
        Transaction tx = null;

        try {
            session = HibernateUtil.currentSession();
            tx = session.beginTransaction();

            //guardamos
            session.save(partida);
            
            session.flush();
            tx.commit();

            log.info("DAOPartidas: "+metodo+": Partida " + partida.getCodigo() + " INSERTADA OK");
            res = true;

        } catch (org.hibernate.HibernateException he) {
            tx.rollback();
            log.error("DAOPartidas: "+metodo+": Error de Hibernate: " + he.getMessage());
        } catch (SQLException sqle) {
            tx.rollback();
            log.error("DAOPartidas: "+metodo+": Error SQLException: " + sqle.getMessage());
        } catch (Exception e) {
            tx.rollback();
            log.error("DAOPartidas: "+metodo+": Error Exception: " + e.getMessage());
        } finally {
            // Liberamos sesión
            HibernateUtil.closeSession();
            log.info("DAOPartidas: "+ metodo+": Sesion liberada. Finished");
        }

        return res;
    }

    /**
     * Devuelve todas las partidas que hay registrados en el casino
     * @return
     */
    public ArrayList getPartidas() {

        String metodo="getPartidas";
        ArrayList lista = new ArrayList();
        Session session = null;
        Transaction tx = null;

        try {
            session = HibernateUtil.currentSession();
            tx = session.beginTransaction();
            
            lista = (ArrayList)session.createQuery("from Partidas").list();
            
            session.flush();
            tx.commit();

            log.info("DAOPartidas: "+metodo+": Se obtienen " + lista.size() + " partidas");

        } catch (org.hibernate.HibernateException he) {
            tx.rollback();
            log.error("DAOPartidas: "+metodo+": Error de Hibernate: " + he.getMessage());
        } catch (SQLException sqle) {
            tx.rollback();
            log.error("DAOPartidas: "+metodo+": Error SQLException: " + sqle.getMessage());
        } catch (Exception e) {
            tx.rollback();
            log.error("DAOPartidas: "+metodo+": Error Exception: " + e.getMessage());
        } finally {
            // Liberamos sesión
            HibernateUtil.closeSession();
            log.info("DAOPartidas: "+metodo+": Sesion liberada. Finished");
        }

        return lista;
    }

    /**
     * Busca una partida en la BBDD por codigo.
     * @param codigo codigo de la partida
     * @return objeto Partidas
     */
    public Partidas getPartidaPorCodigo(int codigo) {

        String metodo = "getPartidaPorCodigo";

        Partidas partida = null;
        Session session = null;
        Transaction tx = null;
        
        try {
            session = HibernateUtil.currentSession();
            tx = session.beginTransaction();

            partida = (Partidas) session.createQuery("from Partidas p where p.codigo= ?").setString(0, ""+codigo).uniqueResult();

            session.flush();
            tx.commit();

            log.info("DAOPartidas: " + metodo + ": Partida obtenida con CODIGO: " + partida.getCodigo());

        } catch (org.hibernate.HibernateException he) {
            tx.rollback();
            log.error("DAOPartidas: " + metodo + ": Error de Hibernate: " + he.getMessage());
        } catch (SQLException sqle) {
            tx.rollback();
            log.error("DAOPartidas: " + metodo + ": Error SQLException: " + sqle.getMessage());
        } catch (Exception e) {
            tx.rollback();
            log.error("DAOPartidas: " + metodo + ": Error Exception: " + e.getMessage());
        } finally {
            // Liberamos sesión
            HibernateUtil.closeSession();
            log.info("DAOPartidas: " + metodo + ": Sesion liberada. Finished");
        }

        return partida;
    }

    /**
     * Borra una partida
     * @param partida partida que se quiere borrar
     * @return resultado de la operación
     */
    public void borrarPartida(Partidas partida) {

        String metodo = "borrarPartida";

        Session session = null;
        Transaction tx = null;

        try {
            session = HibernateUtil.currentSession();
            tx = session.beginTransaction();

            session.delete(partida);

            session.flush();
            tx.commit();

            log.info("DAOPartidas: " + metodo + ": Partida con codigo" + partida.getCodigo() + " BORRADA");

        } catch (org.hibernate.HibernateException he) {
            tx.rollback();
            log.error("DAOPartidas: " + metodo + ": Error de Hibernate: " + he.getMessage());
        } catch (SQLException sqle) {
            tx.rollback();
            log.error("DAOPartidas: " + metodo + ": Error SQLException: " + sqle.getMessage());
        } catch (Exception e) {
            tx.rollback();
            log.error("DAOPartidas: " + metodo + ": Error Exception: " + e.getMessage());
        } finally {
            // Liberamos sesión
            HibernateUtil.closeSession();
            log.info("DAOPartidas: "+metodo+": Sesion liberada. Finished");
        }

    }

    /**
     * Modifica una partida
     * 
     * @param partida objeto ya modificado localmente
     */
    public void modificarPartida(Partidas partida) {

        String metodo = "modificarPartida";

        Session session = null;
        Transaction tx = null;

        try {
            session = HibernateUtil.currentSession();
            tx = session.beginTransaction();

            session.update(partida);

            session.flush();
            tx.commit();

            log.info("DAOPartidas: " + metodo + ": Partida con codigo" + partida.getCodigo() + " MODIFICADA");

        } catch (org.hibernate.HibernateException he) {
            tx.rollback();
            log.error("DAOPartidas: " + metodo + ": Error de Hibernate: " + he.getMessage());
        } catch (SQLException sqle) {
            tx.rollback();
            log.error("DAOPartidas: " + metodo + ": Error SQLException: " + sqle.getMessage());
        } catch (Exception e) {
            tx.rollback();
            log.error("DAOPartidas: " + metodo + ": Error Exception: " + e.getMessage());
        } finally {
            // Liberamos sesión
            HibernateUtil.closeSession();
            log.info("DAOPartidas: "+metodo+": Sesion liberada. Finished");
        }

    }

}
