package br.uern.sisgeq.controller;

import br.uern.sisgeq.dao.DepartamentoDao;
import br.uern.sisgeq.dao.hibernate.CampusDaoHibernate;
import br.uern.sisgeq.dao.hibernate.DepartamentoDaoHibernate;
import br.uern.sisgeq.model.Campus;
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
    private DataModel dataModelDepartamentos = getListarDepartamentos();
    private String nome;
    private String area;
    private String campus;
    private String nucleo;

    public DataModel getListarDepartamentos() {
        List<Departamento> lista = new DepartamentoDaoHibernate().getDepartamentos(true);
        dataModelDepartamentos = new ListDataModel(lista);
        return dataModelDepartamentos;
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
        departamento = (Departamento) (dataModelDepartamentos.getRowData());
    }

    public void prepararFiltrarDepartamento(ActionEvent actionEvent) {
        nome = nucleo = area = campus = "";
    }

    public String excluirDepartamento() {
        Departamento departamentoTemp = (Departamento) (dataModelDepartamentos.getRowData());
        DepartamentoDao dao = new DepartamentoDaoHibernate();
        dao.remove(departamentoTemp);
        return "departamento";
    }

    public void filtrarDepartamento(ActionEvent actionEvent) {
        //List<Departamento> lista = new DepartamentoDaoHibernate().getDepartamentos(true);
        Campus c = new CampusDaoHibernate().getCampusByNome(campus);
        if (c != null){
            System.out.println("CAMPUS");
            System.out.println(c.getNome());
            System.out.println("-> NUCLEOS");
            for (Nucleo n : c.getNucleos()) {
                System.out.println(n.getNome());
            }
        } else {
            System.out.println(c);
        }
        List<Departamento> lista = new DepartamentoDaoHibernate().getDepartamentosByCampus(c);
        dataModelDepartamentos = new ListDataModel(lista);
    }

    public void adicionarDepartamento(ActionEvent actionEvent) {
        DepartamentoDao dao = new DepartamentoDaoHibernate();
        departamento.setAtivo(Boolean.TRUE);
        dao.save(departamento);
    }

    public void alterarDepartamento(ActionEvent actionEvent) {
        DepartamentoDao dao = new DepartamentoDaoHibernate();
        dao.update(departamento);
    }

    public DataModel getDataModelDepartamentos() {
        return dataModelDepartamentos;
    }

    public void setDataModelDepartamentos(DataModel dataModelDepartamentos) {
        this.dataModelDepartamentos = dataModelDepartamentos;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNucleo() {
        return nucleo;
    }

    public void setNucleo(String nucleo) {
        this.nucleo = nucleo;
    }

    public String getCampus() {
        return campus;
    }

    public void setCampus(String campus) {
        this.campus = campus;
    }
}
