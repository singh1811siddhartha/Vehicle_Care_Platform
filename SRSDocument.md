# Name:
 1) 229191 : Kharmate Rohit Bhagwat
		 2) 229214 : Siddhartha Singh
		IACSD Sept-22 Batch
# Vehicle Care Platform

## Document:
System Requirement Specification Document

## Title:
System Requirement Specification for Online Vehicle Care Portal

## Team: 
Direct Customer, Indirect Customer, Architect, Business Analyst,	Quality Assurance Team, System Analyst

## Objective (Purpose):
The online Vehicle Care Platform for vehicles Web Application is intended to provide a complete solution for Customers as well as Mechanics/Garage Owners through a single Gateway using the internet. It will enable Mechanics/Garage Owners to set up online shops, customers to browse through virtual shops and book the services or vehicle care online without visiting the shop physically.

## Scope:
This System allows Mechanics/Garage Owners to maintain their products/services for adding or removing from catalog based on their availability.
Customers will be able to place the order from a variety of options depending upon their requirement whether it is regular maintenance or urgent repair or custom modifications.
The System will be able to show suggestions regarding nearest availability of mechanics or garage based on location of customer.

## Definitions:
	MGO: Mechanics/Garage Owners
	SPC:  Services/Product Catalog
	GW: Garage/workshop
	PDA: Portable Device Application

## Functional Requirements:

Any customer will be able to view a list of different services and spare parts available. Any customer will be able select the services required from the list available.
Customers will have to sign up and make a registered verified profile before placing an order for any of the services from SPC.
MGO will also have to sign up and make a registered verified profile before adding their services in the SPC.
Registered MGO will be able promote their offered services for sale by adding them in the SPC maintained by System.
MGO will be able to add or remove products from SPC based on availability.
Customers will be able to request for addition of new products or new services in the catalog maintained by the system.  The MGO Team will be able to go through these requests  raised by customers for adding products in the SPC.
Customers will be able to see the SPC divided in three categories on the home page.
1st category is having details about General Maintenance of the vehicle from the SPC..
2nd category is having details about Urgent repair of vehicle & the services in this category from SPC.
3rd category is about custom modifications of the vehicle for interested customers.

Based on the preference the customer will be able to choose their order and place it from the list of MGO offering the same services, also by comparing the charges for the same services and the ratings of different MGO.
Once the order is placed, whether the customer has chosen onsite services or pickup, the MGO will see the order and choose to accept it or pass it, if it is in their range of operation or not.
The customer will be able to see it and also the progress of their orders placed. 
The MGO team will go to the pick-up location(set by the customers), get the vehicles from the location and bring it back to the GW if it is not repairable at the site.
By default, the MGO will get the orders if the order contains the services offered by them in their catalog, and also by considering the fact of location how nearest it is.
But the customer is also having the freedom to choose their favorite MGO even if its location is not close by.
Once the order is placed, vehicles are received and brought back to their respective GW by them.
the customer will be able to see the progress and when it will be finished. When the order is finished and services or repair work is done, the vehicle will be delivered back to their respective owners.
Once the vehicle is received by the customer, they can verify it and after verification the payment is done by upi/internet banking/cash.
If the order is placed by the customer in the urgent repair section, then the MGO will send the team with a mechanic, for checking if the vehicle can be quickly repaired on the spot.
Customers will be able to submit feedback/ratings about the service they received.
Customers will be able to update his/ her personal information. 
Customer  will be able to manage his profile maintained by the system.
Customer will be able to change his credentials if required. 
Customers will be notified about order status, delivery status through  SMS, Email communication.
Customer will get complete information about his orders, likes, comments, details through a dashboard.
Customer will be able to update his payment related information.
System will present a dashboard for Customers, MGO as well.
Customers will be able to get their business related information using Customer Dashboard.
MGO will be able to submit feedback/ratings about the customers.
MGO  will be able to manage his profile maintained by the system.
MGO will be able to change his credentials if required. 
MGO will be notified about order status, delivery status through  SMS, Email communication.
MGO will get complete information about their served orders, likes, comments, details through a dashboard.
MGO will be able to update his payment related information.
MGO will be able to get their business related information using MGO Dashboard.

	
## NonFunctional Requirement:

### Security
Registered Customers will be allowed to place a service.	
Each customer/MGO will have to access the system through the authentication process. Who are you ?
System will provide access to  the content , operations using Role based security (Authorization) (Permissions based on Role)
Using SSL in all transactions  which will be performed by the customer/MGO. It would protect confidential information shared by the system to them.
System will automatically log off all  customers/MGO after some time due to inactiveness.
System will block operations for inactive customers/MGO and would redirect for authentication.
System  will internally maintain secure communication channel between Servers ( Web Servers, App Servers, database Server)
Sensitive data will always be encrypted across communication.
User proper firewall to protect servers from outside fishing, vulnerable attacks.


### Reliability
The system will backup business data on regular basis and recover in short time duration to keep system operational
Continuous updates are maintained , continuous Administration is done to keep the system operational.
During peak hours the system will maintain the same user experience by managing load balancing .

### Availability
uptime:   24* 7  available  99.999%
	
### Maintainability:
A Commercial database software will be used to maintain System data Persistence.
A ready-made Web Server will be installed to host an online servicing platform portal (Web Site) to management server capabilities.
The IT operations team will easily monitor and configure the System using Administrative tools provided by Servers.
Separate environments will be maintained for systems for isolation in  production, testing, and development.

### Portability:
PDA: Portable Device Application
System will provide a portable User Interface ( HTML, CSS, JS) through which customers  will be able to access online servicing platform portals.
System can be deployed to single server, multi server, to any OS, Cloud (Azure or AWS or GCP)

### Accessibility:
only registered customers/MGO will be able to place an order after authentication.
The MGO team will be able to view daily, weekly, monthly, annual business Growth through customized dashboard.
Customers will be able to view their orders placed in the history section.

### Durability:
System will maintain a wishlist for customers . customers  will be able to add products from the wishlist whenever needed in case of general maintenance.
System will implement backup and recovery for retaining customers/MGO data, business operation data and business data over time.

### Efficiency:
Festival offers and services will be placed in the wishlist to attract more customers, so as to maintain the website such that the customers are able to view products with the same response time.
System will be able to manage all transactions with isolation.


### Scalability:
System will be able  to  provide  consistent user experience to customers/MGO as well as visitors irrespective of load.

### Safety:	
Online servicing  portal will be secure from malicious attack, fishing.
Online servicing  portal functionalities are protected from outside with proper  firewall configuration.
The online servicing portal will be always kept updated with the latest anti virus software.
Business data will be backed up periodically to ensure safety of data using incremental backup strategy.
Role based security will be applied for Application data and operations accessibility.
