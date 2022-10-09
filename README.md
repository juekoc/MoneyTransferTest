"MoneyTransferProject - Java application" built by Juela Giorgio

This is a RESTful API for money transfers between accounts. I have used Maven for depency injection using Spring and Java as the main programing language. It uses SpringData JPA to connect and access a local MySQL database.

- I have used Spring Initializr  that creates a simple class for the application - MoneytransferTestAppApplication. The main() method uses Spring Boot’s SpringApplication.run() method to launch an application. 
- I have created Account class where I have defined Account as JPA Entity Model. The Account class has 3 attributes: id,  name and balance. These properties are mapped to fields used in the MySQL table.
- I have used JpaRepository to create a repository Account. This Interface works with Account Entity to hold the records of Account Entity AccountData table from Accounts Schema of MySQL database. AccountRepository extends the JpaRepository interface. This way it inherits several metthors working with Account such as findById, findAll() and save().
- I have created the AccountRepository.java interface 



* Build the JAR file using Maven with the below command: 
./mvnw clean package

* Run the JAR file: 
java -jar moneytransfer-test-app-0.0.1-SNAPSHOT.jar

![image](https://user-images.githubusercontent.com/115390606/194747653-96d02368-11b2-48e2-912b-0d25fb55e9de.png)

