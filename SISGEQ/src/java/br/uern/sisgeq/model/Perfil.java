package br.uern.sisgeq.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * @author Felipe Lemos
 */
@Entity
@Table(name = "perfil")
public class Perfil implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;
    private String tipo;
    @ManyToMany
    private Set<Pessoa> pessoas;

    public Perfil() {
        this.pessoas = new HashSet<Pessoa>();
    }

    public long getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Set<Pessoa> getPessoas() {
        return pessoas;
    }

    public void setPessoas(Set<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }
    
}
