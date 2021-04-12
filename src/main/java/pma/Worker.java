package pma;

public class Worker {

    private String firstname;
    private String lastname;
    private String ID;

    public Worker(){

    }


    public Worker(String firstname,String lastname,String ID) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.ID = ID;
    }



    public String getID() {
        return ID;
    }

    public void setID(String iD) {
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
