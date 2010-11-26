package br.uern.sisgeq.dao.hibernate;

import br.uern.sisgeq.dao.NucleoDao;
import br.uern.sisgeq.model.Campus;
import br.uern.sisgeq.model.Nucleo;
import java.util.List;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 *
 * @author willian
 */
public class NucleoDaoHibernate  extends HibernateDaoSupport implements NucleoDao {

    public Nucleo getNucleo(Integer id) {
        return (Nucleo) getHibernateTemplate().get(Nucleo.class, id);
    }

    public List<Nucleo> getNucleos() {
       return getHibernateTemplate().find("from Nucleo");
    }

    public List<Nucleo> getNucleosByCampus(Campus campus) {
        return getHibernateTemplate().find("from Nucleo as n where n.campus.id = ?", campus.getId());
    }

    public void saveOrUpdateNucleo(Nucleo nucleo) {
        getHibernateTemplate().saveOrUpdate(nucleo);
    }

    public void removeNucleo(Nucleo nucleo) {
        getHibernateTemplate().delete(nucleo);
    }

}
