package miniProject.accountBook.repository;

import miniProject.accountBook.account.Account;
import miniProject.accountBook.calculator.Calculator;

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
    public Optional<Calculator> findById(String id) {
        Calculator calculator = em.find(Calculator.class,id);
        return Optional.ofNullable(calculator);
    }
}
