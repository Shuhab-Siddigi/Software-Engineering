package dtu.pmatest.HelperClasses;

import java.sql.Date;

import dtu.pma.Activity;
import dtu.pma.OperationNotAllowedException;
import dtu.pma.PMA;

public class ActivityHelper {
    private Activity activity;
    private PMA pma;

    public ActivityHelper(PMA pma) {
        this.pma = pma;
    }

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
