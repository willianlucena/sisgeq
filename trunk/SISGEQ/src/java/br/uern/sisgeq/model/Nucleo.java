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
@Table(name = "nucleo")
public class Nucleo implements Serializable {

    @Id
    @GeneratedValue
    private int id;
    @ManyToOne
    private Campus campus;
    private String nome;
    @OneToMany(mappedBy = "nucleo")
    private Set<Departamento> departamentos;
    @OneToMany(mappedBy = "nucleo")
    private Set<Turma> turmas;
    private Boolean ativo;

    public Nucleo() {
        this.departamentos = new HashSet<Departamento>();
        this.turmas = new HashSet<Turma>();
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Campus getCampus() {
        return this.campus;
    }

    public void setCampus(Campus campus) {
        this.campus = campus;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Departamento> getDepartamentos() {
        return this.departamentos;
    }

    public void setDepartamentos(Set<Departamento> departamentos) {
        this.departamentos = departamentos;
    }

    public Set<Turma> getTurmas() {
        return this.turmas;
    }

    public void setTurmas(Set<Turma> turmas) {
        this.turmas = turmas;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }
}
