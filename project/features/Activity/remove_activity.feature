Feature: Description Remove new Activity
    Description: A project is removed from the system
    Actors: Worker or Project leader
 #only worker or PL can remove?
    Scenario: An activity is removed from project sucessfully
        Given there is a project with title "Extreme Programming", ID 0001
        And the project exist in the system
        And the system contains a worker with ID "AAAA"
        And the worker with ID "AAAA" is assigned to the project with ID 0001
        And there exist an activity with title "Activity 1", ID 0001, start date "2020-12-21", end date "2021-01-20"
        And the activity with ID 0001 is added to the project
        When the worker with ID "AAAA" removes the activity with ID 0001 from the project with ID 0001
        Then the activity with id 0001 is not contained in project

#     Scenario: Cannot remove an activity that does not exist
#         Given there is a project with title "Extreme Programming", ID 0001
#         And the worker with ID "AAAA" is the project leader of the project with ID 0001
#         And there does not exist an activity with number 0001 in the project with ID 0001
#         When the activity is removed
#         Then the error text "Activity is not in project" is given

#     Scenario: Worker tries to remove activity
#         Given there is a project with title "Extreme Programming", ID 0001
#         And the worker with ID "AAAA" is not the project leader of the project with ID 0001
#         And there exist an activity with number 0001 in the project with ID 0001
#         When the activity is removed
#         Then the error text "Worker cannot remove activities" is given


# Scenario: A new Activity is added to project by projectleader
#         Given the system contains a worker with ID "AAAA"
#         And there is a project with title "Extreme Programming", ID 0001
#         And the project exist in the system
#         And there exist an activity with title "Activity 1", ID 0001, start date "2020-12-21", end date "2021-01-20"
#     #  And the activity is more than a week long (SKAL DETTE IMPLEMENTERES?)
#         When the activity is added to the project
#         Then the project with ID 0001 contains the activity with ID 0001
#         And the project start and end date is set to activity start and end date


# theProjectExistInTheSystem - adds "Extreme Programming", ID 0001 to the system and checks
# theSystemContainsAWorkerWithID(String ID) - adds worker with id
# theWorkerWithIDIsAssignedToTheProjectWithID(String wID, Integer pID) - adds worker as PL to project again worker "AAAA"
# theActivityWithIDIsAddedToTheProject(Integer aID) --adds acitiy with id aID
#
#