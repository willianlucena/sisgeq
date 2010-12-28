package br.uern.sisgeq.dao.hibernate;

import br.uern.sisgeq.dao.DepartamentoDao;
import br.uern.sisgeq.model.Campus;
import br.uern.sisgeq.model.Departamento;
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
public class DepartamentoDaoHibernate implements DepartamentoDao {

    public Departamento getDepartamento(Integer id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        return (Departamento) session.load(Departamento.class, id);
    }

    public List<Departamento> getDepartamentos(Boolean ativo) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        List lista = session.createQuery("from Departamento where ativo = :ativo")
                .setParameter("ativo", ativo)
                .list();
        t.commit();
        session.close();
        return lista;
    }

    public List<Departamento> getDepartamentosByCampus(Campus campus) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        List lista = session.createQuery("select d from Departamento as d where "
                + "d.ativo = :ativo and d.nucleo in (select n.id from Nucleo as"
                + " n where n.campus = :campus)")
                .setParameter("ativo", true)
                .setParameter("campus", campus)
                .list();
        t.commit();
        session.close();
        return lista;

    }

    public List<Departamento> getDepartamentosByNucleo(Nucleo nucleo) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        return session.createSQLQuery("from Departamento as d where d.nucleo = :nucleo")
                .setParameter("nucleo", nucleo)
                .list();
    }

    public void save(Departamento departamento) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.save(departamento);
        t.commit();
        session.close();
    }

    public void update(Departamento departamento) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.update(departamento);
        t.commit();
        session.close();
    }

    public void remove(Departamento departamento) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.delete(departamento);
        t.commit();
        session.close();
    }

    public List<Departamento> getDepartamentosComFiltros(String nome, String area, String nucleo, String campus) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        Criteria criteria = session.createCriteria(Departamento.class);
        criteria.add(Restrictions.eq("ativo", true));
        if (nome != null && nome.length() > 1) {
            System.out.println("add nome no criteria");
            System.out.println("nome: " + nome);
            criteria.add(Restrictions.ilike("nome", nome + "%"));
        }
        if (area != null && area.length() > 1) {
            System.out.println("add area no criteria");
            System.out.println("area: " + area);
            criteria.add(Restrictions.ilike("area", area + "%"));
        }
        if (nucleo != null && nucleo.length() > 1) {
            System.out.println("add nucleo no criteria");
            System.out.println("nucleo: " + nucleo);
            //cria um novo criteria para acessar o campo nucleo de departamento
            criteria.createCriteria("nucleo").add(Restrictions.ilike("nome", nucleo + "%"));
        }
        if (campus != null && campus.length() > 1) {
            System.out.println("add campus no criteria");
            System.out.println("campus: " + campus);
            //acessando o campo campus de nucleo
            criteria.createCriteria("nucleo.campus").add(Restrictions.ilike("nome", campus + "%"));
        }
        List lista = criteria.list();
        t.commit();
        session.close();
        return lista;
    }
}
