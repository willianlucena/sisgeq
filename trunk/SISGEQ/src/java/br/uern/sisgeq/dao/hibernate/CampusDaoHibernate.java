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
        return session.createQuery("from Campus").list();
    }

    public void saveOrUpdate(Campus Campus) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.saveOrUpdate(Campus);
        t.commit();
    }

    public void remove(Campus Campus) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.delete(Campus);
        t.commit();
    }
}
