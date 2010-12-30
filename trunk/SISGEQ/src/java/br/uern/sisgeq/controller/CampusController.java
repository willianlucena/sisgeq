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
    private DataModel dataModelCampi = getListarCampi();
    String nome;

    public DataModel getListarCampi() {
        System.out.println("listar!!!!");
        List<Campus> lista = new CampusDaoHibernate().getCampi(true);
        dataModelCampi = new ListDataModel(lista);
        return dataModelCampi;
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
        campus = (Campus) (dataModelCampi.getRowData());
    }

    public void prepararExcluirCampus(ActionEvent actionEvent) {
        campus = (Campus) (dataModelCampi.getRowData());
    }

    public void prepararFiltrarCampus(ActionEvent actionEvent) {
        nome = null;
    }

    public String excluirCampus() {
        //Campus campusTemp = (Campus) (dataModelCampi.getRowData());
        CampusDao dao = new CampusDaoHibernate();
        dao.remove(campus);
        dataModelCampi = getListarCampi();
        return "campus";
    }

    public void filtrarCampus(ActionEvent actionEvent) {
        List<Campus> lista = new CampusDaoHibernate().getCampiComFiltros(nome);
        for (Campus c : lista) {
            System.out.println(c.getNome());
        }
        dataModelCampi = new ListDataModel(lista);
    }

    public void adicionarCampus(ActionEvent actionEvent) {
        CampusDao dao = new CampusDaoHibernate();
        campus.setAtivo(Boolean.TRUE);
        dao.save(campus);
        dataModelCampi = getListarCampi();
    }

    public void alterarCampus(ActionEvent actionEvent) {
        CampusDao dao = new CampusDaoHibernate();
        dao.update(campus);
        dataModelCampi = getListarCampi();
    }

    public DataModel getDataModelCampi() {
        return dataModelCampi;
    }

    public void setDataModelCampi(DataModel dataModelCampi) {
        this.dataModelCampi = dataModelCampi;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
