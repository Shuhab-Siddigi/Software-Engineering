Feature: Create project

    Description: A worker creates a project
    Actors: Worker OR Projectleader

    Scenario: A project is added to system successfully
        Given the system contains a worker with name "Bob Hansen", ID "ABCD"
        And the system contains a project with name "Project1", number "030901"
        When the worker creates the project
        Then the project exist in the system

    Scenario: Adding a project to the system fails when project already exist
        Given the system contains a worker with name "Bob Hansen", ID "ABCD"
        And the system contains a project with name "Project1", number "030901"
        When the worker adds the project again
        Then the error "Project already exist!" is given
