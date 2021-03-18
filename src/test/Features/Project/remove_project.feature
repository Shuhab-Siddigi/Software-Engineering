# Feature: Remove project
# Description: Project leader can remove project
# Actors: Project leader

#     Description: A worker creates a project
#     Actors: Worker OR Projectleader

#     Scenario: A project is removed from system successfully
#         Given the system contains a worker with name "Bob Hansen", ID "ABCD"
#         And the system contains a project with name "Project1", number "030901"
#         When the worker removes the project
#         Then the project does not exist in the system

#     Scenario: Removing a project from the system fails when project does not exist
#         Given the system contains a worker with name "Bob Hansen", ID "ABCD"
#         When the worker remove the project with number "030901"
#         Then the error "Project does not exist!" is given
