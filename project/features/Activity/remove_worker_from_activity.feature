Feature: Remove worker from activity
    Description: Project leader removes worker
    Actors: Project leader

    Scenario: A worker is removed from the activity
        Given the project exist in the system
        And the worker with ID "AAAA" is the project leader of the project with ID 0001
        And the project contains the activity with title "Activity 1", ID 0001, start date "2020-12-21", end date "2021-01-20"
        And the worker with ID "AAAB" is assigned to the activity with ID 0001
        When the project leader removes the worker from the activity
        Then the worker with ID "AAAB" is not assigned to the activity with ID 0001

    Scenario: A worker tries to remove another worker from an activity
        # Given the project exist in the system
        # And the project and an activity exist in the system
        # When the worker removes a worker from the activity
        # Then the error "Only the project leader can remove worker from activity" is given
#         And the worker with ID "AAAA" is not the project leader of the project with ID 0001
#         And there exist an activity with number 0001 in the project with ID 0001
#         When the worker removes the worker from the activity
#         Then the error text "Workers can't remove other workers" is given
