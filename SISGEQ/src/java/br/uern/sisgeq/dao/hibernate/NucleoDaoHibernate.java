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
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List<Nucleo> getNucleosByCampus(Campus campus) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void saveOrUpdateNucleo(Nucleo Nucleo) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void removeNucleo(Nucleo Nucleo) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
