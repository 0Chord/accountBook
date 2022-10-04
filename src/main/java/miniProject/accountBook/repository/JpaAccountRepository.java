package miniProject.accountBook.repository;


import miniProject.accountBook.domain.Account;
import miniProject.accountBook.domain.Member;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class JpaAccountRepository implements AccountRepository{

    EntityManager em;

    public JpaAccountRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Account save(Account account) {
        em.persist(account);
        return account;
    }

    @Override
    public List<Account> findAll() {
        return em.createQuery("select a from Account a",Account.class).getResultList();
    }

    @Override
    public List<Account> findById(String username) {
        List<Account> result = em.createQuery("select a from Account a where a.username = :username", Account.class)
                .setParameter("username",username)
                .getResultList();
        return result;
    }


}
