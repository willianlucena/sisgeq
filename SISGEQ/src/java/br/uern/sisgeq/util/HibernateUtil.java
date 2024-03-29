package br.uern.sisgeq.util;

import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.SessionFactory;

/**
 * Hibernate Utility class with a convenient method to get Session Factory object.
 *
 * @author Felipe Lemos
 */
public class HibernateUtil {

    private static SessionFactory sessionFactory;

    private HibernateUtil() {
    }

    public static SessionFactory getSessionFactory() {

        if (sessionFactory == null) {
            try {
                // Create the SessionFactory from standard (hibernate.cfg.xml)
                // config file.
                AnnotationConfiguration ac = new AnnotationConfiguration();
//                ac.addAnnotatedClass(Disciplina.class);
//                ac.addAnnotatedClass(Perfil.class);
                sessionFactory = ac.configure("hibernate.cfg.xml").buildSessionFactory();
                //SchemaExport se = new SchemaExport(ac);
                //se.create(true, true);


            } catch (Throwable ex) {
                // Log the exception.
                System.err.println("Initial SessionFactory creation failed." + ex);
                throw new ExceptionInInitializerError(ex);
            }

            return sessionFactory;

        } else {
            return sessionFactory;
        }

    }

    public static void main(String[] args) {
        HibernateUtil.getSessionFactory();
    }
}
