package br.uern.sisgeq.dao.hibernate;

import br.uern.sisgeq.dao.CursoDao;
import br.uern.sisgeq.model.Campus;
import br.uern.sisgeq.model.Curso;
import br.uern.sisgeq.model.Departamento;
import br.uern.sisgeq.model.Nucleo;
import java.util.List;

/**
 *
 * @author rafael
 */
public class CursoDaoHibernate implements CursoDao {

    public Curso getCurso(Integer id) {
        return null;//(Curso) getHibernateTemplate().get(Curso.class, id);
    }

    public List<Curso> getCursos() {
        return null;//getHibernateTemplate().find("from Curso");
    }

    public List<Curso> getCursos(int inicio, int numeroResultados) {
//        Criteria criteria =  getHibernateTemplate().getSessionFactory().getCurrentSession().createCriteria(Curso.class);
//        criteria.setFirstResult(inicio);
//        criteria.setMaxResults(numeroResultados);
        return null;//criteria.list();
    }

    public List<Curso> getCursosByDepartamento(Departamento departamento) {
        return null;//getHibernateTemplate().find("from Curso as d where d.departamento.id = ?", departamento.getId());
    }

    public List<Curso> getCursosByCampus(Campus campus) {
        String query = "select d from Curso as c where c.departamento.id in (select d.id from Departamento as d where d.nucleo.id in (select d.id from Nucleo as n where n.campus.id = :campus))";
        return null;//getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery(query).setParameter("campus", campus.getId()).list();
    }

    public List<Curso> getCursosByNucleo(Nucleo nucleo) {
        String query = "select d from Curso as c where c.departamento.id in (select d.id from Departamento as d where d.nucleo.id = :nucleo)";
        return null;//getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery(query).setParameter("nucleo", nucleo.getId()).list();
    }

    public void saveOrUpdateCurso(Curso curso) {
       // getHibernateTemplate().saveOrUpdate(curso);
    }

    public void removeCurso(Curso curso) {
        //getHibernateTemplate().delete(curso);
    }
}
