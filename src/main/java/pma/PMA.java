package pma;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class PMA {

    private List<Worker> workers = new ArrayList<Worker>();
    private List<Project> projects = new ArrayList<Project>();
    private Database db = new Database();

    public void addDatabase() {

        for (Worker w : db.getWorkers()) {
            workers.add(w);
        }
    }

    public boolean containsProjectWithID(int ID) {
        return projects.stream().anyMatch(p -> p.getID() == ID);
    }

    public boolean containsProjectWithTitle(String Title) {
        return projects.stream().anyMatch(p -> p.getTitle().contentEquals(Title));
    }

    public void addProject(Project p) throws OperationNotAllowedException {

        if (!containsProjectWithID(p.getID()) || !containsProjectWithTitle(p.getTitle())) {
            projects.add(p);
        } else {
            throw new OperationNotAllowedException("Project ID is already used!");
        }

    }

    public boolean containsWorkerWithID(String ID) {
        return workers.stream().anyMatch(w -> w.getID().contentEquals(ID));
    }

    public Project getProjectWithID(int ID) {
        for (Project project : projects) {
            if (ID == project.getID()) {
                return project;
            }
        }
        return null;
    }

    public Worker getWorkerWithID(String ID) {
        for (Worker worker : workers) {
            if (ID == worker.getID()) {
                return worker;
            }
        }
        return null;
    }

    public void assignLeader(Worker worker, Project project) {
        project.setProjectLeader(worker);
    }

}