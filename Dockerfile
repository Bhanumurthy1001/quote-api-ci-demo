# ------------------------------------------------------------
# Stage 1: Build the application using Maven
# ------------------------------------------------------------
FROM eclipse-temurin:17-jdk AS build

# Set working directory
WORKDIR /app

# Copy Maven descriptor and source code
COPY pom.xml .
COPY src ./src

# Package the application (skip tests to speed up CI/CD build)
RUN ./mvnw clean package -DskipTests || mvn clean package -DskipTests

# ------------------------------------------------------------
# Stage 2: Create the final lightweight runtime image
# ------------------------------------------------------------
FROM eclipse-temurin:17-jdk-jammy

# Set working directory
WORKDIR /app

# Copy built jar from the build stage
COPY --from=build /app/target/quote-api-1.0-SNAPSHOT.jar app.jar

# Define default command
CMD ["java", "-jar", "app.jar"]
