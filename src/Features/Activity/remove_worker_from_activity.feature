# Feature remove worker from activity
# Description: Project leader removes worker
# Actors: Project leader

# Scenario: A worker is removed from the activity
#         Given the system contains a project with number "030901" 
#         And that name "Jens Jensen", ID "JeJe" is the project leader
#         And there exist an activity with number "01"
#         When the project leader adds the worker with name "Bob Hansen", ID "ABCD"
#         Then the worker is added to the activity
#         When the project leader removes the worker from the activity
#         Then the workers is not assigned to the activity

# Scenario: Another project leader tries to remove a worker from an activity
#         Given the system contains a project with number "030901" 
#         And that name "Jens Jensen", ID "JeJe" is the project leader
#         And there exist an activity with number "01"
#         When the project leader adds the worker with name "Bob Hansen", ID "ABCD"
#         Then the worker is added to the activity
#         When another project leader removes the worker from the activity
#         Then the error text "Only the project leader assigned to the project can remove a worker" is given

# Scenario: A worker tries to remove another worker from an activity
#         Given the system contains a project with number "030901" 
#         And that name "Jens Jensen", ID "JeJe" is the project leader
#         And there exist an activity with number "01"
#         When the project leader adds the worker with name "Bob Hansen", ID "ABCD"
#         Then the worker is added to the activity
#         When the worker removes the worker from the activity
#         Then the error text "Only the project leader assigned to the project can remove a worker" is given
