/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uern.sisgeq.controller;

import br.uern.sisgeq.dao.DisciplinaDao;
import br.uern.sisgeq.model.Disciplina;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.event.ActionEvent;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

/**
 *
 * @author rafael
 */
@ManagedBean
@SessionScoped
public class DisciplinaMB {

    private Disciplina disciplina;
    private DataModel listaDisciplinas;
    private DisciplinaDao disciplinaDao;

    public DisciplinaMB() {
    }

    public DataModel getListarDisciplinas() {
        List<Disciplina> lista = disciplinaDao.list();
        listaDisciplinas = new ListDataModel(lista);
        return listaDisciplinas;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public void prepararAdicionarDisciplina(ActionEvent actionEvent) {
        disciplina = new Disciplina();
    }

    public void prepararAlterarDisciplina(ActionEvent actionEvent) {
        disciplina = (Disciplina) (listaDisciplinas.getRowData());
    }

    public String excluirDisciplina() {

        Disciplina disciplinaTemp = (Disciplina) (listaDisciplinas.getRowData());
        disciplinaDao.remove(disciplinaTemp);
        return "index";

    }

    public void adicionarDisciplina(ActionEvent actionEvent) {
        disciplinaDao.save(disciplina);

    }

    public void alterarDisciplina(ActionEvent actionEvent) {
        disciplinaDao.update(disciplina);

    }
}
