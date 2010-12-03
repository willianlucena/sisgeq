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

    public List<Departamento> getDepartamentos() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        return session.createQuery("from Departamento").list();
    }

    public List<Departamento> getDepartamentosByCampus(Campus campus) {
        String query = "from Departamento as d where d.nucleo.id in (select n.id from Nucleo as n where n.campus.id = :campus)";
        Session session = HibernateUtil.getSessionFactory().openSession();
        return session.createSQLQuery(query).setParameter("campus", campus.getId()).list();
    }

    public List<Departamento> getDepartamentosByNucleo(Nucleo nucleo) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        return session.createSQLQuery("from Departamento as d where d.nucleo.id = :nucleo").setParameter("nucleo", nucleo.getId()).list();
    }

    public void saveOrUpdate(Departamento departamento) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.saveOrUpdate(departamento);
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
