FROM maven:3.9.4-amazoncorretto-21-debian-bookworm AS MAVEN_BUIL
COPY ./pom.xml ./pom.xml
RUN mvn dependency:go-offline -B
COPY ./src ./src
RUN mvn package

FROM openjdk:23
EXPOSE 8080
COPY --from=MAVEN_BUILD /target/security-*.jar /app.jar
ENTRYPOINT ["java","-jar","/app.jar"]

