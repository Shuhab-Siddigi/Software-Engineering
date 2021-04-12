package pma;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PMA {

    private List<Worker> workers = new ArrayList<>();
    private List<Project> projects = new ArrayList<>();

    public boolean containsProjectWithID(int ID) {
        return projects.stream().anyMatch(p -> p.getID() == ID);

    }

    public boolean containsProjectWithTitle(String Title) {
        return projects.stream().anyMatch(p -> p.getTitle().contentEquals(Title));
    }

    public void addProject(Project p) throws OperationNotAllowedException {
        
        if(searchProject(p) != null){
            throw new OperationNotAllowedException("Project ID is already used!");
        }else{
           projects.add(p);
        }
        
    }

    private Project searchProject(Project project) {
        return projects.stream()
                .filter(p -> (p.getID() == project.getID() || p.getTitle().contentEquals(project.getTitle()))).findAny()
                .orElse(null);
    }

    public void addWorker(Worker worker) {
        workers.add(worker);
    }
}
