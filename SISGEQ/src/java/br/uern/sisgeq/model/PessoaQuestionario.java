package br.uern.sisgeq.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author Willian
 */
@Entity
public class PessoaQuestionario implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;
    private Questionario questionario;
    private Pessoa pessoa;
    private Integer situacao;

    public PessoaQuestionario() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Questionario getQuestionario() {
        return this.questionario;
    }

    public void setQuestionario(Questionario questionario) {
        this.questionario = questionario;
    }

    public Pessoa getPessoa() {
        return this.pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Integer getSituacao() {
        return this.situacao;
    }

    public void setSituacao(Integer situacao) {
        this.situacao = situacao;
    }
}
