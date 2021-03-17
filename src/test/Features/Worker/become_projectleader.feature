# Feature: Becomes project leader

#     Description: A worker becomes a project leader
#     Actors: Worker

#     Scenario: A worker is promoted to project leader sucessfully
#         Given the system contains a worker with name "Bob Hansen", ID "ABCD"
#         And the system contains a project with name "Project1", number "030901"
#         When the worker is added as project leader
#         Then the project with the number "030901" has a leader with ID "ABCD"

#     Scenario:  A worker is not promoted because the project already has a leader
#         Given the system contains a worker with name "Bob Hansen", ID "ABCD"
#         And the system contains a project with name "Project1", number "030901"
#         And the project already has another leader
#         When the worker is added as project leader
#         Then the error message "Project already has a project leader" is given
