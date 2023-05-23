FROM openjdk:11
ADD /target/ExamThourayaS2-0.0.1-SNAPSHOT.jar target/app.jar
RUN bash -c "touch target/app.jar"
ENTRYPOINT ["java", "-jar", "target/app.jar"]
EXPOSE 8089