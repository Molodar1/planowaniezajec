package pl.chmielewski.planowaniezajec.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.chmielewski.planowaniezajec.repo.ActivityRepo;

@Service
public class ActivityService {
    private ActivityRepo activityRepo;

    @Autowired
    public ActivityService(ActivityRepo activityRepo) {
        this.activityRepo = activityRepo;
    }

}
