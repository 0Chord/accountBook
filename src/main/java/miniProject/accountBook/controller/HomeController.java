package miniProject.accountBook.controller;

import miniProject.accountBook.member.Member;
import miniProject.accountBook.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class HomeController {

    MemberService memberService;

    public HomeController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/")
    public String home(){
        return "Home";
    }

    @PostMapping("/")
    public String auth(MemberForm memberForm, Model model){
        Optional<Member> member = memberService.findOne(memberForm.getId());
        if(member.get().getPassword().equals(memberForm.getPassword())){
            model.addAttribute("member",member.get());
            return "signIn/private";
        }else{
            return "redirect:/";
        }
    }

}
