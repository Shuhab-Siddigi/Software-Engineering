Feature: Worker register hours in project
Description: A worker registers hours
Actors: Worker

   Scenario: A Worker registers hours succesfully
        Given a project and an activity exist in the system
        And a worker with ID "AAAA" exist in the system
        And the worker is assigned to the activity
        When the worker registers 10 work hours on activity
        Then the worker has worked 10 hours on the activity with ID 0001
        And the registered hours is updated for the project with 10 hours
        
   Scenario: A Worker can't register hours, if worker isn't assigned to activity on project
        Given a project and an activity exist in the system
        And a worker with ID "AAAA" exist in the system
        And the worker is not assigned to the activity
        When the worker registers 10 work hours on activity
        Then the error message "Worker isn't assigned to project" is given