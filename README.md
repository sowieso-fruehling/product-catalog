# Product catalog

Provides REST CRUD api to authenticated user. 

Currently only one user can be authenticated and he's credentials are username/password

In memory H2 database is used as a product repository and it is populated at the application startup. 

Api is versioned using URI versioning technique

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

###Dockerize the app

Open terminal and go to project's home directory. To create docker image run:

`./scripts/create-docker-image.sh`

to run this image, execute:

`./scripts/run-docker-image.sh`

If you're having slower machine, before you continue, be sure that you see a message like: `"INFO 1 --- [           main] d.b.a.c.ProductServiceApplication        : Started ProductServiceApplication in xxx seconds"`

Now you can use the same scripts (get-jwt-token, get-products) as in `How to run the service locally`, to access your containerized app

To stop your container, you can do ctrl+c

### How to run the tests locally

In terminal, in project's home directory exacute: 
`./gradlew test`

