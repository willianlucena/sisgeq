package br.uern.sisgeq.model;
// Generated 23/11/2010 09:58:27 by Hibernate Tools 3.2.1.GA



/**
 * Alternativa generated by hbm2java
 */
public class Alternativa  implements java.io.Serializable {


     private Integer id;
     private Pergunta pergunta;
     private String descricao;
     private int perguntaPosterior;

    public Alternativa() {
    }

    public Alternativa(Pergunta pergunta, String descricao, int perguntaPosterior) {
       this.pergunta = pergunta;
       this.descricao = descricao;
       this.perguntaPosterior = perguntaPosterior;
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




}


