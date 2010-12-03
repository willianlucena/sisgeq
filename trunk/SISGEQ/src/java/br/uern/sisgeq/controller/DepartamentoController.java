package br.uern.sisgeq.controller;

import br.uern.sisgeq.dao.DepartamentoDao;
import br.uern.sisgeq.dao.hibernate.DepartamentoDaoHibernate;
import br.uern.sisgeq.model.Departamento;
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
public class DepartamentoController implements Serializable {

    private Departamento departamento;
    private DataModel listaDepartamentos;

    public DataModel getListarDepartamentos() {
        List<Departamento> lista = new DepartamentoDaoHibernate().getDepartamentos();
        listaDepartamentos = new ListDataModel(lista);
        return listaDepartamentos;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento Departamento) {
        this.departamento = Departamento;
    }

    public void prepararAdicionarDepartamento(ActionEvent actionEvent) {
        departamento = new Departamento();
        departamento.setNucleo(new Nucleo());
    }

    public void prepararAlterarDepartamento(ActionEvent actionEvent) {
        departamento = (Departamento) (listaDepartamentos.getRowData());
    }

    public String excluirDepartamento() {
        Departamento departamentoTemp = (Departamento) (listaDepartamentos.getRowData());
        DepartamentoDao dao = new DepartamentoDaoHibernate();
        dao.remove(departamentoTemp);
        return "index";
    }

    public void adicionarDepartamento(ActionEvent actionEvent) {
        DepartamentoDao dao = new DepartamentoDaoHibernate();
        dao.saveOrUpdate(departamento);
    }

    public void alterarDepartamento(ActionEvent actionEvent) {
        DepartamentoDao dao = new DepartamentoDaoHibernate();
        dao.saveOrUpdate(departamento);
    }
}
