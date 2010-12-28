package br.uern.sisgeq.dao;

import br.uern.sisgeq.model.Campus;
import java.util.List;

/**
 *
 * @author willian
 */
public interface CampusDao extends DAO {

    public Campus getCampus(Integer id);
    public Campus getCampusByNome(String nome);

    public List<Campus> getCampi(Boolean ativo);

    public List<Campus> getCampiComFiltros(String nome);

    public void save(Campus Campus);

    public void update(Campus campus);

    public void remove(Campus Campus);
}
