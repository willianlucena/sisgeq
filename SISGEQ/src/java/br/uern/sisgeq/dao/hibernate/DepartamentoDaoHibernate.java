package br.uern.sisgeq.dao.hibernate;

import br.uern.sisgeq.dao.DepartamentoDao;
import br.uern.sisgeq.model.Campus;
import br.uern.sisgeq.model.Departamento;
import br.uern.sisgeq.model.Nucleo;
import br.uern.sisgeq.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

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
        //String query = "from Departamento as d where d.nucleo.id in (select n.id from Nucleo as n where n.campus = :campus)";
        //Session session = HibernateUtil.getSessionFactory().openSession();
        //return session.createSQLQuery(query).setParameter("campus", campus).list();
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        List lista = session.createQuery("select d from Departamento as d where d.ativo = :ativo and d.nucleo in (select n.id from Nucleo as n where n.campus = :campus)")
                .setParameter("ativo", true)
                .setParameter("campus", campus)
                .list();
        t.commit();
        session.close();
        return lista;

    }

    public List<Departamento> getDepartamentosByNucleo(Nucleo nucleo) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        return session.createSQLQuery("from Departamento as d where d.nucleo = :nucleo").setParameter("nucleo", nucleo).list();
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
}
