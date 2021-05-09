package dtu.pmatest.WhiteBoxTest;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.booleanThat;

import java.sql.Date;

import org.junit.Test;

import dtu.pma.Activity;
import dtu.pma.OperationNotAllowedException;
import dtu.pma.PMA;
import dtu.pma.Project;

public class PmaProjectContainsActivity {

    PMA sut = new PMA();


  


@Test
public void testInputDataSetPmaA() throws OperationNotAllowedException {

    //setup


    Project project = new Project("Extreme Programming",0001);

    Date startDate = Date.valueOf("2020-01-01");
    Date endDate = Date.valueOf("2021-01-01");


    Activity activity = new Activity("title1", 1, startDate, endDate);

    sut.addProject(project);

    sut.addActivityToProject(project, activity);

    int projectID = 2;
    int activityID = 3;

    try {
        sut.projectContainsActivity(projectID, activityID);
    } catch (Exception e) {
       assertTrue(e instanceof Exception);
      
    }

}

@Test
public void testInputDataSetPmaB() throws OperationNotAllowedException {


    Project project = new Project("Extreme Programming",0001);

    Date startDate = Date.valueOf("2020-01-01");
    Date endDate = Date.valueOf("2021-01-01");


    Activity activity = new Activity("title1", 1, startDate, endDate);

    sut.addProject(project);

    sut.addActivityToProject(project, activity);

    int projectID = 1;
    int activityID = 3;
    boolean result = false;

    try {
        result = sut.projectContainsActivity(projectID, activityID);
    } catch (Exception e) {
       assertTrue(e instanceof Exception);
      
    }

    assertEquals(result, false);
    

}

@Test
public void testInputDataSetPmaC() throws OperationNotAllowedException {


    Project project = new Project("Extreme Programming",0001);

    Date startDate = Date.valueOf("2020-01-01");
    Date endDate = Date.valueOf("2021-01-01");


    Activity activity = new Activity("title1", 1, startDate, endDate);

    sut.addProject(project);

    sut.addActivityToProject(project, activity);

    int projectID = 1;
    int activityID = 1;
    boolean result = false;

    try {
        result = sut.projectContainsActivity(projectID, activityID);
    } catch (Exception e) {
       assertTrue(e instanceof Exception);
    }

    assertEquals(result, true);
    

}






// @Test
// public void testInputDataSetPmaA() {

//     int projectID = 1;
//     int activityID = 3;
//     boolean res = false;

//     Project project = new Project("Extreme Programming",0001);





//     try {
//         res = sut.projectContainsActivity(projectID, activityID);
//     } catch (Exception e) {
//     }


//  assertFalse(res);



// }



}




    

