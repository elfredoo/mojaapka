FROM maven:3.9.9-eclipse-temurin-23 AS MAVEN_BUILD
COPY ./pom.xml ./pom.xml
RUN mvn dependency:go-offline -B
COPY ./src ./src
RUN mvn clean package

FROM openjdk:23
EXPOSE 8080
COPY --from=MAVEN_BUILD target/security-*.jar /app.jar
ENTRYPOINT ["java","-jar","/app.jar"]

