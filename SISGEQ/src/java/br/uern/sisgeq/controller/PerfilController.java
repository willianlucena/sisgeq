package br.uern.sisgeq.controller;

import br.uern.sisgeq.dao.PerfilDao;
import br.uern.sisgeq.dao.hibernate.PerfilDaoHibernate;
import br.uern.sisgeq.model.Perfil;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

/**
 *
 * @author Felipe Lemos
 */
@ManagedBean
@SessionScoped
public class PerfilController implements Serializable {

    private Perfil perfil;
    private DataModel dataModelPerfis = getListarPerfis();
    private String tipo;

    public DataModel getListarPerfis() {
        List<Perfil> lista = new PerfilDaoHibernate().list();
        dataModelPerfis = new ListDataModel(lista);
        return dataModelPerfis;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    public void prepararAdicionarPerfil(ActionEvent actionEvent) {
        perfil = new Perfil();
    }

    public void prepararAlterarPerfil(ActionEvent actionEvent) {
        perfil = (Perfil) (dataModelPerfis.getRowData());
    }

    public void prepararFiltrarPerfil(ActionEvent actionEvent){
        tipo = null;
    }

    public void prepararExcluirPerfil(ActionEvent actionEvent){
        perfil = (Perfil) (dataModelPerfis.getRowData());
    }

    public String excluirPerfil() {
        //Perfil perfilTemp = (Perfil) (dataModelPerfis.getRowData());
        PerfilDao dao = new PerfilDaoHibernate();
        dao.remove(perfil);
        dataModelPerfis = getListarPerfis();
        return "perfil";

    }

    public void adicionarPerfil(ActionEvent actionEvent) {
        PerfilDao dao = new PerfilDaoHibernate();
        dao.save(perfil);
        dataModelPerfis = getListarPerfis();
    }

    public void alterarPerfil(ActionEvent actionEvent) {
        PerfilDao dao = new PerfilDaoHibernate();
        dao.update(perfil);
        dataModelPerfis = getListarPerfis();
    }

    public void filtrarPerfil(ActionEvent actionEvent){
        List<Perfil> lista = new PerfilDaoHibernate().getPerfisComFiltros(tipo);
        for (Perfil p : lista) {
            System.out.println(p.getTipo());
        }
        dataModelPerfis = new ListDataModel(lista);
    }

    public DataModel getDataModelPerfis() {
        return dataModelPerfis;
    }

    public void setDataModelPerfis(DataModel dataModelPerfis) {
        this.dataModelPerfis = dataModelPerfis;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
