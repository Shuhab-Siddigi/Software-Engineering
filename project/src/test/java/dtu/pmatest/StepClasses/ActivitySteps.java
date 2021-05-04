package dtu.pmatest.StepClasses;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.sql.Date;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import dtu.pma.OperationNotAllowedException;
import dtu.pma.PMA;
import dtu.pma.Project;
import dtu.pma.Worker;
import dtu.pmatest.HelperClasses.ActivityHelper;
import dtu.pmatest.HelperClasses.ProjectHelper;
import dtu.pma.Activity;
import dtu.pma.ErrorMessageHolder;

public class ActivitySteps {
    private PMA pma;
    private ErrorMessageHolder errorMessage;
    private ProjectHelper projectHelper;
    private ActivityHelper activityHelper;
    private Activity activity;
    private Project project;
    private Worker worker;
    private Worker projectLeader;
    private boolean result;

    public ActivitySteps(PMA pma, ProjectHelper projectHelper, ErrorMessageHolder errorMessage, ActivityHelper activityHelper) {
        this.pma = pma;
        this.projectHelper = projectHelper;
        this.errorMessage = errorMessage;
        this.activityHelper = activityHelper;
    }

    @Given("there exist an activity with title {string}, ID {int}, start date {string}, end date {string}")
    public void thereExistAnActivityWithTitleIDStartDateEndDate(String title, Integer ID, String dateStart, String dateEnd) throws OperationNotAllowedException {
        Date startDate = Date.valueOf(dateStart);
        Date endDate = Date.valueOf(dateEnd);
        activity = new Activity(title, ID, startDate, endDate);
    }
    
    @When("the activity is added to the project")
    public void theActivityIsAddedToTheProject() throws OperationNotAllowedException {
        Project p = projectHelper.getProject();
        try {
            pma.addActivityToProject(p, activity);
        } catch (OperationNotAllowedException e) {
            errorMessage.setErrorMessage(e.getMessage());
        }
    }
    
    @Then("the project with ID {int} contains the activity with ID {int}")
    public void theProjectWithIDContainsTheActivityWithID(Integer pID, Integer aID) throws Exception {
        assertTrue(pma.projectContainsActivity(pID, aID));
    }


    @Then("the project start and end date is set to activity start and end date")
    public void theProjectStartAndEndDateIsSetToActivityStartAndEndDate() {
        Project p = projectHelper.getProject();
        assertEquals(p.getInfo().getStartDate(), activity.getInfo().getStartDate());
        assertEquals(p.getInfo().getStartDate(), activity.getInfo().getStartDate());
    }

    @Given("there exist an activity with number {int} in the project with ID {int}")
    public void thereExistAnActivityWithNumberInTheProjectWithID(Integer aID, Integer pID) throws Exception {
        Project p = projectHelper.getProject();
        Activity a = activityHelper.getActivity();
        pma.addActivityToProject(p, a);
        assertTrue(pma.projectContainsActivity(pID, aID));
    }

    @When("the activity with ID {int} is added to the project")
    public void theActivityWithIDIsAddedToTheProject(Integer aID) {
        Project p = projectHelper.getProject();
        if (activity.getInfo().getID() == aID){
            try {
                pma.addActivityToProject(p, activity);
            } catch (OperationNotAllowedException e) {
                errorMessage.setErrorMessage(e.getMessage());
            }
        }
    }
    
    @Then("the error {string} is given")
    public void theErrorIsGiven(String errorMessage) {
        assertEquals(errorMessage, this.errorMessage.getErrorMessage());
    }


    @Then("the error text {string} is given")
    public void theErrorTextIsGiven(String errorMessage) {
        assertEquals(errorMessage, this.errorMessage.getErrorMessage());
    }   
    
    @Given("the project contains the activity with title {string}, ID {int}, start date {string}, end date {string}")
    public void theProjectContainsTheActivityWithTitleIDStartDateEndDate(String title, Integer ID, String startDate, String endDate) throws Exception {
        Date start = Date.valueOf(startDate);
        Date end = Date.valueOf(endDate);
        Project p = projectHelper.getProject();
        Activity a2 = new Activity(title, ID, start, end);
        pma.addActivityToProject(p, a2);
        assertTrue(pma.projectContainsActivity(p.getInfo().getID(), a2.getInfo().getID()));
    }
    
    @Given("an activity exist with start date {string} and end date {string}")
    public void anActivityExistWithStartDateAndEndDate(String startDate, String endDate) throws OperationNotAllowedException {
        Date start = Date.valueOf(startDate);
        Date end = Date.valueOf(endDate);
        activity = new Activity("title", 00, start, end);
    }
    
    @When("checked if activity is booked with date {string} and end date {string}")
    public void checkedIfActivityIsBookedWithDateAndEndDate(String startDate, String endDate) throws Exception {
        Date start = Date.valueOf(startDate);
        Date end = Date.valueOf(endDate);
        result = activity.getInfo().isFree(start, end);
    }
    
    @Then("the activity fits in plan")
    public void theActivityFitsInPlan() {
        assertTrue(result);
    }
    
    @Then("the activity does not fit in plan")
    public void theActivityDoesNotFitInPlan() {
        assertFalse(result);
    }

    @When("the worker with ID {string} removes the activity with ID {int} from the project with ID {int}")
    public void theWorkerWithIDRemovesTheActivityWithIDFromTheProjectWithID(String wID, Integer aID, Integer pID) throws OperationNotAllowedException {
    
        try {
            pma.getProjectWithID(pID).removeActivity(pma.getWorkerWithID(wID), pma.getProjectWithID(pID).getActivityFromID(aID));
        } catch (OperationNotAllowedException e) {
            errorMessage.setErrorMessage(e.getMessage());
        }
    }
    
    @Then("the activity with id {int} is not contained in project")
    public void theActivityWithIdIsNotContainedInProject(Integer aID) {
        assertEquals(null, projectHelper.getProject().getActivityFromID(aID));
    }

    
    @When("the project leader adds the worker with ID {string} to activity with ID {int}")
    public void theProjectLeaderAddsTheWorkerWithIDToActivityWithNumber(String workerID, Integer activityID) throws OperationNotAllowedException {
        project = projectHelper.getProject();
        activity = project.getActivityFromID(activityID);
        worker = pma.getWorkerWithID(workerID);
        projectLeader = project.getProjectLeader();

        try {
            project.addWorkerToActivity(activity, worker, projectLeader);
        } catch (OperationNotAllowedException e) {
            errorMessage.setErrorMessage(e.getMessage());
        }
    }

    @Then("the worker with ID {string} is added to the activity")
    public void theWorkerWithIDIsAddedToTheActivity(String workerID) {
        assertTrue(activity.getWorker(workerID).getID().equals(workerID));
    }

    @When("worker with ID {string} adds the worker with ID {string} to activity with ID {int}")
    public void workerWithIDAddsTheWorkerWithIDToActivityWithNumber(String workerID, String workerID2, Integer activityID) {
        project = projectHelper.getProject();
        activity = project.getActivityFromID(activityID);
        Worker projectLeader = pma.getWorkerWithID(workerID);
        Worker worker = pma.getWorkerWithID(workerID2);
        try {
            project.addWorkerToActivity(activity, worker, projectLeader);
        } catch (OperationNotAllowedException e) {
            errorMessage.setErrorMessage(e.getMessage());
        }
    }

    @Given("the worker with ID {string} is assigned to the activity with ID {int}")
    public void theWorkerWithIDIsAssignedToTheActivityWithID(String workerID, Integer activityID) throws OperationNotAllowedException {
        theProjectLeaderAddsTheWorkerWithIDToActivityWithNumber(workerID, activityID);
    }

    @When("the project leader removes the worker from the activity")
    public void theProjectLeaderRemovesTheWorkerFromTheActivity() throws OperationNotAllowedException {
        try {
            project.removeWorkerFromActivity(activity, worker, projectLeader);
        } catch (OperationNotAllowedException e) {
            errorMessage.setErrorMessage(e.getMessage());
        }
    }

    @Then("the worker with ID {string} is not assigned to the activity with ID {int}")
    public void theWorkerWithIDIsNotAssignedToTheActivityWithID(String workerID, Integer activityID) {
        assertFalse(pma.getActivityWithID(project, activityID).getWorker(workerID) != null);
    }

    @When("the worker removes a worker from the activity")
    public void theWorkerRemovesAWorkerFromTheActivity() throws OperationNotAllowedException {
        try {
            project.removeWorkerFromActivity(activity, worker, worker);
        } catch (OperationNotAllowedException e) {
            errorMessage.setErrorMessage(e.getMessage());
        }  
    }

    @Given("a project and an activity exist in the system")
    public void theProjectAndAnActivityExistInTheSystem() throws OperationNotAllowedException {
        project = projectHelper.getProject();
        pma.addProject(project);
        activity = activityHelper.getActivity();
        try {
            project.addActivity(activity);
        } catch (OperationNotAllowedException e) {
            errorMessage.setErrorMessage(e.getMessage());
        }  
    }


    @Given("a worker exist in the system")
    public void aWorkerExistInTheSystem() throws OperationNotAllowedException  {
        pma.addDatabase();
        worker = pma.getWorkerWithID("AAAB");
    }

    @Given("a worker with ID {string} exist in the system")
    public void aWorkerWithIDExistInTheSystem(String id) throws OperationNotAllowedException {
        pma.addDatabase();
        worker = pma.getWorkerWithID(id);
    }
    

    @Given("the project has a project leader")
    public void theProjectHasAProjectLeader() throws OperationNotAllowedException {
        pma.addDatabase();
        projectLeader = pma.getWorkerWithID("AAAA");
        try {
            pma.assignLeader(projectLeader, project);
        } catch (OperationNotAllowedException e) {
            errorMessage.setErrorMessage(e.getMessage());
        }  
    }

    @Given("the worker is assigned to the activity")
    public void theWorkerIsAssignedToTheActivity() {
        try {
            project.addWorkerToActivity(activity, worker, projectLeader);
        } catch (OperationNotAllowedException e) {
            errorMessage.setErrorMessage(e.getMessage());
        }
    }

    @Then("the worker is removed from the activity")
    public void theWorkerIsRemovedFromTheActivity() {
        assertFalse(activity.getWorker(worker.getID()) != null);
    }

    @Given("the activity with ID {int} is not contained in the project")
    public void theActivityWithIDIsNotContainedInTheProject(Integer aID) {
        theActivityWithIdIsNotContainedInProject(aID);
    }

    @When("the start date of the activity is changed to {string}")
    public void theStartDateOfTheActivityIsChangedTo(String startDate) throws OperationNotAllowedException {
        activity = activityHelper.getActivity();
        project = projectHelper.getProject();
        Date start = Date.valueOf(startDate);
        try {
            pma.changeStartDateActivity(project, activity , start);
        } catch (OperationNotAllowedException e) {
            errorMessage.setErrorMessage(e.getMessage());
        }
    }

    @Then("the activity changes start date to {string}")
    public void theActivityChangesStartDateTo(String startDate) {
        Date start = Date.valueOf(startDate);
        assertEquals(activity.getInfo().getStartDate(), start);
    }

    @When("the end date of the activity is changed to {string}")
    public void theEndDateOfTheActivityIsChangedTo(String endDate) throws OperationNotAllowedException {
        activity = activityHelper.getActivity();
        project = projectHelper.getProject();
        Date end = Date.valueOf(endDate);
        try {
            pma.changeEndDateActivity(project, activity, end);
        } catch (OperationNotAllowedException e) {
            errorMessage.setErrorMessage(e.getMessage());
        }
    }
    
    @Then("the activity changes end date to {string}")
    public void theActivityChangesEndDateTo(String endDate) {
        Date end = Date.valueOf(endDate);
        assertEquals(activity.getInfo().getEndDate(), end);
    }
    
    @When("the worker registers {int} work hours on activity")
    public void theWorkerRegistersWorkHoursOnActivity(Integer hours) throws Exception {
        worker = pma.getWorkerWithID("AAAA");
        try {
            pma.addWorkHours(worker, activity, hours);
        } catch (OperationNotAllowedException e) {
            errorMessage.setErrorMessage(e.getMessage());
        }
        
    }
    
    @Then("the worker has worked {int} hours on the activity with ID {int}")
    public void theWorkerHasWorkedHoursOnTheActivityWithID(Integer hours, Integer aID) {
        assertTrue(activity.getRegisteredHours() == hours);
    }

    @Then("the registered hours is updated for the project with {int} hours")
    public void theRegisteredHoursIsUpdatedForTheProjectWithHours(Integer hours) {
        System.out.println(project.getInfo().getHoursWorked()); 
        assertTrue(project.getInfo().getHoursWorked() == hours);
    }

    @Given("the worker is not assigned to the activity")
    public void theWorkerIsNotAssignedToTheActivity() {
        assertEquals(null, activity.getWorker(worker.getID()));
    }
    
    
}
