package br.uern.sisgeq.util;
// Generated 23/11/2010 09:58:27 by Hibernate Tools 3.2.1.GA


import java.util.HashSet;
import java.util.Set;

/**
 * Turma generated by hbm2java
 */
public class Turma  implements java.io.Serializable {


     private int id;
     private Nucleo nucleo;
     private Disciplina disciplina;
     private String periodo;
     private Set<PessoaTurma> pessoaTurmas = new HashSet<PessoaTurma>(0);

    public Turma() {
    }

	
    public Turma(int id, Nucleo nucleo, Disciplina disciplina, String periodo) {
        this.id = id;
        this.nucleo = nucleo;
        this.disciplina = disciplina;
        this.periodo = periodo;
    }
    public Turma(int id, Nucleo nucleo, Disciplina disciplina, String periodo, Set<PessoaTurma> pessoaTurmas) {
       this.id = id;
       this.nucleo = nucleo;
       this.disciplina = disciplina;
       this.periodo = periodo;
       this.pessoaTurmas = pessoaTurmas;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public Nucleo getNucleo() {
        return this.nucleo;
    }
    
    public void setNucleo(Nucleo nucleo) {
        this.nucleo = nucleo;
    }
    public Disciplina getDisciplina() {
        return this.disciplina;
    }
    
    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }
    public String getPeriodo() {
        return this.periodo;
    }
    
    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }
    public Set<PessoaTurma> getPessoaTurmas() {
        return this.pessoaTurmas;
    }
    
    public void setPessoaTurmas(Set<PessoaTurma> pessoaTurmas) {
        this.pessoaTurmas = pessoaTurmas;
    }




}


