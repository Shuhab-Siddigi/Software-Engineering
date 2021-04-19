package pma;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Project {

    private List<Activity> activities = new ArrayList<>();
    private Worker projectLeader;
    private Info info;
    
    public Project(String title, int ID) {
        this.info = new Info(title, ID);
    }

    public void setProjectLeader(Worker worker){
        this.projectLeader = worker;
    }
    
    public Worker getProjectLeader(){
        return projectLeader;
    }

    public Info getInfo() {
        return this.info;
    }
    
    //Create activity
    public void addActivity(Activity activity){
        this.activities.add(activity);
    }
    //Remove activity

    public Activity getActivityFromID (int ID){
        for (Activity a : activities){
            if (a.getInfo().getID() == ID){
                return a;
            } 
        }
        return null;
    }
}
