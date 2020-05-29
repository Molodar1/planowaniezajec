package pl.chmielewski.planowaniezajec.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.chmielewski.planowaniezajec.model.ActivityType;

@Repository
public interface ActivityTypeRepo extends JpaRepository<ActivityType,Integer> {
    public ActivityType getActivityTypeById(int id);
}
