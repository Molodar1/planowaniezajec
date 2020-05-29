package pl.chmielewski.planowaniezajec.service;

import org.springframework.stereotype.Service;
import pl.chmielewski.planowaniezajec.model.ActivityKind;
import pl.chmielewski.planowaniezajec.model.ActivityType;
import pl.chmielewski.planowaniezajec.repo.ActivityKindRepo;

@Service
public class ActivityKindService {

    private ActivityKindRepo activityKindRepo;

    public ActivityKindService(ActivityKindRepo activityKindRepo) {
        this.activityKindRepo = activityKindRepo;
    }

    public Iterable<ActivityKind> findAll()
    {
        return activityKindRepo.findAll();
    }
}
