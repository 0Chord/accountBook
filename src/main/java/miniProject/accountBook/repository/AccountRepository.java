package miniProject.accountBook.repository;

import miniProject.accountBook.domain.Account;

import java.util.List;
import java.util.Optional;

public interface AccountRepository {
    Account save(Account account);
    List<Account> findAll();
    List<Account> findById(String id);
}
