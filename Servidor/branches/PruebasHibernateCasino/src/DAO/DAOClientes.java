/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Beans.Clientes;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
            
            log.info("DAOClientes:insertarNuevoCliente: cliente "+cliente.getNombre()+" insertado OK");
            res=true;
            
        } catch (org.hibernate.HibernateException he) {

            tx.rollback();
            log.error("DAOClientes:insertarNuevoCliente: Error de Hibernate: " + he.getMessage());

        } catch (SQLException sqle) {
            tx.rollback();
            log.error("DAOClientes:insertarNuevoCliente:Error SQLException: " + sqle.getMessage());

        } catch (Exception e) {
            tx.rollback();
            log.error("DAOClientes:insertarNuevoCliente:Error Exception: " + e.getMessage());

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

        ArrayList lista = new ArrayList();

        Session session = null;
        Transaction tx = null;

        try {
            session = HibernateUtil.currentSession();
            tx = session.beginTransaction();

            //guardamos
            List list=session.createQuery("from Clientes").list();
            lista=(ArrayList)list;

            
            session.flush();            
            tx.commit();
            
            log.info("DAOClientes:getClientes: Se obtienen "+lista.size()+" clientes");
            
            
        } catch (org.hibernate.HibernateException he) {

            tx.rollback();
            log.error("DAOClientes:getClientes: Error de Hibernate: " + he.getMessage());

        } catch (SQLException sqle) {
            tx.rollback();
            log.error("DAOClientes:getClientes:Error SQLException: " + sqle.getMessage());

        } catch (Exception e) {
            tx.rollback();
            log.error("DAOClientes:getClientes:Error Exception: " + e.getMessage());

        } finally {
            // Liberamos sesión
            HibernateUtil.closeSession();
            log.info("DAOClientes:insertarNuevoCliente:Sesion liberada. Finished");

        }

        return lista;
    }
}
