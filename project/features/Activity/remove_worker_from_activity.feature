Feature: Remove worker from activity
    Description: Project leader removes worker
    Actors: Project leader

    Scenario: A worker is removed from the activity
        Given the project exist in the system
        And the worker with ID "AAAA" is the project leader of the project with ID 0001
        And the project contains the activity with title "Activity 1", ID 0001, start date "2020-12-21", end date "2021-01-20"
        And the worker with ID "AAAB" is assigned to the activity with ID 0001
        When the project leader removes the worker from the activity
        Then the worker with ID "AAAB" is not assigned to the activity with ID 0001


    Scenario: A worker is removed from the activity
        Given a project and an activity exist in the system
        And the project has a project leader
        And a worker exist in the system
        And the worker is assigned to the activity
        When the project leader removes the worker from the activity
        Then the worker is removed from the activity
        
    Scenario: A worker tries to remove another worker from an activity
        Given a project and an activity exist in the system
        And a worker exist in the system
        And the worker is assigned to the activity
        When the worker removes a worker from the activity
        Then the error "You are not the project leader for this project!" is given