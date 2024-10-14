FROM maven:3.8.3-openjdk-17 as build
WORKDIR /app
COPY . .
RUN mvn clean install -Dmaven.test.skip=true


FROM openjdk:17-jdk-alpine3.14
WORKDIR /app
COPY --from=build ./app/target/*.jar .
EXPOSE 8080
CMD [ "java", "-jar", "./orm-0.0.1-SNAPSHOT.jar" ]
