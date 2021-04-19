Feature: Assign project leader
    Description: Assign project leader to project
    Actors: Worker/System

    Scenario: A project leader is assigned to a project
        Given there is a project with title "Extreme Programming", ID 0001
        And the project exist in the system
        And the system contains a worker with ID "AAAA"
        When the worker with ID "AAAA" is assigned to the project with ID 0001
        Then the worker with ID "AAAA" is the project leader of the project with ID 0001

    Scenario:  A project leader is not assigned to a project, as project does not exist
        Given the system contains a worker with ID "AAAA"
        When the worker with ID "AAAA" is assigned to the project with ID 0001
        Then the error message "Project does not exist" is given

    Scenario:  A project leader is not assigned to a project, as worker does not exist
        Given the system doesn't contains a worker with ID "ZZZZ"
        And the project exist in the system
        When the worker with ID "ZZZZ" is assigned to the project with ID 0001
        Then the error message "Worker does not exist in system" is given

    Scenario: A project leader already exist
        Given there is a project with title "Extreme Programming", ID 0001
        And the project exist in the system
        And the system contains a worker with ID "AAAA"
        And the system contains a worker with ID "AAAB"
        When the worker with ID "AAAA" is assigned to the project with ID 0001
        When the worker with ID "AAAB" is assigned to the project with ID 0001
        Then the error message "A project leader already exist" is given