package br.uern.sisgeq.dao.hibernate;

import br.uern.sisgeq.dao.NucleoDao;
import br.uern.sisgeq.model.Campus;
import br.uern.sisgeq.model.Nucleo;
import br.uern.sisgeq.util.HibernateUtil;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author willian
 */
public class NucleoDaoHibernate implements NucleoDao {

    public Nucleo getNucleo(Integer id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        return (Nucleo) session.load(Nucleo.class, id);
    }

    public List<Nucleo> getNucleos(Boolean ativo) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        List lista = session.createQuery("from Nucleo where ativo = :ativo")
                .setParameter("ativo", ativo)
                .list();
        t.commit();
        session.close();
        return lista;
    }

    public List<Nucleo> getNucleosByCampus(Campus campus) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        return session.createSQLQuery("from Nucleo as n where n.campus.id = :campus").setParameter("campus", campus.getId()).list();
    }

    public List<Nucleo> getNucleoComFiltros(String nome, String campus) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        Criteria criteria = session.createCriteria(Nucleo.class);
        criteria.add(Restrictions.eq("ativo", true));

        if (nome != null && nome.length() > 1) {
            System.out.println("add nome no criteria");
            System.out.println("nome: " + nome);
            criteria.add(Restrictions.ilike("nome", nome + "%"));
        }

        if (campus != null) {
            System.out.println("add campus no criteria");
            System.out.println("campus: " + campus);
            //acessando o campo campus de nucleo
            criteria.createCriteria("campus").add(Restrictions.ilike("nome", campus + "%"));
        }

        List lista = criteria.list();
        t.commit();
        session.close();
        return lista;
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
