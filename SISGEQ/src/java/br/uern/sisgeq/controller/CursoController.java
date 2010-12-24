package br.uern.sisgeq.controller;

import br.uern.sisgeq.dao.CursoDao;
import br.uern.sisgeq.dao.hibernate.CursoDaoHibernate;
import br.uern.sisgeq.model.Curso;
import br.uern.sisgeq.model.Departamento;
import java.io.Serializable;
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
public class CursoController implements Serializable {

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
        curso.setDepartamento(new Departamento());
    }

    public void prepararAlterarCurso(ActionEvent actionEvent) {
        curso = (Curso) (listaCursos.getRowData());
    }

    public String excluirCurso() {
        Curso cursoTemp = (Curso) (listaCursos.getRowData());
        CursoDao dao = new CursoDaoHibernate();
        dao.remove(cursoTemp);
        return "curso";
    }

    public void adicionarCurso(ActionEvent actionEvent) {
        CursoDao dao = new CursoDaoHibernate();
        curso.setAtivo(Boolean.TRUE);
        dao.save(curso);
    }

    public void alterarCurso(ActionEvent actionEvent) {
        CursoDao dao = new CursoDaoHibernate();
        dao.update(curso);
    }
}
