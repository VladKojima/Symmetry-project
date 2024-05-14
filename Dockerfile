FROM maven:3.8.4-openjdk-17 as build
WORKDIR /usr/app
COPY ./authserver ./authserver
RUN mvn -f ./authserver/pom.xml clean install
COPY ./backend ./backend
RUN mvn -f ./backend/pom.xml clean package

FROM eclipse-temurin:17-jre-alpine
COPY --from=build /usr/app/backend/target/*.jar app.jar
EXPOSE 8080

ENTRYPOINT [ "java", "-jar", "app.jar" ]