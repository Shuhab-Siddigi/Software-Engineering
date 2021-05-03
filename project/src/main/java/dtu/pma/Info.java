package dtu.pma;
import java.sql.Date;

public class Info {
    private String title;
    private int ID;
    private int expectedHours;
    private int hoursWorked;
    private Date startDate;
    private Date endDate;
    private String description;

    public Info(String title, int ID, int expectedHours, int hoursWorked, Date startDate, Date endDate, String description) {
        this.title = title;
        this.ID = ID;
        this.setExpectedHours(expectedHours);
        this.setHoursWorked(hoursWorked);
        this.setStartDate(startDate);
        this.setEndDate(endDate);
        this.setDescription(description);
    }

    public boolean isFree(Date startDate, Date endDate) throws Exception{
        if (endDate.before(startDate)){ // 1
            throw new Exception("End Date is before Start Date"); // 1a
        }
       
        Date start = this.getStartDate(); 
        Date end = this.getEndDate(); 
        if(start.before(startDate) && end.after(endDate)){ // 2
            return false; // 2a
        }else if(start.after(endDate)){ // 3
            return true;    // 3a
        }else if(end.before(startDate)){ // 4
            return true; // 4a
        }
        return false;   // 5
    }
    
    public Info (String title, int ID){
        this.title = title;
        this.ID = ID;
    } //For projects

    public Info (String title, int ID, Date startDate, Date endDate){
        this.title = title;
        this.ID = ID;
        this.startDate = startDate;
        this.endDate = endDate;
    } //For activities

    public int getExpectedHours() {
        return expectedHours;
    }

    public void setExpectedHours(int expectedHours) {
        this.expectedHours = expectedHours;
    }

    public int getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public Date getStartDate() {
      
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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


