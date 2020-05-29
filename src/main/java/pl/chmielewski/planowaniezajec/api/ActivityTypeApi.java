package pl.chmielewski.planowaniezajec.api;


import org.springframework.web.bind.annotation.*;
import pl.chmielewski.planowaniezajec.model.ActivityType;
import pl.chmielewski.planowaniezajec.repo.ActivityTypeRepo;

import javax.transaction.Transactional;

@RestController
@Transactional
@CrossOrigin
public class ActivityTypeApi {
    private ActivityTypeRepo activityTypeRepo;

    public ActivityTypeApi(ActivityTypeRepo activityTypeRepo) {
        this.activityTypeRepo = activityTypeRepo;
    }
    @GetMapping("/getAllActivityTypes")
    public Iterable<ActivityType> getAll(){return activityTypeRepo.findAll();}

    @GetMapping("/getActivityTypeById/{id}")
    public ActivityType getActivityTypeById(@PathVariable int id){ return activityTypeRepo.getActivityTypeById(id); }
}
