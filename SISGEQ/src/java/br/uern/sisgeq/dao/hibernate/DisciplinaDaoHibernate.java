package br.uern.sisgeq.dao.hibernate;

import br.uern.sisgeq.dao.DisciplinaDao;
import br.uern.sisgeq.model.Disciplina;
import br.uern.sisgeq.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

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
        List lista = session.createQuery("from Disciplina where ativo = :ativo")
                .setParameter("ativo", ativo)
                .list();
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
}
