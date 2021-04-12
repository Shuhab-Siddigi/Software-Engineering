package pmatest.HelperClasses;

import java.util.ArrayList;
import java.util.List;

import pma.PMA;
import pma.Worker;

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
        Worker worker = new Worker("Angela", "Anderson", "AAAA");
        return worker;
    }

    private List<Worker> exampleAllWorkers() {

        // Female
        pma.addWorker(new Worker("Aaliyah", "Turner", "AAAB"));
        pma.addWorker(new Worker("allulah", " Hebert", "AAAC"));
        pma.addWorker(new Worker("Courtney", " Carr", "AAAD"));
        pma.addWorker(new Worker("Maisy", " Hudson", "AAAE"));
        pma.addWorker(new Worker("Saskia", " Dillon", "AAAF"));
        pma.addWorker(new Worker("Rachel", " Wright", "AAAG"));
        pma.addWorker(new Worker("Laura", " Lam", "AAAH"));
        pma.addWorker(new Worker("Naomi", " Gross", "AAAI"));
        pma.addWorker(new Worker("Poppy", " Abbott", "AAAJ"));
        pma.addWorker(new Worker("Lauren", " Best", "AAAK"));
        pma.addWorker(new Worker("Edith", " Velez", "AAAL"));
        pma.addWorker(new Worker("Gabrielle", " Moyer", "AAAM"));
        pma.addWorker(new Worker("Hafsah", " Benson", "AAAN"));
        pma.addWorker(new Worker("Tina", " Friedman", "AAAO"));
        pma.addWorker(new Worker("Natalie", "Leonard", "AAAP"));
        pma.addWorker(new Worker("Lena", " Jarvis", "AAAQ"));
        pma.addWorker(new Worker("Salma", " Montgomery", "AAAR"));
        pma.addWorker(new Worker("Teresa", " Watson", "AAAS"));
        pma.addWorker(new Worker("Georgia", " Ortiz", "AAAT"));
        pma.addWorker(new Worker("Bailey", " Hill", "AAAU"));
        pma.addWorker(new Worker("Rhonda", " Rivera", "AAAV"));
        pma.addWorker(new Worker("Rosemary", " Wolf", "AAAW"));
        pma.addWorker(new Worker("Gertrude", " Fernandez", "AAAX"));

        // Male

        pma.addWorker(new Worker("Henry", " Lyons", "AABA"));
        pma.addWorker(new Worker(" Euan", " Maddox", "AACA"));
        pma.addWorker(new Worker(" Maxwell", " Shah", "AADA"));
        pma.addWorker(new Worker("Hassan", " Greer", "AAEA"));
        pma.addWorker(new Worker("  Marco", " Crane", "AAFA"));
        pma.addWorker(new Worker("  Verity", " Meza", "AAGA"));
        pma.addWorker(new Worker("   Louis", "Doyle", "AAHA"));
        pma.addWorker(new Worker(" Michael", "Schneider", "AAIA"));
        pma.addWorker(new Worker(" Juan", "Pollard", "AAJA"));
        pma.addWorker(new Worker("Carlos", "Crawford", "AAKA"));
        pma.addWorker(new Worker("Marvin", "Harrison", "AALA"));
        pma.addWorker(new Worker("Arran", "Escobar", "AAMA"));
        pma.addWorker(new Worker("Thomas", "Tapia", "AANA"));
        pma.addWorker(new Worker("Phillip", "Lara", "AAOA"));
        pma.addWorker(new Worker("Conner", "Walker", "AAPA"));
        pma.addWorker(new Worker("Jeremiah", "Cuevas", "AAQA"));
        pma.addWorker(new Worker("Isaiah", "Dickerson", "AARA"));
        pma.addWorker(new Worker("Willard", "Sawyer", "AASA"));
        pma.addWorker(new Worker("Zachary", "Woodard", "AATA"));
        pma.addWorker(new Worker("Amir", "Vargas", "AAUA"));
        pma.addWorker(new Worker("Kyle", "Gilmore", "AAVA"));
        pma.addWorker(new Worker("Patrick", " Martin", "AAWA"));
        pma.addWorker(new Worker("Tallulah", "Hebert", "AAXA"));
        pma.addWorker(new Worker("Aaliyah", "Turner", "AAYA"));
        pma.addWorker(new Worker("Courtney", "Carr", "AAZA"));

        pma.addWorker(new Worker("Saskia", " Dillon", "ABAA"));
        pma.addWorker(new Worker("Rachel", " Wright", "ACAA"));
        pma.addWorker(new Worker("Laura", " Lam", "ADAA"));
        pma.addWorker(new Worker("Naomi", " Gross", "AEAA"));
        pma.addWorker(new Worker("Poppy", " Abbott", "AFAA"));
        pma.addWorker(new Worker("Lauren", " Best", "AGAA"));
        pma.addWorker(new Worker("Edith", "Velez", "AHAA"));
        pma.addWorker(new Worker("Gabrielle", " Moyer", "AIAA"));
        pma.addWorker(new Worker("Hafsah", " Benson", "AJAA"));
        pma.addWorker(new Worker("Tina", " Friedman", "AKAA"));
        pma.addWorker(new Worker("Natalie", " Leonard", "ALAA"));
        pma.addWorker(new Worker("Lena", " Jarvis", "AMAA"));
        pma.addWorker(new Worker("Salma", " Montgomery", "ANAA"));
        pma.addWorker(new Worker("Teresa", " Watson", "AOAA"));
        pma.addWorker(new Worker("Georgia", " Ortiz", "APAA"));
        pma.addWorker(new Worker("Bailey", " Hill", "AQAA"));
        pma.addWorker(new Worker("Rhonda", " Rivera", "ARAA"));
        pma.addWorker(new Worker("Rosemary", " Wolf", "ASAA"));
        pma.addWorker(new Worker("Gertrude", "Fernandez", "ATAA"));
        pma.addWorker(new Worker("Angela", " Anderson", "AUAA"));
        pma.addWorker(new Worker("Aiden", "Faulkner", "AVAA"));
        pma.addWorker(new Worker("Maisy", " Hudson", "AWAA"));

        return allWorkers;
    }

}
