Feature: Finding available workers
    Description:
    Actors: project leader

    Scenario: Finding avaiable worker in list by worker ID
        Given there is a list of workers, which contain worker with Name "Bent" "Bentsen" ID "BENT"
        When the project leader search for avaiable workers using ID "BENT"
        Then the system returns a worker with matching id

    Scenario: Unable to find avaiable worker by worker ID
        Given there is a list of workers, which contain worker with Name "Bent" "Bentsen" ID "BENT"
        When the project leader search for avaiable workers using ID "ZZZZ"
        Then the error "There are no workers by that ID" is given

    Scenario: Finding avaiable worker in list by worker first name
        Given there is a list of workers, which contain worker with Name "Bent" "Bentsen" ID "BENT"
        When the project leader search for avaiable workers using first name "Bent"
        Then the system returns a worker with matching first name

    Scenario: Unable to find avaiable worker by worker first name
        Given there is a list of workers, which contain worker with Name "Bent" "Bentsen" ID "BENT"
        When the project leader search for avaiable workers using first name "Tobias"
        Then the error "There are no workers by that First Name" is given

    Scenario: Finding avaiable worker in list by worker last name
        Given there is a list of workers, which contain worker with Name "Bent" "Bentsen" ID "BENT"
        When the project leader search for avaiable workers using last name "Bentsen"
        Then the system returns a worker with matching last name

    Scenario: Unable to find avaiable worker by worker last name
        Given there is a list of workers, which contain worker with Name "Bent" "Bentsen" ID "BENT"
        When the project leader search for avaiable workers using last name "Tobiasen"
        Then the error "There are no workers by that Last Name" is given

    Scenario: Worker is avaliable by checking activity before
        Given an activity exist with start date "2020-05-01" and end date "2020-05-31"
        When checked if activity is booked with date "2020-04-01" and end date "2020-04-30"
        Then the activity fits in plan

    Scenario: Worker is avaliable by checking activity after
        Given an activity exist with start date "2020-05-01" and end date "2020-05-31"
        When checked if activity is booked with date "2020-06-01" and end date "2020-06-30"
        Then the activity fits in plan

    Scenario: Worker is not avaliable by checking activity with start in middel
        Given an activity exist with start date "2020-05-01" and end date "2020-05-31"
        When checked if activity is booked with date "2020-05-15" and end date "2020-06-30"
        Then the activity does not fit in plan

    Scenario: Worker is not avaliable by checking activity with end in middel
        Given an activity exist with start date "2020-05-01" and end date "2020-05-31"
        When checked if activity is booked with date "2020-04-01" and end date "2020-05-15"
        Then the activity does not fit in plan

################# er ikke sikker på de giver mening #################
#    Scenario: Finding avaiable workers in list by worker ID
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