"MoneyTransferProject - Java application" built by Juela Giorgio

This is a RESTful API for money transfers between accounts. I have used Maven for depency injection using Spring and Java as the main programing language. It uses SpringData JPA to connect and access a local MySQL database.

- I have used Spring Initializr  that creates a simple class for the application - MoneytransferTestAppApplication. The main() method uses Spring Boot’s SpringApplication.run() method to launch an application. 
- I have created Account class where I have defined Account as JPA Entity Model. The Account class has 3 attributes: id,  name and balance. These properties are mapped to fields used in the MySQL table. In here I have also defined the method that will make possible the transfer between accounts. 
- I have used JpaRepository to create a repository Account. This Interface works with Account Entity to hold the records of Account Entity AccountData table from Accounts Schema of MySQL database. AccountRepository extends the JpaRepository interface. This way it inherits several methods working with Account such as findById, findAll() and save().
- I have created a controller class Controller, to handle HTTP requests to my application. In this application we will use GET and POST requests. 

GET: http://localhost:8080/moneytransfer/account/all 
It will list all the accounts retrieved from the database.

GET: http://localhost:8080/moneytransfer/account/1
It will list the specific account record. 

Post: http://localhost:8080/moneytransfer/transferMoney?fromaccount=3&toaccount=1&amount=4
It will send the request to process the money transefer. In the url you have to define the paramer of account id from where you want to get the money, the account id where you want to transfer the money and the amount to be transfered.

---------------------------------------------------------
Built and test the application

* Build the JAR file using Maven with the below command: 
./mvnw clean package

* Run the JAR file: 
java -jar moneytransfer-test-app-0.0.1-SNAPSHOT.jar

![image](https://user-images.githubusercontent.com/115390606/194747653-96d02368-11b2-48e2-912b-0d25fb55e9de.png)

