package dtu.pmatest.StepClasses;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import dtu.pma.OperationNotAllowedException;
import dtu.pma.ErrorMessageHolder;
import dtu.pma.PMA;
import dtu.pma.Project;
import dtu.pma.Worker;


public class ProjectLeaderSteps {

    private PMA pma;

    private ErrorMessageHolder errorMessage;

    private Worker worker;

    private Project project;

    public ProjectLeaderSteps(PMA pma, ErrorMessageHolder errorMessage) {

        this.pma = pma;
        this.errorMessage = errorMessage;
    }

    @Given("the system contains a worker with ID {string}")
    public void theSystemContainsAWorkerWithID(String ID) throws OperationNotAllowedException {
        pma.addDatabase();
        assertTrue(pma.containsWorkerWithID(ID));

    }

    @When("the worker with ID {string} is assigned to the project with ID {int}")
    public void theWorkerWithIDIsAssignedToTheProjectWithID(String wID, Integer pID) {

        try {
            worker = pma.getWorkerWithID(wID);
            project = pma.getProjectWithID(pID);
            pma.assignLeader(worker, project);
        } catch (OperationNotAllowedException e) {
            errorMessage.setErrorMessage(e.getMessage());
        }
      
    }

    @Then("the worker with ID {string} is the project leader of the project with ID {int}")
    public void theWorkerWithIDIsTheProjectLeaderOfTheProjectWithID(String wID, Integer pID) {
        assertEquals(pma.getWorkerWithID(wID), pma.getProjectWithID(pID).getProjectLeader());
    }

    @Given("the system doesn't contains a worker with ID {string}")
    public void theSystemDoesnTContainsAWorkerWithID(String wID) {
        assertEquals(pma.getWorkerWithID(wID), null);
      
    }

    @Given("the worker with ID {string} is the project leader of project with ID {int}")
    public void theWorkerWithIDIsTheProjectLeaderOfProjectWithID(String wID, Integer pID) throws OperationNotAllowedException {
        try {
            worker = pma.getWorkerWithID(wID);
            project = pma.getProjectWithID(pID);
            pma.assignLeader(worker, project);
        } catch (OperationNotAllowedException e) {
            errorMessage.setErrorMessage(e.getMessage());
        }
    }

    @When("the worker with ID {string} removes the project with ID {int}")
    public void theWorkerWithIDRemovesTheProjectWithID(String wID, Integer pID) throws OperationNotAllowedException {
        worker = pma.getWorkerWithID(wID);
        project = pma.getProjectWithID(pID);
        try {
            pma.removeProject(worker, project);
        } catch (OperationNotAllowedException e) {
            errorMessage.setErrorMessage(e.getMessage());
        }
    }

    

   
}
