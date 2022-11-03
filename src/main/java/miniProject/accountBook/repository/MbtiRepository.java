package miniProject.accountBook.repository;

import miniProject.accountBook.domain.Mbti;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MbtiRepository extends JpaRepository<Mbti, String> {

    Mbti save(Mbti mbti);

    Optional<Mbti> findByUsername(String username);
}
