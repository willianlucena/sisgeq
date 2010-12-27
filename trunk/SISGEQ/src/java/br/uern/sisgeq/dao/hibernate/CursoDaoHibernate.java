package br.uern.sisgeq.dao.hibernate;

import br.uern.sisgeq.dao.CursoDao;
import br.uern.sisgeq.model.Campus;
import br.uern.sisgeq.model.Curso;
import br.uern.sisgeq.model.Departamento;
import br.uern.sisgeq.model.Nucleo;
import br.uern.sisgeq.util.HibernateUtil;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author rafael
 */
public class CursoDaoHibernate implements CursoDao {

    public Curso getCurso(Integer id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        return (Curso) session.load(Curso.class, id);
    }

    public List<Curso> getCursos(Boolean ativo) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        List lista = session.createQuery("from Curso where ativo = :ativo")
                .setParameter("ativo", ativo)
                .list();
        t.commit();
        session.close();
        return lista;
    }

    public List<Curso> getCursos(int inicio, int numeroResultados) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Curso.class);
        criteria.setFirstResult(inicio);
        criteria.setMaxResults(numeroResultados);
        return criteria.list();
    }

    public List<Curso> getCursosByDepartamento(Departamento departamento) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        return session.createSQLQuery("from Curso as d where d.departamento.id = :departamento").setParameter("departamento", departamento.getId()).list();
    }

    public List<Curso> getCursosByCampus(Campus campus) {
        String query = "from Curso as c where c.departamento.id in (select d.id from Departamento as d where d.nucleo.id in (select d.id from Nucleo as n where n.campus.id = :campus))";
        Session session = HibernateUtil.getSessionFactory().openSession();
        return session.createSQLQuery(query).setParameter("campus", campus.getId()).list();
    }

    public List<Curso> getCursosByNucleo(Nucleo nucleo) {
        String query = "select d from Curso as c where c.departamento.id in (select d.id from Departamento as d where d.nucleo.id = :nucleo)";
        Session session = HibernateUtil.getSessionFactory().openSession();
        return session.createSQLQuery(query).setParameter("nucleo", nucleo.getId()).list();
    }

    public void save(Curso curso) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.save(curso);
        t.commit();
        session.close();
    }

    public void update(Curso curso) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.update(curso);
        t.commit();
        session.close();
    }

    public void remove(Curso curso) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.delete(curso);
        t.commit();
        session.close();
    }
}
