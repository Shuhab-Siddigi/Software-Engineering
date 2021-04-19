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
import pmatest.HelperClasses.ProjectHelper;
import pma.Activity;
import pma.ErrorMessageHolder;

public class ActivitySteps {
    private PMA pma;
    private ErrorMessageHolder errorMessage;
    private ProjectHelper projectHelper;
    private Activity activity;

    public ActivitySteps(PMA pma, ProjectHelper projectHelper, ErrorMessageHolder errorMessage) {
        this.pma = pma;
        this.projectHelper = projectHelper;
        this.errorMessage = errorMessage;
    }

    @Given("there exist an activity with title {string}, ID {int}, start date {string}, end date {string}")
    public void thereExistAnActivityWithTitleIDStartDateEndDate(String title, Integer ID, String dateStart, String dateEnd) {
        Date startDate = Date.valueOf(dateStart);
        Date endDate = Date.valueOf(dateEnd);
        activity = new Activity(title, ID, startDate, endDate);
    }
    
    @When("the activity is added to the project")
    public void theActivityIsAddedToTheProject() {
        Project p = projectHelper.getProject();
        pma.addActivityToProject(p, activity);
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
    
}
