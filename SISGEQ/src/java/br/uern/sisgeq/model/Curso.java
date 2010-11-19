/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.uern.sisgeq.model;

/**
 *
 * @author rafael
 */
public class Curso {

    private String nome;
    private int id;
    private int departamento_id;

    public int getDepartamento_id() {
        return departamento_id;
    }

    public void setDepartamento_id(int departamento_id) {
        this.departamento_id = departamento_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
