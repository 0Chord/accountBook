package miniProject.accountBook.repository;

import miniProject.accountBook.domain.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends JpaRepository<Location, String> {
    Location save(Location location);
}
