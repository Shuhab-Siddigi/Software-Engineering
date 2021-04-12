package pmatest.StepClasses;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pma.OperationNotAllowedException;
import pma.PMA;
import pma.Project;
import pmatest.HelperClasses.ProjectHelper;
import pma.ErrorMessageHolder;

public class ProjectSteps {

    private PMA pma;

    private ProjectHelper projectHelper;
    private Project project;
    private ErrorMessageHolder errorMessage;

    public ProjectSteps(PMA pma, ProjectHelper projectHelper, ErrorMessageHolder errorMessage) {
        this.pma = pma;
        this.projectHelper = projectHelper;
        this.errorMessage = errorMessage;
    }

    @Given("there is a project with title {string}, ID {int}")
    public void thereIsAProjectWithTitleID(String title, Integer ID) {
        project = new Project(title, ID);
    }

    @Given("project with title {string}, ID {int} does not exist in the system")
    public void projectWithTitleIDDoesNotExistInTheSystem(String title, Integer ID) {
        assertFalse(pma.containsProjectWithID(ID));
    }

    @When("the project with title {string}, ID {int} is added to the system")
    public void theProjectWithTitleIDIsAddedToTheSystem(String title, Integer ID) throws OperationNotAllowedException {
        pma.addProject(new Project(title, ID));
    }

    @Then("the project with ID {int} exist in the system")
    public void theProjectWithIDExistInTheSystem(Integer ID) {
        assertTrue(pma.containsProjectWithID(ID));
    }

}
