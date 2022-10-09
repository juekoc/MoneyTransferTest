"MoneyTransferProject - Java application" built by Juela Giorgio

This is a RESTful API for money transfers between accounts. I have used Maven for depency injection and Java as the main programing language. It uses SpringData JPA to connect and access a local MySQL database.

I have created a JpaRepository - Account that is used as repository to hold the records of AccountData table from Accounts database.




* Build the JAR file using Maven with the below command: 
./mvnw clean package

* Run the JAR file: 
java -jar moneytransfer-test-app-0.0.1-SNAPSHOT.jar

![image](https://user-images.githubusercontent.com/115390606/194747653-96d02368-11b2-48e2-912b-0d25fb55e9de.png)

