package pmatest.StepClasses;

import static org.junit.Assert.assertTrue;

import io.cucumber.java.en.Given;

public class ProjectSteps {

    @Given("there is a project  with  title {string} and ID {int}.")
    public void thereIsAProjectWithTitleAndID(String string, Integer int1) {
       assertTrue(true);
    }
    

}
