package pl.chmielewski.planowaniezajec.api;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import pl.chmielewski.planowaniezajec.model.Activity;

import pl.chmielewski.planowaniezajec.model.Classification;
import pl.chmielewski.planowaniezajec.model.Equipment;
import pl.chmielewski.planowaniezajec.repo.ActivityRepo;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;


@RestController
@Transactional
@CrossOrigin
public class ActivityApi {
   private ActivityRepo activityRepo;

    @Autowired
    private RestTemplate restTemplate;

@Autowired
    public ActivityApi(ActivityRepo activityRepo) {
        this.activityRepo = activityRepo;
    }

    @GetMapping("/getAllActivities")
    public Iterable<Activity> getAll(){return activityRepo.findAll();}

    @GetMapping("/getActivitiesByDate/{date}")
    public Iterable<Activity> getActivitiesByDate(@PathVariable String date){return activityRepo.getActivitiesByDate(date);}

    @GetMapping("/getActivitiesById/{id}")
    public Activity getActivitiesById(@PathVariable int id){return activityRepo.getActivityById(id);}

    @PutMapping("/updateActivity")
    public void updateActivity(@RequestBody Activity activity)
    {
        if(activity.isClassCanceled()) {
            activityRepo.updateActivity(
                    activity.getId(),
                    activity.getName(),
                    activity.getLeader(),
                    activity.getActivityType(),
                    activity.getDate(),
                    activity.getHourStart(),
                    activity.getHourEnd(),
                    activity.getEquipmentUsed(),
                    activity.isClassCanceled());
            changeEquipmentAvailabilityToAvailable(activity.getEquipmentUsed());
        }
        else
            {
                activityRepo.updateActivity(
                        activity.getId(),
                        activity.getName(),
                        activity.getLeader(),
                        activity.getActivityType(),
                        activity.getDate(),
                        activity.getHourStart(),
                        activity.getHourEnd(),
                        activity.getEquipmentUsed(),
                        activity.isClassCanceled());
                changeEquipmentAvailabilityToNotAvailable(activity.getEquipmentUsed());
        }

}
@PostMapping("/addActivity")
    public void addActivity(@RequestBody Activity activity){
    activityRepo.save(activity);
    changeEquipmentAvailabilityToNotAvailable(activity.getEquipmentUsed());




}
//@EventListener(ApplicationReadyEvent.class)
//public void changeEquipmentAvailabilityTest(){
//    List<Equipment> equipmentlist=new ArrayList<>();
//    long id=1,id2=2;
//     Classification classification=Classification.PILKI;
//    Equipment equipment=new Equipment(id,"Pilka do baseballa", Classification.PILKI,"bb",false,true);
//    Equipment equipment1=new Equipment(id2,"abcabc", Classification.PILKI,"cc",false,true);
//    equipmentlist.add(equipment);
//    equipmentlist.add(equipment1);
//    changeEquipmentAvailabilityToAvailable(equipmentlist);
//}
public void changeEquipmentAvailabilityToAvailable(List<Equipment> equipmentList){
    System.out.println(equipmentList);
    HttpEntity httpEntity=new HttpEntity(equipmentList);

    restTemplate.exchange("https://justfitequipmentcatalog.herokuapp.com/justfit/equipment/changeAvailabilityList?availability=true",
            HttpMethod.PATCH,
            httpEntity,
            Void.class);
}

    public void changeEquipmentAvailabilityToNotAvailable(List<Equipment> equipmentList){
        System.out.println(equipmentList);
        HttpEntity httpEntity=new HttpEntity(equipmentList);

        restTemplate.exchange("https://justfitequipmentcatalog.herokuapp.com/justfit/equipment/changeAvailabilityList?availability=false",
                HttpMethod.PATCH,
                httpEntity,
                Void.class);
    }

}

