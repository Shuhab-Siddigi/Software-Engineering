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

    public void setProjectLeader(Worker worker) {
        this.projectLeader = worker;
    }

    public Worker getProjectLeader() {
        return projectLeader;
    }

    public Info getInfo() {
        return this.info;
    }

    public String generateReport() {
        String text = printRepport();
        for (Activity a : activities) {
            text += a.printActivity();
        }

        return text;
    }

    public List<Activity> getActivities() {
        return this.activities;
    }

    public String printRepport() {
        String text = this.getInfo().getTitle() + " " + this.getInfo().getID() + " ";
        if (this.getInfo().getStartDate() != null)
            text += this.getInfo().getStartDate() + " ";
        if (this.getInfo().getEndDate() != null)
            text += this.getInfo().getEndDate() + " ";
        if (this.getInfo().getExpectedHours() > 0) {
            text += this.getInfo().getExpectedHours() + " ";
            text += this.getInfo().getHoursWorked() + " ";
        }
        text += "\n";
        text += this.projectLeader.getLastname() + ", " + this.projectLeader.getFirstname() + " "
                + this.projectLeader.getID();

        if (this.activities.size() >0)
            text += "\n\n";
        
            return text;
    }

    private void checksDates(Activity activity) {
        if (this.info.getStartDate() != null) {
            for (Activity a : activities) {
                if (activity.getInfo().getEndDate().after(a.getInfo().getEndDate())) {
                    this.info.setEndDate(activity.getInfo().getEndDate());
                }
            }
        } else {
            this.info.setStartDate(activity.getInfo().getStartDate());
            this.info.setEndDate(activity.getInfo().getEndDate());
        }
    }

    public void addActivity(Activity activity) throws OperationNotAllowedException {
        // Creates start and end date for project
        checksDates(activity);

        if (getActivityFromID(activity.getInfo().getID()) != null) {
            throw new OperationNotAllowedException("Project already contains activity!");
        } else if (activity.getInfo().getEndDate().before(this.info.getStartDate())) {
            //System.out.println("Date check works");
            throw new OperationNotAllowedException("Activity date is before project start!");
        }

        // Adds activity
        this.activities.add(activity);
    }

    // Remove activity

    public Activity getActivityFromID(int ID) {
        for (Activity a : activities) {
            if (a.getInfo().getID() == ID) {
                return a;
            }
        }
        return null;
    }

    public void removeActivity(Worker worker, Activity activity) throws OperationNotAllowedException {
        if (activity == null) {
            throw new OperationNotAllowedException("Activity does not exist!");
        } else if (worker != getProjectLeader()) {
            throw new OperationNotAllowedException("Only the project leader can remove activity!");
        } 
            activities.remove(activity);
    }



  

  





}
