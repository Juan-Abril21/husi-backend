# Build stage
FROM eclipse-temurin:17-jdk AS build
WORKDIR /app

COPY gradlew .
COPY gradle gradle
COPY build.gradle .
COPY settings.gradle .

RUN chmod +x ./gradlew
RUN ./gradlew dependencies

COPY src src

RUN ./gradlew build -x test

# Runtime stage
FROM eclipse-temurin:17-jre
WORKDIR /app

COPY --from=build /app/build/libs/*.jar app.jar

ENV SPRING_PROFILES_ACTIVE=prod

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]