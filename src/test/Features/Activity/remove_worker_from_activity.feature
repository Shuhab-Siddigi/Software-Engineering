# Feature remove worker from activity
# Description: Project leader removes worker
# Actors: Project leader


# Scenario: a worker is removed from the activity
#     Given the system contains a project with number "030901"
#     And that name "Jens Jensen", ID "JeJe" is the project leader
#     And there exist an activity with number "01"
#     And the activity contains a worker with ID "ABCD"
#     When the project leader removes the worker with name "Bob Hansen", ID "ABCD"
#     Then the worker is not contained in the activity


# Scenario: Another project leader tries to remove a worker from an activity
#     Given the system contains a project with number "030901"
#     And that name "Jens Jensen", ID "JeJe" is the project leader
#     And there exist an activity with number "01"
#     And the activity contains a worker with ID "ABCD"
#     When the project leader with name "Hans Hansen", ID "HaHa" removes the worker with ID "ABCD"
#     Then the error message "only the project leader assigned to the project can remove a worker" is given
#     And the worker is still contained in the activity


# Scenario: A worker tries to remove another worker from an activity
#     Given the system contains a project with number "030901"
#     And the system contains a worker with name "Bob Hansen", ID "ABCD"
#     And there exist an activity with number "01"
#     When the worker with ID "EFGH" removes the worker with name "Bob Hansen", ID "ABCD"
#     Then the error message "Only the project leader can remove workers from activities!" is given
#     And the worker is still contained in the activity
