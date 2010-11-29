package br.uern.sisgeq.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * @author Willian
 */
@Entity
public class Campus implements Serializable {

    @Id
    @GeneratedValue
    private int id;
    private String nome;
    @OneToMany(mappedBy = "campus")
    private Set<Nucleo> nucleos;

    public Campus() {
        nucleos = new HashSet<Nucleo>();
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Nucleo> getNucleos() {
        return this.nucleos;
    }

    public void setNucleos(Set<Nucleo> nucleos) {
        this.nucleos = nucleos;
    }
}
