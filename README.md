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

(App will be running on http://localhost:8080 ,if nothing is running on 8080)

Now that the application is running, we can test it by using curl to execute requests to the api. We have three HTTP endpoints that we can test:

* Show all the accounts 
Command: curl http://localhost:8080/moneytransfer/account/all

Output: 
![image](https://user-images.githubusercontent.com/115390606/194754805-368f84e6-a831-4891-9de7-0c991faeefff.png)

Confirm with the values from the MySQL database: 
![image](https://user-images.githubusercontent.com/115390606/194754830-ab98c804-9b6d-4ccc-8765-4bd9346cad3f.png)


* Show specific account. In below request we are searching for accountId 1

Command: curl http://localhost:8080/moneytransfer/account/1
Output: 
![image](https://user-images.githubusercontent.com/115390606/194754906-3fa005e4-ba6e-4db3-853c-6a56fb10bc5b.png)

* Money Transfer Transaction. Transfer money from one account to another. In below request we are transfering money from AccountId 1 to AccountId 2. The transferred amount will be 10. 

Check what are the values in MySQL database before doing the transfer
![image](https://user-images.githubusercontent.com/115390606/194756453-43bcb6d0-8b90-454f-a863-8f2efca3782e.png)

Command in Curl: curl -X POST -d "fromaccount=1&toaccount=2&amount=10" http://localhost:8080/moneytransfer/transferMoney
Output: 
![image](https://user-images.githubusercontent.com/115390606/194756490-fa0d530d-02dc-463f-83e5-d1038dad34a7.png)

Show the updated account balances from database: 
![image](https://user-images.githubusercontent.com/115390606/194756522-2066ea3f-27dc-4511-8d5e-3688e71a7a64.png)

  *** Validations for Money Transfer ***
  * Not enough money
  
  Command: curl -X POST -d "fromaccount=1&toaccount=2&amount=100" http://localhost:8080/moneytransfer/transferMoney
  
  Output: Unsufficient funds in the first account  
  ![image](https://user-images.githubusercontent.com/115390606/194759096-e5bcf984-5cf7-444b-94b1-40ca6e52005e.png)
   
  * Money transfer failed because we could not identify one of the account ids;
  
  Command: curl -X POST -d "fromaccount=1&toaccount=8&amount=10" http://localhost:8080/moneytransfer/transferMoney
  
  Output: Account Id does not exist
  ![image](https://user-images.githubusercontent.com/115390606/194759185-5effff17-a8c6-48a4-abb2-d43ded665bae.png)

  ----------------------------------------------------------------------------------------------------------------
  
I have enabled the application to use Docker. The docker Images is buid with Maven and it is called backend-container. 
  
![image](https://user-images.githubusercontent.com/115390606/195055439-c3815abc-1674-44b2-b44e-196b16222537.png)

The Money Transfer application is running inside the docker. I have created a bash script to show that the request can be called within a bash script. The script executes the transfer of 10 euros from account 2 to account 1.  Also I executed the curl commands to display output the result. 

![image](https://user-images.githubusercontent.com/115390606/195057747-a6844fa6-608c-4061-b2f3-ffdcb510a44a.png)

Below are the values shows in the database after the update of balance. 

![image](https://user-images.githubusercontent.com/115390606/195058121-b8be30c8-a78a-4e0b-9d9e-8696eaa09ad6.png)

------------------------------------------------------------------------------------------------------------------

Since it is just a simple test I have not included the below, however these are things that can be improved in the application: 
* To add more error/expection handling and add more logs.
