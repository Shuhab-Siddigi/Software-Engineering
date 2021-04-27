package dtu.pma;

import java.util.ArrayList;
import java.util.List;

import dtu.pma.Worker;

public class Database {
    
    public List<Worker> getWorkers(){
        // Female
        List<Worker> workers = new ArrayList<>();
        workers.add(new Worker("System", "Huset", "X"));
        workers.add(new Worker("Angela", "Anderson", "AAAA"));
        workers.add(new Worker("Aaliyah", "Turner", "AAAB"));
        workers.add(new Worker("allulah", " Hebert", "AAAC"));
        workers.add(new Worker("Courtney", " Carr", "AAAD"));
        workers.add(new Worker("Maisy", " Hudson", "AAAE"));
        workers.add(new Worker("Saskia", " Dillon", "AAAF"));
        workers.add(new Worker("Rachel", " Wright", "AAAG"));
        workers.add(new Worker("Laura", " Lam", "AAAH"));
        workers.add(new Worker("Naomi", " Gross", "AAAI"));
        workers.add(new Worker("Poppy", " Abbott", "AAAJ"));
        workers.add(new Worker("Lauren", " Best", "AAAK"));
        workers.add(new Worker("Edith", " Velez", "AAAL"));
        workers.add(new Worker("Gabrielle", " Moyer", "AAAM"));
        workers.add(new Worker("Hafsah", " Benson", "AAAN"));
        workers.add(new Worker("Tina", " Friedman", "AAAO"));
        workers.add(new Worker("Natalie", "Leonard", "AAAP"));
        workers.add(new Worker("Lena", " Jarvis", "AAAQ"));
        workers.add(new Worker("Salma", " Montgomery", "AAAR"));
        workers.add(new Worker("Teresa", " Watson", "AAAS"));
        workers.add(new Worker("Georgia", " Ortiz", "AAAT"));
        workers.add(new Worker("Bailey", " Hill", "AAAU"));
        workers.add(new Worker("Rhonda", " Rivera", "AAAV"));
        workers.add(new Worker("Rosemary", " Wolf", "AAAW"));
        workers.add(new Worker("Gertrude", " Fernandez", "AAAX"));

        // Male

         workers.add(new Worker("Henry", " Lyons", "AABA"));
         workers.add(new Worker(" Euan", " Maddox", "AACA"));
         workers.add(new Worker(" Maxwell", " Shah", "AADA"));
         workers.add(new Worker("Hassan", " Greer", "AAEA"));
         workers.add(new Worker("  Marco", " Crane", "AAFA"));
         workers.add(new Worker("  Verity", " Meza", "AAGA"));
         workers.add(new Worker("   Louis", "Doyle", "AAHA"));
         workers.add(new Worker(" Michael", "Schneider", "AAIA"));
         workers.add(new Worker(" Juan", "Pollard", "AAJA"));
         workers.add(new Worker("Carlos", "Crawford", "AAKA"));
         workers.add(new Worker("Marvin", "Harrison", "AALA"));
         workers.add(new Worker("Arran", "Escobar", "AAMA"));
         workers.add(new Worker("Thomas", "Tapia", "AANA"));
         workers.add(new Worker("Phillip", "Lara", "AAOA"));
         workers.add(new Worker("Conner", "Walker", "AAPA"));
         workers.add(new Worker("Jeremiah", "Cuevas", "AAQA"));
         workers.add(new Worker("Isaiah", "Dickerson", "AARA"));
         workers.add(new Worker("Willard", "Sawyer", "AASA"));
         workers.add(new Worker("Zachary", "Woodard", "AATA"));
         workers.add(new Worker("Amir", "Vargas", "AAUA"));
         workers.add(new Worker("Kyle", "Gilmore", "AAVA"));
         workers.add(new Worker("Patrick", " Martin", "AAWA"));
         workers.add(new Worker("Tallulah", "Hebert", "AAXA"));
         workers.add(new Worker("Aaliyah", "Turner", "AAYA"));
         workers.add(new Worker("Courtney", "Carr", "AAZA"));

         workers.add(new Worker("Saskia", " Dillon", "ABAA"));
         workers.add(new Worker("Rachel", " Wright", "ACAA"));
         workers.add(new Worker("Laura", " Lam", "ADAA"));
         workers.add(new Worker("Naomi", " Gross", "AEAA"));
         workers.add(new Worker("Poppy", " Abbott", "AFAA"));
         workers.add(new Worker("Lauren", " Best", "AGAA"));
         workers.add(new Worker("Edith", "Velez", "AHAA"));
         workers.add(new Worker("Gabrielle", " Moyer", "AIAA"));
         workers.add(new Worker("Hafsah", " Benson", "AJAA"));
         workers.add(new Worker("Tina", " Friedman", "AKAA"));
         workers.add(new Worker("Natalie", " Leonard", "ALAA"));
         workers.add(new Worker("Lena", " Jarvis", "AMAA"));
         workers.add(new Worker("Salma", " Montgomery", "ANAA"));
         workers.add(new Worker("Teresa", " Watson", "AOAA"));
         workers.add(new Worker("Georgia", " Ortiz", "APAA"));
         workers.add(new Worker("Bailey", " Hill", "AQAA"));
         workers.add(new Worker("Rhonda", " Rivera", "ARAA"));
         workers.add(new Worker("Rosemary", " Wolf", "ASAA"));
         workers.add(new Worker("Gertrude", "Fernandez", "ATAA"));
         workers.add(new Worker("Angela", " Anderson", "AUAA"));
         workers.add(new Worker("Aiden", "Faulkner", "AVAA"));
         workers.add(new Worker("Maisy", " Hudson", "AWAA")); // 72
        return workers;
    }

}
