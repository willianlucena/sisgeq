package br.uern.sisgeq.dao.hibernate;

import br.uern.sisgeq.dao.PessoaDao;
import br.uern.sisgeq.model.Pessoa;
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

    public List<Pessoa> getPessoasComFiltros(String matricula, String nome, String curso, String departamento) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        Criteria criteria = session.createCriteria(Pessoa.class);
        criteria.add(Restrictions.eq("ativo", true));

        if (matricula != null && matricula.length() > 1) {
            System.out.println("add matricula no criteria");
            System.out.println("matricula: " + matricula);
            criteria.add(Restrictions.ilike("matricula", matricula + "%"));
        }

        if (nome != null && nome.length() > 1) {
            System.out.println("add nome no criteria");
            System.out.println("nome: " + nome);
            criteria.add(Restrictions.ilike("nome", nome + "%"));
        }

        if (curso != null && curso.length() > 1) {
            System.out.println("add curso no criteria");
            System.out.println("curso: " + curso);
            //cria um novo criteria para acessar o campo departamento de pessoa
            criteria.createCriteria("curso").add(Restrictions.ilike("nome", curso + "%"));
        }

        if (departamento != null && departamento.length() > 1) {
            System.out.println("add departamento no criteria");
            System.out.println("departamento: " + departamento);
            //cria um novo criteria para acessar o campo departamento de pessoa
            criteria.createCriteria("departamento").add(Restrictions.ilike("nome", departamento + "%"));
        }

        List lista = criteria.list();
        t.commit();
        session.close();
        return lista;
    }
}
