Feature: Create new Activity

    Description: A project leader creates an activity in a project
    Actors: Project leader

    Scenario: A new Activity is added to project by projectleader
        Given the system contains a worker with ID "AAAA"
        And there is a project with title "Extreme Programming", ID 0001
        And the project exist in the system
        And there exist an activity with title "Activity 1", ID 0001, start date "2020-12-21", end date "2021-01-20"
    #  And the activity is more than a week long (SKAL DETTE IMPLEMENTERES?)
        When the activity is added to the project
        Then the project with ID 0001 contains the activity with ID 0001
        And the project start and end date is set to activity start and end date

#     Scenario: A new Activity is added to project by customer
#         Given the system contains a worker with ID "AAAA"
#         And the system contains a project with ID 0001
#         And the project has a start date "21 December 2020", end date "1 January 2021"
#         And there exist an activity with number 0001 in the project with ID 0001
#         And the activity has a start date "21 December 2020", end date "1 January 2021"
#         When the activity is added to the project
#         Then the project contains the activity

#     Scenario: Activity already exist
#         Given the system contains a worker with ID "AAAA"
#         And the system contains a project with ID 0001
#         And there exist an activity with number 0001 in the project with ID 0001
#         When the activity with ID 0001 is added to the project
#         Then the error text "project already contains activity" is given

#     Scenario: Activity starts time is before project start
#         Given the system contains a worker with ID "AAAA"
#         And the system contains a project with ID 0001
#         And the project has a start date "21 December 2020", end date "1 January 2021"
#         And there exist an activity with number 0001 in the project with ID 0001
#         And the activity has a start date "15 December 2020", end date "1 January 2021"
#         And the current date is "19 December 2020"
#         When the activity is added to the project
#         Then the error text "Activity date is before project start" is given

#     Scenario: Activity starts after estimated deadline
#         Given the system contains a worker with ID "AAAA"
#         And the system contains a project with ID 0001
#         And the project has a start date "21 December 2020", end date "1 January 2021"
#         And there exist an activity with number 0001 in the project with ID 0001
#         And the activity has a start date "21 December 2020", end date "13 January 2021"
#         When the activity is added to the project
#         Then the project has a end date "13 January 2021"
