# Feature: change times of an activity
#     Description: Project leader changes date of activity
#     Actors: Project leader

#     Scenario: Activity starts time is closer to project start
#         Given the system contains a worker with name "Bob Hansen", ID "ABCD"
#         And the system contains a project with name "Project1", number "030901"
#         And the project has a start date "21 December 2020", end date "1 January 2021"
#         And the activity with name "activity1", number "01"
#         And the activity has a start date "22 December 2020", end date "30 December 2020"
#         When the activity is added to the project
#         Then the project contains the activity
#         When the activity changes start date "21 December 2020", end date "30 December 2020"
#         Then the project changes date

#     Scenario: Activity end time is closer to project end
#         Given the system contains a worker with name "Bob Hansen", ID "ABCD"
#         And the system contains a project with name "Project1", number "030901"
#         And the project has a start date "21 December 2020", end date "1 January 2021"
#         And the activity with name "activity1", number "01"
#         And the activity has a start date "22 December 2020", end date "30 December 2020"
#         When the activity is added to the project
#         Then the project contains the activity
#         When the activity changes start date "22 December 2020", end date "1 January 2021"
#         Then the project changes date


#     Scenario: Activity starts time is before project start
#         Given the system contains a worker with name "Bob Hansen", ID "ABCD"
#         And the system contains a project with name "Project1", number "030901"
#         And the project has a start date "21 December 2020", end date "1 January 2021"
#         And the activity with name "activity1", number "01"
#         And the activity has a start date "22 December 2020", end date "30 December 2020"
#         When the activity is added to the project
#         Then the project contains the activity
#         When the activity changes start date "20 December 2020", end date "30 December 2020"
#         Then the error text "Activity starts before project" is given

#     Scenario: Activity starts time is after project ends
#         Given the system contains a worker with name "Bob Hansen", ID "ABCD"
#         And the system contains a project with name "Project1", number "030901"
#         And the project has a start date "21 December 2020", end date "1 January 2021"
#         And the activity with name "activity1", number "01"
#         And the activity has a start date "22 December 2020", end date "30 December 2020"
#         When the activity is added to the project
#         Then the project contains the activity
#         When the activity changes start date "22 December 2020", end date "2 January 2021"
#         Then the error text "Activity ends after project" is given
