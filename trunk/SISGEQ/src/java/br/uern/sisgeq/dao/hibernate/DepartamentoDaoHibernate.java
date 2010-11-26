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
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List<Departamento> getDepartamentosByCampus(Campus campus) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List<Departamento> getDepartamentosByNucleo(Nucleo nucleo) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void saveOrUpdateDepartamento(Departamento Departamento) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void removeDepartamento(Departamento Departamento) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
