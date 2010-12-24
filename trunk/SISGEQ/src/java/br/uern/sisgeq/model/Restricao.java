package br.uern.sisgeq.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Restricao generated by hbm2java
 */
public class Restricao implements java.io.Serializable {

    private int numero;
    private String tipo;
    private Set<Questionario> questionarios = new HashSet<Questionario>(0);

    public Restricao() {
    }

    public Restricao(int numero, String tipo) {
        this.numero = numero;
        this.tipo = tipo;
    }

    public Restricao(int numero, String tipo, Set<Questionario> questionarios) {
        this.numero = numero;
        this.tipo = tipo;
        this.questionarios = questionarios;
    }

    public int getNumero() {
        return this.numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getTipo() {
        return this.tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Set<Questionario> getQuestionarios() {
        return this.questionarios;
    }

    public void setQuestionarios(Set<Questionario> questionarios) {
        this.questionarios = questionarios;
    }
}
