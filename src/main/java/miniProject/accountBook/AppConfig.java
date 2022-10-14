package miniProject.accountBook;

import miniProject.accountBook.repository.*;
import miniProject.accountBook.service.AccountService;
import miniProject.accountBook.service.BoardService;
import miniProject.accountBook.service.CalculatorService;
import miniProject.accountBook.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import javax.persistence.EntityManager;

@Configuration
public class AppConfig {

    private final EntityManager em;

    @Autowired
    public AppConfig(EntityManager em) {
        this.em = em;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new JpaMemberRepository(em);
    }

    @Bean
    public AccountRepository accountRepository() {
        return new JpaAccountRepository(em);
    }

    @Bean
    public AccountService accountService() {
        return new AccountService(accountRepository());
    }

    @Bean
    public CalculatorRepository calculatorRepository() {
        return new JpaCalculatorRepository(em);
    }

    @Bean
    public CalculatorService calculatorService() {
        return new CalculatorService(calculatorRepository());
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public BoardRepository boardRepository() {
        return new JpaBoardRepository(em);
    }

    @Bean
    public BoardService boardService() {
        return new BoardService(boardRepository());
    }
}
