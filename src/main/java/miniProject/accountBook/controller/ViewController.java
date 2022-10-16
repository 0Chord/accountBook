package miniProject.accountBook.controller;

import miniProject.accountBook.domain.Board;
import miniProject.accountBook.domain.Member;
import miniProject.accountBook.service.BoardService;
import miniProject.accountBook.service.MemberService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/view")
public class ViewController {

    BoardService boardService;
    MemberService memberService;

    public ViewController(BoardService boardService, MemberService memberService) {
        this.boardService = boardService;
        this.memberService = memberService;
    }

    @GetMapping("{orderId}")
    public String viewing(Model model, @PathVariable("orderId") Long orderId,  @ModelAttribute BoardForm boardForm){
        Board board = boardService.findOne(orderId).get();
        model.addAttribute("board",board);
        return "boards/view";
    }

    @PostMapping("{id}/delete")
    public String removing(@ModelAttribute @Validated BoardForm boardForm, BindingResult bindingResult, Model model, @PathVariable("id") Long id){
        Board board = boardService.findOne(id).get();
        Member member = memberService.findOneByNickname(board.getNickname());
        if(bindingResult.hasErrors()){
            model.addAttribute("member",member);
            return "signIn/private";
        }
        BCryptPasswordEncoder decoder = new BCryptPasswordEncoder();
        if(!decoder.matches(boardForm.getPassword(),board.getPassword())){
            bindingResult.reject("loginFail","아이디 또는 비번이 일치하지 않습니다.");
            model.addAttribute("board", board);
            return "boards/view";
        }
        boardService.removing(board);
        model.addAttribute("member",member);
        return "signIn/private";
    }
}
