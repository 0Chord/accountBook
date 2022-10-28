package miniProject.accountBook.repository;

import miniProject.accountBook.domain.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BoardRepository extends JpaRepository<Board, Integer> {

    Board save(Board board);

    Optional<Board> findByOrderId(Long orderId);

    Page<Board> findByTitleContaining(String searchKeyword, Pageable pageable);
}
