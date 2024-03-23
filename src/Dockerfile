# Use a Docker image that includes Java 17
FROM openjdk:17-jdk

# Set the working directory inside the container
WORKDIR /app

# Copy the compiled Java application JAR file into the container
COPY build/libs/db-0.0.1-SNAPSHOT.jar .

# Create a directory for static resources
RUN mkdir -p /app/src/main/resources/templates

# Copy the HTML file into the container
COPY src/main/resources/templates/index.html /app/src/main/resources/templates/

# Specify the command to run your Java application when the container starts
CMD ["java", "-jar", "db-0.0.1-SNAPSHOT.jar"]