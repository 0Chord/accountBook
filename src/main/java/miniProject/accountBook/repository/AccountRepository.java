package miniProject.accountBook.repository;

import miniProject.accountBook.account.Account;

import java.util.List;
import java.util.Optional;

public interface AccountRepository {
    Account save(Account account);
    List<Account> findAll();
}
