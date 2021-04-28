Feature: Create Project
#Done

    Scenario:  A project is created succesfully
        Given there is a project with title "Extreme Programming", ID 0001
        And project with title "Extreme Programming", ID 0001 does not exist in the system
        When the project with title "Extreme Programming", ID 0001 is added to the system
        Then the project with ID 0001 exist in the system

    Scenario:  A project ID is already used in the system
        Given there is a project with title "Extreme Programming", ID 0001
        And the project exist in the system
        When the project with title "Extreme Programming", ID 0001 is added to the system
        Then the error message "Project ID is already used!" is given

    Scenario: Project with wrong ID is added 
        Given there is a project with title "Extreme Programming", ID 12341
        And project with title "Extreme Programming", ID 12341 does not exist in the system
        When the project with title "Extreme Programming", ID 12341 is added to the system
        Then the error message "Project can not have more than a 4 digit ID" is given
        #Can only check if it is more than 4. 0's will be compiled as white space

    Scenario: Project with nonInteger ID
        Given there is a project with title "Extreme Programming", ID "ABCD"
        When the project with title "Extreme Programming", ID "ABCD" is added to the system
        Then the error message "Invalid input sequence: ID has to be in range [0000-9999]" is given    
