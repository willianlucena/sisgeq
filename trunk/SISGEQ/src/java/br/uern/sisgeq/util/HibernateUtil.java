package br.uern.sisgeq.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hibernate Utility class with a convenient method to get Session Factory object.
 *
 * @author willian
 */
public class HibernateUtil {

    private static final SessionFactory sessionFactory;
    private static final ThreadLocal threadlocal = new ThreadLocal();

    static {
        try {
            // Create the SessionFactory from standard (hibernate.cfg.xml) 
            // config file.
            sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        } catch (Throwable ex) {
            // Log the exception. 
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        Session session = (Session) threadlocal.get();
        session = sessionFactory.openSession();
        threadlocal.set(session);
        return (SessionFactory) session;
    }
}
