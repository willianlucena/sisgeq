package br.uern.sisgeq.controller;

import br.uern.sisgeq.dao.DisciplinaDao;
import br.uern.sisgeq.dao.hibernate.DisciplinaDaoHibernate;
import br.uern.sisgeq.model.Departamento;
import br.uern.sisgeq.model.Disciplina;
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
public class DisciplinaController implements Serializable {

    private Disciplina disciplina;
    private DataModel dataModelDisciplinas = getListarDisciplinas();
    String codigo;
    String nome;
    String departamento;

    public DataModel getListarDisciplinas() {
        List<Disciplina> lista = new DisciplinaDaoHibernate().list(true);
        dataModelDisciplinas = new ListDataModel(lista);
        return dataModelDisciplinas;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public void prepararAdicionarDisciplina(ActionEvent actionEvent) {
        disciplina = new Disciplina();
        disciplina.setDepartamento(new Departamento());
    }

    public void prepararAlterarDisciplina(ActionEvent actionEvent) {
        disciplina = (Disciplina) (dataModelDisciplinas.getRowData());
    }

    public void prepararExcluirDisciplina(ActionEvent actionEvent) {
        disciplina = (Disciplina) (dataModelDisciplinas.getRowData());
    }

    public void prepararFiltrarDisciplina(ActionEvent actionEvent) {
        codigo = nome = departamento = null;
    }

    public String excluirDisciplina() {
        //Disciplina disciplinaTemp = (Disciplina) (dataModelDisciplinas.getRowData());
        DisciplinaDao dao = new DisciplinaDaoHibernate();
        dao.remove(disciplina);
        dataModelDisciplinas = getListarDisciplinas();
        return "disciplina";

    }

    public void adicionarDisciplina(ActionEvent actionEvent) {
        DisciplinaDao dao = new DisciplinaDaoHibernate();
        disciplina.setAtivo(Boolean.TRUE);
        dao.save(disciplina);
        dataModelDisciplinas = getListarDisciplinas();
    }

    public void alterarDisciplina(ActionEvent actionEvent) {
        DisciplinaDao dao = new DisciplinaDaoHibernate();
        dao.update(disciplina);
        dataModelDisciplinas = getListarDisciplinas();
    }

    public void filtrarDisciplina(ActionEvent actionEvent){
        List<Disciplina> lista = new DisciplinaDaoHibernate().getDisciplinaComFiltros(codigo, nome, departamento);
        for (Disciplina d : lista) {
            System.out.println(d.getNome());
            System.out.println(d.getCodigo());
        }
        dataModelDisciplinas = new ListDataModel(lista);
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public DataModel getDataModelDisciplinas() {
        return dataModelDisciplinas;
    }

    public void setDataModelDisciplinas(DataModel dataModelDisciplinas) {
        this.dataModelDisciplinas = dataModelDisciplinas;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
