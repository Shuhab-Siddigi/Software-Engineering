Feature: Description Remove new Activity
    Description: A project is removed from the system
    Actors: Worker or Project leader

    Scenario: An activity is removed from project sucessfully 

        Given a project with project number "030901" exists in the system
        And a project leader with name "Jens Jensen" and ID "EFGH" is assigned to the project
        And the project contains an activity with Name "activity1" and a start time of "21 December"
        When activity named "activity1" is removed
        Then the activity is not contained in project


    Scenario: The Activity does not exist 

        Given a project with name "Project1", and project number "030901" exists in the system
        And a project leader with name "Jens Jensen" and ID "EFGH" is assigned to the project
        And The project has an activity with Name "activity1" and a start time of "21 December"
        When activity named "activity2" is removed
        Then the error text "Activity not in project" is given


