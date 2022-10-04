package miniProject.accountBook.service;

import miniProject.accountBook.domain.Account;
import miniProject.accountBook.repository.AccountRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
public class AccountService {

    AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public String register(Account account){
        accountRepository.save(account);
        return account.getUsername();
    }

    public List<Account> findAccount(){
        return accountRepository.findAll();
    }

    public List<Account> findByIdAccount(String id){
        return accountRepository.findById(id);
    }
}
