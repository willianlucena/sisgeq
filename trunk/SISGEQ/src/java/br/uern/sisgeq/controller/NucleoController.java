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
    private DataModel dataModelNucleos = getListarNucleos();
    //private Campus campus = new Campus();
    private String nome;
    private String campus;

    public DataModel getListarNucleos() {
        List<Nucleo> lista = new NucleoDaoHibernate().getNucleos(true);
        dataModelNucleos = new ListDataModel(lista);
        return dataModelNucleos;
    }

    public void prepararAdicionarNucleo(ActionEvent actionEvent) {
        nucleo = new Nucleo();
        nucleo.setCampus(new Campus());
    }

    public void prepararAlterarNucleo(ActionEvent actionEvent) {
        nucleo = (Nucleo) (dataModelNucleos.getRowData());
    }

    public void prepararFiltrarNucleo(ActionEvent actionEvent) {
        nome = null;
        campus = null;
    }

    public void prepararExcluirNucleo(ActionEvent actionEvent){
        nucleo = (Nucleo) (dataModelNucleos.getRowData());
    }

    public String excluirNucleo() {
        //Nucleo nucleoTemp = (Nucleo) (dataModelNucleos.getRowData());
        NucleoDao dao = new NucleoDaoHibernate();
        dao.remove(nucleo);
        dataModelNucleos = getListarNucleos();
        return "nucleo";
    }

    public void adicionarNucleo(ActionEvent actionEvent) {
        NucleoDao dao = new NucleoDaoHibernate();
        nucleo.setAtivo(Boolean.TRUE);
        dao.save(nucleo);
        dataModelNucleos = getListarNucleos();
    }

    public void alterarNucleo(ActionEvent actionEvent) {
        NucleoDao dao = new NucleoDaoHibernate();
        dao.update(nucleo);
        dataModelNucleos = getListarNucleos();
    }

    public void filtrarNucleo(ActionEvent actionEvent) {
        List<Nucleo> lista = new NucleoDaoHibernate().getNucleoComFiltros(nome, campus);
        for (Nucleo n : lista) {
            System.out.println(n.getNome());
            System.out.println(n.getCampus());
        }
        dataModelNucleos = new ListDataModel(lista);

    }

    public void setListaNucleos(DataModel listaNucleos) {
        this.dataModelNucleos = listaNucleos;
    }

    public Nucleo getNucleo() {
        return nucleo;
    }

    public void setNucleo(Nucleo nucleo) {
        this.nucleo = nucleo;
    }

    public DataModel getDataModelNucleos() {
        return dataModelNucleos;
    }

    public void setDataModelNucleos(DataModel dataModelNucleos) {
        this.dataModelNucleos = dataModelNucleos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCampus() {
        return campus;
    }

    public void setCampus(String campus) {
        this.campus = campus;
    }
}
