Feature: Change times of an activity
    Description: Project leader changes date of activity
    Actors: Project leader

    Scenario: Activity start time is changed
        Given the system contains a worker with ID "AAAA"
        And there is a project with title "Extreme Programming", ID 0001 
        # And the project has a start date "21 December 2020", end date "1 January 2021"
#         And there exist an activity with number 0001 in the project with ID 0001
#         And the activity has a start date "22 December 2020", end date "30 December 2020"
#         And the current date is "15 December 2020"
#         When the activity changes start date to "20 December 2020"
#         Then the project changes start date to "20 December 2020"

#     Scenario: Activity end time is changed
#         Given the system contains a worker with ID "AAAA"
#         And there is a project with title "Extreme Programming", ID 0001 
#         And the project has a start date "21 December 2020", end date "1 January 2021"
#         And there exist an activity with number 0001 in the project with ID 0001
#         And the activity has a start date "22 December 2020", end date "30 December 2020"
#         When the activity changes end date to end date "5 Januar 2021"
#         Then the project changes end date to "5 Januar 2021"

#     Scenario: Activity starts time is before project start
#         Given the system contains a worker with ID "AAAA"
#         And there is a project with title "Extreme Programming", ID 0001 
#         And the project has a start date "21 December 2020", end date "1 January 2021"
#         And there exist an activity with number 0001 in the project with ID 0001
#         And the activity has a start date "22 December 2020", end date "30 December 2020"
#         And the current date is "15 December 2020"
#         When the activity changes start date to "14 December 2020"
#         Then the error text "Activity starts before project" is given

#     Scenario: Activity starts time is after project ends
#         Given the system contains a worker with ID "AAAA"
#         And there is a project with title "Extreme Programming", ID 0001 
#         And the project has a start date "21 December 2020", end date "1 January 2021"
#         And there exist an activity with number 0001 in the project with ID 0001
#         And the activity has a start date "22 December 2020", end date "30 December 2020"
#         When the activity changes start date "2 January 2021"
#         Then the error text "Activity start after project ends" is given
