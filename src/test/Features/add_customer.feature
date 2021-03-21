Feature: Add customer

	Description: A Customer is added to the system
	Actors: Administrator

	Scenario:  A non-existing customer is added to the system
		Given a Costumer with name ”SoftwareHuset A/S” does not exist
		And a Costumer with name ”SoftwareHuset A/S” is created
		When the Costumer with name ”SoftwareHuset A/S” is added to the system–
		Then a Costumer with name ”SoftwareHuset A/S” is contained in the system

	Scenario:  A Customer already exists in the system
		Given Costumer with name ”SoftwareHuset A/S” does not exist
		And a Costumer with name ”SoftwareHuset A/S” is created
		When the Costumer with name ”SoftwareHuset A/S” is added to the system
		Then a Costumer with name ”SoftwareHuset A/S” is contained in the system
		And the error message ”Costumer is already in the system” is given