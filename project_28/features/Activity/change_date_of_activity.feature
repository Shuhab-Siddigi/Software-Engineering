Feature: Change times of an activity
    Description: Project leader changes date of activity
    Actors: Project leader

    Scenario: Activity start time is changed
        Given the project exist in the system
        And the project contains the activity with title "Activity 1", ID 0001, start date "2020-12-21", end date "2021-01-20"
        When the start date of the activity is changed to "2020-12-29"
        Then the activity changes start date to "2020-12-29"

    Scenario: Activity and project start time is changed 
        Given the project exist in the system
        And the project contains the activity with title "Activity 1", ID 0001, start date "2020-12-21", end date "2021-01-20"
        When the start date of the activity is changed to "2020-12-29"
        Then the activity changes start date to "2020-12-29"

    Scenario: Activity start time is changed to time after project end 
        Given the project exist in the system
        And the project contains the activity with title "Activity 1", ID 0001, start date "2020-12-21", end date "2021-01-20"
        When the start date of the activity is changed to "2021-01-21"
        Then the error "Cannot change start date to after project ends!" is given

    Scenario: Activity end time is changed
        Given the project exist in the system
        And the project contains the activity with title "Activity 1", ID 0001, start date "2020-12-21", end date "2021-01-20"
        When the end date of the activity is changed to "2021-01-25"
        Then the activity changes end date to "2021-01-25"

    Scenario: Activity start time is changed to time after project end 
        Given the project exist in the system
        And the project contains the activity with title "Activity 1", ID 0001, start date "2020-12-21", end date "2021-01-20"
        When the end date of the activity is changed to "2020-01-25"
        Then the error "Cannot change end date to before project starts!" is given

