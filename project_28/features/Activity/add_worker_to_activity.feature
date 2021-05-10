Feature: Assign worker to activity
    Description: Project leader assigns worker to activity
    Actors: Project leader


    Scenario: a worker is assigned to an activity
        Given the project exist in the system
        And the worker with ID "AAAA" is the project leader of the project with ID 0001
        And the project contains the activity with title "Activity 1", ID 0001, start date "2020-12-21", end date "2021-01-20"
        And the system contains a worker with ID "AAAB"
        When the project leader adds the worker with ID "AAAB" to activity with ID 0001
        Then the worker with ID "AAAB" is added to the activity
    
    Scenario: A worker is not assigned because the activity does not exist
        Given the project exist in the system
        And the worker with ID "AAAA" is the project leader of the project with ID 0001
        When the project leader adds the worker with ID "AAAB" to activity with ID 0001
        Then the error message "Activity does not exist!" is given

    Scenario: Worker is not assigned to project, because worker does not exist
        When the project leader adds the worker with ID "AAAB" to activity with ID 0001
        Then the error message "Activity does not exist!" is given
    
    Scenario: project leader assignes a worker to activity
        Given the project exist in the system
        And the worker with ID "AAAA" is the project leader of the project with ID 0001
        And the project contains the activity with title "Activity 1", ID 0001, start date "2020-12-21", end date "2021-01-20"
        And the system contains a worker with ID "AAAB"
        When the project leader adds the worker with ID "AAAB" to activity with ID 0001
        Then the worker with ID "AAAB" is added to the activity
    
    Scenario: Another project leader tries to assigned a worker to activity
        Given the project exist in the system
        And the worker with ID "AAAA" is the project leader of the project with ID 0001
        And the project contains the activity with title "Activity 1", ID 0001, start date "2020-12-21", end date "2021-01-20"
        And the system contains a worker with ID "AAAB"
        When worker with ID "AAAB" adds the worker with ID "AAAB" to activity with ID 0001
        Then the error message "You are not the project leader for this project!" is given
    
    Scenario: Worker is not assigned to project, because worker does not exist
        Given the project exist in the system
        And the worker with ID "AAAA" is the project leader of the project with ID 0001
        And the project contains the activity with title "Activity 1", ID 0001, start date "2020-12-21", end date "2021-01-20"
        When the project leader adds the worker with ID "AAAB" to activity with ID 0001
        Then the error message "Worker does not exist in system" is given

    # Scenario: A worker tries to assigned another worker to activity
    #     Given there is a project with title "Extreme Programming", ID 0001 
    #     And the system contains a worker with ID "AAAB"
    #     And there exist an activity with number 0001 in the project with ID 0001
    #     When the worker with ID "AAAA" adds the worker with name ID "AAAB"
    #     Then the error message "Only the project leader can assign workers to activities!" is given
    #     And the worker is not contained in the activity
    