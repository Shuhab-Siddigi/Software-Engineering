package dtu.pma;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class PMA {

    private List<Worker> workers = new ArrayList<>();
    private List<Project> projects = new ArrayList<>();
    private Database db = new Database();
    private boolean databaseAdded = false;

    public void addDatabase() throws OperationNotAllowedException {
        if (databaseAdded == false) {

            databaseAdded = true;
            for (Worker w : db.getWorkers()) {
                workers.add(w);
            }
            for (Project p : db.getProjects()) {
                projects.add(p);
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

    public Activity getActivityWithID(Project project, int activityID) {
        return project.getActivityFromID(activityID);
    }

    public void addWorker(Worker worker) {
        workers.add(worker);
    }

    public boolean projectContainsActivity(int projectID, int activityID) throws Exception {

        //assert pre 
        assert projectID >-1 && activityID > -1;
        assertTrue(getProjectWithID(projectID) instanceof Project);

        boolean result = false;

        Project p = getProjectWithID(projectID); // 1
        if (p == null) { // 2
            throw new NullPointerException("Project with " + projectID + " does not exist"); // 2a
        }
        if (p.getActivityFromID(activityID) != null) { // 3
            result = true; // 3a
        }

        //assert post
        //  assert 
        assert ((result = true 
                && p.getActivityFromID(activityID) != null) 
                ||
                (result == false && (p.getActivityFromID(activityID) == null)));



        return result; // 4
    }

    public List<Worker> getWorkers() {
        return this.workers;
    }

    public List<Project> getProjects() {
        return this.projects;
    }

    public void addProject(Project p) throws OperationNotAllowedException { 
        //preconditions are mutually exclusive with if statements ( DO NOT DELETE COMMENTS)
        //  assert containsProjectWithID(p.getInfo().getID()); //if  
        //  assert containsProjectWithTitle(p.getInfo().getTitle());
        //  assert Integer.toString(p.getInfo().getID()).length()> 4;
        assert true;

        int lengthID = Integer.toString(p.getInfo().getID()).length(); // 1
        if (containsProjectWithID(p.getInfo().getID())) { // 2
            throw new OperationNotAllowedException("Project ID is already used!"); // 2a
        } else if (containsProjectWithTitle(p.getInfo().getTitle())) { // 3
            throw new OperationNotAllowedException("Project title is already used!"); // 3a
        } else if (lengthID > 4) { // 4
            throw new OperationNotAllowedException("Project can not have more than a 4 digit ID"); // 4a
        }
        projects.add(p); // 5
        
        //assert post
        assert projects.contains(p);
    }

    public void addActivityToProject(Project p, Activity a) throws OperationNotAllowedException {
        p.addActivity(a);
        if (a.getInfo().getEndDate().after(p.getInfo().getEndDate())) {
            p.getInfo().setEndDate(a.getInfo().getEndDate());
        }
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

    public List<Worker> findAvaliableWorkersByDates(List<Worker> list, Date startDate, Date endDate) throws Exception {
        List<Worker> avaliableWorkers = new ArrayList<>();
        for (Worker worker : list) {
            if (worker.CheckSchedule(startDate, endDate)){
                avaliableWorkers.add(worker);
            }
        }
        return avaliableWorkers;
    }

    public void changeStartDateActivity(Project project, Activity activity, Date startDate)
            throws OperationNotAllowedException {
        project.changeStartDateForActivity(activity, startDate);
    }

    public void changeEndDateActivity(Project project, Activity activity, Date endDate)
            throws OperationNotAllowedException {
        project.changeEndDateForActivity(activity, endDate);
    }
    
    public void addWorkHours (Worker w, Activity a, int hours) throws Exception{
        w.registerHours(hours, a);
        for (Project p : projects){
            if (projectContainsActivity(p.getInfo().getID(), a.getInfo().getID())){
                p.updateHoursWorked();
            }
        }
    }
}