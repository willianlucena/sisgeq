package br.uern.sisgeq.dao;

import br.uern.sisgeq.model.Pessoa;
import java.util.List;

/**
 *
 * @author Felipe Lemos
 */
public interface PessoaDao {

    public void save(Pessoa pessoa);

    public Pessoa getPessoa(long id);

    public List<Pessoa> list(Boolean ativo);

    public void remove(Pessoa pessoa);

    public void update(Pessoa pessoa);
}
