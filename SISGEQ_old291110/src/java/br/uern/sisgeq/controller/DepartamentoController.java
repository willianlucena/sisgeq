package br.uern.sisgeq.controller;

import br.uern.sisgeq.model.Departamento;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author willian
 */
@ManagedBean(name="departamentoManagedBean")
@RequestScoped
public class DepartamentoController {

    private Departamento departamento;

    /** Creates a new instance of DepartamentoController */
    public DepartamentoController() {
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

}
