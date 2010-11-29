package br.uern.sisgeq.controller;

import br.uern.sisgeq.dao.DisciplinaDao;
import br.uern.sisgeq.dao.hibernate.DisciplinaDaoHibernate;
import br.uern.sisgeq.model.Disciplina;
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
public class DisciplinaController {

    private Disciplina disciplina;
    private DataModel listaDisciplinas;

    public DataModel getListarDisciplinas() {
        List<Disciplina> lista = new DisciplinaDaoHibernate().list();
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
        DisciplinaDao dao = new DisciplinaDaoHibernate();
        dao.remove(disciplinaTemp);
        return "disciplina";

    }

    public void adicionarDisciplina(ActionEvent actionEvent) {

        DisciplinaDao dao = new DisciplinaDaoHibernate();
        dao.save(disciplina);

    }

    public void alterarDisciplina(ActionEvent actionEvent) {

        DisciplinaDao dao = new DisciplinaDaoHibernate();
        dao.update(disciplina);

    }
}
