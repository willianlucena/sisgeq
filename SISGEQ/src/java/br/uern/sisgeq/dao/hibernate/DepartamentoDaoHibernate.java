package br.uern.sisgeq.dao.hibernate;

import br.uern.sisgeq.dao.DepartamentoDao;
import br.uern.sisgeq.model.Campus;
import br.uern.sisgeq.model.Departamento;
import br.uern.sisgeq.model.Nucleo;
import java.util.List;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 *
 * @author willian
 */
public class DepartamentoDaoHibernate extends HibernateDaoSupport implements DepartamentoDao {

    public Departamento getDepartamento(Integer id) {
        return (Departamento) getHibernateTemplate().get(Departamento.class, id);
    }

    public List<Departamento> getDepartamentos() {
        return getHibernateTemplate().find("from Departamento");
    }

    public List<Departamento> getDepartamentosByCampus(Campus campus) {
        String query = "select d from Departamento as d where d.nucleo.id in (select from Nucleo as n where n.campus.id = :campus)";
        return getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery(query).setParameter("campus", campus.getId()).list();
    }

    public List<Departamento> getDepartamentosByNucleo(Nucleo nucleo) {
        return getHibernateTemplate().find("from Departamento as d where d.nucleo.id = ?", nucleo.getId());
    }

    public void saveOrUpdateDepartamento(Departamento departamento) {
        getHibernateTemplate().saveOrUpdate(departamento);
    }

    public void removeDepartamento(Departamento departamento) {
        getHibernateTemplate().delete(departamento);
    }
}
