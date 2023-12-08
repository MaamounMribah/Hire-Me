FROM openjdk:17-jdk

WORKDIR /app

COPY target/springboot-backend-0.0.1-SNAPSHOT.jar /app/offersback.jar

EXPOSE 8081:8081

CMD ["java", "-jar", "offersback.jar"]