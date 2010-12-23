package br.uern.sisgeq.controller;

import br.uern.sisgeq.dao.PessoaDao;
import br.uern.sisgeq.dao.hibernate.PessoaDaoHibernate;
import br.uern.sisgeq.model.Pessoa;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

/**
 *
 * @author Felipe Lemos
 */
@ManagedBean
@SessionScoped
public class PessoaController {

    private Pessoa pessoa;
    private DataModel listaPessoas;

    public DataModel getListarPessoas() {
        List<Pessoa> lista = new PessoaDaoHibernate().list();
        listaPessoas = new ListDataModel(lista);
        return listaPessoas;
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
