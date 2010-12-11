/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uern.sisgeq.dao;

import br.uern.sisgeq.model.Pessoa;
import java.util.List;

/**
 *
 * @author pepeto
 */
public interface PessoaDao {

    public Pessoa getPessoa(Integer id);

    public List<Pessoa> getPessoas();

    public void save(Pessoa pessoa);

    public void update(Pessoa pessoa);

    public void remove(Pessoa pessoa);
}
