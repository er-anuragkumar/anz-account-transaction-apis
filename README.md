# anz-account-transaction-apis

Spring Boot REST application to get account details and transactions details.

- [1 Project Setup and Build](#1-project-setup-and-build)
  * [1-a Clone the project](#1-a-Clone-the-project)
  * [1-b Open the project and build the package](#1-b-Open-the-project-and-build-the-package)
  * [1-c Go to target folder and run the Spring Boot Application](#1-c-run-spring-boot)
- [2 Swagger Link](#2-swagger-link)
  * [2-a Account API's](#2-a-Account-API)
  * [2-b Transaction API's](#2-b-Transaction-API)
- [3 REST API's](#3-REST-API's)
  * [3-a getAllAccounts()](#3-a-getAllAccounts)
  * [3-b getAccountByAccountNumber()](#3-b-getAccountByAccountNumber)
  * [3-c getAllAccountsByUserId()](#3-c-getAllAccountsByUserId)
  * [3-d getAllTransactions()](#3-d-getAllTransactions)
  * [3-e getTransactionByTransactionId()](#3-e-getTransactionByTransactionId)
  * [3-f getAllTransactionByAccountNumber()](#3-f-getAllTransactionByAccountNumber)
- [4 Test Plan Postman](#4-Test-Plan-Postman)

1 Project Setup and Build
-------------------------
1-a Clone the project:
-----------------------
```
git clone https://github.com/er-anuragkumar/anz-account-transaction-apis.git
```
1-b Open the project & build the package:
------------------------------------------
```
mvn clean package
```
1-c Go to target folder and run the Spring Boot Application:
------------------------------------------------------------
```
java -jar anz-account-transactions-0.0.1-SNAPSHOT.jar
```
2 Swagger Link:
---------------

2-a Account API's:
------------------
```
http://localhost:8080/swagger-ui.html#/account-controller
```
2-b Transaction API's:
----------------------
```
http://localhost:8080/swagger-ui.html#/transaction-controller
```
3 REST API's:
-------------

3-a getAllAccounts()
---------------------
```
Full URL: http://localhost:8080/accounts
Method:   GET
Sends:    N/A
Receives: JSON

Sample Response JSON:
[
    {
        "accountNumber": 9467563426,
        "accountName": "SGSaving726",
        "accountType": "Savings",
        "balanceDate": "2018-11-07T13:00:00.000+0000",
        "currency": "SGD",
        "balance": 84327.51,
        "userId": "AU2344"
    },
	.
	.
	.
	.
	.
	.
	.
	.
	.
	.
    {
        "accountNumber": 9876459851,
        "accountName": "AUCurrent569",
        "accountType": "Current",
        "balanceDate": "2018-11-07T13:00:00.000+0000",
        "currency": "AUD",
        "balance": 41327.28,
        "userId": "AU2344"
    },
    {
        "accountNumber": 9876459867,
        "accountName": "SGCurrent855",
        "accountType": "Current",
        "balanceDate": "2018-11-07T13:00:00.000+0000",
        "currency": "SGD",
        "balance": 38010.62,
        "userId": "AU2344"
    }
]
```
3-b getAccountByAccountNumber()
-------------------------------
```
Full URL: http://localhost:8080/accounts/search/account?accountNumber={accountNumber}
Sample URL: http://localhost:8080/accounts/search/account?accountNumber=9467563426
Method:   GET
Sends:    N/A
Receives: JSON

Sample Response JSON:
{
    "accountNumber": 9467563426,
    "accountName": "SGSaving726",
    "accountType": "Savings",
    "balanceDate": "2018-11-07T13:00:00.000+0000",
    "currency": "SGD",
    "balance": 84327.51,
    "userId": "AU2344"
}
```
3-c getAllAccountsByUserId()
----------------------------
```
Full URL: http://localhost:8080/accounts/search/allaccounts?userId={userId}
Sample URL: http://localhost:8080/accounts/search/allaccounts?userId=AU2344
Method:   GET
Sends:    N/A
Receives: JSON

Sample Response JSON:
[
    {
        "accountNumber": 9467563426,
        "accountName": "SGSaving726",
        "accountType": "Savings",
        "balanceDate": "2018-11-07T13:00:00.000+0000",
        "currency": "SGD",
        "balance": 84327.51,
        "userId": "AU2344"
    },
    {
        "accountNumber": 9876443652,
        "accountName": "AUSaving111",
        "accountType": "Current",
        "balanceDate": "2018-11-07T13:00:00.000+0000",
        "currency": "AUD",
        "balance": 88794.48,
        "userId": "AU2344"
    },
    {
        "accountNumber": 9876457865,
        "accountName": "AUSaving111",
        "accountType": "Savings",
        "balanceDate": "2018-11-07T13:00:00.000+0000",
        "currency": "AUD",
        "balance": 48928.79,
        "userId": "AU2344"
    },
    {
        "accountNumber": 9876459851,
        "accountName": "AUCurrent569",
        "accountType": "Current",
        "balanceDate": "2018-11-07T13:00:00.000+0000",
        "currency": "AUD",
        "balance": 41327.28,
        "userId": "AU2344"
    },
    {
        "accountNumber": 9876459867,
        "accountName": "SGCurrent855",
        "accountType": "Current",
        "balanceDate": "2018-11-07T13:00:00.000+0000",
        "currency": "SGD",
        "balance": 38010.62,
        "userId": "AU2344"
    }
]
```
3-d getAllTransactions()
-------------------------
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
    .
	.
	.
	.
	.
	.
	.
	.
	.
	.
	.
    {
        "transactionId": 47,
        "transactionDate": "12/01/2012",
        "currency": "AUD",
        "debitAmount": 0.0,
        "creditAmount": 7497.82,
        "type": "credit",
        "description": "Interest Received",
        "accountName": "Current Account",
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
3-e getTransactionByTransactionId()
-----------------------------------
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
3-f getAllTransactionByAccountNumber()
---------------------------------------
```
Full URL: http://localhost:8080/transactions/search/alltransactions?accountNumber={accountNumber}
Sample URL: http://localhost:8080/transactions/search/alltransactions?accountNumber=9467563426
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
	.
	.
	.
	.
	.
	.
	.
	.
	.
    {
        "transactionId": 5,
        "transactionDate": "12/01/2012",
        "currency": "SGD",
        "debitAmount": 0.0,
        "creditAmount": 9442.46,
        "type": "credit",
        "description": "Interest Received",
        "accountName": "Savings Account",
        "links": []
    },
    {
        "transactionId": 6,
        "transactionDate": "12/01/2012",
        "currency": "SGD",
        "debitAmount": 0.0,
        "creditAmount": 7614.45,
        "type": "credit",
        "description": "Interest Received",
        "accountName": "Savings Account",
        "links": []
    }
]
```
4 Test Plan Postman:
--------------------
[Test Plan Postman](https://github.com/er-anuragkumar/anz-account-transaction-apis/blob/master/test/Test-Plan-ANZ-Account-Transactions-API-Postman.postman_collection.json)
