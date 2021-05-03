package dtu.WhiteBoxTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import java.sql.Date;
import dtu.pma.Activity;
import dtu.pma.OperationNotAllowedException;
import dtu.pma.Project;

public class ProjectWhiteBoxTest {
    Project sut = new Project("title", 0);

    

@Test
public void testInputDataSetA() {
    Date startDate = Date.valueOf("2020-01-01");
    Date endDate = Date.valueOf("2021-01-01");
   Activity activity = new Activity("title1", 1, startDate, endDate);
   try {
    sut.addActivity(activity);
} catch (OperationNotAllowedException e) {
    e.printStackTrace();
}   
int ID = -1;
assertEquals(null,sut.getActivityFromID(ID));
}

@Test
public void testInputDataSetB() {
    Date startDate = Date.valueOf("2020-01-01");
    Date endDate = Date.valueOf("2021-01-01");
   Activity activity = new Activity("title1", 1, startDate, endDate);
   try {
    sut.addActivity(activity);
} catch (OperationNotAllowedException e) {
    e.printStackTrace();
}   
int ID = 1;
assertEquals(activity,sut.getActivityFromID(ID));
}







}
