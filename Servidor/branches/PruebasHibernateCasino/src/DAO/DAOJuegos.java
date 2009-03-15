/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Beans.Juegos;
import java.sql.SQLException;
import java.util.ArrayList;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Chaudhary
 */
public class DAOJuegos {

    //log4j
    static Logger log = Logger.getLogger(DAOClientes.class);

    /** Contructora por defecto */
    public DAOJuegos() {
    }

    /**
     * Obtiene todos los juegos activos del Casino
     * @return lista de todos los juegos
     */
    public ArrayList getJuegosCasino() {

        String metodo = "getJuegosCasino";
        ArrayList lista = new ArrayList();
        Session session = null;
        Transaction tx = null;

        try {
            session = HibernateUtil.currentSession();
            tx = session.beginTransaction();

            lista = (ArrayList) session.createQuery("from Juegos").list();

            session.flush();
            tx.commit();

            log.info("DAOJuegos:" + metodo + ": Se obtienen " + lista.size() + " juegos");

        } catch (org.hibernate.HibernateException he) {
            tx.rollback();
            log.error("DAOJuegos:" + metodo + ": Error de Hibernate: " + he.getMessage());
        } catch (SQLException sqle) {
            tx.rollback();
            log.error("DAOJuegos:" + metodo + ":Error SQLException: " + sqle.getMessage());
        } catch (Exception e) {
            tx.rollback();
            log.error("DAOJuegos:" + metodo + ":Error Exception: " + e.getMessage());
        } finally {
            // Liberamos sesión
            HibernateUtil.closeSession();
            log.info("DAOJuegos:" + metodo + ":Sesion liberada. Finished");
        }

        return lista;
    }

    /**
     * Obtiene todas las salas donde de está jugando al JUEGO
     * @param lista de salas donde se está jugando el juego
     *//*
    public ArrayList getSalasconJuego() {
        String metodo = "getSalasconJuego";
        ArrayList lista = new ArrayList();

        Session session = null;
        Transaction tx = null;

        try {
            session = HibernateUtil.currentSession();
            tx = session.beginTransaction();

            //TODO crear la query
           // lista = (ArrayList) session.createQuery("from Juegos").list();

            session.flush();
            tx.commit();

            log.info("DAOJuegos:" + metodo + ": Se obtienen " + lista.size() + " juegos");

        } catch (org.hibernate.HibernateException he) {
            tx.rollback();
            log.error("DAOJuegos:" + metodo + ": Error de Hibernate: " + he.getMessage());
        } catch (SQLException sqle) {
            tx.rollback();
            log.error("DAOJuegos:" + metodo + ":Error SQLException: " + sqle.getMessage());
        } catch (Exception e) {
            tx.rollback();
            log.error("DAOJuegos:" + metodo + ":Error Exception: " + e.getMessage());
        } finally {
            // Liberamos sesión
            HibernateUtil.closeSession();
            log.info("DAOJuegos:" + metodo + ":Sesion liberada. Finished");
        }

        return lista;
    }*/

    /**
     * Inserta un nuevo Juego en BBDD
     * @param juego Juego a insertar
     */
    public void insertarJuego(Juegos juego) {

        String metodo = "insertarJuego";
        Session session = null;
        Transaction tx = null;

        try {
            session = HibernateUtil.currentSession();
            tx = session.beginTransaction();

            session.save(juego);

            session.flush();
            tx.commit();

            log.info("DAOJuegos:" + metodo + ": Juego " + juego.getNombre() + " INSERTADO");

        } catch (org.hibernate.HibernateException he) {
            tx.rollback();
            log.error("DAOJuegos:" + metodo + ": Error de Hibernate: " + he.getMessage());
        } catch (SQLException sqle) {
            tx.rollback();
            log.error("DAOJuegos:" + metodo + ": Error SQLException: " + sqle.getMessage());
        } catch (Exception e) {
            tx.rollback();
            log.error("DAOJuegos:" + metodo + ": Error Exception: " + e.getMessage());
        } finally {
            // Liberamos sesión
            HibernateUtil.closeSession();
            log.info("DAOJuegos:" + metodo + ":Sesion liberada. Finished");
        }
    }

    /**
     * Modifica un juego
     * @param juego
     */
    public void modificarJuego(Juegos juego) {

        String metodo = "modificarJuego";
        Session session = null;
        Transaction tx = null;

        try {
            session = HibernateUtil.currentSession();
            tx = session.beginTransaction();

            session.update(juego);

            session.flush();
            tx.commit();

            log.info("DAOJuegos:" + metodo + ": Juego " + juego.getNombre() + " MODIFICADO");

        } catch (org.hibernate.HibernateException he) {
            tx.rollback();
            log.error("DAOJuegos:" + metodo + ": Error de Hibernate: " + he.getMessage());
        } catch (SQLException sqle) {
            tx.rollback();
            log.error("DAOJuegos:" + metodo + ": Error SQLException: " + sqle.getMessage());
        } catch (Exception e) {
            tx.rollback();
            log.error("DAOJuegos:" + metodo + ": Error Exception: " + e.getMessage());
        } finally {
            // Liberamos sesión
            HibernateUtil.closeSession();
            log.info("DAOJuegos:" + metodo + ":Sesion liberada. Finished");
        }
    }

    /**
     * Elimina un juego
     * @param juego
     */
    public void borrarJuego(Juegos juego) {

        String metodo = "borrarJuego";
        Session session = null;
        Transaction tx = null;

        try {
            session = HibernateUtil.currentSession();
            tx = session.beginTransaction();

            session.delete(juego);

            session.flush();
            tx.commit();

            log.info("DAOJuegos:" + metodo + ": Juego " + juego.getNombre() + " BORRADO");

        } catch (org.hibernate.HibernateException he) {
            tx.rollback();
            log.error("DAOJuegos:" + metodo + ": Error de Hibernate: " + he.getMessage());
        } catch (SQLException sqle) {
            tx.rollback();
            log.error("DAOJuegos:" + metodo + ": Error SQLException: " + sqle.getMessage());
        } catch (Exception e) {
            tx.rollback();
            log.error("DAOJuegos:" + metodo + ": Error Exception: " + e.getMessage());
        } finally {
            // Liberamos sesión
            HibernateUtil.closeSession();
            log.info("DAOJuegos:" + metodo + ":Sesion liberada. Finished");
        }
    }
}
