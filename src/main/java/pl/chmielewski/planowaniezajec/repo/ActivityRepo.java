package pl.chmielewski.planowaniezajec.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.chmielewski.planowaniezajec.model.Activity;
import pl.chmielewski.planowaniezajec.model.Equipment;

import java.util.List;

@Repository
public interface ActivityRepo extends JpaRepository<Activity,Integer> {

 List<Activity> getActivitiesByDate(String date);

 @Modifying
 @Query(value = "UPDATE activity SET activity.name = :activityName, activity.leader =:leader, activity.activity_type =:activityType, activity.date =:activityDate, activity.hour_start =:hourStart, activity.hour_end =:hourEnd, activity.equipment_used =:equipmentUsed, activity.class_canceled =:classCanceled WHERE activity.id = :id",nativeQuery = true)
 void updateActivity(@Param("id")int id, @Param("activityName")String activityName, @Param("leader")String leader, @Param("activityType")String activityType, @Param("activityDate")String activityDate, @Param("hourStart")String hourStart, @Param("hourEnd")String hourEnd, @Param("equipmentUsed") List<Equipment> equipmentUsed, @Param("classCanceled")boolean classCanceled);

 Activity getActivityById(int id);

}



