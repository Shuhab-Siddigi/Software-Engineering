package pmatest.StepClasses;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pma.PMA;
import pma.Project;

public class ProjectSteps {

    private PMA pma;

    private Project project;

    public ProjectSteps(PMA pma) {
        this.pma = pma;
    }

    @Given("a  project  with  title  {string},ID {int}")
    public void aProjectWithTitleID(String title, Integer ID) {
        project = new Project(title, ID);
    }

    @Given("project does not exist in the system")
    public void projectDoesNotExistInTheSystem() {
        assertFalse(pma.containsProjectWithID(project.getID()));
    }

    @When("the project with title {string},ID {int} is added to the system")
    public void theProjectWithTitleIDIsAddedToTheSystem(String title, Integer ID) {
        pma.addProject(new pma.Project(title, ID));
    }

    @Then("the project exist in the system")
    public void theProjectExistInTheSystem() {
        assertTrue(pma.containsProjectWithID(project.getID()));
    }

}
