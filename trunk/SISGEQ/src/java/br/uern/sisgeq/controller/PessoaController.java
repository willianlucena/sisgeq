package br.uern.sisgeq.controller;

import br.uern.sisgeq.dao.PessoaDao;
import br.uern.sisgeq.dao.hibernate.PessoaDaoHibernate;
import br.uern.sisgeq.model.Pessoa;
import java.awt.event.ActionEvent;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.DataModel;

/**
 *
 * @author pepeto
 */
@ManagedBean
@RequestScoped
public class PessoaController implements Serializable {

    private Pessoa pessoa;
    private DataModel listaPessoas;

    public DataModel getListaPessoa() {
        return listaPessoas;
    }

    public void setListaPessoa(DataModel listaPessoa) {
        this.listaPessoas = listaPessoa;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public void prepararAdicionarPessoa(ActionEvent actionEvent) {
        pessoa = new Pessoa();
    }

    public void prepararAlterarPessoa(ActionEvent actionEvent) {
        pessoa = (Pessoa) (listaPessoas.getRowData());
    }

    public String excluirPessoa() {
        Pessoa pessoaTemp = (Pessoa) (listaPessoas.getRowData());
        PessoaDao dao = new PessoaDaoHibernate();
        dao.remove(pessoaTemp);
        return "pessoa";
    }

    public void adicionarPessoa(ActionEvent actionEvent) {
        PessoaDao dao = new PessoaDaoHibernate();
        dao.save(pessoa);
    }

    public void alterarPessoa(ActionEvent actionEvent) {
        PessoaDao dao = new PessoaDaoHibernate();
        dao.update(pessoa);
    }
}
