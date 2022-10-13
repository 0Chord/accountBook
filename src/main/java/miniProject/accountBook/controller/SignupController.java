package miniProject.accountBook.controller;

import miniProject.accountBook.domain.Member;
import miniProject.accountBook.service.MemberService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/signup")
public class SignupController {

    private MemberService memberService;

    public SignupController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/new")
    public String signPage(@ModelAttribute MemberForm memberForm){
        return "/signup/New";
    }

    @PostMapping("/new")
    public String signUp(@ModelAttribute @Validated MemberForm memberForm, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "signup/New";
        }
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String securePassword = encoder.encode(memberForm.getPassword());
        Member member = new Member();
        member.setId(memberForm.getId());
        member.setPassword(securePassword);
        member.setNickname(memberForm.getNickname());
        System.out.println("securePassword = " + securePassword);
        boolean join = memberService.join(member);
        if(!join){
            bindingResult.reject("signupFail","아이디 또는 닉네임이 중복됩니다.");
            return "signup/New";
        }
        return "redirect:/";
    }
}
