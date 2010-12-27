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
    private DataModel listaPerfis;

    public DataModel getListarPerfis() {
        List<Perfil> lista = new PerfilDaoHibernate().list();
        listaPerfis = new ListDataModel(lista);
        return listaPerfis;
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
        perfil = (Perfil) (listaPerfis.getRowData());
    }

    public String excluirPerfil() {
        Perfil perfilTemp = (Perfil) (listaPerfis.getRowData());
        PerfilDao dao = new PerfilDaoHibernate();
        dao.remove(perfilTemp);
        return "perfil";

    }

    public void adicionarPerfil(ActionEvent actionEvent) {
        PerfilDao dao = new PerfilDaoHibernate();
        dao.save(perfil);

    }

    public void alterarPerfil(ActionEvent actionEvent) {
        PerfilDao dao = new PerfilDaoHibernate();
        dao.update(perfil);
    }
}
