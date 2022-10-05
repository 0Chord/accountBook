package miniProject.accountBook.repository;

import miniProject.accountBook.domain.Calculator;
import miniProject.accountBook.domain.Member;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class JpaCalculatorRepository implements CalculatorRepository{

    EntityManager em;

    public JpaCalculatorRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Calculator save(Calculator calculator) {
        em.persist(calculator);
        return calculator;
    }

    @Override
    public List<Calculator> findAll() {
        return em.createQuery("select c from Calculator c",Calculator.class).getResultList();
    }

    @Override
    public Optional<Calculator> findById(String username) {
        List<Calculator> result = em.createQuery("select c from Calculator c where c.username = :username", Calculator.class)
                .setParameter("username",username)
                .getResultList();
        return result.stream().findAny();
    }

    @Override
    public Calculator remove(Calculator calculator) {
        em.remove(calculator);
        return calculator;
    }
}
