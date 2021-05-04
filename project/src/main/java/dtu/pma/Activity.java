package dtu.pma;


import java.sql.Date;
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

    public String printActivity() {
        Info tempInfo = this.getInfo();
        String text = tempInfo.getTitle() + " " + tempInfo.getStartDate() + " " + tempInfo.getEndDate() + " ";
        if (tempInfo.getExpectedHours() > 0) {
            text += tempInfo.getExpectedHours() + " " + tempInfo.getHoursWorked() + " ";
        }

        text += "\n";

        if (workers.size() > 0) {
            for (Worker w : workers) {
                text += w.getLastname() + ", " + w.getFirstname() + " " + w.getID() + " \n";
            }
        }
        text += "\n\n";

        return text;
    }

    // er hurtigt tilføjet da den skulle bruges i generate_report.feature
    public void addWorker(Worker worker) {
        this.workers.add(worker);
    }

    public List<Worker> getWorkers() {
        return workers;
    }

    public Worker getWorker(String workerID){
        return workers.stream().filter(w -> w.getID().equals(workerID)).findAny().orElse(null);
    }
    
    public void removeWorker(Worker worker) {
        workers.removeIf(w -> w.getID().equals(worker.getID()));
    }

    public void setRegisteredHours(int hours){
        this.info.setHoursWorked(this.info.getHoursWorked() + hours);
    }

    public int getRegisteredHours(){
        return this.info.getHoursWorked();
    }
}
