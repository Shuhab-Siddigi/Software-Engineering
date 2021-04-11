

# Feature: Promote Worker create project leader•

#     Scenario:  A Worker is promoted to project leader
#         Given a Worker with name ”Bob hansen” and ID ”ABCD” exists–
#         And a Costumer with name ”SoftwareHuset A/S” exists in the system
#         When the Costumer with name ”SoftwareHuset A/S” promotes a Worker withname ”Bob hansen” and ID ”ABCD” to project leader
#         Then a Worker with name ”Bob hansen” and ID ”ABCD” is a project leader•

#     Scenario:  A Worker is not promoted to project leader when  customer does not exist–

#         Give n a Worker with name ”Bob hansen” and ID ”ABCD” exists–
#         And a Costumer with name ”SoftwareHuset A/S” does not exist
#         When the Costumer with name ”SoftwareHuset A/S” promotes a Worker withname ”Bob hansen” and ID ”ABCD” to project leader
#         Then a  Worker  with  name  ”Bob  hansen”  and  ID  ”ABCD”  is  not  a  projectleader–
#         And the error message ”Costumer doesn’t exist” is given

#     Scenario:  A Worker is not promoted to project leader when  Worker does not exist–

#         Given a Worker with name ”Bob hansen” and ID ”ABCD” does not exist
#         And a Costumer with name ”SoftwareHuset A/S” exists in the system
#         When the Costumer with name ”SoftwareHuset A/S” promotes a Worker with name ”Bob hansen” and ID ”ABCD” to project leader
#         Then a  Worker  with  name  ”Bob  hansen”  and  ID  ”ABCD”  is  not  a  projectleader–
#         And the error message ”Worker doesn’t exist” is given.

# Feature: Assign Project leader•

#     Scenario:  A project leader is assigned to a project–

#         Given a project leader with name ”Bob hansen” and ID ”ABCD” exists
#         And a Costumer with name ”SoftwareHuset A/S” exists in the system
#         And a project with name ”Extreme Programming”, and project number ”030901”exists in the systemSide 7 af 8
#         When the Costumer with name ”SoftwareHuset A/S” assigns a project leaderwith name ”Bob hansen” and ID ”ABCD” to the project with name ”ExtremeProgramming”, and project number ”030901”
#         Then a project leader with name ”Bob hansen” and ID ”ABCD” is assigned tothe project with name ”Extreme Programming”, and project number ”030901”•

#     Scenario:  A project leader is not assigned to a project, as project does not exist–

#         Given a project leader with name ”Bob hansen” and ID ”ABCD” exists
#         And a Costumer with name ”SoftwareHuset A/S” exists in the system
#         And a project with name ”Extreme Programming”, and project number ”030901”does not exist in the system–
#         When the Costumer with name ”SoftwareHuset A/S” assigns a project leaderwith name ”Bob hansen” and ID ”ABCD” to the project with name ”ExtremeProgramming”, and project number ”030901”
#         Then a  project  leader  with  name  ”Bob  hansen”  and  ID  ”ABCD”  is  not  as-signed to the project with name ”Extreme Programming”, and project number”030901”–
#         Andthe error message ”Project doesn’t exist” is given

#     Scenario:  A project leader is not assigned to a project, as project leader does notexist–

#         Given a  project  leader  with  name  ”Bob  hansen”  and  ID  ”ABCD”  does  notexist
#         Anda Costumer with name ”SoftwareHuset A/S” exists in the system
#         And a project with name ”Extreme Programming”, and project number ”030901”does not exist in the system–
#         When the Costumer with name ”SoftwareHuset A/S” assigns a project leaderwith name ”Bob hansen” and ID ”ABCD” to the project with name ”ExtremeProgramming”, and project number ”030901”
#         Then a  project  leader  with  name  ”Bob  hansen”  and  ID  ”ABCD”  is  not  as-signed to the project with name ”Extreme Programming”, and project number”030901”
#         And the error message ”Project leader doesn’t exist” is given.

# Feature: assign worker to project•

#     Scenario:  A Worker is assigned to a projectı
#         Given a Worker with name ”Bob hansen” and ID ”ABCD” exists in the system
#         And a project with name ”Extreme Programming”, and project number”030901” exists in the systemAnda project leader with name ”Jens Jensen”and  ID  ”EFGH”  is  assigned  to  the  project
#         When the  project  leader  assignsa  Worker  with  name  ”Bob  hansen”  and  ID  ”ABCD”  to  the  projectThen aWorker with name ”Bob hansen” and ID ”ABCD” does not existAndthe errormessage ”Costumer doesn’t exist” is given