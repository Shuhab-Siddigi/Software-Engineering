    Feature assign worker to activity
    Description:
    Actors:


    Scenario: a worker is assigned to an activity
        Given the system contains a project with number "030901" 
        And that name "Jens Jensen", ID "JeJe" is the project leader
        And there exist an activity with number "01"
        When the project leader adds the worker with name "Bob Hansen", ID "ABCD"
        Then the worker is added to the activity
    
        
    Scenario: A worker is not assigned because the activity does not exist
        Given the system contains a project with number "030901" 
        And that name "Jens Jensen", ID "JeJe" is the project leader
        And does not exist an activity with number "01"
        When the project leader adds the worker with name "Bob Hansen", ID "ABCD"
        Then the error message "The activity does not exist!" is given
    
    Scenario: Another project leader tries to assigned a worker to activity
        Given the system contains a project with number "030901" 
        And that name "Jens Jensen", ID "JeJe" is not the project leader
        And there exist an activity with number "01"
        When the project leader adds the worker with name "Bob Hansen", ID "ABCD"
        Then the error message "You are not the project leader for this project" is given
    
    
    Scenario: A worker tries to assigned another worker to activity
        Given the system contains a project with number "030901" 
        And the system contains a worker with name "Bob Hansen", ID "ABCD"
        And there exist an activity with number "01"
        When the worker adds the worker with name "Bob Hansen", ID "ABCD"
        Then the error message "Only the project leader can assign workers to activities!" is given
    