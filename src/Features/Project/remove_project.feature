# Feature: A project is removed
# Description: Project leader can remove project
# Actors: Worker/Project leader


#     Scenario: A project is removed from system by project leader
#         Given the system contains a worker with ID "AAAA"
#         And there is a project with title "Extreme Programming", ID 0001
#         And the worker with ID "AAAA" is the projecleader of project with ID 0001
#         When the worker with ID "AAAA" removes the project with ID 0001
#         Then the project does not exist in the system

#     Scenario: Removing a project from the system fails when project does not exist
#         Given the system contains a worker with ID "AAAA"
#         And there is not a project with title "Extreme Programming", ID 0001  
#         When the worker remove the project with number "0001"
#         Then the error "Project does not exist!" is given

#     Scenario: Worker tries to remove project
#         Given there is a project with title "Extreme Programming", ID 0001
#         And the system contains a worker with ID "AAAA"
#         And the worker with ID "AAAA" is the project leader of the project with ID 0001
#         And the system contains a worker with name ID "AAAB"
#         When the worker with ID "AAAA" remove the project with number "0001"
#         Then the error "Only the project leader can remove project" is given
