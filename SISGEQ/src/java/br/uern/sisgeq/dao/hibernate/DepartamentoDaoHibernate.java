package br.uern.sisgeq.dao.hibernate;

import br.uern.sisgeq.dao.DepartamentoDao;
import br.uern.sisgeq.model.Campus;
import br.uern.sisgeq.model.Departamento;
import br.uern.sisgeq.model.Nucleo;
import java.util.List;

/**
 *
 * @author willian
 */
public class DepartamentoDaoHibernate implements DepartamentoDao {

    public Departamento getDepartamento(Integer id) {
        return null;//(Departamento) getHibernateTemplate().get(Departamento.class, id);
    }

    public List<Departamento> getDepartamentos() {
        return null;//getHibernateTemplate().find("from Departamento");
    }

    public List<Departamento> getDepartamentosByCampus(Campus campus) {
        String query = "select d from Departamento as d where d.nucleo.id in (select n.id from Nucleo as n where n.campus.id = :campus)";
        return null;//getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery(query).setParameter("campus", campus.getId()).list();
    }

    public List<Departamento> getDepartamentosByNucleo(Nucleo nucleo) {
        return null;//getHibernateTemplate().find("from Departamento as d where d.nucleo.id = ?", nucleo.getId());
    }

    public void saveOrUpdateDepartamento(Departamento departamento) {
        //getHibernateTemplate().saveOrUpdate(departamento);
    }

    public void removeDepartamento(Departamento departamento) {
        //getHibernateTemplate().delete(departamento);
    }
}
