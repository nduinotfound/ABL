FROM openjdk:21-ea-21-jdk-slim

WORKDIR /app

COPY target/*.jar app.jar

EXPOSE 9000

CMD ["java", "-jar", "app.jar"]