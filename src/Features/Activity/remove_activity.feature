# Feature: Description Remove new Activity
#     Description: A project is removed from the system
#     Actors: Worker or Project leader

#     Scenario: An activity is removed from project sucessfully
#         Given there is a project with title "Extreme Programming", ID 0001
#         And the worker with ID "AAAA" is the project leader of the project with ID 0001
#         And there exist an activity with number 0001 in the project with ID 0001
#         When the activity is removed
#         Then the activity with id 0001 is not contained in project

#     Scenario: Cannot remove an activity that does not exist
#         Given there is a project with title "Extreme Programming", ID 0001
#         And the worker with ID "AAAA" is the project leader of the project with ID 0001
#         And there does not exist an activity with number 0001 in the project with ID 0001
#         When the activity is removed
#         Then the error text "Activity is not in project" is given

#     Scenario: Worker tries to remove activity
#         Given there is a project with title "Extreme Programming", ID 0001
#         And the worker with ID "AAAA" is not the project leader of the project with ID 0001
#         And there exist an activity with number 0001 in the project with ID 0001
#         When the activity is removed
#         Then the error text "Worker cannot remove activities" is given
