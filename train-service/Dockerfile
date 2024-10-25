# Build stage
FROM openjdk:17-jdk-slim AS build

# Install Maven
RUN apt-get update && apt-get install -y maven

# Copy pom.xml to the container
COPY pom.xml ./

# Resolve dependencies
RUN mvn dependency:go-offline

# Copy source files
COPY src src

# Build the application
RUN mvn clean install -DskipTests -Dcheckstyle.skip=true

# Runtime stage
FROM openjdk:17-jdk-slim
WORKDIR /app

# Copy the built jar file
COPY --from=build target/*.jar app.jar

# Set the entry point for the container
ENTRYPOINT ["java", "-jar", "app.jar"]
