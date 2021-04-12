package pma;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

public class PMA {

   // private List<Worker> workers = new ArrayList<>();
    private List<Project> projects = new ArrayList<>();
    

    public boolean containsProjectWithID(int ID) {
        return projects.stream().anyMatch(p -> p.getID() == ID);
    }


    public void addProject(Project project) {
        projects.add(project);
    }

}
