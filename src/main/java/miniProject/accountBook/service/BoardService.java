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
        return board.getOrder_id();
    }

    public Long removing(Board board){
        boardRepository.remove(board);
        return board.getOrder_id();
    }

    public Long updating(Board board){
        boardRepository.fetch(board);
        return board.getOrder_id();
    }

    public List<Board> findBoards(){
        return boardRepository.findAll();
    }

    public Optional<Board> findOne(Long memberId){
        return boardRepository.findById(memberId);
    }
}
