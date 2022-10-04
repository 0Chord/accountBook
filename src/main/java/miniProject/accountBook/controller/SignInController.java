package miniProject.accountBook.controller;

import miniProject.accountBook.domain.Account;
import miniProject.accountBook.domain.Calculator;
import miniProject.accountBook.domain.Member;
import miniProject.accountBook.service.AccountService;
import miniProject.accountBook.service.CalculatorService;
import miniProject.accountBook.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/signIn")
public class SignInController {

    MemberService memberService;
    AccountService accountService;
    CalculatorService calculatorService;

    public SignInController(MemberService memberService, AccountService accountService, CalculatorService calculatorService) {
        this.memberService = memberService;
        this.accountService = accountService;
        this.calculatorService = calculatorService;
    }

    @GetMapping("{id}/registration")
    public String register(Model model, @PathVariable("id") String id){
        Optional<Member> member = memberService.findOne(id);
        model.addAttribute("member",member.get());
        return "signIn/registration";
    }

    @PostMapping("{id}/registration")
    public String account(AccountForm accountForm, SelectionForm selectionForm, @PathVariable("id") String id){
        Account account = new Account();
        Calculator calculator = new Calculator();
        account.setUsername(id);
        account.setItem(accountForm.getItem());
        account.setPrice(accountForm.getPrice());
        account.setDate(accountForm.getDate());
        accountService.register(account);
        calculator.setUsername(id);
        calculator.setDate(accountForm.getDate());
        Optional<Calculator> result = calculatorService.findOneCalculator(id);
        if(selectionForm.getOption().equals("import")){
            calculator.setImportSum(accountForm.getPrice()+result.get().getImportSum());
            calculator.setExportSum(0L);
        }else if(selectionForm.getOption().equals("export")) {
            calculator.setExportSum(accountForm.getPrice() + result.get().getExportSum());
            calculator.setImportSum(0L);
        }
        calculatorService.register(calculator);
        return "redirect:/";
    }

    @GetMapping("{id}/account")
    public String view(Model model, @PathVariable("id") String id){
//        List<Account> accounts = accountService.findByIdAccount(id);
        List<Account> accounts = accountService.findAccount();
        model.addAttribute("accounts",accounts);
        return "signIn/account";
    }
}
