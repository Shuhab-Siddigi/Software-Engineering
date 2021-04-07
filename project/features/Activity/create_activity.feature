# Feature: Create new Activity

#     Description: A project leader creates an activity in a project
#     Actors: Project leader

#     Scenario: A new Activity is added to project
#         Given the system contains a worker with name "Bob Hansen", ID "ABCD"
#         And the system contains a project with name "Project1", number "030901"
#         And the project has a start date "21 December 2020", end date "1 January 2021"
#         And the activity with name "activity1", number "01"
#         And the activity has a start date "21 December 2020", end date "1 January 2021"
#         When the activity is added to the project
#         Then the project contains the activity

#     Scenario: Activity already exist
#         Given the system contains a worker with name "Bob Hansen", ID "ABCD"
#         And the system contains a project with name "Project1", number "030901"
#         And the project contains an activity with Name "activity1", number "01"
#         When the activity is added to the project
#         Then the error text "project already contain activity" is given

#     Scenario: Activity starts time is before project start
#         Given the system contains a worker with name "Bob Hansen", ID "ABCD"
#         And the system contains a project with name "Project1", number "030901"
#         And the project has a start date "21 December 2020", end date "1 January 2021"
#         And the activity with name "activity1", number "01"
#         And the activity has a start date "15 December 2020", end date "1 January 2021"
#         When the activity is added to the project
#         Then the error text "Activity starts before project" is given


#     Scenario: Activity starts after estimated deadline
#         Given the system contains a worker with name "Bob Hansen", ID "ABCD"
#         And the system contains a project with name "Project1", number "030901"
#         And the project has a start date "21 December 2020", end date "1 January 2021"
#         And the activity with name "activity1", number "01"
#         And the activity has a start date "21 December 2020", end date "13 January 2021"
#         When the activity is added to the project
#         Then the error text "Activity ends after project" is given

#     Scenario: Worker tries to create project
