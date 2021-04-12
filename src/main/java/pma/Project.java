package pma;


public class Project {


    private String title;
    private int ID;
    
    public Project(String title, Integer ID) {
        this.setTitle(title);
        this.setID(ID);
    }


    public Project(Integer ID) {
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
