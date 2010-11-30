package br.uern.sisgeq.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author Willian
 */
@Entity
@Table(name="departamento")
public class Departamento implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;
    @ManyToOne
    private Nucleo nucleo;
    private String area;
    private String nome;
    @OneToMany(mappedBy = "departamento")
    private Set<Pessoa> pessoas;
    @OneToMany(mappedBy = "departamento")
    private Set<Curso> cursos;
    @OneToMany(mappedBy = "departamento")
    private Set<Disciplina> disciplinas;

    public Departamento() {
        this.pessoas = new HashSet<Pessoa>();
        this.cursos = new HashSet<Curso>();
        this.disciplinas = new HashSet<Disciplina>();
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Nucleo getNucleo() {
        return this.nucleo;
    }

    public void setNucleo(Nucleo nucleo) {
        this.nucleo = nucleo;
    }

    public String getArea() {
        return this.area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Pessoa> getPessoas() {
        return this.pessoas;
    }

    public void setPessoas(Set<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }

    public Set<Curso> getCursos() {
        return this.cursos;
    }

    public void setCursos(Set<Curso> cursos) {
        this.cursos = cursos;
    }

    public Set<Disciplina> getDisciplinas() {
        return this.disciplinas;
    }

    public void setDisciplinas(Set<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }
}
