package dtu.pma;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PMA {

    private List<Worker> workers = new ArrayList<>();
    private List<Project> projects = new ArrayList<>();
    private Database db = new Database();
    private boolean databaseAdded = false;

    public void addDatabase() {
        if (databaseAdded == false) {

            databaseAdded = true;
            for (Worker w : db.getWorkers()) {
                workers.add(w);
            }
        }
    }


    public boolean containsProjectWithID(int ID) {
        return projects.stream().anyMatch(p -> p.getInfo().getID() == ID);
    }

    public boolean containsProjectWithTitle(String Title) {
        return projects.stream().anyMatch(p -> p.getInfo().getTitle().contentEquals(Title));
    }

    public Project getProjectWithID(int ID) {
        return projects.stream().filter(p -> p.getInfo().getID() == ID).findAny().orElse(null);
    }

    public Worker getWorkerWithID(String ID) {
        return workers.stream().filter(u -> u.getID().equals(ID)).findAny().orElse(null);
    }
    public Activity getActivityWithID(Project project, int activityID){
        return project.getActivityFromID(activityID);
    }

    public void addWorker(Worker worker){
        workers.add(worker);
    }

    public boolean projectContainsActivity(int projectID, int activityID) {
        Project p = getProjectWithID(projectID);
        if (p.getActivityFromID(activityID) != null) {
            return true;
        }
        return false;
    }

    public List<Worker> getWorkers() {
        return this.workers;
    }

    public void addProject(Project p) throws OperationNotAllowedException {
        if (!containsProjectWithID(p.getInfo().getID()) || !containsProjectWithTitle(p.getInfo().getTitle())) {
            projects.add(p);
        } else {
            throw new OperationNotAllowedException("Project ID is already used!");
        }

    }

    public void addActivityToProject(Project p, Activity a) throws OperationNotAllowedException {

        p.addActivity(a);
        if (a.getInfo().getEndDate().after(p.getInfo().getEndDate())) {
            p.getInfo().setEndDate(a.getInfo().getEndDate());
        }
        // p.getInfo().setStartDate(aStart);

        // System.out.println("Activity " + a.getInfo().getID() + " enddate: " +
        // a.getInfo().getEndDate());
        // System.out.println("Project enddate: " + p.getInfo().getEndDate());
    }

    public void removeProject(Worker worker, Project project) throws OperationNotAllowedException {
        if (project == null) {
            throw new OperationNotAllowedException("Project does not exist!");
        } else if (worker != project.getProjectLeader()) {
            throw new OperationNotAllowedException("Only the project leader can remove project!");
        } else {
            projects.remove(project);
        }
    }

    public boolean containsWorkerWithID(String ID) {
        return workers.stream().anyMatch(w -> w.getID().contentEquals(ID));
    }

    public void assignLeader(Worker worker, Project project) throws OperationNotAllowedException {
        if (project == null) {
            throw new OperationNotAllowedException("Project does not exist");
        } else if (worker == null) {
            throw new OperationNotAllowedException("Worker does not exist in system");

        } else if (project.getProjectLeader() != null) {
            throw new OperationNotAllowedException("A project leader already exist");
        }

        project.setProjectLeader(worker);

    }

    public Worker findWorkerByID(List<Worker> list, String id) throws OperationNotAllowedException {
        id = id.toLowerCase();
        String tempID;
        for (Worker w : list) {
            tempID = w.getID().toLowerCase();
            if (tempID.equals(id))
                return w;
        }
        throw new OperationNotAllowedException("There are no workers by that ID");
    }


    public Worker findWorkerByFirstName(List<Worker> list, String firstName) throws OperationNotAllowedException {
        firstName = firstName.toLowerCase();
        String tempID;
        for (Worker w : list) {
            tempID = w.getFirstname().toLowerCase();
            if (tempID.equals(firstName))
                return w;
        }
        throw new OperationNotAllowedException("There are no workers by that First Name");
    }

    public Worker findWorkerByLastName(List<Worker> list, String lastName) throws OperationNotAllowedException {
        lastName = lastName.toLowerCase();
        String tempID;
        for (Worker w : list) {
            tempID = w.getLastname().toLowerCase();
            if (tempID.equals(lastName))
                return w;
        }
        throw new OperationNotAllowedException("There are no workers by that Last Name");
    }

    public List<Worker> findAvaliableWorkersByDates(List<Worker> list, Date startDate, Date endDate){
        List<Worker> tempWorkers = new ArrayList<>();
        boolean flag = true;
        for (Worker w : list) {
            for (Activity a : w.getActivities()) {
                if(!a.isFree(startDate, endDate)){
                    flag = false;
                    break;
                }
                    
            }
            if(!flag){
                tempWorkers.add(w);
            }
            flag = true;
        }
        return tempWorkers;
    }


    public void changeStartDateActivity(Project project, Activity activity, Date startDate) throws OperationNotAllowedException {
        project.changeStartDateForActivity(activity, startDate);
    }

    public void changeEndDateActivity(Project project, Activity activity, Date endDate) throws OperationNotAllowedException {
        project.changeEndDateForActivity(activity, endDate);
    }
}