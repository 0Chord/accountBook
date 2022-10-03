package miniProject.accountBook.service;

import miniProject.accountBook.domain.Account;
import miniProject.accountBook.repository.AccountRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public class AccountService {

    AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public String register(Account account){
        accountRepository.save(account);
        return account.getId();
    }

    public List<Account> findAccount(){
        return accountRepository.findAll();
    }
}
