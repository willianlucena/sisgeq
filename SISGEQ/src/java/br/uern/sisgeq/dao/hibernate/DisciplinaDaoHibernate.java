package br.uern.sisgeq.dao.hibernate;

import br.uern.sisgeq.dao.DisciplinaDao;
import br.uern.sisgeq.model.Disciplina;
import br.uern.sisgeq.util.HibernateUtil;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Felipe Lemos
 */
public class DisciplinaDaoHibernate implements DisciplinaDao {

    public void save(Disciplina disciplina) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.save(disciplina);
        t.commit();
        session.close();
    }

    public Disciplina getDisciplina(long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        return (Disciplina) session.load(Disciplina.class, id);
    }

    public List<Disciplina> list(Boolean ativo) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        List lista = session.createQuery("from Disciplina where ativo = :ativo").setParameter("ativo", ativo).list();
        t.commit();
        session.close();
        return lista;
    }

    public void remove(Disciplina disciplina) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.delete(disciplina);
        t.commit();
        session.close();
    }

    public void update(Disciplina disciplina) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.update(disciplina);
        t.commit();
        session.close();
    }

    public List<Disciplina> getDisciplinaComFiltros(String codigo, String nome, String departamento) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        Criteria criteria = session.createCriteria(Disciplina.class);
        criteria.add(Restrictions.eq("ativo", true));

        if (codigo != null && codigo.length() > 1) {
            System.out.println("add codigo no criteria");
            System.out.println("codigo " + codigo);
            criteria.add(Restrictions.ilike("codigo", codigo + "%"));
        }

        if (nome != null && nome.length() > 1) {
            System.out.println("add nome no criteria");
            System.out.println("nome: " + nome);
            criteria.add(Restrictions.ilike("nome", nome + "%"));
        }

        if (departamento != null && departamento.length() > 1) {
            System.out.println("add departamento no criteria");
            System.out.println("departamento: " + departamento);
            //cria um novo criteria para acessar o campo departamento de disciplina
            criteria.createCriteria("departamento").add(Restrictions.ilike("nome", departamento + "%"));
        }

        List lista = criteria.list();
        t.commit();
        session.close();
        return lista;
    }
}
