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
-ID : String
-currentActivities : Activity
'-HoursAllowed : int
'-startTimeToday : Calender
'-endTimeToday : Calender

+searchActivityByID(string) : activity
+registerHours(int, Activity) : boolean
+editHours(int, Activity) : boolean
+askForHelp(Activity, Worker) : boolean 
}


class Project{
-activities : Activity[*]
-info : Info
-FixedActivities : Activity[*]
-leader : Worker
'-report : Project
'-Workers : Worker[*]
'-Title : String
'-ID :  String
'-Expected Hours : int
'-Hours Worked :  int
'-StartDate : Calendar
'-EndDate : Calendar
'-Description : String

+addActivity(Activity) : boolean
+removeActivity(Activity) :  boolean
+generateReport(Project) :  void
+addFixedActivities(Project) : boolean
+removeFixedActivity(Project, Activity) :  boolean
}

class Activity{
-workers : Worker[*]
-info : Info
'-Title : String
'-ID :  String
'-Expected Hours : int
'-Hours Worked :  int
'-StartDate : Calendar
'-EndDate : Calendar
'-Description : String
'-Leader : Worker


+addWorker(Worker): void
+removeWorker(Worker) : void 
+searchWorkerByID(String): worker
+canReceiveHelp(Worker) : boolean
'+ChangeDate(Calender, Calender) : void
'+canBecomeLeader(Worker) : boolean
'+setProjectLeader(Worker) : void
}

class Info{
-Title : String
-ID :  String
-Expected Hours : int
-Hours Worked :  int
-StartDate : Calendar
-EndDate : Calendar
-Description : String

+changeStartDate(calendar): void
+changeEndDate(calendar): void
+calHoursWorked(): int
}

Worker o-up-> System
Project -up-> System
Activity -down-> Worker
Activity o-left-> Project  
Info o-down-> Activity
Info o-down-> Project

```