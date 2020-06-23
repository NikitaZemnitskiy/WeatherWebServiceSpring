FROM openjdk:8
COPY ./application/target/application-0.0.1-SNAPSHOT.jar application-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "application-0.0.1-SNAPSHOT.jar"]
