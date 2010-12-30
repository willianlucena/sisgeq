package br.uern.sisgeq.controller;

import br.uern.sisgeq.dao.PessoaDao;
import br.uern.sisgeq.dao.hibernate.PessoaDaoHibernate;
import br.uern.sisgeq.model.Pessoa;
import java.io.Serializable;
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
public class PessoaController implements Serializable {

    private Pessoa pessoa;
    private DataModel dataModelPessoas = getListarPessoas();
    private String matricula;
    private String nome;
    private String curso;
    private String departamento;
    private String cidade;
    private String estado;
    private String naturalidade;
    private String nacionalidade;

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
        matricula = nome = curso = departamento = cidade = estado = nacionalidade = naturalidade = null;
    }

    public void prepararExcluirPessoa(ActionEvent actionEvent) {
        pessoa = (Pessoa) (dataModelPessoas.getRowData());
    }

    public String excluirPessoa() {
        //Pessoa pessoaTemp = (Pessoa) (dataModelPessoas.getRowData());
        PessoaDao dao = new PessoaDaoHibernate();
        dao.remove(pessoa);
        dataModelPessoas = getListarPessoas();
        return "pessoa";
    }

    public void adicionarPessoa(ActionEvent actionEvent) {
        System.out.println("entrou no save");
        PessoaDao dao = new PessoaDaoHibernate();
        System.out.println("criou novo objeto dao");
        pessoa.setAtivo(Boolean.TRUE);
        System.out.println("setou ativ comom true");
        dao.save(pessoa);
        System.out.println("salvou pessoa");
        dataModelPessoas = getListarPessoas();
        System.out.println("listou tudo novamente");
    }

    public void alterarPessoa(ActionEvent actionEvent) {
        PessoaDao dao = new PessoaDaoHibernate();
        dao.update(pessoa);
        dataModelPessoas = getListarPessoas();
    }

    public void filtrarPessoa(ActionEvent actionEvent) {
        List<Pessoa> lista = new PessoaDaoHibernate().getPessoasComFiltros(matricula, nome, curso, departamento, cidade, estado, naturalidade, nacionalidade);
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

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public String getNaturalidade() {
        return naturalidade;
    }

    public void setNaturalidade(String naturalidade) {
        this.naturalidade = naturalidade;
    }
}
