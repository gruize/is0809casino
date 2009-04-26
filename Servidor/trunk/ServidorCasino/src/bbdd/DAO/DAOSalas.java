/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bbdd.DAO;

import bbdd.beans.Salas;
import java.sql.SQLException;
import java.util.ArrayList;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Ambrin Chaudhary y Joaquin Lopez
 */
public class DAOSalas {

    private static Logger log = Logger.getLogger(DAOClientes.class);

    /**
     * Inserta una nueva sala
     * @param sala
     * @return resultado de la operacion
     */
    public boolean insertarNuevaSala(Salas sala) {

        String metodo="insertarNuevaSala";
        boolean res = false;

        Session session = null;
        Transaction tx = null;

        try {
            session = HibernateUtil.currentSession();
            tx = session.beginTransaction();

            //guardamos
            session.save(sala);
            
            session.flush();
            tx.commit();

            log.info("DAOSalas: "+metodo+": Sala " + sala.getCodigo() + " INSERTADA OK");
            res = true;

        } catch (org.hibernate.HibernateException he) {
            tx.rollback();
            log.error("DAOSalas: "+metodo+": Error de Hibernate: " + he.getMessage());
        } catch (SQLException sqle) {
            tx.rollback();
            log.error("DAOSalas: "+metodo+": Error SQLException: " + sqle.getMessage());
        } catch (Exception e) {
            tx.rollback();
            log.error("DAOSalas: "+metodo+": Error Exception: " + e.getMessage());
        } finally {
            // Liberamos sesión
            HibernateUtil.closeSession();
            log.info("DAOSalas: "+metodo+": Sesion liberada. Finished");
        }

        return res;
    }

    /**
     * Devuelve todos las salas que hay registradas en el casino
     * @return
     */
    public ArrayList getSalas() {

        String metodo="getSalas";
        ArrayList lista = new ArrayList();
        Session session = null;
        Transaction tx = null;

        try {
            session = HibernateUtil.currentSession();
            tx = session.beginTransaction();
            
            lista = (ArrayList)session.createQuery("from Salas").list();
            
            session.flush();
            tx.commit();

            log.info("DAOSalas: "+metodo+": Se obtienen " + lista.size() + " salas");

        } catch (org.hibernate.HibernateException he) {
            tx.rollback();
            log.error("DAOSalas: "+metodo+": Error de Hibernate: " + he.getMessage());
        } catch (SQLException sqle) {
            tx.rollback();
            log.error("DAOSalas: "+metodo+": Error SQLException: " + sqle.getMessage());
        } catch (Exception e) {
            tx.rollback();
            log.error("DAOSalas: "+metodo+": Error Exception: " + e.getMessage());
        } finally {
            // Liberamos sesión
            HibernateUtil.closeSession();
            log.info("DAOSalas: "+metodo+": Sesion liberada. Finished");
        }

        return lista;
    }

    /**
     * Busca una sala en la BBDD por codigo.
     * @param codigo de la sala
     * @return objeto Salas
     */
    public Salas getSalaPorCodigo(int codigo) {

        String metodo = "getSalaPorCodigo";

        Salas sala = null;
        Session session = null;
        Transaction tx = null;
        
        try {
            session = HibernateUtil.currentSession();
            tx = session.beginTransaction();

            sala = (Salas) session.createQuery("from Salas s where s.codigo= ?").setInteger(0, codigo).uniqueResult();

            session.flush();
            tx.commit();

            log.info("DAOSalas: " + metodo + ": Sala obtenida con CODIGO: " + sala.getCodigo());

        } catch (org.hibernate.HibernateException he) {
            tx.rollback();
            log.error("DAOSalas: " + metodo + ": Error de Hibernate: " + he.getMessage());
        } catch (SQLException sqle) {
            tx.rollback();
            log.error("DAOSalas: " + metodo + ": Error SQLException: " + sqle.getMessage());
        } catch (Exception e) {
            tx.rollback();
            log.error("DAOSalas: " + metodo + ": Error Exception: " + e.getMessage());
        } finally {
            // Liberamos sesión
            HibernateUtil.closeSession();
            log.info("DAOSalas: " + metodo + ": Sesion liberada. Finished");
        }

        return sala;
    }

    /**
     * Borra una sala
     * @param sala sala que se quiere borrar
     * @return resultado de la operación
     */
    public void borrarSala(Salas sala) {

        String metodo = "borrarSala";

        Session session = null;
        Transaction tx = null;

        try {
            session = HibernateUtil.currentSession();
            tx = session.beginTransaction();

            session.delete(sala);

            session.flush();
            tx.commit();

            log.info("DAOSalas: " + metodo + ": Sala con codigo" + sala.getCodigo() + " BORRADA");

        } catch (org.hibernate.HibernateException he) {
            tx.rollback();
            log.error("DAOSalas: " + metodo + ": Error de Hibernate: " + he.getMessage());
        } catch (SQLException sqle) {
            tx.rollback();
            log.error("DAOSalas: " + metodo + ": Error SQLException: " + sqle.getMessage());
        } catch (Exception e) {
            tx.rollback();
            log.error("DAOSalas: " + metodo + ": Error Exception: " + e.getMessage());
        } finally {
            // Liberamos sesión
            HibernateUtil.closeSession();
            log.info("DAOSalas: "+metodo+": Sesion liberada. Finished");
        }

    }

    /**
     * Modifica una sala
     * 
     * @param sala objeto ya modificado localmente
     */
    public void modificarSala(Salas sala) {

        String metodo = "modificarSala";

        Session session = null;
        Transaction tx = null;

        try {
            session = HibernateUtil.currentSession();
            tx = session.beginTransaction();

            session.update(sala);

            session.flush();
            tx.commit();

            log.info("DAOSalas: " + metodo + ": Sala con codigo" + sala.getCodigo() + " MODIFICADA");

        } catch (org.hibernate.HibernateException he) {
            tx.rollback();
            log.error("DAOSalas: " + metodo + ": Error de Hibernate: " + he.getMessage());
        } catch (SQLException sqle) {
            tx.rollback();
            log.error("DAOSalas: " + metodo + ": Error SQLException: " + sqle.getMessage());
        } catch (Exception e) {
            tx.rollback();
            log.error("DAOSalas: " + metodo + ": Error Exception: " + e.getMessage());
        } finally {
            // Liberamos sesión
            HibernateUtil.closeSession();
            log.info("DAOSalas: "+metodo+": Sesion liberada. Finished");
        }

    }

}
