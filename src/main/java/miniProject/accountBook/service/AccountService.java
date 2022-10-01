package miniProject.accountBook.service;

import miniProject.accountBook.controller.AccountForm;
import miniProject.accountBook.domain.Account;
import miniProject.accountBook.repository.AccountRepository;
import miniProject.accountBook.repository.MemberRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public class AccountService {

    AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public String register(AccountForm accountForm){
        Account account = new Account();
        account.setId(accountForm.getId());
        account.setItem(accountForm.getItem());
        account.setPrice(accountForm.getPrice());
        account.setDate(accountForm.getDate());
        accountRepository.save(account);
        return account.getId();
    }

    public List<Account> findAccount(){
        return accountRepository.findAll();
    }
}
