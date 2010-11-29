package br.uern.sisgeq.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Felipe Lemos
 */
@Entity
@Table(name = "disciplina")
public class Disciplina implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;
    private String codigo;
    private Integer departamento_id;
    private String nome;

    public Disciplina() {
    }

    public Disciplina(Integer id, String codigo, Integer departamento_id, String nome) {
        this.id = id;
        this.codigo = codigo;
        this.departamento_id = departamento_id;
        this.nome = nome;
    }

    public Integer getDepartamento_id() {
        return departamento_id;
    }

    public void setDepartamento_id(Integer departamento_id) {
        this.departamento_id = departamento_id;
    }

    public long getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}
