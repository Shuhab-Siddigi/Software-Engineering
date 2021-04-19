package pma;

import java.sql.Date;
import java.sql.Time;

public class Activity {
    
    private String title;
    private int ID;
    private Time expectedHours;
    private Time hoursWorked;
    private Date startDate;
    private Date endDate;
    private String descripton;
    private Worker projectLeder;
    

    public Activity(String title, int ID) {
        this.title = title;
        this.ID = ID;
    }
    
    public String getTitle() {
        return title;
    }
    public Worker getProjectLeder() {
        return projectLeder;
    }
    public void setProjectLeder(Worker projectLeder) {
        this.projectLeder = projectLeder;
    }
    public String getDescripton() {
        return descripton;
    }
    public void setDescripton(String descripton) {
        this.descripton = descripton;
    }
    public Date getEndDate() {
        return endDate;
    }
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
    public Date getStartDate() {
        return startDate;
    }
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
    public Time getHoursWorked() {
        return hoursWorked;
    }
    public void setHoursWorked(Time hoursWorked) {
        this.hoursWorked = hoursWorked;
    }
    public Time getExpectedHours() {
        return expectedHours;
    }
    public void setExpectedHours(Time expectedHours) {
        this.expectedHours = expectedHours;
    }
    public int getID() {
        return ID;
    }
    public void setID(int iD) {
        this.ID = iD;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    

}
