package pma;

import java.sql.Date;
import java.sql.Time;

public class Project {


    private String title;
    private int ID;
    private Time expectedHours;
    private Time hoursWorked;
    private Date startDate;
    private Date endDate;
    private String descripton;
    private Worker projectLeder;
    

    public Project(String title, Integer ID) {
        this.setTitle(title);
        this.setID(ID);
    }


    public String getTitle() {
        return title;
    }


    public void setTitle(String title) {
        this.title = title;
    }


    public int getID() {
        return ID;
    }


    public void setID(int iD) {
        this.ID = iD;
    }


    
}
