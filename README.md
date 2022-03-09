# Adobe Engineering Task : Roman Numeral convertor

The aim of this task was to build an API endpoint which converts an integer to its Roman Numeral representation (a String).
I used Spring Boot to create the endpoint because I was already a bit familiar with the framework. And I made the algorithm using Java.
 
### Roman Numerals Specification

https://en.wikipedia.org/wiki/Roman_numerals

### Required Environment

- Java 11
- Maven 3.8.4

#### Dependencies (handled by Maven)

- Spring Boot 2.6.4

### Running the server

Ensure port 8080 is free on your machine.

Inside current directory run :

`mvn clean`

`mvn package`

`java -jar .\target\aem_engineering_test-0.0.1-SNAPSHOT.jar`

Modern IDEs like IntelliJ IDEA are also capable of building and running the application.

### Endpoint usage

Once the server is started, navigate to `localhost:8080/romannumeral?query={integer}` with "integer" being an integer between 1 and 255.

### Error handling

The endpoint will return a 400 status code and a string error message in the following cases : 
- No parameter given.
- The query parameter isn't an integer.
- The query parameter doesn't belong to the range 1-255.

### Testing

The class `RomanNumeralConverter` responsible for converting an integer to a roman numeral has been tested using Junit 5.
Tests are located inside `src\test\java\com.example.aem_engineering_test`.

To run the tests, use :

``mvn test``

I did not consider integration testing relevant for this endpoint.