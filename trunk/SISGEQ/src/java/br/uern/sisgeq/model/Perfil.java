package br.uern.sisgeq.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
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

    public Perfil() {
    }

    public Perfil(Integer id, String tipo) {
        this.id = id;
        this.tipo = tipo;
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
}
