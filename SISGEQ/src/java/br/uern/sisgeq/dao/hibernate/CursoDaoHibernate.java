package br.uern.sisgeq.dao.hibernate;

import br.uern.sisgeq.dao.CursoDao;
import br.uern.sisgeq.model.Campus;
import br.uern.sisgeq.model.Curso;
import br.uern.sisgeq.model.Departamento;
import br.uern.sisgeq.model.Nucleo;
import java.util.List;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 *
 * @author rafael
 */
public class CursoDaoHibernate extends HibernateDaoSupport implements CursoDao {

    public Curso getCurso(Integer id) {
        return (Curso) getHibernateTemplate().get(Curso.class, id);
    }

    public List<Curso> getCursos() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List<Curso> getCursosByDepartamento(Departamento departamento) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List<Curso> getCursosByCampus(Campus campus) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List<Curso> getCursosByNucleo(Nucleo nucleo) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void saveOrUpdateCurso(Curso curso) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void removeCurso(Curso curso) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List<Curso> getCursos(int inicio, int fim) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
