# Use OpenJDK 17 as base image
FROM openjdk:17-jdk-slim

# Set working directory
WORKDIR /app

# Copy built jar file
COPY target/quote-api-1.0-SNAPSHOT.jar app.jar

# Expose no ports since it's a CLI app
CMD ["java", "-jar", "app.jar"]
