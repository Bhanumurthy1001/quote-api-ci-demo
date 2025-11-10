# ------------------------------------------------------------
# Stage 1: Build the application using Maven
# ------------------------------------------------------------
FROM eclipse-temurin:17-jdk AS build

# Install Maven
RUN apt-get update && apt-get install -y maven && rm -rf /var/lib/apt/lists/*

# Set working directory
WORKDIR /app

# Copy Maven descriptor and source code
COPY pom.xml .
COPY src ./src

# Package the application
RUN mvn clean package -DskipTests

# ------------------------------------------------------------
# Stage 2: Create the final lightweight runtime image
# ------------------------------------------------------------
FROM eclipse-temurin:17-jdk-jammy

# Set working directory
WORKDIR /app

# Copy the jar from the previous stage
COPY --from=build /app/target/quote-api-1.0-SNAPSHOT.jar app.jar

# Run the application
CMD ["java", "-jar", "app.jar"]

