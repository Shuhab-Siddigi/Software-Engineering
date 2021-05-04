package dtu.pma;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Activity {

    private List<Worker> workers = new ArrayList<>();
    private Info info;

    public Activity(String title, int ID, Date startDate, Date endDate) throws OperationNotAllowedException {
        if (isDateAllowed(startDate.toString()) && isDateAllowed(endDate.toString())) {
            this.info = new Info(title, ID, startDate, endDate);
        }
    }

    public boolean isDateAllowed(String date) throws OperationNotAllowedException {

        String regex = "^[0-9]{4}[-][0-9]{2}[-][0-9]{2}$";

        Pattern p = Pattern.compile(date);

        if (date == null || date == "") {
            throw new OperationNotAllowedException("Invalid input sequence: Date has to be inserted");
        }
        Matcher m = p.matcher(date);

        if (m.matches() == false) {
            throw new OperationNotAllowedException("Invalid input sequence: Date has to be in format YYYY-MM-DD");
        }
        return true;
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

    public Worker getWorker(String workerID) {
        return workers.stream().filter(w -> w.getID().equals(workerID)).findAny().orElse(null);
    }

    public void removeWorker(Worker worker) {
        workers.removeIf(w -> w.getID().equals(worker.getID()));
    }

    public void setRegisteredHours(int hours) {
        this.info.setHoursWorked(this.info.getHoursWorked() + hours);
    }

    public int getRegisteredHours() {
        return this.info.getHoursWorked();
    }
}
