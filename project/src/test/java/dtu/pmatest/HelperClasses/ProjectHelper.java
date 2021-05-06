package dtu.pmatest.HelperClasses;

import dtu.pma.Project;

public class ProjectHelper {
    

    private Project project;
   
    public Project getProject() {
        if (project == null) {
            project = exampleProject();
        }
        return project;
    }

    
    private Project exampleProject() {
        Project project = new Project("Extreme Programming",0001);
        return project;
    }



}
