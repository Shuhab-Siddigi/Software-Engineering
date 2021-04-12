package pmatest.StepClasses;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pma.ErrorMessageHolder;
import pma.PMA;
import pma.Project;
import pma.Worker;
import pmatest.HelperClasses.WorkerHelper;

public class AssignLeaderSteps {

    private PMA pma;

    private ErrorMessageHolder errorMessage;

    private Worker worker;

    private Project project;

    public AssignLeaderSteps(PMA pma, ErrorMessageHolder errorMessage) {

        this.pma = pma;
        this.errorMessage = errorMessage;
    }

    @Given("the system contains a worker with ID {string}")
    public void theSystemContainsAWorkerWithID(String ID) {
        pma.addDatabase();
        assertTrue(pma.containsWorkerWithID(ID));

    }

    @When("the worker with ID {string} is assigned to the project with ID {int}")
    public void theWorkerWithIDIsAssignedToTheProjectWithID(String wID, Integer pID) {
        // Write code here that turns the phrase above into concrete actions
        worker = pma.getWorkerWithID(wID);
        project = pma.getProjectWithID(pID);
        pma.assignLeader(worker, project);
    }

    /*
     * @When("the worker with ID {string} is assigned to project with ID {int}")
     * public void theWorkerIsAssignedAsTheProjectLeader() {
     */

}
