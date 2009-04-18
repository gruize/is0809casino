/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bbdd.DAO;

import bbdd.beans.Juegos;
import java.sql.SQLException;
import java.util.ArrayList;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Ambrin Chaudhary y Joaquin Lopez
 */
public class DAOJuegos {

    //log4j
    static Logger log = Logger.getLogger(DAOClientes.class);
   

    /** Contructora por defecto */
    public DAOJuegos() {
      
    }


    /**
     * Inserta un nuevo juego
     * @param juego
     * @return resultado de la operacion
     */
    public boolean insertarNuevoJuego(Juegos juego) {

        String metodo="insertarNuevoJuego";
        boolean res = false;

        Session session = null;
        Transaction tx = null;

        try {
            session = HibernateUtil.currentSession();
            tx = session.beginTransaction();

            //guardamos
            session.save(juego);

            session.flush();
            tx.commit();

            log.info("DAOJuegos: "+metodo+": Juego " + juego.getNombre() + " INSERTADO OK");
            res = true;

        } catch (org.hibernate.HibernateException he) {
            tx.rollback();
            log.error("DAOJuegos: "+metodo+": Error de Hibernate: " + he.getMessage());
        } catch (SQLException sqle) {
            tx.rollback();
            log.error("DAOJuegos: "+metodo+": Error SQLException: " + sqle.getMessage());
        } catch (Exception e) {
            tx.rollback();
            log.error("DAOJuegos: "+metodo+": Error Exception: " + e.getMessage());
        } finally {
            // Liberamos sesión
            HibernateUtil.closeSession();
            log.info("DAOJuegos: "+metodo+": Sesion liberada. Finished");
        }

        return res;
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

            log.info("DAOJuegos: " + metodo + ": Se obtienen " + lista.size() + " juegos");

        } catch (org.hibernate.HibernateException he) {
            tx.rollback();
            log.error("DAOJuegos: " + metodo + ": Error de Hibernate: " + he.getMessage());
        } catch (SQLException sqle) {
            tx.rollback();
            log.error("DAOJuegos: " + metodo + ": Error SQLException: " + sqle.getMessage());
        } catch (Exception e) {
            tx.rollback();
            log.error("DAOJuegos: " + metodo + ": Error Exception: " + e.getMessage());
        } finally {
            // Liberamos sesión
            HibernateUtil.closeSession();
            log.info("DAOJuegos: " + metodo + ": Sesion liberada. Finished");
        }

        return lista;
    }

    /**
     * Busca un juego en la BBDD por codigo.
     * @param codigo codigo del juego
     * @return objeto Juegos
     */
    public Juegos getJuegoPorCodigo(int codigo) {

        String metodo = "getJuegoPorCodigo";

        Juegos juego = null;
        Session session = null;
        Transaction tx = null;

        try {
            session = HibernateUtil.currentSession();
            tx = session.beginTransaction();

            juego = (Juegos) session.createQuery("from Juegos j where j.codigo= ?").setString(0, ""+codigo).uniqueResult();

            session.flush();
            tx.commit();

            log.info("DAOJuegos: " + metodo + ": Juego obtenido con CODIGO: " + juego.getCodigo());

        } catch (org.hibernate.HibernateException he) {
            tx.rollback();
            log.error("DAOJuegos: " + metodo + ": Error de Hibernate: " + he.getMessage());
        } catch (SQLException sqle) {
            tx.rollback();
            log.error("DAOJuegos: " + metodo + ": Error SQLException: " + sqle.getMessage());
        } catch (Exception e) {
            tx.rollback();
            log.error("DAOJuegos: " + metodo + ": Error Exception: " + e.getMessage());
        } finally {
            // Liberamos sesión
            HibernateUtil.closeSession();
            log.info("DAOJuegos: " + metodo + ": Sesion liberada. Finished");
        }

        return juego;
    }

    /**
     * Busca un juego en la BBDD por nombre.
     * @param nombre nombre del juego
     * @return objeto Juegos
     */
    public Juegos getJuegoPorNombre(String nombre) {

        String metodo = "getJuegoPorNombre";

        Juegos juego = null;
        Session session = null;
        Transaction tx = null;

        try {
            session = HibernateUtil.currentSession();
            tx = session.beginTransaction();

            juego = (Juegos) session.createQuery("from Juegos j where j.nombre= ?").setString(0, nombre).uniqueResult();

            session.flush();
            tx.commit();

            log.info("DAOJuegos: " + metodo + ": Jugador obtenido con NOMBRE: " + juego.getNombre());

        } catch (org.hibernate.HibernateException he) {
            tx.rollback();
            log.error("DAOJuegos: " + metodo + ": Error de Hibernate: " + he.getMessage());
        } catch (SQLException sqle) {
            tx.rollback();
            log.error("DAOJuegos: " + metodo + ": Error SQLException: " + sqle.getMessage());
        } catch (Exception e) {
            tx.rollback();
            log.error("DAOJuegos: " + metodo + ": Error Exception: " + e.getMessage());
        } finally {
            // Liberamos sesión
            HibernateUtil.closeSession();
            log.info("DAOJuegos: " + metodo + ": Sesion liberada. Finished");
        }

        return juego;
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

            log.info("DAOJuegos: " + metodo + ": Juego " + juego.getNombre() + " MODIFICADO");

        } catch (org.hibernate.HibernateException he) {
            tx.rollback();
            log.error("DAOJuegos: " + metodo + ": Error de Hibernate: " + he.getMessage());
        } catch (SQLException sqle) {
            tx.rollback();
            log.error("DAOJuegos: " + metodo + ": Error SQLException: " + sqle.getMessage());
        } catch (Exception e) {
            tx.rollback();
            log.error("DAOJuegos: " + metodo + ": Error Exception: " + e.getMessage());
        } finally {
            // Liberamos sesión
            HibernateUtil.closeSession();
            log.info("DAOJuegos: " + metodo + ": Sesion liberada. Finished");
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

            log.info("DAOJuegos: " + metodo + ": Juego " + juego.getNombre() + " BORRADO");

        } catch (org.hibernate.HibernateException he) {
            tx.rollback();
            log.error("DAOJuegos: " + metodo + ": Error de Hibernate: " + he.getMessage());
        } catch (SQLException sqle) {
            tx.rollback();
            log.error("DAOJuegos: " + metodo + ": Error SQLException: " + sqle.getMessage());
        } catch (Exception e) {
            tx.rollback();
            log.error("DAOJuegos: " + metodo + ": Error Exception: " + e.getMessage());
        } finally {
            // Liberamos sesión
            HibernateUtil.closeSession();
            log.info("DAOJuegos: " + metodo + ": Sesion liberada. Finished");
        }
    }
}
