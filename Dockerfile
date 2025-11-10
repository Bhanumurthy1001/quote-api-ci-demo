# Use OpenJDK 17 base image
FROM eclipse-temurin:17-jdk-jammy

WORKDIR /app
COPY target/quote-api-1.0-SNAPSHOT.jar app.jar

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]

# Health check
HEALTHCHECK --interval=30s --timeout=5s --start-period=10s --retries=3 \
  CMD curl -f http://localhost:8080/health || exit 1
