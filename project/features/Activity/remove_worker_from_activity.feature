# Feature Remove worker from activity
# Description: Project leader removes worker
# Actors: Project leader

# Scenario: A worker is removed from the activity
#         Given there is a project with title "Extreme Programming", ID 0001
#         And the worker with ID "AAAA" is the project leader of the project with ID 0001
#         And there exist an activity with number 0001 in the project with ID 0001
#         And the worker with ID "AAAB" is assigned to the activity with ID 0001
#         When the project leader removes the worker from the activity
#         Then the workers with ID "AAAB" is not assigned to the activity with ID 0001

# Scenario: A worker tries to remove another worker from an activity
#         Given there is a project with title "Extreme Programming", ID 0001
#         And the worker with ID "AAAA" is not the project leader of the project with ID 0001
#         And there exist an activity with number 0001 in the project with ID 0001
#         When the worker removes the worker from the activity
#         Then the error text "Workers can't remove other workers" is given
