/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Beans.Clientes;
import java.sql.SQLException;
import java.util.ArrayList;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class DAOClientes {

    //log4j
    static Logger log = Logger.getLogger(DAOClientes.class);

    /**
     * Inserta un nuevo cliente
     * @param cliente
     * @return resultado de la operacion
     */
    public boolean insertarNuevoCliente(Clientes cliente) {

        String metodo="insertarNuevoCliente";
        boolean res = false;

        Session session = null;
        Transaction tx = null;

        try {
            session = HibernateUtil.currentSession();
            tx = session.beginTransaction();

            //guardamos
            session.save(cliente);
            
            session.flush();
            tx.commit();

            log.info("DAOClientes:"+metodo+": cliente " + cliente.getNombre() + " insertado OK");
            res = true;

        } catch (org.hibernate.HibernateException he) {
            tx.rollback();
            log.error("DAOClientes:"+metodo+": Error de Hibernate: " + he.getMessage());
        } catch (SQLException sqle) {
            tx.rollback();
            log.error("DAOClientes:"+metodo+": Error SQLException: " + sqle.getMessage());
        } catch (Exception e) {
            tx.rollback();
            log.error("DAOClientes:"+metodo+": Error Exception: " + e.getMessage());
        } finally {
            // Liberamos sesión
            HibernateUtil.closeSession();
            log.info("DAOClientes:insertarNuevoCliente:Sesion liberada. Finished");
        }

        return res;
    }

    /**
     * Devuelve todos los clientes que hay registrados en el casino
     * @return
     */
    public ArrayList getClientes() {

        String metodo="getClientes";
        ArrayList lista = new ArrayList();
        Session session = null;
        Transaction tx = null;

        try {
            session = HibernateUtil.currentSession();
            tx = session.beginTransaction();
            
            lista = (ArrayList)session.createQuery("from Clientes").list();
            
            session.flush();
            tx.commit();

            log.info("DAOClientes:"+metodo+": Se obtienen " + lista.size() + " clientes");

        } catch (org.hibernate.HibernateException he) {
            tx.rollback();
            log.error("DAOClientes:"+metodo+": Error de Hibernate: " + he.getMessage());
        } catch (SQLException sqle) {
            tx.rollback();
            log.error("DAOClientes:"+metodo+":Error SQLException: " + sqle.getMessage());
        } catch (Exception e) {
            tx.rollback();
            log.error("DAOClientes:"+metodo+":Error Exception: " + e.getMessage());
        } finally {
            // Liberamos sesión
            HibernateUtil.closeSession();
            log.info("DAOClientes:"+metodo+":Sesion liberada. Finished");
        }

        return lista;
    }

    /**
     * Busca un cliente en la BBDD por usuario. 
     * @param usuario nombre de usuario (login)
     * @return objeto Clientes
     */
    public Clientes getClientePorUsuario(String usuario) {

        String metodo = "getClientePorUsuario";

        Clientes cliente = null;
        Session session = null;
        Transaction tx = null;

        try {
            session = HibernateUtil.currentSession();
            tx = session.beginTransaction();

            cliente = (Clientes) session.createQuery("from Clientes c where c.usuario= ?").setString(0, usuario).uniqueResult();

            session.flush();
            tx.commit();

            log.info("DAOClientes:" + metodo + ": Jugador obtenido con CODIGO: " + cliente.getCodigo());

        } catch (org.hibernate.HibernateException he) {
            tx.rollback();
            log.error("DAOClientes:" + metodo + ": Error de Hibernate: " + he.getMessage());
        } catch (SQLException sqle) {
            tx.rollback();
            log.error("DAOClientes:" + metodo + ":Error SQLException: " + sqle.getMessage());
        } catch (Exception e) {
            tx.rollback();
            log.error("DAOClientes:" + metodo + ":Error Exception: " + e.getMessage());
        } finally {
            // Liberamos sesión
            HibernateUtil.closeSession();
            log.info("DAOClientes:" + metodo + ":Sesion liberada. Finished");
        }

        return cliente;
    }

    /**
     * Borra un cliente
     * @param cliente cliente que se quiere borrar
     * @return resultado de la operación
     */
    public void borrarCliente(Clientes cliente) {

        String metodo = "borrarCliente";

        Session session = null;
        Transaction tx = null;

        try {
            session = HibernateUtil.currentSession();
            tx = session.beginTransaction();

            session.delete(cliente);

            session.flush();
            tx.commit();

            log.info("DAOClientes:" + metodo + ":Cliente con usuario" + cliente.getUsuario() + " BORRADO");

        } catch (org.hibernate.HibernateException he) {
            tx.rollback();
            log.error("DAOClientes:" + metodo + ": Error de Hibernate: " + he.getMessage());
        } catch (SQLException sqle) {
            tx.rollback();
            log.error("DAOClientes:" + metodo + ":Error SQLException: " + sqle.getMessage());
        } catch (Exception e) {
            tx.rollback();
            log.error("DAOClientes:" + metodo + ":Error Exception: " + e.getMessage());
        } finally {
            // Liberamos sesión
            HibernateUtil.closeSession();
            log.info("DAOClientes:getClientePorUsuario:Sesion liberada. Finished");
        }

    }

    /**
     * Modifica un cliente
     * 
     * @param cliente objeto ya modificado localmente
     */
    public void modificarCliente(Clientes cliente) {

        String metodo = "modificarCliente";

        Session session = null;
        Transaction tx = null;

        try {
            session = HibernateUtil.currentSession();
            tx = session.beginTransaction();

            session.update(cliente);

            session.flush();
            tx.commit();

            log.info("DAOClientes:" + metodo + ":Cliente con usuario" + cliente.getUsuario() + " MODIFICADO");

        } catch (org.hibernate.HibernateException he) {
            tx.rollback();
            log.error("DAOClientes:" + metodo + ": Error de Hibernate: " + he.getMessage());
        } catch (SQLException sqle) {
            tx.rollback();
            log.error("DAOClientes:" + metodo + ":Error SQLException: " + sqle.getMessage());
        } catch (Exception e) {
            tx.rollback();
            log.error("DAOClientes:" + metodo + ":Error Exception: " + e.getMessage());
        } finally {
            // Liberamos sesión
            HibernateUtil.closeSession();
            log.info("DAOClientes:getClientePorUsuario:Sesion liberada. Finished");
        }

    }
}
