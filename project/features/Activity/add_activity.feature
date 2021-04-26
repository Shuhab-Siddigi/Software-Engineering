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

    Scenario: Activity already exist
        Given there is a project with title "Extreme Programming", ID 0001
        And the project exist in the system
        And there exist an activity with title "Activity 1", ID 0001, start date "2020-12-21", end date "2021-01-20"
        And there exist an activity with number 0001 in the project with ID 0001
        When the activity with ID 0001 is added to the project
        Then the error "Project already contains activity!" is given

    Scenario: Activity end time is before project start
        Given there is a project with title "Extreme Programming", ID 0001
        And the project exist in the system
        And the project contains the activity with title "Activity 1", ID 0001, start date "2020-12-21", end date "2021-01-20"
        And there exist an activity with title "Activity 2", ID 0002, start date "2010-12-01", end date "2010-12-02"
        When the activity with ID 0002 is added to the project
        Then the error text "Activity date is before project start!" is given

    Scenario: Activity starts after estimated deadline
        Given there is a project with title "Extreme Programming", ID 0001
        And the project exist in the system
        And the project contains the activity with title "Activity 1", ID 0001, start date "2020-12-21", end date "2021-01-20"
        And there exist an activity with title "Activity 2", ID 0002, start date "2020-12-25", end date "2021-01-22"
        When the activity with ID 0002 is added to the project
        Then the project has a end date "2021-01-22"

    Scenario: Activity with wrong ID is added 
        Given there is a project with title "Extreme Programming", ID 0001
        And the project exist in the system
        And there exist an activity with title "Activity 1", ID 12341, start date "2020-12-25", end date "2021-01-22"
        When the activity with ID 12341 is added to the project
        Then the error text "Activity can not have more than a 4 digit ID" is given
        #Can only check if it is more than 4. 0's will be compiled as white space