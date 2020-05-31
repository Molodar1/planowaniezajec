package pl.chmielewski.planowaniezajec;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import pl.chmielewski.planowaniezajec.model.*;
import pl.chmielewski.planowaniezajec.repo.ActivityKindRepo;
import pl.chmielewski.planowaniezajec.repo.ActivityRepo;
import pl.chmielewski.planowaniezajec.repo.ActivityTypeRepo;


import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Component
@Transactional
public class StartClass {
    private ActivityRepo activityRepo;
    private ActivityTypeRepo activityTypeRepo;
    private ActivityKindRepo activityKindRepo;


//    private List<Equipment> equipmentlist;
//    private long id=1,id2=2;
//private Classification classification=Classification.PILKI;
//Equipment equipment=new Equipment(id,"Pilka do baseballa", Classification.PILKI,"bb",false,true);
//Equipment equipment1=new Equipment(id2,"abcabc", Classification.PILKI,"cc",false,true);
//
////    {"equipmentName":"Pilka do baseballa","classification":"PILKI","specification":"bb","broken":false,"availability":true,"id":1},
////    {"equipmentName":"abcabc","classification":"PILKI","specification":"cc","broken":false,"availability":true,"id":2},
//
//
//    @Autowired
//    public StartClass(ActivityRepo activityRepo,ActivityTypeRepo activityTypeRepo,ActivityKindRepo activityKindRepo) {
//        this.activityRepo = activityRepo;
//        this.activityTypeRepo=activityTypeRepo;
//        this.activityKindRepo=activityKindRepo;
//    }
//        @EventListener(ApplicationReadyEvent.class)
//                public void init() {
//            equipmentlist = new ArrayList<>();
//            equipmentlist.add(equipment);
//            equipmentlist.add(equipment1);
//
//
//
//            ActivityType activityType1=new ActivityType("Sztuki Walki");
//            ActivityType activityType2=new ActivityType("Sporty Siłowe");
//            ActivityType activityType3=new ActivityType("Aerobik");
//            ActivityType activityType4=new ActivityType("Zajęcia Taneczne");
//
//            Activity activity1 = new Activity("Pierwsze zajęcia", "Robert Makłowicz", activityType1.getName(), "19.03.2020", "7:00", "10:00", equipmentlist, false);
//
//
//
//            ActivityKind activityKind1=new ActivityKind("Basic");
//            ActivityKind activityKind2=new ActivityKind("Premium");
//            ActivityKind activityKind3=new ActivityKind("VIP");
//
//
//            activityRepo.save(activity1);
//            activityTypeRepo.save(activityType1);
//            activityTypeRepo.save(activityType2);
//            activityTypeRepo.save(activityType3);
//            activityTypeRepo.save(activityType4);
//
//            activityKindRepo.save(activityKind1);
//            activityKindRepo.save(activityKind2);
//            activityKindRepo.save(activityKind3);
//       List<Activity> activity= activityRepo.getActivitiesByDate("19.03.2020");
//            System.out.println(activity.toString());
//        }


}
