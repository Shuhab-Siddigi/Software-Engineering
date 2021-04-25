Feature: Generate report
    Description: A report is generated by the project leader
    Actors: project leader


    Scenario: A report is generated susccesfully with minimal info about project
        Given there is a project with title "Extreme Programming", ID 0001
        And the project exist in the system
        And the worker with Name "Anders" "Andersen" and ID "AAAA" is assigned project leader of the project with ID 0001
        When the project leader generates a report
        Then the text is given "Extreme Programming 1 \nAndersen, Anders AAAA"

    Scenario: A report is generated susccesfully with full info about
        Given there is a project with title "Extreme Programming", ID 0001
        And the project exist in the system
        And with start date "2020-01-01", endDate "2020-02-01", expected hours 500 and worked hours 300
        And the worker with Name "Anders" "Andersen" and ID "AAAA" is assigned project leader of the project with ID 0001
        When the project leader generates a report
        Then the text is given "Extreme Programming 1 2020-01-01 2020-02-01 500 300 \nAndersen, Anders AAAA"

    Scenario: A report is generated susccesfully with minimal info about project, but with 1 activity attached with minimal info
        Given there is a project with title "Extreme Programming", ID 0001
        And the project exist in the system
        And the worker with Name "Anders" "Andersen" and ID "AAAA" is assigned project leader of the project with ID 0001
        And has activty "do Work", ID 6666, start date "2020-01-01", end date "2020-02-01"
        And activity with ID 6666 contains worker "Bent" "Bentsen", ID "BBBB" and worker "Claus" "Clausen", ID "CCCC"
        When the project leader generates a report
        Then the text is given "Extreme Programming 1 2020-01-01 2020-02-01 \nAndersen, Anders AAAA\n\ndo Work 2020-01-01 2020-02-01 \nBentsen, Bent BBBB \nClausen, Claus CCCC \n\n\n"