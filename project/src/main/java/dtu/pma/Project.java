package dtu.pma;

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
        int lengthID = Integer.toString(activity.getInfo().getID()).length();
        
        if (getActivityFromID(activity.getInfo().getID()) != null) {
            throw new OperationNotAllowedException("Project already contains activity!");
        } else if (activity.getInfo().getEndDate().before(this.info.getStartDate())) {
            //System.out.println("Date check works");
            throw new OperationNotAllowedException("Activity date is before project start!");
        } else if (lengthID > 4){
            System.out.println("ID: "+ activity.getInfo().getID());
            System.out.println("ID as string: "+ lengthID);
            throw new OperationNotAllowedException("Activity can not have more than a 4 digit ID");
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

    public void addWorkerToActivity(Activity activity, Worker worker, Worker projectLeader) throws OperationNotAllowedException {
        if(activity == null)
        {
            throw new OperationNotAllowedException("Activity does not exist!");
        } else if (worker == null){
            throw new OperationNotAllowedException("Worker does not exist in system");
        } else if (projectLeader != this.projectLeader) {
            throw new OperationNotAllowedException("You are not the project leader for this project!");
        }
        activity.addWorker(worker);
    }

    public void removeWorkerFromActivity(Activity activity, Worker worker, Worker projectLeader) throws OperationNotAllowedException {
        if(activity == null)
        {
            throw new OperationNotAllowedException("Activity does not exist!");
        } else if (worker == null){
            throw new OperationNotAllowedException("Worker does not exist in system");
        } else if (projectLeader != this.projectLeader) {
            throw new OperationNotAllowedException("You are not the project leader for this project!");
        }
        activity.removeWorker(worker);
    }

    public void changeStartDateForActivity(Activity activity, Date startDate) throws OperationNotAllowedException {
        
        System.out.println("start date: " + this.info.getStartDate() + " end date: " + this.info.getEndDate());
        System.out.println("New start date: " + startDate);
        if(startDate.after(this.info.getEndDate()))
        {
            throw new OperationNotAllowedException("Cannot change start date to after project ends!");
        }
        if (startDate.before(this.info.getStartDate())){
            this.info.setStartDate(startDate);
        }// Skrevet af Tobias: Ikke sikker på om projekt start skal ændre sig hvis activity start gør..
        
        activity.getInfo().setStartDate(startDate);
        System.out.println("Project new start date: " + this.info.getStartDate());
    }

    public void changeEndDateForActivity(Activity activity, Date endDate) throws OperationNotAllowedException {
        System.out.println("start date: " + this.info.getStartDate() + " end date: " + this.info.getEndDate());
        System.out.println("New end date: " + endDate);
        if(endDate.before(this.info.getStartDate()))
        {
            throw new OperationNotAllowedException("Cannot change end date to before project starts!");
        }
        if (endDate.after(this.info.getEndDate())){
            this.info.setEndDate(endDate);
        }
        activity.getInfo().setEndDate(endDate);
        System.out.println("Project new end date: " + this.info.getEndDate());
    }
}
