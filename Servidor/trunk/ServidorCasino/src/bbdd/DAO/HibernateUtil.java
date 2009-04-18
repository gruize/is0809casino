/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bbdd.DAO;


import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Ambrin Chaudhary y Joaquin Lopez
 */
public class HibernateUtil {

    
        //log4j
    static Logger loggerLog = Logger.getLogger(HibernateUtil.class);

    
    /**
     * Location of hibernate.cfg.xml file.
     * NOTICE: Location should be on the classpath as Hibernate uses
     * #resourceAsStream style lookup for its configuration file. That
     * is place the config file in a Java package - the default location
     * is the default Java package.<br><br>
     * Examples: <br>
     * <code>CONFIG_FILE_LOCATION = "/bbdd/configuracion/hibernate.conf.xml".
     * CONFIG_FILE_LOCATION = "/com/foo/bar/myhiberstuff.conf.xml".</code>
     */

    private static String CONFIG_FILE_LOCATION = "/bbdd/configuracion/hibernate.cfg.xml";

    /**
     * Holds a single instance of Session
     */
    private static final ThreadLocal threadLocal = new ThreadLocal();

    /**
     * The single instance of hibernate configuration
     */
    private static final Configuration cfg = new Configuration();

    /**
     * The single instance of hibernate SessionFactory
     */
    private static org.hibernate.SessionFactory sessionFactory;
    
    /**
     * Returns the ThreadLocal Session instance.  Lazy initialize
     * the <code>SessionFactory</code> if needed.
     *
     * @return Session
     * @throws Exception
     */

    public static Session currentSession() throws Exception {
       

        System.out.println( "Hibernate Util: init");
       loggerLog.info("Hibernate Util: init");

        Session session = (Session) threadLocal.get();

        try {
            if (session != null && !session.isOpen()) session = null;
            if (session == null) {
                if (sessionFactory == null) {
                    try {
                        cfg.configure(CONFIG_FILE_LOCATION);
                        sessionFactory = cfg.buildSessionFactory();
                        System.out.println("Hibernate Util: cargado el fichero hibernate.cfg.xml");

                    }
                    catch (Exception e) {
                         System.err.println("Error Creating SessionFactory: "+e.getMessage());

                   }
                }
                session = sessionFactory.openSession();
                threadLocal.set(session);
            }

            System.out.println("Hibernate Util: retornamos la session");
            return session;
        } catch (HibernateException e) {
            System.err.println("Hibernate Exception: " + e.getMessage() + "ocurrida en currentSession");
            throw new Exception("Error hibernate al conectar con BBDD", e);
        }
    }

    /**
     * Close the single hibernate session instance.
     *
     * @throws Exception
     */
    public static void closeSession() {

        Session session = (Session) threadLocal.get();
        threadLocal.set(null);
        try {
            if (session != null) {
                session.close();
            }
        } catch (HibernateException he) {
            System.err.println("Hibernate Exception: " + he.getMessage() + "ocurrida en closeSession");

        }
    }

    /**
     * Default constructor.
     */
    private HibernateUtil() {
    }

}

