package br.uern.sisgeq.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Willian
 */
@Entity
@Table(name = "alternativa")
public class Alternativa implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;
    @ManyToOne
    private Pergunta pergunta;
    private String descricao;
    private int perguntaPosterior;
    private Boolean ativo;

    public Alternativa() {
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Pergunta getPergunta() {
        return this.pergunta;
    }

    public void setPergunta(Pergunta pergunta) {
        this.pergunta = pergunta;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getPerguntaPosterior() {
        return this.perguntaPosterior;
    }

    public void setPerguntaPosterior(int perguntaPosterior) {
        this.perguntaPosterior = perguntaPosterior;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }
    
}
