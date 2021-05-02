package dtu.pmatest.StepClasses;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.sql.Date;
import java.util.Collections;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import dtu.pma.OperationNotAllowedException;
import dtu.pma.PMA;
import dtu.pma.Project;
import dtu.pma.Worker;
import dtu.pmatest.HelperClasses.ProjectHelper;
import dtu.pma.Activity;
import dtu.pma.ErrorMessageHolder;
public class ProjectSteps {

    private PMA pma;

    private ProjectHelper projectHelper;
    private Project project;
    private ErrorMessageHolder errorMessage;
    private String reportText;
    private Worker origWorker;
    private Worker testWorker;

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

    @Given("has activty {string}, ID {int}, start date {string}, end date {string}")
    public void hasActivtyIDStartDateEndDate(String name, Integer id, String startDate, String endDate) {
        Activity activity = new Activity(name, id, Date.valueOf(startDate), Date.valueOf(endDate));
        try {
            project.addActivity(activity);
        } catch (OperationNotAllowedException e) {
            errorMessage.setErrorMessage(e.getMessage());
        }

        assertTrue(project.getActivities().contains(activity));
    }

    @Given("activity with ID {int} contains worker {string} {string}, ID {string} and worker {string} {string}, ID {string}")
    public void activityWithIDContainsWorkerIDAndWorkerID(Integer activityID, String firstName1, String lastName1,
            String id1, String firstName2, String lastName2, String id2) {
        Worker worker1 = new Worker(firstName1, lastName1, id1);
        Worker worker2 = new Worker(firstName2, lastName2, id2);

        project.getActivityFromID(activityID).addWorker(worker1);
        project.getActivityFromID(activityID).addWorker(worker2);

        assertTrue(project.getActivityFromID(activityID).getWorkers().contains(worker1));
        assertTrue(project.getActivityFromID(activityID).getWorkers().contains(worker2));
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

    @Given("there is a list of workers, which contain worker with Name {string} {string} ID {string}")
    public void thereIsAListOfWorkersWhichContainWorkerWithNameID(String firstName, String lastName, String id) throws OperationNotAllowedException  {
        origWorker = new Worker(firstName, lastName, id);
        pma.addDatabase();
        pma.getWorkers().add(origWorker);
        Collections.shuffle(pma.getWorkers());

        assertTrue(pma.getWorkers().contains(origWorker));
    }

    @When("the project leader search for avaiable workers using ID {string}")
    public void theProjectLeaderSearchForAvaiableWorkersUsingID(String id) {
        try {
            testWorker = pma.findWorkerByID(pma.getWorkers(), id);
        } catch (OperationNotAllowedException e) {
            errorMessage.setErrorMessage(e.getMessage());
        }

    }

    @Then("the system returns a worker with matching id")
    public void theSystemReturnsAWorkerWithMatchingId() {
        assertEquals(origWorker.getID(), testWorker.getID());
    }

    @When("the project leader search for avaiable workers using first name {string}")
    public void theProjectLeaderSearchForAvaiableWorkersUsingFirstName(String firstName) {
        try {
            testWorker = pma.findWorkerByFirstName(pma.getWorkers(), firstName);
        } catch (OperationNotAllowedException e) {
            errorMessage.setErrorMessage(e.getMessage());
        }
    }

    @Then("the system returns a worker with matching first name")
    public void theSystemReturnsAWorkerWithMatchingFirstName() {
        assertEquals(origWorker.getFirstname(), testWorker.getFirstname());
    }

    @When("the project leader search for avaiable workers using last name {string}")
    public void theProjectLeaderSearchForAvaiableWorkersUsingLastName(String lastName) {
        try {
            testWorker = pma.findWorkerByLastName(pma.getWorkers(), lastName);
        } catch (OperationNotAllowedException e) {
            errorMessage.setErrorMessage(e.getMessage());
        }
    }
    
    @Then("the system returns a worker with matching last name")
    public void theSystemReturnsAWorkerWithMatchingLastName() {
        assertEquals(origWorker.getLastname(), testWorker.getLastname());
    }

    @Given("there is a project with title {string}, ID {string}")
    public void thereIsAProjectWithTitleID(String title, String ID) {
        try {
            project = new Project(title, ID);
        } catch (OperationNotAllowedException e) {
            errorMessage.setErrorMessage(e.getMessage());
        }
    }

    @When("the project with title {string}, ID {string} is added to the system")
    public void theProjectWithTitleIDIsAddedToTheSystem(String title, String ID) {
        try {
            pma.addProject(new Project(title, ID));
        } catch (OperationNotAllowedException e) {
            errorMessage.setErrorMessage(e.getMessage());
        }
}


 



    
    

}
