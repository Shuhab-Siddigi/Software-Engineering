package pmatest.HelperClasses;

import pma.PMA;
import pma.Project;

public class ProjectHelper {
    

    private Project project;
    private PMA pma;

    public ProjectHelper(PMA pma) {
        this.pma = pma;
    }



    public Project getProject() {
        if (project == null) {
            project = exampleProject();
        }
        return project;
    }

    
    private Project exampleProject() {
        Project project = new Project("Extreme Programming");
        return project;
    }



}