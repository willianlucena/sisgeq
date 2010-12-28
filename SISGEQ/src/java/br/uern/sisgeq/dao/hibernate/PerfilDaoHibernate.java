package br.uern.sisgeq.dao.hibernate;

import br.uern.sisgeq.dao.PerfilDao;
import br.uern.sisgeq.model.Perfil;
import br.uern.sisgeq.util.HibernateUtil;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Felipe Lemos
 */
public class PerfilDaoHibernate implements PerfilDao {

    public void save(Perfil perfil) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.save(perfil);
        t.commit();
        session.close();
    }

    public Perfil getPerfil(long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        return (Perfil) session.load(Perfil.class, id);
    }

    public List<Perfil> list() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        List lista = session.createQuery("from Perfil").list();
        t.commit();
        session.close();
        return lista;
    }

    public void remove(Perfil perfil) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.delete(perfil);
        t.commit();
        session.close();
    }

    public void update(Perfil perfil) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.update(perfil);
        t.commit();
        session.close();
    }

    public List<Perfil> getPerfisComFiltros(String tipo) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        Criteria criteria = session.createCriteria(Perfil.class);
        criteria.add(Restrictions.eq("ativo", true));
        if (tipo != null && tipo.length() > 1) {
            System.out.println("add tipo no criteria");
            System.out.println("tipo: " + tipo);
            criteria.add(Restrictions.ilike("nome", tipo + "%"));
        }

        List lista = criteria.list();
        t.commit();
        session.close();
        return lista;
    }
}
