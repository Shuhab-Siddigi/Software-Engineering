package dtu.pmatest.WhiteBoxTest;

import org.junit.Test;
import dtu.pma.Activity;
import dtu.pma.OperationNotAllowedException;
import dtu.pma.PMA;
import dtu.pma.Project;
import dtu.pmatest.HelperClasses.ProjectHelper;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Date;

public class PmaAddProjectWhiteBoxTest {




    PMA sut = new PMA();

   
   //rigtige opsætning af exceptions?
   
    @Test
    public void PmaAddProjectTestInputDataSetA()  {

        Project project =  new Project("Extreme Programming",0001);

        try {
            sut.addProject(project);
        } catch (OperationNotAllowedException e) {
           
        }
        Project project2 =  new Project("Programming",0001);

        try {
            sut.addProject(project2);
        } catch (OperationNotAllowedException e) {
        assertTrue(e instanceof Exception);
        }
        
    }


    @Test
    public void PmaAddProjectTestInputDataSetB()  {

        Project project =  new Project("Extreme Programming",0001);

        try {
            sut.addProject(project);
        } catch (OperationNotAllowedException e) {
           
        }
        Project project2 =  new Project("Extreme Programming",0002);

        try {
            sut.addProject(project2);
        } catch (OperationNotAllowedException e) {

        assertTrue(e instanceof Exception);
        }
        
    }

    @Test
    public void PmaAddProjectTestInputDataSetC()  {

        Project project =  new Project("Extreme Programming",10000);

     
        try {
            sut.addProject(project);
        } catch (OperationNotAllowedException e) {
        assertTrue(e instanceof Exception);
        }
        
    }


    @Test
    public void PmaAddProjectTestInputDataSetD()  {

        Project project =  new Project("Extreme Programming",0001);

     
        try {
            sut.addProject(project);
        } catch (OperationNotAllowedException e) {

        }
        assertTrue(sut.getProjects().contains(project));
    }






//     @Test
// public void testInputDataSetPmaAddProjectA() {

//     int projectID = 2;
//     int activityID = 3;

//     try {
//         sut.projectContainsActivity(projectID, activityID);
//     } catch (Exception e) {
//        assertTrue(e instanceof Exception);

//     }





// }


// @Test


    







}
