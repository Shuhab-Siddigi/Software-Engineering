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

    