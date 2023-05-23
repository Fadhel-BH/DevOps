FROM openjdk:11
ADD /target/ExamThourayaS2-0.0.1-SNAPSHOT.jar tpThourayaProject.jar
ENTRYPOINT ["java", "-jar", "tpThourayaProject.jar"]