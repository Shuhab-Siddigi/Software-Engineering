# Feature: Worker manages hours in project
# Description: A worker registers hours
# Actors: Worker

#     Scenario: A Worker registers hours succesfully

#         Given the system contains a worker with name "Bob Hansen", ID "ABCD"
#         And the system contains a project with name "Project1", number "030901"
#         And the worker is assigned to the project
#         When the worker registers 'int' number of work hours on project
#         Then the worker "Bob Hansen" has worked 'int' hours on the project with name "Project1", project number "030901"


#     Scenario: A Worker can't register hours, if worker isn't assigned to project

#         Given a worker with name "Bob hansen", ID "ABCD" exists in the system
#         And a project with name "Project1", project number "030901" exists in the system
#         And the worker isn't assigned to the project
#         When the worker registers 'int' number of work hours on project
#         Then the worker "Bob Hansen" hasn't registered 'int' number of work hours on the project with name "Project1", project number "030901"
#         And the error message "Worker isn't assigned to project" is given


#     Scenario: Worker can't register hours because he is not in the system

#         Given a worker with name "Bob hansen", ID "ABCD" doesn't exist
#         And a project with name "Project1", project number "030901" exists in the system
#         And the worker isn't assigned to the project
#         When the worker registers 'int' number of work hours on project
#         Then the error message "Worker doesn't exist" is given


#     Scenario: Worker can't register hours because he hasent enough hours