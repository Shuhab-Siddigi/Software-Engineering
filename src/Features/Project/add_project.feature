Feature: Create Project

    Scenario:  A project is created succesfully
        Given a  project  with  title  "Extreme  Programming",ID 0001
        And project does not exist in the system
        When the project with title "Extreme  Programming",ID 0001 is added to the system
        Then the project exist in the system

#     Scenario:  A project is not created when customer does not exist
#         Given a Costumer with name "SoftwareHuset A/S" does not exist
#         And a project with name "Extreme Programming", and project number "030901" does not exist
#         When the Costumer with name "SoftwareHuset A/S" creates a project withname "Extreme Programming", and project number "030901"
#         Then a project with name "Extreme Programming", and project number "030901"does not exist
#         And the error message "Costumer doesn’t exist" is given

#     Scenario:  A project is added to system successfully–
#         Given that a project with name "Extreme Programming", and project number"030901" exists–  Anda customer with name "Softwarehuset A/S" exists–
#         When the costumer adds the project to the system–  Then"Sofwarehust A/S" adds "Extreme Programming", "030901" to the system

#     Scenario:  A project is added to system fails when costumer doesn’t exist
#         Giventhat a project with name "Extreme Programming", and project number"030901" exists
#         And a customer with name "Softwarehuset A/S" doesn’t exists
#         When the costumer adds the project to the system
#         Then the error message "Costumer doesn’t exist" is given•

#     Scenario:  A project is added to system fails when project doesn’t exist
#         Given that a project with name "Extreme Programming", and project number"030901" doesn’t exists–
#         And a customer with name "Softwarehuset A/S" exists
#         When the costumer adds the project to the system
#         Then the error message "Project doesn’t exist" is given

#     Scenario:  A project is added to system fails when project is already added
#         Given a project is in the system
#         And a customer with name "Softwarehuset A/S" exists
#         When the costumer adds the project to the system
#         Then the error message "Project is already in the system" is given