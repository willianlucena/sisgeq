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
@Table(name = "pessoa_turma")
public class PessoaTurma implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;
    @ManyToOne
    private Turma turma;
    @ManyToOne
    private Pessoa pessoa;
    private Integer situacao;
    private Float media;

    public PessoaTurma() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Turma getTurma() {
        return this.turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
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

    public Float getMedia() {
        return this.media;
    }

    public void setMedia(Float media) {
        this.media = media;
    }
}
