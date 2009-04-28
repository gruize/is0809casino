/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bbdd.DAO;

import bbdd.beans.Mesas;
import java.sql.SQLException;
import java.util.ArrayList;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;


/**
 *
 * @author Ambrin Chaudhary y Joaquin Lopez
 */
public class DAOMesas {

    private static Logger log = Logger.getLogger(DAOMesas.class);

    /**
     * Inserta una nueva mesa
     * @param mesa
     * @return resultado de la operacion
     */
    public boolean insertarNuevaMesa(Mesas mesa) {

        String metodo="insertarNuevaMesa";
        boolean res = false;

        Session session = null;
        Transaction tx = null;

        try {
            session = HibernateUtil.currentSession();
            tx = session.beginTransaction();

            //guardamos
            session.save(mesa);
            
            session.flush();
            tx.commit();

            log.info("DAOMesas: "+metodo+": Mesa " + mesa.getCodigo() + " INSERTADA OK");
            res = true;

        } catch (org.hibernate.HibernateException he) {
            tx.rollback();
            log.error("DAOMesas: "+metodo+": Error de Hibernate: " + he.getMessage());
        } catch (SQLException sqle) {
            tx.rollback();
            log.error("DAOMesas: "+metodo+": Error SQLException: " + sqle.getMessage());
        } catch (Exception e) {
            tx.rollback();
            log.error("DAOMesas: "+metodo+": Error Exception: " + e.getMessage());
        } finally {
            // Liberamos sesión
            HibernateUtil.closeSession();
            log.info("DAOMesas: "+ metodo+": Sesion liberada. Finished");
        }

        return res;
    }

    /**
     * Devuelve todas las mesas que hay registrados en el casino
     * @return
     */
    public ArrayList getMesas() {

        String metodo="getMesas";
        ArrayList lista = new ArrayList();
        Session session = null;
        Transaction tx = null;

        try {
            session = HibernateUtil.currentSession();
            tx = session.beginTransaction();
            
            lista = (ArrayList)session.createQuery("from Mesas").list();
            
            session.flush();
            tx.commit();

            log.info("DAOMesas: "+metodo+": Se obtienen " + lista.size() + " mesas");

        } catch (org.hibernate.HibernateException he) {
            tx.rollback();
            log.error("DAOMesas: "+metodo+": Error de Hibernate: " + he.getMessage());
        } catch (SQLException sqle) {
            tx.rollback();
            log.error("DAOMesas: "+metodo+": Error SQLException: " + sqle.getMessage());
        } catch (Exception e) {
            tx.rollback();
            log.error("DAOMesas: "+metodo+": Error Exception: " + e.getMessage());
        } finally {
            // Liberamos sesión
            HibernateUtil.closeSession();
            log.info("DAOMesas: "+metodo+": Sesion liberada. Finished");
        }

        return lista;
    }

    /**
     * Busca una mesa en la BBDD por codigo.
     * @param codigo de la mesa
     * @return objeto Mesas
     */
    public Mesas getMesaPorCodigo(int codigo) {

        String metodo = "getMesaPorCodigo";

        Mesas mesa = null;
        Session session = null;
        Transaction tx = null;
        
        try {
            session = HibernateUtil.currentSession();
            tx = session.beginTransaction();

            mesa = (Mesas) session.createQuery("from Mesas m where m.codigo= ?").setString(0, ""+codigo).uniqueResult();

            session.flush();
            tx.commit();

            log.info("DAOMesas: " + metodo + ": Mesa obtenida con CODIGO: " + mesa.getCodigo());

        } catch (org.hibernate.HibernateException he) {
            tx.rollback();
            log.error("DAOMesas: " + metodo + ": Error de Hibernate: " + he.getMessage());
        } catch (SQLException sqle) {
            tx.rollback();
            log.error("DAOMesas: " + metodo + ": Error SQLException: " + sqle.getMessage());
        } catch (Exception e) {
            tx.rollback();
            log.error("DAOMesas: " + metodo + ": Error Exception: " + e.getMessage());
        } finally {
            // Liberamos sesión
            HibernateUtil.closeSession();
            log.info("DAOMesas: " + metodo + ": Sesion liberada. Finished");
        }

        return mesa;
    }

    /**
     * Borra una mesa
     * @param mesa mesa que se quiere borrar
     * @return resultado de la operación
     */
    public void borrarMesa(Mesas mesa) {

        String metodo = "borrarMesa";

        Session session = null;
        Transaction tx = null;

        try {
            session = HibernateUtil.currentSession();
            tx = session.beginTransaction();

            session.delete(mesa);

            session.flush();
            tx.commit();

            log.info("DAOMesas: " + metodo + ": Mesa con codigo" + mesa.getCodigo() + " BORRADA");

        } catch (org.hibernate.HibernateException he) {
            tx.rollback();
            log.error("DAOMesas: " + metodo + ": Error de Hibernate: " + he.getMessage());
        } catch (SQLException sqle) {
            tx.rollback();
            log.error("DAOMesas: " + metodo + ": Error SQLException: " + sqle.getMessage());
        } catch (Exception e) {
            tx.rollback();
            log.error("DAOMesas: " + metodo + ": Error Exception: " + e.getMessage());
        } finally {
            // Liberamos sesión
            HibernateUtil.closeSession();
            log.info("DAOMesas: "+metodo+": Sesion liberada. Finished");
        }

    }

    /**
     * Modifica una mesa
     * 
     * @param mesa objeto ya modificada localmente
     */
    public void modificarMesa(Mesas mesa) {

        String metodo = "modificarMesa";

        Session session = null;
        Transaction tx = null;

        try {
            session = HibernateUtil.currentSession();
            tx = session.beginTransaction();

            session.update(mesa);

            session.flush();
            tx.commit();

            log.info("DAOMesas: " + metodo + ": Mesa con codigo " + mesa.getCodigo() + " MODIFICADA");

        } catch (org.hibernate.HibernateException he) {
            tx.rollback();
            log.error("DAOMesas: " + metodo + ": Error de Hibernate: " + he.getMessage());
        } catch (SQLException sqle) {
            tx.rollback();
            log.error("DAOMesas: " + metodo + ": Error SQLException: " + sqle.getMessage());
        } catch (Exception e) {
            tx.rollback();
            log.error("DAOMesas: " + metodo + ": Error Exception: " + e.getMessage());
        } finally {
            // Liberamos sesión
            HibernateUtil.closeSession();
            log.info("DAOMesas: "+metodo+": Sesion liberada. Finished");
        }

    }

}
