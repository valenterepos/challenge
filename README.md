# CODE CHALLENGE

#### Requirements
Before running the application, ensure you have the following installed:

* Java 17

* Docker (latest version recommended)

* Maven

* Postgres

* JMeter (for performance testing)
#### Installation and Setup

1. Clone the Repository

git clone https://github.com/valenterepos/challenge

git checkout master

2. Start the Application

Use the provided script to start the application with Docker:

./start.sh

This script will:

* Start the PostgreSQL database and the application container

* Wait for the database to be ready

* Insert initial data into the database

* Confirm that the application is running

Once completed, the application will be accessible at:

* Swagger UI: http://localhost:8080/swagger-ui/index.html

* Direct API Requests: http://localhost:8080

#### Testing Endpoints

1. Create a consult

To create a consult send a POST request to /consults endpoint:

curl -X POST http://localhost:8080/consults \
-H "Content-Type: application/json" \
-d '{"doctorId": 1, "patientId": 2}'

2. Retrieve Patient Consults and Symptoms

To get all consultations and symptoms for a specific patient (example: patient ID = 1):

curl -X GET http://localhost:8080/patients/1/consults


3. Get top specialties

To get all specialities send a GET request:
curl -X GET http://localhost:8080/consults/topSpecialities


4. Retrieve All Patients

To list all patients, send a GET request:

curl -X GET http://localhost:8080/patients


#### Logs and Debugging

To check the logs of the application container:

docker logs hospital-app --tail=100

#### To stop the application:

docker compose stop


#### Restart the Application

docker compose start 
or docker-compose up -d hospital_app if there are any changes to the code


#### Performance Testing with JMeter

Performance tests were conducted using JMeter. You can import and run the provided TestJMETER.jmx file:

1. Open JMeter

2. Import the file TestJMETER.jmx

3. Make sure that the application is running

3. Run the test and view results on Results Tree


#### Notes
The application uses Hibernate with PostgreSQL. Tables are automatically created based on the entity classes.

If you encounter issues with database schema creation, check spring.jpa.hibernate.ddl-auto in application.properties or application.yml.

For additional troubleshooting, check the logs and ensure all required services are running.

To check the logs run:
docker logs -f hospital_app


* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/3.4.2/maven-plugin)
* [Create an OCI image](https://docs.spring.io/spring-boot/3.4.2/maven-plugin/build-image.html)
* [Spring Data JPA](https://docs.spring.io/spring-boot/3.4.2/reference/data/sql.html#data.sql.jpa-and-spring-data)

### Guides
The following guides illustrate how to use some features concretely:

* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)
