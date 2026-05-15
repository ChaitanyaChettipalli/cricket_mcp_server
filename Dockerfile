# Use a lightweight JDK 25 image
FROM mcr.microsoft.com/openjdk/jdk:25-ubuntu

CMD ["bash"]

LABEL authors="chaitanyachettipalli"

EXPOSE 8082

# Define an argument for the JAR file name
ARG JAR_FILE=build/libs/spring_mcp_server-0.0.1-SNAPSHOT.jar

# Define the command to run the application when the container starts
# Copy the JAR file from your host machine into the container's filesystem
COPY ${JAR_FILE} /app.jar

# Load secrets as environment variables, then start the app
ENTRYPOINT ["java", "-jar", "/app.jar"]