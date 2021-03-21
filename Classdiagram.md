```plantuml
class ICONINFO{
-private
#protected
~package private
+public
}

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
-Title : String
-ID :  String
-Expected Hours : int
-Hours Worked :  int
-StartDate : Calendar
-EndDate : Calendar
-Description : String
-Leader : Worker
-Workers : Worker[*]
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

System o-right-> Worker
System o-down-> Project
Project -right-|> Activity
Activity o-left-> Worker
Activity -left-> Project  

```