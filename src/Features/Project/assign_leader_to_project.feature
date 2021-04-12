Feature: Assign project leader
    Description: Assign project leader to project
    Actors: Worker/System

    Scenario: A project leader is assigned to a project
        Given there is a project with title "Extreme Programming", ID 0001
        And the project exist in the system
        And the system contains a worker with ID "AAAA"
        When the worker with ID "AAAA" is assigned to the project with ID 0001
        Then the worker with ID "AAAA" is the project leader of the project with ID 0001

# Scenario:  A project leader is not assigned to a project, as project does not exist
#       Given the system contains a worker with name "Bob Hansen", ID "ABCD"
#       When the worker is assigned project leader
#       Then the error message "Project does not excist" is given

# Scenario: A project leader already excists
#       Given the system contains a project with number "030901"
#       And that name "Jens Jensen", ID "JeJe" is the project leader
#       And the system contains a worker with name "Bob Hansen", ID "ABCD"
#       When the worker is assigned project leader
#      n Then the error message "A project leader already excists" is given