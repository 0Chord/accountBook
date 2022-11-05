package miniProject.accountBook.controller;

import miniProject.accountBook.domain.Mbti;
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
        model.addAttribute("mbtiForm",new MbtiForm());
        model.addAttribute("member",member);
        return "mbti/mbtiForm";
    }

    @PostMapping("/{id}/registration")
    public String analyze(@Validated MbtiForm mbtiForm, Model model, @PathVariable("id") String id){
        Mbti mbti = new Mbti();
        Long[] resultForm = new Long[4];
        Member member = memberService.findOne(id);
        Mbti compareMbti = mbtiService.findByName(member.getNickname());
        System.out.println("mbtiForm = " + mbtiForm);
        resultForm[0] = Long.parseLong(mbtiForm.getFirstProblem());
        resultForm[1] = Long.parseLong(mbtiForm.getSecondProblem());
        resultForm[2] = Long.parseLong(mbtiForm.getThirdProblem());
        resultForm[3] = Long.parseLong(mbtiForm.getFourthProblem());
        resultForm[0] += Long.parseLong(mbtiForm.getFifthProblem());
        resultForm[1] += Long.parseLong(mbtiForm.getSixthProblem());
        resultForm[2] += Long.parseLong(mbtiForm.getSeventhProblem());
        resultForm[3] += Long.parseLong(mbtiForm.getEighthProblem());
        resultForm[0] += Long.parseLong(mbtiForm.getNinthProblem());
        resultForm[1] += Long.parseLong(mbtiForm.getTenthProblem());

        String result = "";

        if(resultForm[0] <=0){
            result+= "I";
        }else{
            result += "E";
        }

        if(resultForm[1] <= 0){
            result += "N";
        }else{
            result += "S";
        }

        if(resultForm[2] <= 0){
            result += "T";
        }else{
            result += "F";
        }

        if(resultForm[3] <= 0){
            result += "P";
        }else{
            result += "J";
        }
        if(compareMbti==null){
            mbti.setUsername(member.getNickname());
            mbti.setResult(result);
            mbtiService.store(mbti);

            model.addAttribute("member",mbti);

        }else{
            mbtiService.updateMbti(member.getNickname(),result);
            model.addAttribute("member",mbtiService.findByName(member.getNickname()));
        }
        System.out.println("result = " + result);

        return "mbti/mbtiResult";
    }
}
