# Sprint1_ABC_ELectronics

## Team members
* Sarthak Bhagat(Sprint lead)
* Vrushali Magdum(Product)
* Dakara Vidyamanohar(Admin and Client)
* Ronit Singh(Complaint)
* Megha Agarwal(Engineer)

## Problem Statement

To create an application for ABC-Electronic Smart Customer Service. The ABC Electronics is looking for the smart after sales services , In this
regard we proposed the solution.

* Client can book complaint through Online Complaint Portal(OCP),after registration of complaint user will get a unique complaint number along with following details.
* Complaint Status (Open or resolved).
* And the allocated engineer details.
* The User can see all the complaints made so far along with newly registered complaint

Engineers can also login in the same the portal but having different view.
Which is as follow.
Engineers can see.
* All allocated complaints to him
* And engineers can perform following filter operations on the same view.
* Can filter the complaint on the status of the compliant.
* The engineer can see detailed information of complaint and user such as
  * Complaint Information
  * product issue provided by the client.
  * product information such as make, model no, date of purchase.
b) Client Information
   *Name , Address ,Phone number
   
## Use Case: Admin
* Add Engineers (/engineer/add)
* Retrieve Engineers (/engineer/get/all)
* Retrieve Client ("/client/get/all")
* Retrieve Complaint ("/complaint/get/all")
* Get complaint of requested product ("/complaint/product/{modelNumber}")
* Remove engineer by EngineerId ("/engineer/remove/{engineerId}")
* Replace engineer from complaint ("/complaint/{engineerId}/{complaintId}")
* Login ("/login")
* Logout ("/logout")

## Use Case: Client
* Get details about current Client (/get)
* Get Engineer assigned to the given Complaint (/getengineer/{complaintid})
* Register(/register)
* Buy a product(
* Book a complaint(/book/{modelNumber}/{complaintName})
* Change Status of a complaint(/changestatus/{complaintId})
*Check all complaints(/get/all)
* Check open complaints(/get/open)
* Create a Client Account (/login)
* Logout(/logout)

## Use Case: Engineer
* Retrieve all Open complaints for currently logged in Engineers("/open")
* Retrieve all Resolved complaints for currently logged in Engineers("/resolved")
* Login("/login")
* Logout("/signout")

##Class Design - Entities
![Entities UML](https://raw.githubusercontent.com/Sarthak-Bhagat/Sprint1_ABC_ELectronics/main/.screenshots/Entities.png)

##Class Design - Exceptions
![Exceptions UML](https://raw.githubusercontent.com/Sarthak-Bhagat/Sprint1_ABC_ELectronics/main/.screenshots/Exceptions.png)

##Class Design - Repositories
![Repositories UML](https://raw.githubusercontent.com/Sarthak-Bhagat/Sprint1_ABC_ELectronics/main/.screenshots/Repos.png)

##Class Design - Services
![Services UML](https://raw.githubusercontent.com/Sarthak-Bhagat/Sprint1_ABC_ELectronics/main/.screenshots/Services.png)
![services UML](https://raw.githubusercontent.com/Sarthak-Bhagat/Sprint1_ABC_ELectronics/main/.screenshots/Services2.png)

## Conclusion
* Our aim of the project was to present a smart solution for managing complaints service for ABC Electronics.
* The technologies used - Java 8, Spring Boot, Maven, PostgreSQL, to achieve our goal.
* We generated the design structure as per the class design provided and proceeded with the TDD approach. 
* We used Github for collaborative development of the project.
* Every team member got an experience to work and coordinate as a team. 

 




