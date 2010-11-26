package br.uern.sisgeq.controller;

import br.uern.sisgeq.model.Campus;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author willian
 */
@ManagedBean(name="campusManagedBean")
@RequestScoped
public class CampusController {

    private Campus campus;
    /** Creates a new instance of CampusController */
    public CampusController() {
    }

    public Campus getCampus() {
        return campus;
    }

    public void setCampus(Campus campus) {
        this.campus = campus;
    }

}
