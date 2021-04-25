package pmatest.StepClasses;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.sql.Date;

import javax.swing.UIDefaults.ActiveValue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pma.OperationNotAllowedException;
import pma.PMA;
import pma.Project;
import pmatest.HelperClasses.ActivityHelper;
import pmatest.HelperClasses.ProjectHelper;
import pma.Activity;
import pma.ErrorMessageHolder;

public class ActivitySteps {
    private PMA pma;
    private ErrorMessageHolder errorMessage;
    private ProjectHelper projectHelper;
    private ActivityHelper activityHelper;
    private Activity activity;
    private boolean result;

    public ActivitySteps(PMA pma, ProjectHelper projectHelper, ErrorMessageHolder errorMessage, ActivityHelper activityHelper) {
        this.pma = pma;
        this.projectHelper = projectHelper;
        this.errorMessage = errorMessage;
        this.activityHelper = activityHelper;
    }

    @Given("there exist an activity with title {string}, ID {int}, start date {string}, end date {string}")
    public void thereExistAnActivityWithTitleIDStartDateEndDate(String title, Integer ID, String dateStart, String dateEnd) {
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
    public void theProjectWithIDContainsTheActivityWithID(Integer pID, Integer aID) {
        assertTrue(pma.projectContainsActivity(pID, aID));
    }


    @Then("the project start and end date is set to activity start and end date")
    public void theProjectStartAndEndDateIsSetToActivityStartAndEndDate() {
        Project p = projectHelper.getProject();
        assertEquals(p.getInfo().getStartDate(), activity.getInfo().getStartDate());
        assertEquals(p.getInfo().getStartDate(), activity.getInfo().getStartDate());
    }

    @Given("there exist an activity with number {int} in the project with ID {int}")
    public void thereExistAnActivityWithNumberInTheProjectWithID(Integer aID, Integer pID) throws OperationNotAllowedException {
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
    public void theProjectContainsTheActivityWithTitleIDStartDateEndDate(String title, Integer ID, String startDate, String endDate) throws OperationNotAllowedException {
        Date start = Date.valueOf(startDate);
        Date end = Date.valueOf(endDate);
        Project p = projectHelper.getProject();
        Activity a2 = new Activity(title, ID, start, end);
        pma.addActivityToProject(p, a2);
        assertTrue(pma.projectContainsActivity(p.getInfo().getID(), a2.getInfo().getID()));
    }
    
    @Given("an activity exist with start date {string} and end date {string}")
    public void anActivityExistWithStartDateAndEndDate(String startDate, String endDate) {
        Date start = Date.valueOf(startDate);
        Date end = Date.valueOf(endDate);
        activity = new Activity("title", 00, start, end);
    }
    
    @When("checked if activity is booked with date {string} and end date {string}")
    public void checkedIfActivityIsBookedWithDateAndEndDate(String startDate, String endDate) {
        Date start = Date.valueOf(startDate);
        Date end = Date.valueOf(endDate);
        result = activity.isFree(start, end);
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


}

  

    

