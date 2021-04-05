package PMATest.HelperClasses;

import java.util.ArrayList;
import java.util.List;

import PMA.PMA;
import PMA.Worker;


public class WorkerHelper {

    private Worker worker;
    private PMA pma;
    private List<Worker> allWorkers = new ArrayList<>();


    public WorkerHelper(PMA pma) {
        this.pma = pma;
    }

    public Worker getWorker() {
        if (worker == null) {
            worker = exampleWorker();
        }
        return worker;
    }


    public List<Worker> getAllWorkers() {
        if (allWorkers == null) {
            allWorkers = exampleAllWorkers();
        }
        return allWorkers;
    }

    private Worker exampleWorker() {
        Worker worker = new Worker("Worker","Workerson","A");
        return worker;
    }

    private List<Worker> exampleAllWorkers() {
        Worker tempWorker = new Worker();    
        String ID;    
        for (int i = 1; i <= 50; i++){
            tempWorker.setFirstname("Worker"+i);
            tempWorker.setLastname("Workerson"+i);
            ID = Integer.toString(i);
            tempWorker.setID(ID);
            allWorkers.add(tempWorker);
            pma.addWorker(tempWorker);
        }
     
        return allWorkers;
    }

}

/*
// Female
Angela Anderson, 
Tallulah Hebert,
Aaliyah Turner
Courtney Carr, Maisy Hudson,
Saskia Dillon,
Rachel Wright,
Laura Lam, Naomi Gross,
Poppy Abbott,
Lauren Best,
Edith Velez,
Gabrielle Moyer,
Hafsah Benson,
Tina Friedman,
Natalie Leonard,
Lena Jarvis,
Salma Montgomery,
Teresa Watson,
Georgia Ortiz, Bailey Hill,
Rhonda Rivera,
Rosemary Wolf,
Gertrude Fernandez,

// Male
Aiden Faulkner
Henry Lyons
Euan Maddox
Maxwell Shah
Hassan Greer
Marco Crane
Verity Meza
Louis Doyle
Michael Schneider
Juan Pollard
Carlos Crawford
Marvin Harrison
Arran Escobar
Thomas Tapia
Phillip Lara
Conner Walker
Jeremiah Cuevas
Isaiah Dickerson
Willard Sawyer
Zachary Woodard
Amir Vargas
Kyle Gilmore
Patrick Martin
Tallulah Hebert,
Aaliyah Turner
Courtney Carr, Maisy Hudson,
Saskia Dillon,
Rachel Wright,
Laura Lam, Naomi Gross,
Poppy Abbott,
Lauren Best,
Edith Velez,
Gabrielle Moyer,
Hafsah Benson,
Tina Friedman,
Natalie Leonard,
Lena Jarvis,
Salma Montgomery,
Teresa Watson,
Georgia Ortiz, Bailey Hill,
Rhonda Rivera,
Rosemary Wolf,
Gertrude Fernandez,
Angela Anderson, 
*/