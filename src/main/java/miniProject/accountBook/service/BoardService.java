package miniProject.accountBook.service;

import miniProject.accountBook.domain.Board;
import miniProject.accountBook.repository.BoardRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class BoardService {

    private BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    public Long writing(Board board){
        boardRepository.save(board);
        return board.getOrderId();
    }

    public Long removing(Board board){
        boardRepository.remove(board);
        return board.getOrderId();
    }

    public Long updating(Board board){
        boardRepository.fetch(board);
        return board.getOrderId();
    }

    public List<Board> findBoards(){
        return boardRepository.findAll();
    }

    public Optional<Board> findOne(Long memberId){
        return boardRepository.findById(memberId);
    }

    public void updateVisit(Long id, Long visitCount){
        Board board = boardRepository.findById(id).get();

        board.updateVisit(visitCount);
    }
}
