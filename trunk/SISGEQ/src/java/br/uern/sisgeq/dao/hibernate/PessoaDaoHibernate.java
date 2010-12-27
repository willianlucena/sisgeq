package br.uern.sisgeq.dao.hibernate;

import br.uern.sisgeq.dao.PessoaDao;
import br.uern.sisgeq.model.Pessoa;
import br.uern.sisgeq.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Felipe Lemos
 */
public class PessoaDaoHibernate implements PessoaDao {

    public void save(Pessoa pessoa) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.save(pessoa);
        t.commit();
    }

    public Pessoa getPessoa(long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        return (Pessoa) session.load(Pessoa.class, id);
    }

    public List<Pessoa> list(Boolean ativo) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        List lista = session.createQuery("from Pessoa where ativo = :ativo")
                .setParameter("ativo", ativo)
                .list();
        t.commit();
        return lista;
    }

    public void remove(Pessoa pessoa) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.delete(pessoa);
        t.commit();
    }

    public void update(Pessoa pessoa) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.update(pessoa);
        t.commit();
    }
}
