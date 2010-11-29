package br.uern.sisgeq.dao.hibernate;

import br.uern.sisgeq.dao.NucleoDao;
import br.uern.sisgeq.model.Campus;
import br.uern.sisgeq.model.Nucleo;
import java.util.List;

/**
 *
 * @author willian
 */
public class NucleoDaoHibernate implements NucleoDao {

    public Nucleo getNucleo(Integer id) {
        return null;//(Nucleo) getHibernateTemplate().get(Nucleo.class, id);
    }

    public List<Nucleo> getNucleos() {
       return null;//getHibernateTemplate().find("from Nucleo");
    }

    public List<Nucleo> getNucleosByCampus(Campus campus) {
        return null;//getHibernateTemplate().find("from Nucleo as n where n.campus.id = ?", campus.getId());
    }

    public void saveOrUpdateNucleo(Nucleo nucleo) {
        //getHibernateTemplate().saveOrUpdate(nucleo);
    }

    public void removeNucleo(Nucleo nucleo) {
        //getHibernateTemplate().delete(nucleo);
    }

}
