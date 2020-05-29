package pl.chmielewski.planowaniezajec.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.chmielewski.planowaniezajec.model.ActivityKind;

@Repository
public interface ActivityKindRepo extends JpaRepository<ActivityKind,Integer> {
}
