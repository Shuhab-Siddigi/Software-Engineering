package pmatest.HelperClasses;

import java.sql.Date;

import pma.Activity;
import pma.PMA;

public class ActivityHelper {
    private Activity activity;
    private PMA pma;

    public ActivityHelper(PMA pma) {
        this.pma = pma;
    }

    public Activity getActivity() {
        if (activity == null){
            activity = exampleActivity();
        }
        return activity;
    }

    private Activity exampleActivity() {
        Date start = Date.valueOf("2020-12-21");
        Date end = Date.valueOf("2021-01-20");
        Activity a = new Activity("Activity 1", 0001, start, end);
        return a;
    }
}
