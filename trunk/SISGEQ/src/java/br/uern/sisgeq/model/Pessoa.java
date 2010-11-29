package br.uern.sisgeq.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Willian
 */
@Entity
@Table(name="Pessoa")
public class Pessoa implements Serializable {
    @Id
    private String matriculaCpf;
    @ManyToOne
    private Departamento departamento;
    @ManyToOne
    private Curso curso;
    private String nome;
    private String cidade;
    private String estado;
    private String naturalidade;
    private String nacionalidade;
    @ManyToMany
    private Set<Perfil> perfis;

    public Pessoa() {
        this.perfis = new HashSet<Perfil>();
    }

    public String getMatriculaCpf() {
        return this.matriculaCpf;
    }

    public void setMatriculaCpf(String matriculaCpf) {
        this.matriculaCpf = matriculaCpf;
    }

    public Departamento getDepartamento() {
        return this.departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public Curso getCurso() {
        return this.curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCidade() {
        return this.cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return this.estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNaturalidade() {
        return this.naturalidade;
    }

    public void setNaturalidade(String naturalidade) {
        this.naturalidade = naturalidade;
    }

    public String getNacionalidade() {
        return this.nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public Set<Perfil> getPerfis() {
        return perfis;
    }

    public void setPerfis(Set<Perfil> perfis) {
        this.perfis = perfis;
    }
}
