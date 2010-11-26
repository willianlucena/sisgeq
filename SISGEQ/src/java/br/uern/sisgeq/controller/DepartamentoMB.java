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
public class DepartamentoMB {

    private Departamento departamento;

    /** Creates a new instance of DepartamentoMB */
    public DepartamentoMB() {
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

}
