FROM openjdk:11.0.4-jre-slim-buster
EXPOSE 8080
ADD ./app/target/app-0.0.1-SNAPSHOT.jar /app/
CMD ["java", "-jar", "/app/app-0.0.1-SNAPSHOT.jar"]