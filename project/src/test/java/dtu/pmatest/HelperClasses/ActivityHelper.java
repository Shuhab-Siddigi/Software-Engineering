package dtu.pmatest.HelperClasses;

import java.sql.Date;

import dtu.pma.Activity;
import dtu.pma.OperationNotAllowedException;

public class ActivityHelper {
    private Activity activity;
  

    public Activity getActivity() throws OperationNotAllowedException {
        if (activity == null){
            activity = exampleActivity();
        }
        return activity;
    }

    private Activity exampleActivity() throws OperationNotAllowedException {
        Date start = Date.valueOf("2020-12-21");
        Date end = Date.valueOf("2021-01-20");
        Activity a = new Activity("Activity 1", 0001, start, end);
        return a;
    }
}
