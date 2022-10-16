package miniProject.accountBook.controller;

import miniProject.accountBook.domain.Board;
import miniProject.accountBook.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/view")
public class ViewController {

    BoardService boardService;

    public ViewController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping("{orderId}")
    public String viewing(Model model, @PathVariable("orderId") Long orderId){
        Board board = boardService.findOne(orderId).get();
        model.addAttribute("board",board);
        return "boards/view";
    }

}
