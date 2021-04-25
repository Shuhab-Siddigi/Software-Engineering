package dtu.pmatest.HelperClasses;

import dtu.pma.OperationNotAllowedException;
import dtu.pma.PMA;
import dtu.pma.Project;
import dtu.pma.Worker;
import dtu.pmatest.HelperClasses.ProjectHelper;

public class WorkerHelper {

    private Worker worker;
    private Project project;
    private ProjectHelper projectHelper;
    private Worker projectLeader;
    private PMA pma;

    public WorkerHelper(PMA pma) {
        this.pma = pma;
    }

    public Worker getWorker() throws OperationNotAllowedException {
        if(worker == null){
            worker = workerExample();
        }
        return worker;
    }

    public Worker getProjectLeader() throws OperationNotAllowedException {
        if(projectLeader == null){
            projectLeader = projectLeaderExample();
        }
        return projectLeader;
    }

    private Worker workerExample() throws OperationNotAllowedException {
        worker = new Worker("bob", "hansen", "xxx");
        pma.addWorker(worker);
        return worker;
    }

    private Worker projectLeaderExample() throws OperationNotAllowedException {
        projectLeader = new Worker("svend", "sving", "XXX");
        project = projectHelper.getProject();
        pma.addWorker(projectLeader);
        pma.assignLeader(projectLeader, project);

        return projectLeader;
    }
    
    
}
