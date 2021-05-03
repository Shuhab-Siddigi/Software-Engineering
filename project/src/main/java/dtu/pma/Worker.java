package dtu.pma;

import java.util.ArrayList;
import java.util.List;

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

    public void registerHours(int hours, Activity a) throws OperationNotAllowedException {
        if(this.Activities.contains(a)){
            a.setRegisteredHours(hours);
        } else {
            throw new OperationNotAllowedException("Worker isn't assigned to project");
        }
    }
}
