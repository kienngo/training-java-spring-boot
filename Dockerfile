# Use an appropriate base image that includes Java and Gradle
FROM gradle:latest as builder

# Set the working directory
WORKDIR /app

# Copy the Gradle files
COPY build.gradle .
COPY settings.gradle .

# Copy the source code
COPY src src

# Build the application
RUN gradle build

# Create a new lightweight image for the application
FROM openjdk:17-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the built jar file from the builder stage
COPY --from=builder /app/build/libs/*.jar app.jar

# Set the timezone environment variable
#ENV TZ=UTC

# Command to run the application
CMD ["java", "-jar", "app.jar"]
