# Feature: Finding avaiable workers with under 
#     Description: 
#     Actors: project leader

#     Scenario: Finding avaiable workers
#         Given There is a list of workers
#         When The project leader search for avaiable workers
#         Then the system returns a list for workers that are avaiable
    
#     Scenario: Unable to find avaiable workers
#         Given There is a list of workers
#         When The project leader search for avaiable workers
#         And the list is empty
#         Then the error "There are no avaiable workers" is given

#     Scenario: Find a specific worker
#         Given There is a list of workers
#         Given the list contains a worker with name "Bob Hansen", ID "ABCD"
#         When The project leader search for the worker with ID "ABCD"
#         Then the work is in the list

#     Scenario: Unable to find specific worker
#         Given There is a list of workers
#         When The project leader search for the worker with ID "ABCD"
#         Then the error "The worker is not avaiable" is given