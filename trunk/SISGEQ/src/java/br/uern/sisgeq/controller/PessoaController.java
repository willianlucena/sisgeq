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
    private DataModel dataModelPessoas = getListarPessoas();
    private String matricula;
    private String nome;
    private String curso;
    private String departamento;

    public DataModel getListarPessoas() {
        List<Pessoa> lista = new PessoaDaoHibernate().list(true);
        dataModelPessoas = new ListDataModel(lista);
        return dataModelPessoas;
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
        pessoa = (Pessoa) (dataModelPessoas.getRowData());
    }

    public void prepararFiltrarPessoa(ActionEvent actionEvent) {
        matricula = nome = curso = departamento = null;
    }

    public String excluirPessoa() {
        Pessoa pessoaTemp = (Pessoa) (dataModelPessoas.getRowData());
        PessoaDao dao = new PessoaDaoHibernate();
        dao.remove(pessoaTemp);
        dataModelPessoas = getListarPessoas();
        return "pessoa";
    }

    public void adicionarPessoa(ActionEvent actionEvent) {
        PessoaDao dao = new PessoaDaoHibernate();
        pessoa.setAtivo(Boolean.TRUE);
        dao.save(pessoa);
        dataModelPessoas = getListarPessoas();
    }

    public void alterarPessoa(ActionEvent actionEvent) {
        PessoaDao dao = new PessoaDaoHibernate();
        dao.update(pessoa);
        dataModelPessoas = getListarPessoas();
    }

    public void filtrarPessoa(ActionEvent actionEvent){
        List<Pessoa> lista = new PessoaDaoHibernate().getPessoasComFiltros(matricula, nome, curso, departamento);
        for (Pessoa p : lista) {
            System.out.println(p.getNome());
            System.out.println(p.getMatricula());
        }
        dataModelPessoas = new ListDataModel(lista);
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public DataModel getDataModelPessoas() {
        return dataModelPessoas;
    }

    public void setDataModelPessoas(DataModel dataModelPessoas) {
        this.dataModelPessoas = dataModelPessoas;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
