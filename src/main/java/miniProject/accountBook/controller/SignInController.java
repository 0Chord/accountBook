package miniProject.accountBook.controller;

import miniProject.accountBook.domain.Member;
import miniProject.accountBook.service.AccountService;
import miniProject.accountBook.service.CalculatorService;
import miniProject.accountBook.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
