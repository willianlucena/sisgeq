package br.uern.sisgeq.dao.hibernate;

import br.uern.sisgeq.dao.CampusDao;
import br.uern.sisgeq.model.Campus;
import java.util.List;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 *
 * @author willian
 */
public class CampusDaoHibernate  extends HibernateDaoSupport implements CampusDao {

    public Campus getCampus(Integer id) {
        return (Campus) getHibernateTemplate().get(Campus.class, id);
    }

    public List<Campus> getCampi() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void saveOrUpdateCampus(Campus Campus) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void removeCampus(Campus Campus) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
