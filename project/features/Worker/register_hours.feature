# Feature: Worker register hours in project
# Description: A worker registers hours
# Actors: Worker

#     Scenario: A Worker registers hours succesfully

#         Given the system contains a worker with ID "AAAA"
#         And there is a project with title "Extreme Programming", ID 0001
#         And there exist an activity with number 0001 in the project with ID 0001
#         And the worker with ID "AAAA" is assigned to the activity with ID 0001
#         When the worker registers 10 work hours on project
#         Then the worker with ID "AAAA" has worked 10 hours on the project with ID 0001

#     Scenario: A Worker can't register hours, if worker isn't assigned to assignment on project
#         Given the system contains a worker with ID "AAAA"
#         And there is a project with title "Extreme Programming", ID 0001
#         And there exist an activity with number 0001 in the project with ID 0001
#         And the worker with ID "AAAA" is not assigned to the activity with ID 0001
#         When the worker registers 10 work hours on project
#         Then the error message "Worker isn't assigned to project" is given

#     Scenario: A Worker can't register hours, if worker isn't assigned to assignment on project
#         Given the system does not contain a worker with ID "AAAA"
#         And there is a project with title "Extreme Programming", ID 0001
#         And there exist an activity with number 0001 in the project with ID 0001
#         When the worker registers 10 work hours on project
#         Then the error message "Worker doesn't exist" is given