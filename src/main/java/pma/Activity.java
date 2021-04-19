package pma;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class Activity {
        
    private List<Worker> workers = new ArrayList<>();
    private Info info;

    public Activity(String title, int ID, Date startDate, Date endDate) {
        this.info = new Info(title, ID, startDate, endDate);
    }

    public Info getInfo() {
        return this.info;
    }

    //Add worker
    //Remove worker
}
