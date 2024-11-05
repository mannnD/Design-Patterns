
# Loyalty and Reward Project Documentation

## Overview

This project, named "rewardsvc", is a Spring Boot application designed to handle loyalty and reward functionalities. It is set up as a Maven project with Java 11 and uses Spring Boot version 2.7.3.

## Project Structure

The project follows a standard Maven project structure:

```
rewardsvc/
├── .mvn/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── cashfree/
│   │   │           └── rewardsvc/
│   │   │               └── GoodVibes.java
│   │   └── resources/
│   │       └── application.properties
│   └── test/
│       └── java/
│           └── com/
│               └── cashfree/
│                   └── rewardsvc/
│                       └── RewardsvcApplicationTests.java
├── .gitignore
├── mvnw
├── mvnw.cmd
└── pom.xml
```

## Main Application

The main application class is `GoodVibes.java`, which is annotated with `@SpringBootApplication`. This class contains the `main` method to run the Spring Boot application.

## Dependencies

The project uses the following major dependencies:

- Spring Boot Starter Data JPA
- Spring Boot Starter Thymeleaf
- Spring Boot Starter WebFlux
- Spring Boot DevTools
- MySQL Connector Java
- Lombok
- Spring Boot Starter Test
- Reactor Test

## Configuration

The `application.properties` file contains the following configurations:

- Database connection details (MySQL)
- JPA/Hibernate configurations

## Database

The application is configured to connect to a MySQL database named `cfsellers` running on localhost. The database user is set to `nfcpay` with the password `nfcpay.123`.

## Testing

A basic test class `RewardsvcApplicationTests.java` is included, which contains a simple test to load the application context.

## Build and Run

The project uses Maven for build management. To build and run the project:

1. Ensure you have Java 11 and Maven installed.
2. Navigate to the project root directory.
3. Run `./mvnw spring-boot:run` (for Unix-based systems) or `mvnw.cmd spring-boot:run` (for Windows).

## Notes for Developers

- The project is set up with Spring Boot's auto-configuration, which means many standard configurations are handled automatically.
- Lombok is used to reduce boilerplate code. Ensure your IDE has Lombok support.
- The project is configured for automatic schema updates with `spring.jpa.hibernate.ddl-auto=update`. Be cautious with this in production environments.
- WebFlux is included as a dependency, indicating that the application might be using reactive programming paradigms.
