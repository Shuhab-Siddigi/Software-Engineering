package dtu.pma;

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

    public boolean isFree(Date startDate, Date endDate) {
        Date start = this.getInfo().getStartDate();
        Date end = this.getInfo().getEndDate();
        // startDate eller endDate ligger imellem activity start og slut dato
        if ((start.compareTo(startDate) < 0 && end.compareTo(startDate) > 0)
                || (start.compareTo(endDate) < 0 && end.compareTo(endDate) > 0)) {
            return false;

            // startDate og endDate ligger efter activity start og slut dato
        } else if (start.compareTo(startDate) < 0 && start.compareTo(endDate) < 0) {
            return true;

            // startDate og endDate ligger før activity start og slut dato
        } else if (end.compareTo(startDate) > 0 && end.compareTo(endDate) > 0) {
            return true;
        }
        return false;
    }

    // er hurtigt tilføjet da den skulle bruges i generate_report.feature
    public void addWorker(Worker worker) {
        this.workers.add(worker);
    }

    public List<Worker> getWorkers() {
        return workers;
    }
    // Add worker
    // Remove worker
}
