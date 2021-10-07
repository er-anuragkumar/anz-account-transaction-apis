# anz-account-transaction-apis
This is a Demo Application built for getting Account & Transaction Details using Spring Boot & Docker

[1] Components & Scopes:
-----------------------
[1.1] REST API's built using Spring Boot & H2 Database

[1.2] JWT Token-based API authentication & User Validaton against local database. 

[1.3] Pagination & Sorting support in the API's

[1.4] Docker Containerization with Dockerfile and docker-compose.yml

[1.5] Maven for Build

[1.6] Swagger 2.0 for API Documentation

[1.7] Test coverage with @SpringBootTest, @WebMvcTest & @DataJpaTest

[1.8] Mockito & JUnit for automated testing

[1.9] Exception & Error Handling


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
[6.1] login()
```
Full URL: http://localhost:8080/auth
Method:   POST
Sends:    JSON
Receives: JSON

Sample Request JSON:
{
    "user": "anzadmin",
    "pwd": "Ax296783@tR!"
}

Sample Response JSON:
{
    "user": "anzadmin",
    "pwd": "",
    "token": "Bearer eyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiJzb2Z0dGVrSldUIiwic3ViIjoiYW56YWRtaW4iLCJhdXRob3JpdGllcyI6WyJST0xFX1VTRVIiXSwiaWF0IjoxNjMzNTYzNTU1LCJleHAiOjE2MzM1NjQxNTV9.TUnrUcWTmbNBanhKRuCz3djFspZqrqvTzx0Wr9-vysJ1wtH6KjgOCfrQq4BbXoMGf3-_XLFOMwEECtNNrJNuEw",
    "expiration": "600"
}
```
[6.2] getAllAccounts()
```
Full URL: http://localhost:8080/accounts?pageSize=5&pageNo=0&sortBy=accountNumber
Method:   GET
Sends:    N/A
Receives: JSON
Headers: Authorization : Bearer eyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiJzb2Z0dGVrSldUIiwic3ViIjoiYW56YWRtaW4iLCJhdXRob3JpdGllcyI6WyJST0xFX1VTRVIiXSwiaWF0IjoxNjMzNTY0NjA2LCJleHAiOjE2MzM1NjUyMDZ9.5DT2kbyfDWqbpCCYj94n2kmTnzkhJG-wSVlUszY1BkQl8AoaPvZmrjhuuUSbtq1at1iXzXdlOzoS1ragCBa2Fw

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
[6.3] getAccountByAccountNumber()
```
Full URL: http://localhost:8080/accounts/search/account
Method:   POST
Sends:    JSON
Receives: JSON
Headers: Authorization : Bearer eyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiJzb2Z0dGVrSldUIiwic3ViIjoiYW56YWRtaW4iLCJhdXRob3JpdGllcyI6WyJST0xFX1VTRVIiXSwiaWF0IjoxNjMzNTY0NjA2LCJleHAiOjE2MzM1NjUyMDZ9.5DT2kbyfDWqbpCCYj94n2kmTnzkhJG-wSVlUszY1BkQl8AoaPvZmrjhuuUSbtq1at1iXzXdlOzoS1ragCBa2Fw

Sample Request JSON:
{
    "accountNumber": 136056165
}

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
[6.4] getAllAccountsByUserId()
```
Full URL: http://localhost:8080/accounts/search/allaccounts?pageSize=5&pageNo=0&sortBy=accountNumber
Method:   POST
Sends:    JSON
Receives: JSON
Headers: Authorization : Bearer eyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiJzb2Z0dGVrSldUIiwic3ViIjoiYW56YWRtaW4iLCJhdXRob3JpdGllcyI6WyJST0xFX1VTRVIiXSwiaWF0IjoxNjMzNTY0NjA2LCJleHAiOjE2MzM1NjUyMDZ9.5DT2kbyfDWqbpCCYj94n2kmTnzkhJG-wSVlUszY1BkQl8AoaPvZmrjhuuUSbtq1at1iXzXdlOzoS1ragCBa2Fw

Sample Request JSON:
{
    "userId": "AU2344"
}

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
[6.5] getAllTransactions()
```
Full URL: http://localhost:8080/transactions?pageSize=5&pageNo=0&sortBy=transactionId
Method:   GET
Sends:    N/A
Receives: JSON
Headers: Authorization : Bearer eyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiJzb2Z0dGVrSldUIiwic3ViIjoiYW56YWRtaW4iLCJhdXRob3JpdGllcyI6WyJST0xFX1VTRVIiXSwiaWF0IjoxNjMzNTY0NjA2LCJleHAiOjE2MzM1NjUyMDZ9.5DT2kbyfDWqbpCCYj94n2kmTnzkhJG-wSVlUszY1BkQl8AoaPvZmrjhuuUSbtq1at1iXzXdlOzoS1ragCBa2Fw

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
[6.6] getTransactionByTransactionId()
```
Full URL: http://localhost:8080/transactions/search/transaction
Method:   POST
Sends:    JSON
Receives: JSON
Headers: Authorization : Bearer eyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiJzb2Z0dGVrSldUIiwic3ViIjoiYW56YWRtaW4iLCJhdXRob3JpdGllcyI6WyJST0xFX1VTRVIiXSwiaWF0IjoxNjMzNTY0NjA2LCJleHAiOjE2MzM1NjUyMDZ9.5DT2kbyfDWqbpCCYj94n2kmTnzkhJG-wSVlUszY1BkQl8AoaPvZmrjhuuUSbtq1at1iXzXdlOzoS1ragCBa2Fw

Sample Request JSON:
{
    "transactionId": 2
}

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
[6.7] getAllTransactionByAccountNumber()
```
Full URL: http://localhost:8080/transactions/search/alltransactions?pageSize=5&pageNo=0&sortBy=transactionId
Method:   POST
Sends:    JSON
Receives: JSON
Headers: Authorization : Bearer eyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiJzb2Z0dGVrSldUIiwic3ViIjoiYW56YWRtaW4iLCJhdXRob3JpdGllcyI6WyJST0xFX1VTRVIiXSwiaWF0IjoxNjMzNTY0NjA2LCJleHAiOjE2MzM1NjUyMDZ9.5DT2kbyfDWqbpCCYj94n2kmTnzkhJG-wSVlUszY1BkQl8AoaPvZmrjhuuUSbtq1at1iXzXdlOzoS1ragCBa2Fw

Sample Request JSON:
{
    "accountNumber": 136056165
}

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
