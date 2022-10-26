package miniProject.accountBook.controller;

import miniProject.accountBook.domain.Board;
import miniProject.accountBook.domain.Calculator;
import miniProject.accountBook.domain.Comment;
import miniProject.accountBook.domain.Member;
import miniProject.accountBook.dto.CheckBoxForm;
import miniProject.accountBook.dto.CommentForm;
import miniProject.accountBook.dto.CommentPasswordForm;
import miniProject.accountBook.service.BoardService;
import miniProject.accountBook.service.CalculatorService;
import miniProject.accountBook.service.CommentService;
import miniProject.accountBook.service.MemberService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/view")
public class ViewController {

    BoardService boardService;
    MemberService memberService;
    CalculatorService calculatorService;
    CommentService commentService;
    public ViewController(BoardService boardService, MemberService memberService, CalculatorService calculatorService, CommentService commentService) {
        this.boardService = boardService;
        this.memberService = memberService;
        this.calculatorService = calculatorService;
        this.commentService = commentService;
    }

    @GetMapping("{orderId}")
    public String viewing(Model model, @PathVariable("orderId") Long orderId,  @ModelAttribute BoardForm boardForm){
        Board board = boardService.findOne(orderId).get();
        Member member = memberService.findOneByNickname(board.getNickname());
        Calculator calculator = calculatorService.findOneCalculator(member.getId()).get();
        Long updateCount = board.getCountVisit() + 1L;
        boardService.updateVisit(orderId, updateCount);
        List<Comment> comments = commentService.findCommentsByBoardId(orderId);
        model.addAttribute("comments",comments);
        model.addAttribute("board",board);
        model.addAttribute("calculator",calculator);
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
        if(!decoder.matches(boardForm.getPassword(),member.getPassword())){
            bindingResult.reject("loginFail","비밀번호가 일치하지 않습니다.");
            model.addAttribute("board", board);
            return "boards/view";
        }
        boardService.removing(board);
        model.addAttribute("member",member);
        return "signIn/private";
    }

    @GetMapping("{id}/patch")
    public String emend(Model model, @PathVariable("id") Long orderId, @ModelAttribute BoardForm boardForm){
        Board board = boardService.findOne(orderId).get();
        model.addAttribute("board",board);
        model.addAttribute("checkboxForm",new CheckBoxForm());
        return "boards/patch";
    }

    @PostMapping("{id}/patch")
    public String update(@ModelAttribute @Validated BoardForm boardForm,CheckBoxForm checkBoxForm, BindingResult bindingResult, Model model, @PathVariable("id") Long orderId){
        Board board = boardService.findOne(orderId).get();
        Member member = memberService.findOneByNickname(board.getNickname());
        if(bindingResult.hasErrors()){
            model.addAttribute("member",member);
            return "signIn/private";
        }

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        if(!encoder.matches(boardForm.getPassword(),member.getPassword())){
            bindingResult.reject("loginFail","비밀번호가 일치하지 않습니다.");
            model.addAttribute("board", board);
            return "boards/patch";
        }
        boardService.updateBoard(orderId, boardForm.getContent(), boardForm.getTitle(), checkBoxForm.isChecked());
        model.addAttribute("member",member);
        return "signIn/private";
    }

    @PostMapping("{id}/comment")
    public String registerComment(@Validated CommentForm commentForm, Model model,@PathVariable("id") Long orderId){
        Board board = boardService.findOne(orderId).get();
        Comment comment = new Comment();
        comment.setBoardComment(commentForm.getBoardComment());
        comment.setNickname(commentForm.getNickname());
        comment.setDate(commentForm.getDate());
        comment.setBoard(board);

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        String encodingPassword = encoder.encode(commentForm.getCommentPassword());
        comment.setCommentPassword(encodingPassword);

        commentService.store(comment);

        Member member = memberService.findOneByNickname(board.getNickname());
        Calculator calculator = calculatorService.findOneCalculator(member.getId()).get();
        List<Comment> comments = commentService.findCommentsByBoardId(orderId);

        CommentPasswordForm commentPasswordForm = new CommentPasswordForm();
        BoardForm boardForm = new BoardForm();
        model.addAttribute("commentPasswordForm",commentPasswordForm);
        model.addAttribute("boardForm",boardForm);
        model.addAttribute("comments",comments);
        model.addAttribute("board",board);
        model.addAttribute("calculator",calculator);

        return "boards/view";
    }

    @PostMapping("{commentId}/deleteComment")
    public String deleteComment(@Validated CommentPasswordForm commentPasswordForm, @PathVariable("commentId") Long commentId,Model model){
        System.out.println("commentId = " + commentId);
        Comment comment = commentService.findCommentByCommentKey(commentId).get();
        System.out.println("comment = " + comment);
        Board board = comment.getBoard();
        Member member = memberService.findOneByNickname(board.getNickname());
        Calculator calculator = calculatorService.findOneCalculator(member.getId()).get();
        List<Comment> comments = commentService.findCommentsByBoardId(board.getOrderId());
        BCryptPasswordEncoder decoder = new BCryptPasswordEncoder();
        List<Board> boards = boardService.findBoards();

        if(!decoder.matches(commentPasswordForm.getCommentDeletePassword(),comment.getCommentPassword())){
            model.addAttribute("boards",boards);
            return "boards/contents";
        }
        commentService.removeComment(comment);
        model.addAttribute("boards",boards);
        return "boards/contents";
    }
}
