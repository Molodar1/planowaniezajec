package pl.chmielewski.planowaniezajec.model;



import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String leader;
    private String activityType;
    private String date;
    private String hourStart;
    private String hourEnd;

    @OneToMany(mappedBy = "parent",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Equipment> equipmentUsed=new ArrayList<>();

    private boolean classCanceled;

    public Activity() {
    }

    public Activity(String name, String leader, String activityType, String date, String hourStart, String hourEnd, List<Equipment> equipmentUsed, boolean classCanceled) {
        this.name = name;
        this.leader = leader;
        this.activityType = activityType;
        this.date = date;
        this.hourStart = hourStart;
        this.hourEnd = hourEnd;
        this.equipmentUsed = equipmentUsed;
        this.classCanceled = classCanceled;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLeader() {
        return leader;
    }

    public void setLeader(String leader) {
        this.leader = leader;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHourStart() {
        return hourStart;
    }

    public void setHourStart(String hourStart) {
        this.hourStart = hourStart;
    }

    public String getHourEnd() {
        return hourEnd;
    }

    public void setHourEnd(String hourEnd) {
        this.hourEnd = hourEnd;
    }

    public List<Equipment> getEquipmentUsed() {
        return equipmentUsed;
    }

    public void setEquipmentUsed(List<Equipment> equipmentUsed) {
        this.equipmentUsed = equipmentUsed;
    }

    public boolean isClassCanceled() {
        return classCanceled;
    }

    public void setClassCanceled(boolean classCanceled) {
        this.classCanceled = classCanceled;
    }

    public String getActivityType() {
        return activityType;
    }

    public void setActivityType(String activityType) {
        this.activityType = activityType;
    }

    @Override
    public String toString() {
        return "Activity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", leader='" + leader + '\'' +
                ", activityType='" + activityType + '\'' +
                ", date='" + date + '\'' +
                ", hourStart='" + hourStart + '\'' +
                ", hourEnd='" + hourEnd + '\'' +
                ", equipmentUsed=" + equipmentUsed +
                ", classCanceled=" + classCanceled +
                '}';
    }
}
