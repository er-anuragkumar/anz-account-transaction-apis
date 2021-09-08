# anz-account-transaction-apis
This is a Demo Application built for getting Account & Transaction Details using Spring Boot & Docker

[1] Components & Scopes:
-----------------------
[1.1] REST API's built using Spring Boot & H2 Database

[1.2] Docker Containerization with Dockerfile and docker-compose.yml

[1.3] Maven for Build

[1.4] Swagger 2.0 for API Documentation & Testing

[1.5] Mockito & JUnit for automated testing

[1.6] Exception & Error Handling


[2] Perquisites for running the Application:
-----------------------------------------------------------
```
JDK 1.8
Maven
Docker
```
[3] Running the Application:
-----------------------------
[3.1] Clone and Open the project
```
git clone https://github.com/er-anuragkumar/anz-account-transaction-apis.git
```
[3.2] Build & Run the Application in Docker Container
```
docker-compose up --build
```
[3.3] Build & Run the Application without Docker
```
mvn clean package

Go to target folder and run the Spring Boot Application 

java -jar anz-account-transactions-0.0.1-SNAPSHOT.jar
```
[4] Swagger Link:
---------------
[4.1] Account API's:
```
http://localhost:8080/swagger-ui.html#/account-controller
```
[4.2] Transaction API's:
```
http://localhost:8080/swagger-ui.html#/transaction-controller
```
[5] H2 Database Console:
------------------------
```
http://localhost:8080/h2
JDBC URL: jdbc:h2:mem:anzaccountdata
User Name: admin
Password: admin
```

[6] REST API's:
-------------

[6.1] getAllAccounts()
```
Full URL: http://localhost:8080/accounts
Method:   GET
Sends:    N/A
Receives: JSON

Sample Response JSON:
[
    {
        "accountNumber": 136056165,
        "accountName": "AUSaving111",
        "accountType": "Savings",
        "balanceDate": "2018-11-08T00:00:00.000+0000",
        "currency": "AUD",
        "balance": 48928.79,
        "userId": "AU2344"
    },
    {
        "accountNumber": 321143048,
        "accountName": "SGCurrent855",
        "accountType": "Current",
        "balanceDate": "2018-11-08T00:00:00.000+0000",
        "currency": "SGD",
        "balance": 38010.62,
        "userId": "AU2344"
    },
    {
        "accountNumber": 847257972,
        "accountName": "AUSaving111",
        "accountType": "Current",
        "balanceDate": "2018-11-08T00:00:00.000+0000",
        "currency": "AUD",
        "balance": 92561.68,
        "userId": "AU2399"
    }
]
```
[6.2] getAccountByAccountNumber()
```
Full URL: http://localhost:8080/accounts/search/account?accountNumber={accountNumber}
Sample URL: http://localhost:8080/accounts/search/account?accountNumber=136056165
Method:   GET
Sends:    N/A
Receives: JSON

Sample Response JSON:
{
    "accountNumber": 136056165,
    "accountName": "AUSaving111",
    "accountType": "Savings",
    "balanceDate": "2018-11-08T00:00:00.000+0000",
    "currency": "AUD",
    "balance": 48928.79,
    "userId": "AU2344"
}
```
[6.3] getAllAccountsByUserId()
```
Full URL: http://localhost:8080/accounts/search/allaccounts?userId={userId}
Sample URL: http://localhost:8080/accounts/search/allaccounts?userId=AU2344
Method:   GET
Sends:    N/A
Receives: JSON

Sample Response JSON:
[
    {
        "accountNumber": 136056165,
        "accountName": "AUSaving111",
        "accountType": "Savings",
        "balanceDate": "2018-11-08T00:00:00.000+0000",
        "currency": "AUD",
        "balance": 48928.79,
        "userId": "AU2344"
    },
    {
        "accountNumber": 793949180,
        "accountName": "AUSaving111",
        "accountType": "Current",
        "balanceDate": "2018-11-08T00:00:00.000+0000",
        "currency": "AUD",
        "balance": 88794.48,
        "userId": "AU2344"
    }
]
```
[6.4] getAllTransactions()
```
Full URL: http://localhost:8080/transactions
Sample URL: http://localhost:8080/transactions
Method:   GET
Sends:    N/A
Receives: JSON

Sample Response JSON:
[
    {
        "transactionId": 1,
        "transactionDate": "12/01/2012",
        "currency": "SGD",
        "debitAmount": 0.0,
        "creditAmount": 9540.98,
        "type": "credit",
        "description": "Interest Received",
        "accountName": "Savings Account",
        "links": []
    },
    {
        "transactionId": 48,
        "transactionDate": "12/01/2012",
        "currency": "AUD",
        "debitAmount": 0.0,
        "creditAmount": 5564.79,
        "type": "credit",
        "description": "Interest Received",
        "accountName": "Current Account",
        "links": []
    }
]
```
[6.5] getTransactionByTransactionId()
```
Full URL: http://localhost:8080/transactions/search/transaction?transactionId={transactionId}
Sample URL: http://localhost:8080/transactions/search/transaction?transactionId=2
Method:   GET
Sends:    N/A
Receives: JSON

Sample Response JSON:
{
    "transactionDate": "12/01/2012",
    "currency": "SGD",
    "debitAmount": 0.0,
    "creditAmount": 7497.82,
    "type": "credit",
    "description": "Interest Received",
    "accountName": "Savings Account"
}
```
[6.6] getAllTransactionByAccountNumber()
```
Full URL: http://localhost:8080/transactions/search/alltransactions?accountNumber={accountNumber}
Sample URL: http://localhost:8080/transactions/search/alltransactions?accountNumber=136056165
Method:   GET
Sends:    N/A
Receives: JSON

Sample Response JSON:
[
    {
        "transactionId": 31,
        "transactionDate": "12/01/2012",
        "currency": "AUD",
        "debitAmount": 0.0,
        "creditAmount": 9540.98,
        "type": "credit",
        "description": "Interest Received",
        "accountName": "Savings Account",
        "links": []
    },
    {
        "transactionId": 33,
        "transactionDate": "12/01/2012",
        "currency": "AUD",
        "debitAmount": 0.0,
        "creditAmount": 5564.79,
        "type": "credit",
        "description": "Interest Received",
        "accountName": "Savings Account",
        "links": []
    }
]
```
