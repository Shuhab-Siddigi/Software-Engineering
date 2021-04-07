package pma;

import java.sql.Date;
import java.sql.Time;

public class Project {


    private String title;
    private String ID;
    private Time expectedHours;
    private Time hoursWorked;
    private Date startDate;
    private Date endDate;
    private String descripton;
    private Worker projectLeder;
    
    
    public Project(String title) {
       this.title = title;
       //setTitle(title);
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
    public String getID() {
        return ID;
    }
    public void setID(String iD) {
        this.ID = iD;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    
    
    
}
