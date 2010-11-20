package br.uern.sisgeq.controller;

import br.uern.sisgeq.model.Curso;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author rafael
 */
@ManagedBean(name="cursoManagedBean")
@RequestScoped
public class CursoManagedBean {
    private Curso curso = new Curso();

    /** Creates a new instance of CursoManagedBean */
    public CursoManagedBean() {
    }

    public void adicionarCurso(){
        curso = new Curso();
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

}
