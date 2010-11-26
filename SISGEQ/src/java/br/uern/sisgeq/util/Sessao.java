package br.uern.sisgeq.util;

import org.hibernate.Session;

/**
 *
 * @author rafael
 */
public class Sessao {

    private Session session;

    public Sessao() {
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }
}
