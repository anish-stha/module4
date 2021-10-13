# Module 4 Mini-Project

## Demo this project on the public URL of:
http://ec2-18-188-200-41.us-east-2.compute.amazonaws.com:8080/module4/user_registration

## War package 
Since maximum upload file size in Moodle is 10MB, please use this link to download the file if needed:
https://github.com/anish01stha/module4/blob/master/target/module4.war

## Following servlets are created:

/hi-servlet

/user_registration

/user_retreival

## Components used:

**Eclipse/ IntelliJ IDEA:**<br/> This project can be set up in both Eclipse or IntelliJ IDEA

**Maven:**<br/> Dependency management and used to package project into a war file

**Mysql:**<br/> Mysql was used as the relational databse

**Hibernate:**<br/> The projects uses Hibernate with Mysql and connects to Database "db" as
jdbc:mysql://localhost:3306/db

**Xampp:**<br/> Xampp was used to run Mysql and Tomcat in the AWS EC2 instance

**Amazon:**<br/> This program is hosted on a Windows 2002 Server in an Amazon EC2 instance


## Project Structure
**HibernateUtil.java:**<br/> Sets up connection with Mysql database and connects Hibernate

**HelloServlet.java:**<br/> Just a servlet to ping that return "Hi!" message 

**UserDao.java:**<br/> The Hibernate ORM class used to map to MySql table that contains User Entity.

**UserRegistration.java:**<br/> Returns page for user registration under /user_registration servlet

**UserRetrieval.java:**<br/> Returns page for user retrieval under /user_retrieval servlet

**UserService.java:**<br/> A service to save and retrieve UserDAO objects into MySql database. It is best to not write such logic in servlet classes and to abstract them out into service class. Hence, this was done for best practices.

**Note:** Html filles are in /WEB-INF as .jsp files to be used by servlet classes.
