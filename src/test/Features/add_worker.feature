    Feature Create Worker

    Scenario:  A Worker is created
        Given a Worker with name ”Bob hansen” and ID ”ABCD” does not exist
        And a Costumer with name ”SoftwareHuset A/S” exists in the system–
        When the Costumer with name ”SoftwareHuset A/S” creates a Worker withname ”Bob hansen” and ID ”ABCD”
        Then a Worker with name ”Bob hansen” and ID ”ABCD” exists

    Scenario:  A Worker is not created when customer does not exist
        Given  Worker  with  name  ”Bob  hansen”  and  ID  ”ABCD”  does  not  exist
        And a  Costumer with  name  ”SoftwareHuset  A/S”  does  not  exist
        When the Costumer with name ”SoftwareHuset A/S” creates a Worker with name ”Bobhansen”  and  ID  ”ABCD”
        Then a  Worker  with  name  ”Bob  hansen”  and  ID”ABCD”  does  not  exist
        And the  error  message  ”Costumer  doesn’t  exist”  is given