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

# Build the project (skip tests to speed up)
RUN ./gradlew build -x test

# Copy built JAR to a known name
RUN cp build/libs/web-api-product-0.0.1-SNAPSHOT.jar app.jar

# Expose port
EXPOSE 8080

# Run the application using Render-assigned port
CMD ["sh", "-c", "java -jar app.jar --server.port=$PORT"]
