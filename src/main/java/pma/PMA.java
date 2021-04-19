package pma;

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

    public boolean projectContainsActivity(int projectID, int activityID) {
        Project p = getProjectWithID(projectID);
        if (p.getActivityFromID(activityID) != null) {
            return true;
        }
        return false;
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
        
        System.out.println("Activity " + a.getInfo().getID() + " enddate: " + a.getInfo().getEndDate());
        System.out.println("Project enddate: " + p.getInfo().getEndDate());
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

}