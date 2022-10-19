package miniProject.accountBook.controller;

import miniProject.accountBook.domain.Member;
import miniProject.accountBook.dto.FindIdForm;
import miniProject.accountBook.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/search")
public class SearchController {

    MemberService memberService;

    public SearchController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/findId")
    public String findId(@ModelAttribute FindIdForm findIdForm){
        return "search/id";
    }
    @PostMapping("/findId")
    public String id(@ModelAttribute @Validated FindIdForm findIdForm, BindingResult bindingResult, Model model){

        if(bindingResult.hasErrors()){
            return "Home";
        }
        
        Member member = memberService.findOneByName(findIdForm.getName());
        if(member == null){
            bindingResult.reject("searchFail","등록된 사용자가 아닙니다. 다시 시도해주시길 바랍니다.");
            return "search/id";
        }

        if(!member.getPhone().equals(findIdForm.getPhone())){
            bindingResult.reject("searchFail","등록된 사용자가 아닙니다. 다시 시도해주시길 바랍니다");
            return "search/id";
        }

        model.addAttribute("member",member);
        return "search/findId";
    }
}
