## APPLICATION FOR PRESCRIPTION GENERATION ## 
## User Requirements Mini-Specification  
You will be creating a simple Web-based application for prescription generation  

## User Stories The high level functional requirements are as follows. 
* No anonymous users are allowed to use the system. They will be redirected to login page for login. You can use dummy user credentials for login (no need to load that information from DB, but bonus points if you can do that using DB) . 
* After login, show a list of prescription generated for a particular date range (by default the current month) in tabular format. This date range can be selected/changed by the user and the result will be shown accordingly 
* Allow the authenticated users to create new prescription which will be saved in DB. You can use in-memory db or any other db of your choice. Note that you should show proper error messages on form submission when invalid data is submitted. The prescription will contain: 
* Prescription Date (valid date, mandatory) * Patient Name (text, mandatory) 
* Patient Age (integer, valid age range, mandatory) * Patient Gender (select box, mandatory) 
* Diagnosis (text area) * Medicines (Text area) * Next visit date (valid date, optional) 
* Allow user to edit a prescription entry * Allow user to delete a prescription entity. 
* Create a report: Day wise prescription count [day, prescription count] 
* Create a REST API to get  prescription list (GET /api/v1/prescription) which will return JSON 
* Consume this REST API, show it in tabular format in a page: https://rxnav.nlm.nih.gov/REST/interaction/interaction.json*rxcui=341248 

## Bonus points: 
* Ask for confirmation before deleting any prescription entry 
* Make the UI responsive and beautiful. You can use any UI framework if needed. 
* Make form validation in client side too using Javascript 

## -------------- DEVELOPMENT README --------------  ## 
Technology used:
• Frontend: Thymeleaf, Bootstrap
• Backend: Java EE (spring boot version 2.1.7)
• DB: MySQL (using JPA)

Requirements:
• I have used spring boot (v2.1.7) as back end and Thymeleaf as front end framework
• It is a maven project and MySQL database is used for the project.
• Intellij idea is used for this project

Database Setup:
• Please create a database as ‘spring_db’ and update the database username and password in 'application.properties' file before run the application.
• No need to run any database DDL script for this application.
• Run the following Query insert script for create user before login to the system [Here system username/password: user/1234]
INSERT INTO `spring_db`.`user` (`id`, `active`, `password`, `roles`, `user_name`) VALUES ('1', 1, '1234', 'ROLE_USER', 'user');
• Please use login url : http://localhost:8080/
