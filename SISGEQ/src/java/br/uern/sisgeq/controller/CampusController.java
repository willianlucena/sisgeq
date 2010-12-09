package br.uern.sisgeq.controller;

import br.uern.sisgeq.dao.CampusDao;
import br.uern.sisgeq.dao.hibernate.CampusDaoHibernate;
import br.uern.sisgeq.model.Campus;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

/**
 *
 * @author willian
 */
@ManagedBean
@SessionScoped
public class CampusController implements Serializable {

    private Campus campus;
    private DataModel listaCampi;

    public DataModel getListarCampi() {
        List<Campus> lista = new CampusDaoHibernate().getCampi();
        listaCampi = new ListDataModel(lista);
        return listaCampi;
    }

    public Campus getCampus() {
        return campus;
    }

    public void setCampus(Campus Campus) {
        this.campus = Campus;
    }

    public void prepararAdicionarCampus(ActionEvent actionEvent) {
        campus = new Campus();
    }

    public void prepararAlterarCampus(ActionEvent actionEvent) {
        campus = (Campus) (listaCampi.getRowData());
    }

    public String excluirCampus() {
        Campus campusTemp = (Campus) (listaCampi.getRowData());
        CampusDao dao = new CampusDaoHibernate();
        dao.remove(campusTemp);
        return "campus";
    }

    public void adicionarCampus(ActionEvent actionEvent) {
        CampusDao dao = new CampusDaoHibernate();
        dao.save(campus);
    }

    public void alterarCampus(ActionEvent actionEvent) {
        CampusDao dao = new CampusDaoHibernate();
        dao.update(campus);
    }
}
