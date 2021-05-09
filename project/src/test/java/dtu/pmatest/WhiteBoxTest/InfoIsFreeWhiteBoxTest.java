package dtu.pmatest.WhiteBoxTest;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.sql.Date;

import org.junit.Test;

import dtu.pma.Activity;
import dtu.pma.OperationNotAllowedException;

public class InfoIsFreeWhiteBoxTest {


@Test
public void InfoIsFreeWhiteBoxTestA() throws OperationNotAllowedException {

    //direct activity?

    Date startDate = Date.valueOf("2020-01-01");
    Date endDate = Date.valueOf("2021-01-01");


    Activity activity = new Activity("title1", 1, startDate, endDate);


    Date startDate2 = Date.valueOf("2020-01-01");
    Date endDate2 = Date.valueOf("2019-01-01");




     try {
        activity.getInfo().isFree(startDate2, endDate2);
    } catch (Exception e) {
        assertTrue(e instanceof Exception);
    }

}





@Test
public void InfoIsFreeWhiteBoxTestB() throws OperationNotAllowedException {

    //direct activity?

    Date startDate = Date.valueOf("2020-01-01");
    Date endDate = Date.valueOf("2021-01-01");


    Activity activity = new Activity("title1", 1, startDate, endDate);


    Date startDate2 = Date.valueOf("2019-01-01");
    Date endDate2 = Date.valueOf("2022-01-01");

    boolean result = false;



     try {
        result = activity.getInfo().isFree(startDate2, endDate2);
    } catch (Exception e) {
        assertTrue(e instanceof Exception);
    }
    assertFalse(result);

}

@Test
public void InfoIsFreeWhiteBoxTestC() throws OperationNotAllowedException {

    //direct activity?

    Date startDate = Date.valueOf("2020-01-01");
    Date endDate = Date.valueOf("2024-01-01");


    Activity activity = new Activity("title1", 1, startDate, endDate);


    Date startDate2 = Date.valueOf("2017-01-01");
    Date endDate2 = Date.valueOf("2019-01-01");

    boolean result = false;



     try {
        result = activity.getInfo().isFree(startDate2, endDate2);
    } catch (Exception e) {
        assertTrue(e instanceof Exception);
    }
    assertTrue(result);

}


@Test
public void InfoIsFreeWhiteBoxTestD() throws OperationNotAllowedException {

    //direct activity?

    Date startDate = Date.valueOf("2020-01-01");
    Date endDate = Date.valueOf("2024-01-01");


    Activity activity = new Activity("title1", 1, startDate, endDate);


    Date startDate2 = Date.valueOf("2025-01-01");
    Date endDate2 = Date.valueOf("2027-01-01");

    boolean result = false;



     try {
        result = activity.getInfo().isFree(startDate2, endDate2);
    } catch (Exception e) {
        assertTrue(e instanceof Exception);
    }
    assertTrue(result);

}


@Test
public void InfoIsFreeWhiteBoxTestE() throws OperationNotAllowedException {

    //direct activity?

    Date startDate = Date.valueOf("2020-01-01");
    Date endDate = Date.valueOf("2024-01-01");


    Activity activity = new Activity("title1", 1, startDate, endDate);


    Date startDate2 = Date.valueOf("2021-01-01");
    Date endDate2 = Date.valueOf("2027-01-01");

    boolean result = false;



     try {
        result = activity.getInfo().isFree(startDate2, endDate2);
    } catch (Exception e) {
        assertTrue(e instanceof Exception);
    }
    assertFalse(result);

}








    
}
