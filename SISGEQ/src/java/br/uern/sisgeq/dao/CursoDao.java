package br.uern.sisgeq.dao;

import br.uern.sisgeq.model.Campus;
import br.uern.sisgeq.model.Curso;
import br.uern.sisgeq.model.Departamento;
import br.uern.sisgeq.model.Nucleo;
import java.util.List;

/**
 *
 * @author rafael
 */
public interface CursoDao extends DAO {

    public Curso getCurso(Integer id);

    public List<Curso> getCursos(Boolean ativo);

    public List<Curso> getCursosByDepartamento(Departamento departamento);

    public List<Curso> getCursosByCampus(Campus campus);

    public List<Curso> getCursosByNucleo(Nucleo nucleo);

    public List<Curso> getCursos(int inicio, int numeroResultados);

    public void save(Curso curso);

    public void update(Curso curso);

    public void remove(Curso curso);
}
