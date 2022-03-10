FROM openjdk:latest
COPY ./target/SEM_GROUP22-0.1.0.7-jar-with-dependencies.jar /tmp
WORKDIR /tmp
ENTRYPOINT ["java", "-jar", "SEM_GROUP22-0.1.0.7-jar-with-dependencies.jar"]