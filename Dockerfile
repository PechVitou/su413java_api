# Use Java 21 base image
FROM eclipse-temurin:21-jdk

# Set working directory
WORKDIR /app

# Copy Gradle wrapper and build files
COPY gradlew .
COPY gradle gradle
COPY build.gradle settings.gradle ./

# Copy source code
COPY src src

# Make Gradle wrapper executable
RUN chmod +x ./gradlew

# Build the Spring Boot JAR (skip tests for faster build)
RUN ./gradlew bootJar -x test

# Expose the port Render will use
EXPOSE 8080

# Run the Spring Boot application
CMD ["sh", "-c", "java -jar app.jar --server.port=$PORT"]
