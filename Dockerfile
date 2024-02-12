FROM openjdk:21

WORKDIR /app

COPY target/cliente-0.0.1-SNAPSHOT.jar .


CMD ["java", "-jar", "cliente-0.0.1-SNAPSHOT.jar"]
