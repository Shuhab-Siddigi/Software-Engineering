# Feature: Description Remove new Activity
#     Description: A project is removed from the system
#     Actors: Worker or Project leader

#     Scenario: An activity is removed from project sucessfully 

#         Given a project with project number "030901" exists in the system
#         And a project leader with name "Jens Jensen" and ID "EFGH" is assigned to the project
#         And the project contains an activity with Name "activity1" and a start time of "21 December"
#         When activity named "activity1" is removed
#         Then the activity is not contained in project


#     Scenario: The Activity does not exist 

#         Given a project with name "Project1", and project number "030901" exists in the system
#         And a project leader with name "Jens Jensen" and ID "EFGH" is assigned to the project
#         And The project has an activity with Name "activity1" and a start time of "21 December"
#         When activity named "activity2" is removed
#         Then the error text "Activity not in project" is given

#     Scenario: worker ties to remove activity


#     Scenario: An activit is removed rom project
#         Given the system contains a worker with name "Bob Hansen", ID "ABCD"
#         And the system contains a project with name "Project1", number "030901"
#         And the project has a start date "21 December 2020", end date "1 January 2021"
#         And the activity with name "activity1", number "01"
#         And the activity has a start date "22 December 2020", end date "30 December 2020"
#         When the activity is added to the project
#         Then the project contains the activity
#         When the activity is removed from the project
#         Then the project does not contrain the activity

#     Scenario: An activit is removed rom project
#         Given the system contains a worker with name "Bob Hansen", ID "ABCD"
#         And the system contains a project with name "Project1", number "030901"
#         And the project has a start date "21 December 2020", end date "1 January 2021"
#         When the activity is removed from the project
#         Then the error text "Activity does not excist" is given
