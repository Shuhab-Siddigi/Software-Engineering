package dtu.pma;

import java.util.ArrayList;
import java.util.List;
import java.sql.Date;

public class Worker {

    private String firstname;
    private String lastname;
    private String ID;
    private List<Activity> Activities = new ArrayList<>();

    public Worker(String firstname, String lastname, String ID) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.ID = ID;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setID(String iD) {
        this.ID = iD;
    }

    public String getLastname() {
        return lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getID() {
        return ID;
    }

    public List<Activity> getActivities(){
        return this.Activities;
    }
    
    public void addActivity(Activity a){
        this.Activities.add(a);
    }
    public void removeActivity(Activity activity) {
        Activities.removeIf(a -> a.getInfo().equals(activity.getInfo()));
    }

    public Activity getActivitiyByID(int ID) {
        for (Activity activity : Activities) {         
            if (activity.getInfo().getID() == ID) {    
                return activity;                       
            }
        }
        return null;                            
    }

    public void registerHours(int hours, Activity activity) throws OperationNotAllowedException {
        if(!this.Activities.contains(activity)){
            throw new OperationNotAllowedException("Worker isn't assigned to project");
        }

        activity.setRegisteredHours(hours);
    }

    public Boolean CheckSchedule(Date startDate, Date endDate) throws Exception{
        for (Activity activity : Activities) {
            if (!activity.getInfo().isFree(startDate, endDate)){
                return false;
            }
        }
        return true;
    }
}
