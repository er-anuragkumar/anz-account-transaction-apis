# anz-account-transaction-apis
This is a Demo Application built for getting Account & Transaction Details using Spring Boot & Docker

[1] Prequisites for running the Application:
-----------------------------------------------------------
```
JDK 1.8
Maven
Docker
```
[2] Running the Application:
-----------------------------
[2.1] Clone and Open the project
```
git clone https://github.com/er-anuragkumar/anz-account-transaction-apis.git
```
[2.2] Build & Run the Application in Docker Container
```
docker-compose up --build
```
[2.3] Build & Run the Application without Docker
```
mvn clean package

Go to target folder and run the Spring Boot Application 

java -jar anz-account-transactions-0.0.1-SNAPSHOT.jar
```
[3] Swagger Link:
---------------
[3.1] Account API's:
```
http://localhost:8080/swagger-ui.html#/account-controller
```
[3.2] Transaction API's:
```
http://localhost:8080/swagger-ui.html#/transaction-controller
```
[4] REST API's:
-------------

[4.1] getAllAccounts()
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
[4.2] getAccountByAccountNumber()
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
[4.3] getAllAccountsByUserId()
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
[4.4] getAllTransactions()
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
[4.5] getTransactionByTransactionId()
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
[4.6] getAllTransactionByAccountNumber()
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
