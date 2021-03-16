package PMA;

public class Worker {

    private String firstname;
    private String lastname;
    private int ID;

    public Worker(){

    }


    public Worker(String firstname,String lastname,int ID) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.ID = ID;
    
    }

    public int getID() {
        return ID;
    }

    public void setID(int iD) {
        this.ID = iD;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    
    
}
