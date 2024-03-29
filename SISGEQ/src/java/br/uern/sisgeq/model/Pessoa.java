package br.uern.sisgeq.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author Willian
 */
@Entity
@Table(name = "pessoa")
public class Pessoa implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;
    private String matricula;
    @ManyToOne
    private Departamento departamento;
    @ManyToOne
    private Curso curso;
    @ManyToMany
    private Set<Perfil> perfis;
    private String nome;
    private String cidade;
    private String estado;
    private String naturalidade;
    private String nacionalidade;
    private Boolean ativo;
    @OneToMany(mappedBy = "pessoa")
    private Set<PessoaTurma> pessoaTurmas;

    public Pessoa() {
        this.perfis = new HashSet<Perfil>();
        this.pessoaTurmas = new HashSet<PessoaTurma>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
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

    public Set<PessoaTurma> getPessoaTurmas() {
        return pessoaTurmas;
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
