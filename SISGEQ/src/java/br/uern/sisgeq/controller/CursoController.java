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
    private DataModel dataModelCursos = getListarCursos();
    String codigo;
    String nome;
    String departamento;

    public DataModel getListarCursos() {
        System.out.println("listar!!!!");
        List<Curso> lista = new CursoDaoHibernate().getCursos(true);
        dataModelCursos = new ListDataModel(lista);
        return dataModelCursos;
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
        curso = (Curso) (dataModelCursos.getRowData());
    }

     public void prepararFiltrarCurso(ActionEvent actionEvent) {
        nome = codigo = departamento = null;
    }

    public String excluirCurso() {
        Curso cursoTemp = (Curso) (dataModelCursos.getRowData());
        CursoDao dao = new CursoDaoHibernate();
        dao.remove(cursoTemp);
        return "curso";
    }

    public void filtrarCurso(ActionEvent actionEvent) {
        List<Curso> lista = new CursoDaoHibernate().getCursosComFiltros(codigo, nome, departamento);
        for (Curso c : lista) {
            System.out.println(c.getNome());
            System.out.println(c.getCodigo());
        }
        dataModelCursos = new ListDataModel(lista);
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

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public DataModel getDataModelCursos() {
        return dataModelCursos;
    }

    public void setDataModelCursos(DataModel dataModelCursos) {
        this.dataModelCursos = dataModelCursos;
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
