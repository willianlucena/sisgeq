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
import org.hibernate.criterion.Restrictions;

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

    public List<Curso> getCursosComFiltros(String codigo, String nome, String departamento) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        Criteria criteria = session.createCriteria(Curso.class);
        criteria.add(Restrictions.eq("ativo", true));

        if (codigo != null && codigo.length() > 1) {
            System.out.println("add codigo no criteria");
            System.out.println("codigo " + codigo);
            criteria.add(Restrictions.ilike("codigo", codigo + "%"));
        }

        if (nome != null && nome.length() > 1) {
            System.out.println("add nome no criteria");
            System.out.println("nome: " + nome);
            criteria.add(Restrictions.ilike("nome", nome + "%"));
        }

        if (departamento != null && departamento.length() > 1) {
            System.out.println("add departamento no criteria");
            System.out.println("departamento: " + departamento);
            //cria um novo criteria para acessar o campo departamento de curso
            criteria.createCriteria("departamento").add(Restrictions.ilike("nome", departamento + "%"));
        }
        
        List lista = criteria.list();
        t.commit();
        session.close();
        return lista;
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
