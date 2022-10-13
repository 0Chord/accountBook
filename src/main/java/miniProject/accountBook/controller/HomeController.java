package miniProject.accountBook.controller;

import miniProject.accountBook.domain.Member;
import miniProject.accountBook.dto.LoginForm;
import miniProject.accountBook.service.MemberService;
import miniProject.accountBook.session.SessionConst;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class HomeController {

    MemberService memberService;

    public HomeController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/")
    public String home(@ModelAttribute LoginForm loginForm) {
        return "Home";
    }

    @PostMapping("/")
    public String auth(@ModelAttribute @Validated LoginForm loginForm, BindingResult bindingResult, Model model,
                       HttpServletRequest request) {

        if(bindingResult.hasErrors()){
            return "Home";
        }
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        Member member = memberService.findOne(loginForm.getLoginId());
        if(member == null){
            bindingResult.reject("loginFail","아이디 또는 비번이 일치하지 않습니다.");
            return "Home";
        }
        if(!encoder.matches(loginForm.getPassword(),member.getPassword())){
            bindingResult.reject("loginFail","아이디 또는 비번이 일치하지 않습니다.");
        }

        HttpSession httpSession = request.getSession();
        httpSession.setAttribute(SessionConst.LOGIN_MEMBER,member);

        model.addAttribute("member", member);
        return "signIn/private";
    }
}
