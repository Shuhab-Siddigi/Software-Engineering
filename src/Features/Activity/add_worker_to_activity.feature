Feature: Assign worker to activity
    Description: Project leader assigns worker to activity
    Actors: Project leader


    Scenario: a worker is assigned to an activity
        Given the project exist in the system
        And the worker with ID "AAAA" is the project leader of the project with ID 0001
        And there exist an activity with number 0001 in the project with ID 0001
        And the system contains a worker with ID "AAAB"
        When the project leader adds the worker with ID "AAAB" to activity with number 0001
    #     Then the worker is added to the activity
    
    # Scenario: A worker is not assigned because the activity does not exist
    #     Given there is a project with title "Extreme Programming", ID 0001 
    #     And the worker with ID "AAAA" is the project leader of the project with ID 0001
    #     And there doesn't exist an activity with number 0001 in the project with ID 0001
    #     When the project leader adds the worker with ID "AAAB" to activity with number 0001
    #     Then the error message "The activity does not exist!" is given
    
    # Scenario: project leader assignes a worker to activity
    #     Given there is a project with title "Extreme Programming", ID 0001 
    #     And the worker with ID "AAAA" is the project leader with ID 0001
    #     And there exist an activity with number 0001 in the project with ID 0001
    #     When the project leader assignes the worker with ID "AAAB" to activity with number 0001
    #     Then the worker with ID "AAAB" is assigned to the activity with number 0001
    
    # Scenario: Another project leader tries to assigned a worker to activity
    #     Given there is a project with title "Extreme Programming", ID 0001 
    #     And the worker with ID "AAAA" is not the project leader of the project with ID 0001
    #     And there exist an activity with number 0001 in the project with ID 0001
    #     When the project leader adds the worker with ID "AAAB" to activity with number 0001
    #     Then the error message "You are not the project leader for this project" is given
    
    # Scenario: A worker tries to assigned another worker to activity
    #     Given there is a project with title "Extreme Programming", ID 0001 
    #     And the system contains a worker with ID "AAAB"
    #     And there exist an activity with number 0001 in the project with ID 0001
    #     When the worker with ID "AAAA" adds the worker with name ID "AAAB"
    #     Then the error message "Only the project leader can assign workers to activities!" is given
    #     And the worker is not contained in the activity
    