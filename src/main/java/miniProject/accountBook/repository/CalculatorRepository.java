package miniProject.accountBook.repository;

import miniProject.accountBook.account.Account;
import miniProject.accountBook.calculator.Calculator;

import java.util.List;
import java.util.Optional;

public interface CalculatorRepository {

    Calculator save(Calculator calculator);
    List<Calculator> findAll();
    Optional<Calculator> findById(String id);
}
