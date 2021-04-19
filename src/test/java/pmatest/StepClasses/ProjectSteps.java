package pmatest.StepClasses;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.sql.Date;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pma.OperationNotAllowedException;
import pma.PMA;
import pma.Project;
import pma.Worker;
import pmatest.HelperClasses.ProjectHelper;
import pma.ErrorMessageHolder;

public class ProjectSteps {

    private PMA pma;

    private ProjectHelper projectHelper;
    private Project project;
    private ErrorMessageHolder errorMessage;
    private String reportText;

    public ProjectSteps(PMA pma, ProjectHelper projectHelper, ErrorMessageHolder errorMessage) {
        this.pma = pma;
        this.projectHelper = projectHelper;
        this.errorMessage = errorMessage;
    }

    // First scenario
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
        try {
            pma.addProject(new Project(title, ID));
        } catch (OperationNotAllowedException e) {
            errorMessage.setErrorMessage(e.getMessage());
        }
    }

    @Then("the project with ID {int} exist in the system")
    public void theProjectWithIDExistInTheSystem(Integer ID) {
        assertTrue(pma.containsProjectWithID(ID));
    }

    // Second scenario

    @Given("the project exist in the system")
    public void theProjectExistInTheSystem() throws OperationNotAllowedException {
        project = projectHelper.getProject();
        pma.addProject(project);
        assertTrue(pma.containsProjectWithID(project.getInfo().getID()));
    }

    @Then("the error message {string} is given")
    public void theErrorMessageIsGiven(String errorMessage) throws Exception {
        assertEquals(errorMessage, this.errorMessage.getErrorMessage());
    }

    @Then("the project with ID {int} does not exist in the system")
    public void theProjectWithIDDoesNotExistInTheSystem(Integer ID) {
        assertFalse(pma.containsProjectWithID(ID));
    }

    @Given("the worker with Name {string} {string} and ID {string} is assigned project leader of the project with ID {int}")
    public void theWorkerWithNameAndIDIsAssignedProjectLeaderOfTheProjectWithID(String firstName, String lastName,
            String workerID, Integer projectID) {
        project.setProjectLeader(new Worker(firstName, lastName, workerID));
    }

    @Given("with start date {string}, endDate {string}, expected hours {int} and worked hours {int}")
    public void withStartDateEndDateExpectedHoursAndWorkedHours(String startDate, String endDate, Integer expectedHours,
            Integer workedHours) {
        project.getInfo().setStartDate(Date.valueOf(startDate));
        project.getInfo().setEndDate(Date.valueOf(endDate));
        project.getInfo().setExpectedHours(expectedHours);
        project.getInfo().setHoursWorked(workedHours);

        assertEquals(startDate, project.getInfo().getStartDate().toString());
        assertEquals(endDate, project.getInfo().getEndDate().toString());
        assertTrue(expectedHours == project.getInfo().getExpectedHours());
        assertTrue(workedHours == project.getInfo().getHoursWorked());
    }

    @When("the project leader generates a report")
    public void theProjectLeaderGeneratesAReport() {
        reportText = project.generateReport();

    }

    @Then("the text is given {string}")
    public void theTextIsGiven(String text) {
        assertEquals(text.replace("\\n", "\n"), reportText);
    }

    @Then("the project has a end date {string}")
    public void theProjectHasAEndDate(String date) {
        Date endDate = Date.valueOf(date);
        assertEquals(project.getInfo().getEndDate(), endDate);
    }

}
