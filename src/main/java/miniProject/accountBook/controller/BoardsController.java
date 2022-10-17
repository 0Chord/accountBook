package miniProject.accountBook.controller;

import miniProject.accountBook.domain.Board;
import miniProject.accountBook.domain.Member;
import miniProject.accountBook.service.BoardService;
import miniProject.accountBook.service.MemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/boards")
public class BoardsController {
    private final Logger logger = LoggerFactory.getLogger(BoardsController.class);
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
    public String writingForm(Model model, @PathVariable("id") String id){
        Member member = memberService.findOne(id);
        model.addAttribute("member",member);
        return "boards/write";
    }

    @PostMapping("{id}/new")
    public String write(Model model, BoardForm boardForm, @PathVariable("id") String id){
        Member member = memberService.findOne(id);
        Board board = new Board();
        board.setNickname(member.getNickname());
        board.setDate(boardForm.getDate());
        board.setContent(boardForm.getContent());
        board.setTitle(boardForm.getTitle());
        boardService.writing(board);
        model.addAttribute("member",member);
        return "signIn/private";
    }
}
