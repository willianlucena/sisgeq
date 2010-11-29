package br.uern.sisgeq.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * @author Rafael
 */
@Entity
public class Curso implements java.io.Serializable {

    @Id
    @GeneratedValue
    private Integer id;
    @ManyToOne
    private Departamento departamento;
    private String nome;
    @OneToMany(mappedBy = "curso")
    private Set<Pessoa> pessoas;

    public Curso() {
        this.pessoas = new HashSet<Pessoa>();
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Departamento getDepartamento() {
        return this.departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
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
}
