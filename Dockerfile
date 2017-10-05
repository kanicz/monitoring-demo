FROM java:8-jdk-alpine
ENTRYPOINT ["java", "-jar", "/app.jar"]
ADD build/libs/monitoring-demo-0.0.1-SNAPSHOT.jar app.jar
