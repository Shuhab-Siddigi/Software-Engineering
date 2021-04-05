package PMA;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class PMA {

    
    private List<Worker> workers = new ArrayList<>();


    




    public static boolean containsProjectWithID(String string)
    {
        return false;
    }





    public List<Worker> getWorkers() {
        return workers;
    }





    public void setWorkers(List<Worker> workers) {
        this.workers = workers;
    }


    public Stream<Worker> getWorkerStream() {
		return workers.stream();
	}


    public boolean containsWorkerWithID(String iD) {
        return getWorkerStream().anyMatch(m -> m.getID().contentEquals(iD));
    }

    public boolean containsWorkerWithName(String name) {
        return false;
    }



    public void addWorker(Worker tempWorker) {
        workers.add(tempWorker);
    }

    
}
