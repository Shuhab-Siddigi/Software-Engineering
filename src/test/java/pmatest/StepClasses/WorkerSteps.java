package pmatest.StepClasses;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import io.cucumber.java.en.Given;
import pma.PMA;
import pma.Worker;
import pmatest.HelperClasses.WorkerHelper;

public class WorkerSteps {

    private PMA pma; 
    private WorkerHelper workerHelper;
    private Worker worker;

    public WorkerSteps(PMA pma, WorkerHelper workerHelper){
        this.pma = pma;
        this.workerHelper = workerHelper;

    }




    @Given("a Worker with name {string} and ID {string} does not exist")
    public void aWorkerWithNameAndIDDoesNotExist(String name, String ID) {

         // Write code here that turns the phrase above into concrete actions
    
        assertFalse(pma.containsWorkerWithID(ID));
        assertFalse(pma.containsWorkerWithName(name));
    }

    @Given("a Worker with name {string} and ID {string} exists in the system")
    public void aWorkerWithNameAndIDExistsInTheSystem(String name, String ID) {
        //do this with workerhelper? workerHelper.getWorker()
        

        //as is i have to do
        worker = new Worker(name, name ,ID); //first and last name should be one variable name?

        pma.addWorker(worker);

        assertTrue(pma.containsWorkerWithID(worker.getID()));
}






}