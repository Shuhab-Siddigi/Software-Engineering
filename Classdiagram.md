```plantuml
class ICONINFO{
-private
#protected
~package private
+public
}

left to right direction


class System{
-projects : Project[*]
-workers : Worker[*] 
+calender : Calendar

+addProject(Project) : boolean
+removeProject(Project) : boolean
+canBeAssigned(Worker, Activity) : boolean
+isProjectLeader(Project, Worker) : boolean
}

class Worker{
-Name : String
-HoursAllowed : int
-startTimeToday : Calender
-endTimeToday : Calender
-ID : String

+registerHours(int, Activity) : boolean
+editHours(int, Activity) : boolean
+askForHelp(Activity, Worker) : boolean 
}


class Project{
-Activities : Activity[*]
-Report : Project
-FixedActivities : Activity[*]

+addActivity(Activity) : boolean
+removeActivity(Activity) :  boolean
+generateReport(Project) :  void
+addFixedActivities(Project) : boolean
+removeFixedActivity(Project, Activity) :  boolean
}

class Activity{
-Title : String
-ID :  String
-Expected Hours : int
-Hours Worked :  int
-StartDate : Calendar
-EndDate : Calendar
-Description : String
-Leader : Worker
-Workers : Worker[*]

+setProjectLeader(Worker) : void
+ChangeDate(Calender, Calender) : void
+addWorker(Worker): void
+removeWorker(Worker) : void 
+canBecomeLeader(Worker) : boolean
+searchWorkerByID(String): Worker
+canReceiveHelp(Worker) : boolean
}

System o--> Project
System o--> Worker
Activity o--> Worker
Project --|> Activity
Activity --> Project  

```