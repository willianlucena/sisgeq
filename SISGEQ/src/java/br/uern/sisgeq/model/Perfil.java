package br.uern.sisgeq.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 * @author Willian
 */
@Entity
public class Perfil implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;
    private String tipo;
    @ManyToMany(mappedBy = "perfis")
    private Set<Pessoa> pessoas;

    public Perfil() {
        this.pessoas = new HashSet<Pessoa>();
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipo() {
        return this.tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Set<Pessoa> getPessoas() {
        return this.pessoas;
    }

    public void setPessoas(Set<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }
}
