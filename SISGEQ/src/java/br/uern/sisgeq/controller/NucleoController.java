package br.uern.sisgeq.controller;

import br.uern.sisgeq.dao.NucleoDao;
import br.uern.sisgeq.dao.hibernate.NucleoDaoHibernate;
import br.uern.sisgeq.model.Nucleo;
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
public class NucleoController {

    private Nucleo nucleo;
    private DataModel listaNucleos;

    public DataModel getListarNucleos() {
        List<Nucleo> lista = new NucleoDaoHibernate().getNucleos();
        listaNucleos = new ListDataModel(lista);
        return listaNucleos;
    }

    public Nucleo getNucleo() {
        return nucleo;
    }

    public void setNucleo(Nucleo Nucleo) {
        this.nucleo = Nucleo;
    }

    public void prepararAdicionarNucleo(ActionEvent actionEvent) {
        nucleo = new Nucleo();
    }

    public void prepararAlterarNucleo(ActionEvent actionEvent) {
        nucleo = (Nucleo) (listaNucleos.getRowData());
    }

    public String excluirNucleo() {
        Nucleo nucleoTemp = (Nucleo) (listaNucleos.getRowData());
        NucleoDao dao = new NucleoDaoHibernate();
        dao.remove(nucleoTemp);
        return "index";
    }

    public void adicionarNucleo(ActionEvent actionEvent) {
        saveOrUpdate();
    }

    public void alterarNucleo(ActionEvent actionEvent) {
        saveOrUpdate();
    }

    private void saveOrUpdate() {
        NucleoDao dao = new NucleoDaoHibernate();
        dao.saveOrUpdate(nucleo);
    }
}
