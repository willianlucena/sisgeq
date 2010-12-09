package br.uern.sisgeq.dao.hibernate;

import br.uern.sisgeq.dao.NucleoDao;
import br.uern.sisgeq.model.Campus;
import br.uern.sisgeq.model.Nucleo;
import br.uern.sisgeq.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author willian
 */
public class NucleoDaoHibernate implements NucleoDao {

    public Nucleo getNucleo(Integer id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        return (Nucleo) session.load(Nucleo.class, id);
    }

    public List<Nucleo> getNucleos() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        List lista = session.createQuery("from Nucleo").list();
        t.commit();
        session.close();
        return lista;
    }

    public List<Nucleo> getNucleosByCampus(Campus campus) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        return session.createSQLQuery("from Nucleo as n where n.campus.id = :campus").setParameter("campus", campus.getId()).list();
    }

    public void save(Nucleo nucleo) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.save(nucleo);
        t.commit();
        session.close();
    }

    public void update(Nucleo nucleo) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.update(nucleo);
        t.commit();
        session.close();
    }

    public void remove(Nucleo nucleo) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.delete(nucleo);
        t.commit();
        session.close();
    }
}
