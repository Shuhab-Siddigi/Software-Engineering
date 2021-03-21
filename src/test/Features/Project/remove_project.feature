# Feature: A project is removed
# Description: Project leader can remove project
# Actors: Worker/Project leader


#     Scenario: A project is removed from system by worker
#         Given the system contains a worker with name "Bob Hansen", ID "ABCD"
#         And the system contains a project with name "Project1", number "030901"
#         When the worker removes the project
#         Then the project does not exist in the system

#     Scenario: Removing a project from the system fails when project does not exist
#         Given the system contains a worker with name "Bob Hansen", ID "ABCD"
#         When the worker remove the project with number "030901"
#         Then the error "Project does not exist!" is given

#     Scenario: Worker ties to remove project with project leader
#         Given the system contains a project with number "030901"
#         And that name "Jens Jensen", ID "JeJe" is the project leader
#         And the system contains a worker with name "Bob Hansen", ID "ABCD"
#         When the worker remove the project with number "030901"
#         Then the error "Only the project leader can remove project" is given