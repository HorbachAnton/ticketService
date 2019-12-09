The program is a service for buying tickets for festivals, films and other events. It also allows you to leave comments on certain events. The project uses the MySQL 8th version database.

Implemented functionality: authorization, registration, remembering user, changing personal data and password, localisation and internationalization.

Application launch: 1)install maven; 2)clone or download app; 3)create the database using the ScriptDB.sql in the "config" folder; 4)open command line in app folder; 5)enter command "mvn jetty:run"; 6)open browser and enter in the address bar "http://localhost:8080/ticket-service/".

IMPORTANT NOTICE: After the third step, you need to change the password in the hibernate.properties file to your password for the MySQL database. The hibernate.properties file is located in the properties folder (ticketService / src / main / resources / propertiey / hibernate.properties). 
