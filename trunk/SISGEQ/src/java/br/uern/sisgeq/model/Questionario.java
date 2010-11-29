package br.uern.sisgeq.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 * @author Willian
 */
@Entity
@Table(name = "Questionario")
public class Questionario implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;
    private Restricao restricao;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataFim;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataInicio;
    private String descricao;
    private Integer situacao;
    private Set<Pergunta> perguntas;

    public Questionario() {
        this.perguntas = new HashSet<Pergunta>();
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Restricao getRestricao() {
        return this.restricao;
    }

    public void setRestricao(Restricao restricao) {
        this.restricao = restricao;
    }

    public Date getDataFim() {
        return this.dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public Date getDataInicio() {
        return this.dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getSituacao() {
        return this.situacao;
    }

    public void setSituacao(Integer situacao) {
        this.situacao = situacao;
    }

    public Set<Pergunta> getPerguntas() {
        return this.perguntas;
    }

    public void setPerguntas(Set<Pergunta> perguntas) {
        this.perguntas = perguntas;
    }
}
