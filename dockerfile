FROM openjdk:11
copy /target/ExamThourayaS2-0.0.1-SNAPSHOT.jar tpThourayaProject01.jar
CMD ["java", "-jar", "tpThourayaProject01.jar"]