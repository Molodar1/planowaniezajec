package pl.chmielewski.planowaniezajec.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.chmielewski.planowaniezajec.model.ActivityType;
import pl.chmielewski.planowaniezajec.repo.ActivityTypeRepo;

@Service
public class ActivityTypeService {
    private ActivityTypeRepo activityTypeRepo;

    @Autowired
    public ActivityTypeService(ActivityTypeRepo activityTypeRepo) {
        this.activityTypeRepo = activityTypeRepo;
    }

    public Iterable<ActivityType> findAll()
    {
        return activityTypeRepo.findAll();
    }
    public ActivityType getActivityTypeById(int id){return activityTypeRepo.getActivityTypeById(id);}

}
