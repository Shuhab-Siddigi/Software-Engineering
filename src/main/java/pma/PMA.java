package pma;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PMA {

    private List<Worker> workers = new ArrayList<Worker>();
    private List<Project> projects = new ArrayList<Project>();
    private Database db = new Database();
    private boolean databaseAdded = false;

    public void addDatabase() {
        if(databaseAdded == false) {

            databaseAdded = true;
        for (Worker w : db.getWorkers()) {
            workers.add(w);
        }
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
        return projects.stream()
        .filter(u -> u.getID() == ID)
        .findAny()
        .orElse(null);
    }

    public Worker getWorkerWithID(String ID) {
        return workers.stream()
				.filter(u -> u.getID().equals(ID))
				.findAny()
				.orElse(null);
    }

    public void assignLeader(Worker worker, Project project) throws OperationNotAllowedException {
        if (project == null) {
            throw new OperationNotAllowedException("Project does not exist");
        }
        else if (worker == null) {
            throw new OperationNotAllowedException("Worker does not exist in system");

        }
        else if(project.getProjectLeader() != null) {
            throw new OperationNotAllowedException("A project leader already exist");
        }

        project.setProjectLeader(worker);

    }

}

// try {
// getProjectWithID(project.getID());
// } catch (Exception NullPointerException) {
// th
// }