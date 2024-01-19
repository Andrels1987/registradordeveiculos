FROM maven:3.9.0-eclipse-temurin-17-alpine AS build

COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:19


COPY --from=build /target/registradordeveiculos-0.0.1-SNAPSHOT.jar registradordeveiculos.jar
EXPOSE 8023

ENTRYPOINT ["java", "-jar", "registradordeveiculos.jar"]