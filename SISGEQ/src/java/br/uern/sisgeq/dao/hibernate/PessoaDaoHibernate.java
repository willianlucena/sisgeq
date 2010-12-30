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
        List lista = session.createQuery("from Pessoa where ativo = :ativo").setParameter("ativo", ativo).list();
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

    public List<Pessoa> getPessoasComFiltros(String matricula, String nome, String curso, String departamento, String cidade, String estado, String naturalidade, String nacionalidade) {
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

        if (cidade != null && cidade.length() > 1) {
            System.out.println("add cidade no criteria");
            System.out.println("cidade: " + cidade);
            criteria.add(Restrictions.ilike("cidade", cidade + "%"));
        }

        if (estado != null && estado.length() > 1) {
            System.out.println("add estado no criteria");
            System.out.println("estado: " + estado);
            criteria.add(Restrictions.ilike("estado", estado + "%"));
        }

        if (naturalidade != null && naturalidade.length() > 1) {
            System.out.println("add naturalidade no criteria");
            System.out.println("naturalidade: " + naturalidade);
            criteria.add(Restrictions.ilike("naturalidade", naturalidade + "%"));
        }

        if (nacionalidade != null && nacionalidade.length() > 1) {
            System.out.println("add nacionalidade no criteria");
            System.out.println("nacionalidade: " + nacionalidade);
            criteria.add(Restrictions.ilike("nacionalidade", nacionalidade + "%"));
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
