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

    @Given("there exist an activity with title {string} ID {int}")
    public void thereExistAnActivityWithTitleID(String title, Integer ID) {
        
        activity = new Activity(title, ID);
        
       
        

    }

}
