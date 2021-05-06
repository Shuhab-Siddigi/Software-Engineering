package dtu.pma;

import java.util.ArrayList;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
import java.util.Random;

public class Database {
    private int startYear = 2016;
    private int endYear = 2025;
    private Random randomGenerator = new Random();
    private List<Project> projects = new ArrayList<>();
    private Date randomStartDate() {
        long start = Timestamp.valueOf(startYear + 1 + "-1-1 0:0:0").getTime();
        long end = Timestamp.valueOf(endYear + "-1-1 0:0:0").getTime();
        long ms = (long) ((end - start) * Math.random() + start);
        Date randomDay = new Date(ms);
        return randomDay;
    }

    private Date randomEndDate(Date startDate) {
        long start = startDate.getTime() + 1000;
        long end = Timestamp.valueOf(endYear + "-1-1 0:0:0").getTime();
        long ms = (long) ((end - start) * Math.random() + start);
        Date randomDay = new Date(ms);
        return randomDay;
    }

    private int randomNumber(int low, int high) {

        int result = randomGenerator.nextInt(high - low) + low;
        return result;
    }

    public List<Worker> getWorkers() throws OperationNotAllowedException {
        // Female
        List<Worker> workers = new ArrayList<>();
        workers.add(new Worker("System", "Huset", "X"));
        workers.add(new Worker("Angela", "Anderson", "AAAA"));
        workers.add(new Worker("Aaliyah", "Turner", "AAAB"));
        workers.add(new Worker("allulah", "Hebert", "AAAC"));
        workers.add(new Worker("Courtney", "Carr", "AAAD"));
        workers.add(new Worker("Maisy", "Hudson", "AAAE"));
        workers.add(new Worker("Saskia", "Dillon", "AAAF"));
        workers.add(new Worker("Rachel", "Wright", "AAAG"));
        workers.add(new Worker("Laura", "Lam", "AAAH"));
        workers.add(new Worker("Naomi", "Gross", "AAAI"));
        workers.add(new Worker("Poppy", "Abbott", "AAAJ"));
        workers.add(new Worker("Lauren", "Best", "AAAK"));
        workers.add(new Worker("Edith", "Velez", "AAAL"));
        workers.add(new Worker("Gabrielle", "Moyer", "AAAM"));
        workers.add(new Worker("Hafsah", "Benson", "AAAN"));
        workers.add(new Worker("Tina", "Friedman", "AAAO"));
        workers.add(new Worker("Natalie", "Leonard", "AAAP"));
        workers.add(new Worker("Lena", "Jarvis", "AAAQ"));
        workers.add(new Worker("Salma", "Montgomery", "AAAR"));
        workers.add(new Worker("Teresa", "Watson", "AAAS"));
        workers.add(new Worker("Georgia", "Ortiz", "AAAT"));
        workers.add(new Worker("Bailey", "Hill", "AAAU"));
        workers.add(new Worker("Rhonda", "Rivera", "AAAV"));
        workers.add(new Worker("Rosemary", "Wolf", "AAAW"));
        workers.add(new Worker("Gertrude", "Fernandez", "AAAX"));

        // Male

        workers.add(new Worker("Henry", "Lyons", "AABA"));
        workers.add(new Worker("Euan", "Maddox", "AACA"));
        workers.add(new Worker("Maxwell", "Shah", "AADA"));
        workers.add(new Worker("Hassan", "Greer", "AAEA"));
        workers.add(new Worker("Marco", "Crane", "AAFA"));
        workers.add(new Worker("Verity", "Meza", "AAGA"));
        workers.add(new Worker("Louis", "Doyle", "AAHA"));
        workers.add(new Worker("Michael", "Schneider", "AAIA"));
        workers.add(new Worker("Juan", "Pollard", "AAJA"));
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
        workers.add(new Worker("Patrick", "Martin", "AAWA"));
        workers.add(new Worker("Tallulah", "Hebert", "AAXA"));
        workers.add(new Worker("Aaliyah", "Turner", "AAYA"));
        workers.add(new Worker("Courtney", "Carr", "AAZA"));

        workers.add(new Worker("Saskia", "Dillon", "ABAA"));
        workers.add(new Worker("Rachel", "Wright", "ACAA"));
        workers.add(new Worker("Laura", "Lam", "ADAA"));
        workers.add(new Worker("Naomi", "Gross", "AEAA"));
        workers.add(new Worker("Poppy", "Abbott", "AFAA"));
        workers.add(new Worker("Lauren", "Best", "AGAA"));
        workers.add(new Worker("Edith", "Velez", "AHAA"));
        workers.add(new Worker("Gabrielle", "Moyer", "AIAA"));
        workers.add(new Worker("Hafsah", "Benson", "AJAA"));
        workers.add(new Worker("Tina", "Friedman", "AKAA"));
        workers.add(new Worker("Natalie", "Leonard", "ALAA"));
        workers.add(new Worker("Lena", "Jarvis", "AMAA"));
        workers.add(new Worker("Salma", "Montgomery", "ANAA"));
        workers.add(new Worker("Teresa", "Watson", "AOAA"));
        workers.add(new Worker("Georgia", "Ortiz", "APAA"));
        workers.add(new Worker("Bailey", "Hill", "AQAA"));
        workers.add(new Worker("Rhonda", "Rivera", "ARAA"));
        workers.add(new Worker("Rosemary", "Wolf", "ASAA"));
        workers.add(new Worker("Gertrude", "Fernandez", "ATAA"));
        workers.add(new Worker("Angela", "Anderson", "AUAA"));
        workers.add(new Worker("Aiden", "Faulkner", "AVAA"));
        workers.add(new Worker("Maisy", "Hudson", "AWAA")); // 72

        Worker worker;
        for (Project project : projects) {

            worker = workers.get(randomNumber(0, workers.size()));
            project.addWorkerToActivity(project.getActivities().get(0),worker, null);    

        }
        


        
        
        return workers;
    }

    public List<Project> getProjects() throws OperationNotAllowedException {

        

        projects.add(new Project("Shark Platinum", 0002));
        projects.add(new Project("Shark Copper", 0003));
        projects.add(new Project("Sturgeon Lead", 0004));
        projects.add(new Project("Herring Tin", 0005));
        projects.add(new Project("Crayfish Platinum", 0006));
        projects.add(new Project("Sardine Beipiaosaurus", 0007));
        projects.add(new Project("Sturgeon Beishanlong", 0010));
        projects.add(new Project("Bass Seismosaurus", 0011));
        projects.add(new Project("Eel Sonorasaurus", 0012));
        projects.add(new Project("Viper Lycorhinus", 0013));
        projects.add(new Project("King Cobra Brachiosaurus", 0014));
        projects.add(new Project("Python Ornithopsis", 0015));
        projects.add(new Project("Gold Dragonfly", 0016));
        projects.add(new Project("Iron Beetle", 0017));
        projects.add(new Project("Platinum Beetle", 0020));
        projects.add(new Project("Aluminum Scottish Terrier", 0021));
        projects.add(new Project("Krypton Collie", 0022));
        projects.add(new Project("Nihonium Chihuahua", 0023));
        projects.add(new Project("Actinium Collie", 0024));
        projects.add(new Project("Ytterbium Airedale", 0025));
        projects.add(new Project("Cobalt Greyhound", 0026));
        projects.add(new Project("Oganesson Dalmatian", 0031));
        projects.add(new Project("Europium Irish Setter", 0032));
        projects.add(new Project("Potassium Airedale", 0033));
        projects.add(new Project("Astatine Irish Setter", 0034));
        projects.add(new Project("Ytterbium Saint Bernard", 0035));
        projects.add(new Project("Ytterbium Corgi", 0036));
        projects.add(new Project("Cadmium Pekingese", 0037));
        projects.add(new Project("Rhodium Border Collie", 0040));
        projects.add(new Project("Terbium Hound", 0041));
        projects.add(new Project("Yttrium Scottish Terrier", 0042));
        projects.add(new Project("Europium Great Dane", 0043));
        projects.add(new Project("Curium Great Dane", 0044));
        projects.add(new Project("Berkelium Poodle", 0045));
        projects.add(new Project("Neodymium Beagle", 0046));
        projects.add(new Project("Samarium Dachshund", 0047));
        projects.add(new Project("Nitrogen Lhasa Apso", 0050));
        projects.add(new Project("Rutherfordium Collie", 0051));
        projects.add(new Project("Dysprosium Chihuahua", 0052));
        projects.add(new Project("Polonium Spaniel", 0053));
        projects.add(new Project("Thorium Spaniel", 0054));
        projects.add(new Project("Magnesium Hound", 0055));

        for (Project project : projects) {

            Date projectstartDate = randomStartDate();
            Date projectendDate = randomEndDate(projectstartDate);
            int projectExpextedhours = randomNumber(24, 400);
            int projectHoursWorked = randomNumber(1, 23);
            project.getInfo().setExpectedHours(projectExpextedhours);
            project.getInfo().setHoursWorked(projectHoursWorked);
            project.getInfo().setStartDate(projectstartDate);
            project.getInfo().setEndDate(projectendDate);
            project.getInfo().setDescription("INFO");

            Date activityStartDate = randomEndDate(projectendDate);
            Date activityEndDate = randomEndDate(activityStartDate);
           
            String randomTitle = projects.get(randomNumber(0,projects.size()-1)).getInfo().getTitle();
            Activity activity = new Activity(randomTitle, 0, activityStartDate, activityEndDate);
            activity.getInfo().setExpectedHours(randomNumber(0, projectExpextedhours));
            activity.getInfo().setHoursWorked(projectHoursWorked);
            project.addActivity(activity);
        }

        return projects;
    }

}
