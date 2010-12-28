package br.uern.sisgeq.dao;

import br.uern.sisgeq.model.Disciplina;
import java.util.List;

/**
 *
 * @author Felipe Lemos
 */
public interface DisciplinaDao {

    public void save(Disciplina disciplina);

    public Disciplina getDisciplina(long id);

    public List<Disciplina> list(Boolean ativo);

    public List<Disciplina> getDisciplinaComFiltros(String codigo, String nome, String departamento);

    public void remove(Disciplina disciplina);

    public void update(Disciplina disciplina);
}
