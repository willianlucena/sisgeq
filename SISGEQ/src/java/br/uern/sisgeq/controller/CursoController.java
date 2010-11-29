package br.uern.sisgeq.controller;

import br.uern.sisgeq.dao.CursoDao;
import br.uern.sisgeq.dao.hibernate.CursoDaoHibernate;
import br.uern.sisgeq.model.Curso;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

/**
 *
 * @author willian
 */
@ManagedBean
@SessionScoped
public class CursoController {

    private Curso curso;
    private DataModel listaCursos;

    public DataModel getListarCursos() {
        List<Curso> lista = new CursoDaoHibernate().getCursos();
        listaCursos = new ListDataModel(lista);
        return listaCursos;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso Curso) {
        this.curso = Curso;
    }

    public void prepararAdicionarCurso(ActionEvent actionEvent) {
        curso = new Curso();
    }

    public void prepararAlterarCurso(ActionEvent actionEvent) {
        curso = (Curso) (listaCursos.getRowData());
    }

    public String excluirCurso() {
        Curso cursoTemp = (Curso) (listaCursos.getRowData());
        CursoDao dao = new CursoDaoHibernate();
        dao.remove(cursoTemp);
        return "index";
    }

    public void adicionarCurso(ActionEvent actionEvent) {
        saveOrUpdate();
    }

    public void alterarCurso(ActionEvent actionEvent) {
        saveOrUpdate();
    }

    private void saveOrUpdate() {
        CursoDao dao = new CursoDaoHibernate();
        dao.saveOrUpdate(curso);
    }
}
