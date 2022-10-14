package miniProject.accountBook.repository;

import miniProject.accountBook.domain.Board;

import java.util.List;
import java.util.Optional;

public interface BoardRepository {

    Board save(Board board);

    Board remove(Board board);

    Board fetch(Board board);

    Optional<Board> findById(Long id);

    List<Board> findAll();
}
