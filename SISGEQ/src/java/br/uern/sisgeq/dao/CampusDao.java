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

    public void save(Campus Campus);

    public void update(Campus campus);

    public void remove(Campus Campus);
}
