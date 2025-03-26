# Build Stage
FROM maven:3.8.4-openjdk-17-slim as build

# Set the working directory inside the container for the build process
WORKDIR /app

# Copy the pom.xml and source code to the container
COPY pom.xml .
COPY src ./src

# Run Maven to build the JAR file
RUN mvn clean package -DskipTests

# Runtime Stage
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file from the build stage (target directory in build stage)
COPY --from=build /app/target/tablet-tracker-backend-0.0.1-SNAPSHOT.jar app.jar

# Expose the port for the application
EXPOSE 8080

# Command to run the Spring Boot application
ENTRYPOINT ["java", "-jar", "app.jar"]
