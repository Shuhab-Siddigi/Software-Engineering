# Feature: Finding available workers with under 
#     Description: 
#     Actors: project leader

#     Scenario: Finding avaiable workers
#         Given there is a list of workers
#         And there is a project with title "Extreme Programming", ID 0001
#         And the worker with ID "AAAA" is the project leader of the project with ID 0001
#         When the project leader search for avaiable workers
#         Then the system returns a list for workers that are avaiable
    
#     Scenario: Unable to find avaiable workers
#         Given there is a list of workers
#         And there is a project with title "Extreme Programming", ID 0001
#         And the worker with ID "AAAA" is the project leader of the project with ID 0001
#         And the list is empty
#         When the project leader search for avaiable workers
#         Then the error "There are no avaiable workers" is given

#     Scenario: Find a specific worker
#         Given there is a list of workers
#         And there is a project with title "Extreme Programming", ID 0001
#         And the worker with ID "AAAA" is the project leader of the project with ID 0001
#         And the list contains a worker with ID "AAAA"
#         When the project leader search for the worker with ID "AAAA"
#         Then the systems returns the worker

#     Scenario: Unable to find specific worker
#         Given there is a list of workers
#         And there is a project with title "Extreme Programming", ID 0001
#         And the worker with ID "AAAA" is the project leader of the project with ID 0001
#         And the list does not contain a worker with ID "AAAA"
#         When the project leader search for the worker with ID "AAAA"
#         Then the error "Worker is not in list" is given