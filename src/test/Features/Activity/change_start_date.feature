# Feature: change times of an activity
#     Description:
#     Actors: Projectleader

#     Scenario: The start time of an activity is moved closer to the present
#         Given a project with name "Project1", and project number "030901" exists in the system
#         And a project leader with name "Jens Jensen" and ID "EFGH" is assigned to the project
#         And The project has an activity with Name "activity 1" and a start time of "21 december"
#         When the project leader changes the start time of the activity to "20 december"
#         Then the activity has a start time of "20 december"

#     Scenario: The start time of an activity is not moved closer to the present
#         Given a project with name "Project1", and project number "030901" exists in the system
#         And a worker with name "Bob Hansen", ID "ABCD" is assigned to the project
#         And The project has an activity with Name "activity 1" and a start time of "21 december"
#         When the worker changes the start time of the activity to "20 december"
#         Then the activity has a start time of "21 december"
#         And the error message "Only allowed by project leaders" is given


