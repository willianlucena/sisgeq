package br.uern.sisgeq.dao;

import br.uern.sisgeq.model.Perfil;
import java.util.List;

/**
 *
 * @author Felipe Lemos
 */
public interface PerfilDao {

    public void save(Perfil perfil);

    public Perfil getPerfil(long id);

    public List<Perfil> list();

    public List<Perfil> getPerfisComFiltros(String tipo);

    public void remove(Perfil perfil);

    public void update(Perfil perfil);
}
