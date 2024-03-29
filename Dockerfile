# Build
FROM maven:3.5-jdk-8-alpine AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package

# Package
FROM openjdk:8-jdk-alpine
COPY --from=build /home/app/target/anz-account-transactions-0.0.1-SNAPSHOT.jar /usr/local/lib/anz-account-transactions.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/usr/local/lib/anz-account-transactions.jar"]