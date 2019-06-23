# Catalog service

This is an example app of how to protect an application with JWT token using spring security
 
### How to run the tests locally

In terminal, in project's home directory exacute: 
`./gradlew test`


### How to run the service locally

Open terminal and go to project's home directory

To start the app run:

`./gradlew bootRun`

To get a jwt token execute:

`./scripts/get-jwt-token.sh`

Get the value of jwttoken property from the response body, it will look something like: 

`Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ1c2VybmFtZSIsImV4cCI6NDcxNDkyMDgzOSwiaWF0IjoxNTYxMzIwODM5fQ.PqAPFDpg6UrKReqBiBbusnVxKYYpfrfg5Vlgi9zvbV1BsOmEUqmTvH2VYuLTSbHalDFJme1VSD7gngCCGVqABg`

and provide it as a parameter for the get-product.sh script. So your call will look like :

`./scripts/get-products.sh "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ1c2VybmFtZSIsImV4cCI6NDcxNDkyMDgzOSwiaWF0IjoxNTYxMzIwODM5fQ.PqAPFDpg6UrKReqBiBbusnVxKYYpfrfg5Vlgi9zvbV1BsOmEUqmTvH2VYuLTSbHalDFJme1VSD7gngCCGVqABg"`





