package pl.chmielewski.planowaniezajec.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.chmielewski.planowaniezajec.model.Activity;

@Repository
public interface ActivityRepo extends JpaRepository<Activity,Integer> {
}
