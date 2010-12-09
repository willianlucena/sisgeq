package br.uern.sisgeq.dao.hibernate;

import br.uern.sisgeq.dao.CampusDao;
import br.uern.sisgeq.model.Campus;
import br.uern.sisgeq.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author willian
 */
public class CampusDaoHibernate implements CampusDao {

    public Campus getCampus(Integer id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        return (Campus) session.load(Campus.class, id);
    }

    public List<Campus> getCampi() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        List lista = session.createQuery("from Campus").list();
        t.commit();
        session.close();
        return lista;
    }

    public void save(Campus campus) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.save(campus);
        t.commit();
        session.close();
    }

    public void update(Campus campus) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.update(campus);
        t.commit();
        session.close();
    }

    public void remove(Campus campus) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.delete(campus);
        t.commit();
        session.close();
    }
}
