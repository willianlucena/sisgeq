package br.uern.sisgeq.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author Willian
 */
@Entity
@Table(name = "pergunta")
public class Pergunta implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;
    @ManyToOne
    private Questionario questionario;
    private String descricao;
    private int numero;
    private Boolean obrigatoriedade;
    @OneToMany(mappedBy = "pergunta")
    private Set<Alternativa> alternativas;
    @OneToMany(mappedBy = "pergunta")
    private Set<Resposta> respostas;
    private Boolean ativo;

    public Pergunta() {
        this.alternativas = new HashSet<Alternativa>();
        this.respostas = new HashSet<Resposta>();
    }

    public Integer getId() {
        return this.id;
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

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getNumero() {
        return this.numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Boolean getObrigatoriedade() {
        return this.obrigatoriedade;
    }

    public void setObrigatoriedade(Boolean obrigatoriedade) {
        this.obrigatoriedade = obrigatoriedade;
    }

    public Set<Alternativa> getAlternativas() {
        return this.alternativas;
    }

    public void setAlternativas(Set<Alternativa> alternativas) {
        this.alternativas = alternativas;
    }

    public Set<Resposta> getRespostas() {
        return this.respostas;
    }

    public void setRespostas(Set<Resposta> respostas) {
        this.respostas = respostas;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }
}
