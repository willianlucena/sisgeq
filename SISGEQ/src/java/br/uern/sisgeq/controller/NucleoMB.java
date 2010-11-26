package br.uern.sisgeq.controller;

import br.uern.sisgeq.model.Nucleo;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author willian
 */
@ManagedBean(name="nucleoManagedBean")
@RequestScoped
public class NucleoMB {

    private Nucleo nucleo;
    /** Creates a new instance of NucleoMB */
    public NucleoMB() {
    }

    public Nucleo getNucleo() {
        return nucleo;
    }

    public void setNucleo(Nucleo nucleo) {
        this.nucleo = nucleo;
    }

}
