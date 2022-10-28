package miniProject.accountBook.service;

import miniProject.accountBook.domain.Board;
import miniProject.accountBook.repository.BoardRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class BoardService {

    BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    public Long writing(Board board){
        boardRepository.save(board);
        return board.getOrderId();
    }

    public Long removing(Board board){
        boardRepository.delete(board);
        return board.getOrderId();
    }

    public List<Board> findBoards(){
        return boardRepository.findAll();
    }

    public Optional<Board> findOne(Long memberId){
        return boardRepository.findByOrderId(memberId);
    }

    public void updateVisit(Long id, Long visitCount){
        Board board = boardRepository.findByOrderId(id).get();

        board.updateVisit(visitCount);
    }

    public void updateBoard(Long id, String content, String title, Boolean checked){
        Board board = boardRepository.findByOrderId(id).get();
        board.updateBoolean(checked);
        board.updateContent(content);
        board.updateTitle(title);
    }

    public Page<Board> boardList(Pageable pageable){
        return boardRepository.findAll(pageable);
    }

    public Page<Board> findByTitle(String searchKeyword, Pageable pageable){
        return boardRepository.findByTitleContaining(searchKeyword, pageable);
    }
}
