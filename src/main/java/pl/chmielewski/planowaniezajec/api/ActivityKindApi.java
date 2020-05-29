package pl.chmielewski.planowaniezajec.api;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.chmielewski.planowaniezajec.model.ActivityKind;
import pl.chmielewski.planowaniezajec.repo.ActivityKindRepo;

import javax.transaction.Transactional;

@RestController
@Transactional
@CrossOrigin
public class ActivityKindApi {
    private ActivityKindRepo activityKindRepo;

    public ActivityKindApi(ActivityKindRepo activityKindRepo) {
        this.activityKindRepo = activityKindRepo;
    }
    @GetMapping("/getAllActivityKinds")
    public Iterable<ActivityKind> getAll(){return activityKindRepo.findAll();}
}
