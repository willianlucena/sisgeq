package br.uern.sisgeq.dao;

import br.uern.sisgeq.model.Disciplina;
import java.util.List;

/**
 *
 * @author Felipe Lemos
 */
public interface DisciplinaDao extends DAO {

    public void save(Disciplina disciplina);

    public Disciplina getDisciplina(Integer id);

    public List<Disciplina> list();

    public void remove(Disciplina disciplina);

    public void update(Disciplina disciplina);
}
