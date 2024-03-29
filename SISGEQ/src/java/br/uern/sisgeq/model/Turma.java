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
@Table(name = "turma")
public class Turma implements Serializable {

    @Id
    @GeneratedValue
    private int id;
    @ManyToOne
    private Nucleo nucleo;
    @ManyToOne
    private Disciplina disciplina;
    private String periodo;
    @OneToMany(mappedBy = "turma")
    private Set<PessoaTurma> pessoaTurmas;
    private Boolean ativo;

    public Turma() {
        this.pessoaTurmas = new HashSet<PessoaTurma>();
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Nucleo getNucleo() {
        return this.nucleo;
    }

    public void setNucleo(Nucleo nucleo) {
        this.nucleo = nucleo;
    }

    public Disciplina getDisciplina() {
        return this.disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public String getPeriodo() {
        return this.periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public Set<PessoaTurma> getPessoaTurmas() {
        return this.pessoaTurmas;
    }

    public void setPessoaTurmas(Set<PessoaTurma> pessoaTurmas) {
        this.pessoaTurmas = pessoaTurmas;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }
    
}
