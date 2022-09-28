package miniProject.accountBook.controller;

import miniProject.accountBook.member.Member;
import miniProject.accountBook.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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
    public String signPage(){
        return "/signup/New";
    }

    @PostMapping("/new")
    public String signUp(MemberForm memberForm){
        Member member = new Member();
        member.setId(memberForm.getId());
        member.setPassword(memberForm.getPassword());
        member.setNickname(memberForm.getNickname());
        memberService.join(member);
        return "redirect:/";
    }
}
