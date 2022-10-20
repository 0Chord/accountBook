package miniProject.accountBook.controller;

import miniProject.accountBook.domain.Member;
import miniProject.accountBook.dto.FindIdForm;
import miniProject.accountBook.dto.FindPasswordForm;
import miniProject.accountBook.dto.RewritePasswordForm;
import miniProject.accountBook.service.MemberService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/findPassword")
    public String findPassword(@ModelAttribute FindPasswordForm findPasswordForm){
        return "search/password";
    }

    @PostMapping("/findPassword")
    public String searchPassword(@ModelAttribute @Validated FindPasswordForm findPasswordForm, Model model, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return "Home";
        }

        Member member = memberService.findOne(findPasswordForm.getId());
        if(member == null){
            bindingResult.reject("searchFail","등록된 사용자가 아닙니다. 다시 시도해주시길 바랍니다.");
            return "search/password";
        }

        if(!member.getNickname().equals(findPasswordForm.getNickname())||!member.getName().equals(findPasswordForm.getName())
        ||!member.getPhone().equals(findPasswordForm.getPhone())){
            bindingResult.reject("searchFail","등록된 사용자가 아닙니다. 다시 시도해주시길 바랍니다.");
            return "search/password";
        }
        model.addAttribute("member",member);

        return "search/confirmUser";
    }

    @GetMapping("/{id}/rewrite")
    public String rewritingView(@ModelAttribute RewritePasswordForm rewritePasswordForm, @PathVariable("id") String id, Model model){
        Member member = memberService.findOne(id);
        model.addAttribute("member", member);
        return "search/rewritePassword";
    }

    @PostMapping("{id}/rewrite")
    public String rewriting(@ModelAttribute @Validated RewritePasswordForm rewritePasswordForm,
                            BindingResult bindingResult, Model model){

        System.out.println("rewritePasswordForm = " + rewritePasswordForm);
        if(bindingResult.hasErrors()){
            return "Home";
        }
        Member member = memberService.findOne(rewritePasswordForm.getId());
        if(member == null){
            return "Home";
        }
        
        if(!rewritePasswordForm.getPassword().equals(rewritePasswordForm.getValidatedPassword())){
            bindingResult.reject("validateFail","비밀번호가 일치하지 않습니다. 다시 입력해주세요.");    
            model.addAttribute("member",member);
            return "search/rewritePassword";
        }

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodePassword = encoder.encode(rewritePasswordForm.getPassword());
        System.out.println("encodePassword = " + encodePassword);
        System.out.println("member.getPassword() = " + member.getPassword());
        member.setPassword(encodePassword);
        memberService.put(member);
        
        return "redirect:/";
    }

    @GetMapping("/redirect")
    public String redirecting(){
        return "redirect:/";
    }
}
