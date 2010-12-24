package br.uern.sisgeq.controller;

import br.uern.sisgeq.dao.NucleoDao;
import br.uern.sisgeq.dao.hibernate.NucleoDaoHibernate;
import br.uern.sisgeq.model.Campus;
import br.uern.sisgeq.model.Nucleo;
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
public class NucleoController implements Serializable {

    private Nucleo nucleo;
    private DataModel listaNucleos;
    private Campus campus = new Campus();

    public DataModel getListarNucleos() {
        List<Nucleo> lista = new NucleoDaoHibernate().getNucleos();
        listaNucleos = new ListDataModel(lista);
        return listaNucleos;
    }

    public void prepararAdicionarNucleo(ActionEvent actionEvent) {
        nucleo = new Nucleo();
        nucleo.setCampus(new Campus());
    }

    public void prepararAlterarNucleo(ActionEvent actionEvent) {
        nucleo = (Nucleo) (listaNucleos.getRowData());
    }

    public String excluirNucleo() {
        Nucleo nucleoTemp = (Nucleo) (listaNucleos.getRowData());
        NucleoDao dao = new NucleoDaoHibernate();
        dao.remove(nucleoTemp);
        return "nucleo";
    }

    public void adicionarNucleo(ActionEvent actionEvent) {
        NucleoDao dao = new NucleoDaoHibernate();
        nucleo.setAtivo(Boolean.TRUE);
        dao.save(nucleo);
    }

    public void alterarNucleo(ActionEvent actionEvent) {
        NucleoDao dao = new NucleoDaoHibernate();
        dao.update(nucleo);
    }

    public Campus getCampus() {
        return campus;
    }

    public void setCampus(Campus campus) {
        this.campus = campus;
    }

    public void setListaNucleos(DataModel listaNucleos) {
        this.listaNucleos = listaNucleos;
    }

    public Nucleo getNucleo() {
        return nucleo;
    }

    public void setNucleo(Nucleo nucleo) {
        this.nucleo = nucleo;
    }
}
