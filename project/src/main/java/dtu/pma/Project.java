package dtu.pma;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.*;

public class Project {

    private List<Activity> activities = new ArrayList<>();
    private Worker projectLeader;
    private Info info;

    public Project(String title, int ID) {
        this.info = new Info(title, ID);
    }

    public Project(String title, String ID) throws OperationNotAllowedException {
        // input_check
        
            isAllowedID(ID);
            int IDInt = Integer.parseInt(ID);
            this.info = new Info(title, IDInt);
            
        }

    public boolean isAllowedID(String id) throws OperationNotAllowedException {
        // Regex to check string
        // contains only digits
        String regex = "^[0-9]{4}$";

        // Compile the ReGex
        Pattern p = Pattern.compile(regex);
        // empty
        if (id == null || id == "") {   // 1
            throw new OperationNotAllowedException ("Invalid input sequence: ID has to be inserted"); // 1a
          }
        // check
        Matcher m = p.matcher(id);

        if (m.matches() == false) { // 2
            throw new OperationNotAllowedException ("Invalid input sequence: ID has to be in range [0000-9999]"); // 2a
        }

        return true;   // 3
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

    public String gReport(){

        String p =  "Title: "           + this.info.getTitle()          + "\n"+
                    "ID : "             + this.info.getID()             + "\n"+
                    "Expected hours: "  + this.info.getExpectedHours()  + "\n"+
                    "Hours Worked: "    + this.info.getHoursWorked()    + "\n"+
                    "Start Date: "      + this.info.getStartDate()      + "\n"+
                    "End Date : "       + this.info.getEndDate()        + "\n"+
                    "Description: "     + this.info.getDescription()    + "\n";

        if(this.getActivities() != null){
            
            for (Activity activity : this.getActivities()) {

                p+= "\tActivity:\n\n"+
                    "\tTitle: "           + activity.getInfo().getTitle()          + "\n"+
                    "\tID : "             + activity.getInfo().getID()             + "\n"+
                    "\tExpected hours: "  + activity.getInfo().getExpectedHours()  + "\n"+
                    "\tHours Worked: "    + activity.getInfo().getHoursWorked()    + "\n"+
                    "\tStart Date: "      + activity.getInfo().getStartDate()      + "\n"+
                    "\tEnd Date : "       + activity.getInfo().getEndDate()        + "\n"+
                    "\tDescription: "     + activity.getInfo().getDescription()    + "\n"; 
            }
        }
        return p;
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

        if (this.activities.size() > 0)
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
            // System.out.println("Date check works");
            throw new OperationNotAllowedException("Activity date is before project start!");
        } else if (lengthID > 4) {
            throw new OperationNotAllowedException("Activity can not have more than a 4 digit ID");
        }

        // Adds activity
        this.activities.add(activity);
    }

    // Remove activity

    public Activity getActivityFromID(int ID) {
        for (Activity a : activities) {         // 1
            if (a.getInfo().getID() == ID) {    // 2
                return a;                       // 2a
            }
        }
        return null;                            // 3
    }

    public void removeActivity(Worker worker, Activity activity) throws OperationNotAllowedException {
        if (activity == null) {
            throw new OperationNotAllowedException("Activity does not exist!");
        } else if (worker != getProjectLeader()) {
            throw new OperationNotAllowedException("Only the project leader can remove activity!");
        }
        activities.remove(activity);
    }

    public void addWorkerToActivity(Activity activity, Worker worker, Worker projectLeader)
            throws OperationNotAllowedException {
        if (activity == null) {
            throw new OperationNotAllowedException("Activity does not exist!");
        } else if (worker == null) {
            throw new OperationNotAllowedException("Worker does not exist in system");
        } else if (projectLeader != this.projectLeader) {
            throw new OperationNotAllowedException("You are not the project leader for this project!");
        }
        activity.addWorker(worker);
        worker.addActivity(activity);
    }

    public void removeWorkerFromActivity(Activity activity, Worker worker, Worker projectLeader)
            throws OperationNotAllowedException {
        if (activity == null) {
            throw new OperationNotAllowedException("Activity does not exist!");
        } else if (worker == null) {
            throw new OperationNotAllowedException("Worker does not exist in system");
        } else if (projectLeader != this.projectLeader) {
            throw new OperationNotAllowedException("You are not the project leader for this project!");
        }
        activity.removeWorker(worker);
    }

    public void changeStartDateForActivity(Activity activity, Date startDate) throws OperationNotAllowedException {
        if (startDate.after(this.info.getEndDate())) {
            throw new OperationNotAllowedException("Cannot change start date to after project ends!");
        }
        if (startDate.before(this.info.getStartDate())) {
            this.info.setStartDate(startDate);
        } // Skrevet af Tobias: Ikke sikker på om projekt start skal ændre sig hvis
          // activity start gør..

        activity.getInfo().setStartDate(startDate);
    }

    public void changeEndDateForActivity(Activity activity, Date endDate) throws OperationNotAllowedException {
        if (endDate.before(this.info.getStartDate())) {
            throw new OperationNotAllowedException("Cannot change end date to before project starts!");
        }
        if (endDate.after(this.info.getEndDate())) {
            this.info.setEndDate(endDate);
        }
        activity.getInfo().setEndDate(endDate);
    }

    public void updateHoursWorked(){
        int hoursWorked = 0;
        for (Activity a : getActivities()){
            hoursWorked = hoursWorked + a.getRegisteredHours();
        }
        this.info.setHoursWorked(hoursWorked);
    }
}
