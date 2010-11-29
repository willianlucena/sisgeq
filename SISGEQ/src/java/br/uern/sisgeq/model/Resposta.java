package br.uern.sisgeq.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Willian
 */
@Entity
@Table(name = "Resposta")
public class Resposta implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;
    private Pergunta pergunta;
    private String descricao;

    public Resposta() {
    }

    public Resposta(Pergunta pergunta, String descricao) {
        this.pergunta = pergunta;
        this.descricao = descricao;
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
}
