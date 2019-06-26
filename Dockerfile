FROM openjdk:11-jdk-slim as builder
COPY . /
RUN ./gradlew build --no-daemon

FROM openjdk:11-jre-slim as runner
COPY --from=builder build/libs/catalog-service-0.0.1-SNAPSHOT.jar /deployment/app.jar
WORKDIR /deployment
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]