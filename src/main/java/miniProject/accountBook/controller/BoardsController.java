package miniProject.accountBook.controller;

import miniProject.accountBook.domain.Board;
import miniProject.accountBook.domain.Member;
import miniProject.accountBook.dto.CheckBoxForm;
import miniProject.accountBook.service.BoardService;
import miniProject.accountBook.service.MemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/boards")
public class BoardsController {
    private final Logger logger = LoggerFactory.getLogger(BoardsController.class);
    private final BoardService boardService;
    private final MemberService memberService;

    public BoardsController(BoardService boardService, MemberService memberService) {
        this.boardService = boardService;
        this.memberService = memberService;
    }


    @GetMapping("/contents")
    public String view(Model model, @PageableDefault(page=0, size=10, sort="orderId",direction = Sort.Direction.DESC) Pageable pageable,
                       String searchKeyword){

        Page<Board> boards = null;

        if(searchKeyword == null){
            boards = boardService.boardList(pageable);
        }else{
            boards = boardService.findByTitle(searchKeyword, pageable);
        }

        int nowPage = boards.getPageable().getPageNumber() + 1;
        int startPage = Math.max(nowPage - 4, 1);
        int endPage = Math.min(nowPage+9, boards.getTotalPages());

        model.addAttribute("boards",boards);
        model.addAttribute("nowPage",nowPage);
        model.addAttribute("startPage",startPage);
        model.addAttribute("endPage",endPage);
        return "boards/contents";
    }

    @GetMapping("{id}/new")
    public String writingForm(Model model, @PathVariable("id") String id){
        Member member = memberService.findOne(id);
        model.addAttribute("member",member);
        model.addAttribute("checkboxForm",new CheckBoxForm());
        return "boards/write";
    }

    @PostMapping("{id}/new")
    public String write(Model model, BoardForm boardForm, CheckBoxForm checkBoxForm, @PathVariable("id") String id){
        Member member = memberService.findOne(id);
        Board board = new Board();
        board.setNickname(member.getNickname());
        board.setDate(boardForm.getDate());
        board.setContent(boardForm.getContent());
        board.setTitle(boardForm.getTitle());
        board.setChecked(checkBoxForm.isChecked());
        board.setCountVisit(1L);
        boardService.writing(board);
        model.addAttribute("member",member);
        return "signIn/private";
    }
}
