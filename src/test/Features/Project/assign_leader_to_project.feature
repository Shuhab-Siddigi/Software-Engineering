Feature: Assign project leader

    Scenario: A project leader is assigned to a project

        Given a project leader with name "Bob Hansen", ID "ABCD" exists
        And a project with name "Project1", project number "030901" exists in the system
        When the system assigns the project leader to the project
        Then the project leader with name "Bob Hansen", ID "ABCD" is assigned to the project with name "Project1", project number "030901"


    Scenario:  A project leader is not assigned to a project, as project does not exist

        Given a project leader with name "Bob Hansen", ID "ABCD" exists
        And a project with name "Project1", project number "030901" doesn't exist
        When the system assigns the project leader to the project
        Then the project leader with name "Bob Hansen", ID "ABCD" is not assigned to the project with name "Project1", project number "030901"
        And the error message "Project doesn't exist" is given


    Scenario:  A project leader is not assigned to a project, as project leader does not exist

        Given a project leader with name "Bob Hansen", ID "ABCD" doesn't exist
        And a project with name "Project1", project number "030901" exists in the system
        When the system assigns the project leader to the project
        Then the project leader with name "Bob Hansen", ID "ABCD" is not assigned to the project with name "Project1", and project number "030901"
        And the error message "Project leader doesn't exist" is given

