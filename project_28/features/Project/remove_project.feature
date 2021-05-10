Feature: A project is removed
Description: Project leader can remove project
Actors: Worker/Project leader


    Scenario: A project is removed from system by project leader
        Given the system contains a worker with ID "AAAA"
        And there is a project with title "Extreme Programming", ID 0001
        And the project exist in the system
        And the worker with ID "AAAA" is the project leader of project with ID 0001
        When the worker with ID "AAAA" removes the project with ID 0001
        Then the project with ID 0001 does not exist in the system

    Scenario: Removing a project from the system fails when project does not exist
        Given the system contains a worker with ID "AAAA"
        And there is a project with title "Extreme Programming", ID 0001
        And project with title "Extreme Programming", ID 0001 does not exist in the system
        When the worker with ID "AAAA" removes the project with ID 0001
        Then the error message "Project does not exist!" is given

    Scenario: Worker tries to remove project
        Given there is a project with title "Extreme Programming", ID 0001
        And the project exist in the system
        And the system contains a worker with ID "AAAA"
        And the worker with ID "AAAA" is the project leader of project with ID 0001
        And the system contains a worker with ID "AAAB"
        When the worker with ID "AAAB" removes the project with ID 0001
        Then the error message "Only the project leader can remove project!" is given
