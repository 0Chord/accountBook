package miniProject.accountBook.controller;

import miniProject.accountBook.domain.Board;
import miniProject.accountBook.domain.Member;
import miniProject.accountBook.service.BoardService;
import miniProject.accountBook.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/boards")
public class BoardsController {

    BoardService boardService;
    MemberService memberService;

    public BoardsController(BoardService boardService, MemberService memberService) {
        this.boardService = boardService;
        this.memberService = memberService;
    }

    @GetMapping("/contents")
    public String view(Model model){
        List<Board> boards = boardService.findBoards();
        model.addAttribute("boards",boards);
        return "boards/contents";
    }

    @GetMapping("{id}/new")
    public String write(Model model, @RequestParam("id") String id){
        Member member = memberService.findOne(id);
        model.addAttribute("member",member);
        return "boards/write";
    }
}
