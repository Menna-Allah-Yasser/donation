FROM maven:3.8.5-openjdk-17 AS build
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:17.0.1-jdk-slim
COPY --from=build /Blood_Donation-0.0.1-SNAPSHOT.war demo.war
EXPOSE 8080
ENTRYPOINT ["java","-war","demo.war"]