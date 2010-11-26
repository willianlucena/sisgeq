package br.uern.sisgeq.dao;

import br.uern.sisgeq.model.Campus;
import br.uern.sisgeq.model.Departamento;
import br.uern.sisgeq.model.Nucleo;
import java.util.List;

/**
 *
 * @author willian
 */
public interface DepartamentoDao extends DAO {

    public Departamento getDepartamento(Integer id);

    public List<Departamento> getDepartamentos();

    public List<Departamento> getDepartamentosByCampus(Campus campus);

    public List<Departamento> getDepartamentosByNucleo(Nucleo nucleo);

    public void saveOrUpdateDepartamento(Departamento Departamento);

    public void removeDepartamento(Departamento Departamento);
}
