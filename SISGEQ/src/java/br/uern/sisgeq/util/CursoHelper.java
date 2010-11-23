package br.uern.sisgeq.util;

import javax.management.Query;
import org.hibernate.Session;

/**
 *
 * @author rafael
 */
public class CursoHelper {

    Session session = null;

    public CursoHelper() {
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }

    public Curso getCursoById(Integer id) {
        Curso curso = null;

        org.hibernate.Transaction tx = session.beginTransaction();
        

        return curso;
    }
}
