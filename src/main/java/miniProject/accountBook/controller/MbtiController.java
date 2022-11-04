package miniProject.accountBook.controller;

import miniProject.accountBook.domain.Member;
import miniProject.accountBook.dto.MbtiForm;
import miniProject.accountBook.service.MbtiService;
import miniProject.accountBook.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mbti")
public class MbtiController {

    MbtiService mbtiService;
    MemberService memberService;

    public MbtiController(MbtiService mbtiService, MemberService memberService) {
        this.mbtiService = mbtiService;
        this.memberService = memberService;
    }

    @GetMapping("/{id}/mbtiForm")
    public String viewMbti(Model model, @PathVariable("id") String id){
        Member member = memberService.findOne(id);
        model.addAttribute("member",member);
        return "mbti/mbtiForm";
    }

    @PostMapping("/{id}/registration")
    public String analyze(@Validated MbtiForm mbtiForm, Model model, @PathVariable("id") String id){
        return null;
    }
}
