package br.uern.sisgeq.dao;

import br.uern.sisgeq.model.Campus;
import br.uern.sisgeq.model.Nucleo;
import java.util.List;

/**
 *
 * @author willian
 */
public interface NucleoDao extends DAO {

    public Nucleo getNucleo(Integer id);

    public List<Nucleo> getNucleos();

    public List<Nucleo> getNucleosByCampus(Campus campus);

    public void saveOrUpdate(Nucleo nucleo);

    public void remove(Nucleo nucleo);
}
