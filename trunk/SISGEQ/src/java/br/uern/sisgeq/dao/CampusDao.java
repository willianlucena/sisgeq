package br.uern.sisgeq.dao;

import br.uern.sisgeq.model.Campus;
import java.util.List;

/**
 *
 * @author willian
 */
public interface CampusDao extends DAO {

    public Campus getCampus(Integer id);

    public List<Campus> getCampi();

    public void saveOrUpdateCampus(Campus Campus);

    public void removeCampus(Campus Campus);
}
