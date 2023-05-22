# Use a minimalistic version of the OpenJDK 11 JRE as the base image
FROM openjdk:11-jre-slim

# Copy the JAR file to the container
ARG JAR_FILE

COPY target/${JAR_FILE} ExamThourayaS2-0.0.1-SNAPSHOT.jar

EXPOSE 8089

# Run the JAR file when the container starts
CMD ["java","-jar", "ExamThourayaS2-0.0.1-SNAPSHOT.jar"]