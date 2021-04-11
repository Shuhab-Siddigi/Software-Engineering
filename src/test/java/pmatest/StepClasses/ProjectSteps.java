package pmatest.StepClasses;

import static org.junit.Assert.assertTrue;

import io.cucumber.java.en.Given;

public class ProjectSteps {


    @Given("a  project  with  name  {string},")
    public void aProjectWithName(String string) {
        // Write code here that turns the phrase above into concrete actions
        assertTrue(true);
    }
    
    @Given("project  number {string} does not exist")
    public void projectNumberDoesNotExist(String string) {
        // Write code here that turns the phrase above into concrete actions
        assertTrue(true);
    }
    
    

}
