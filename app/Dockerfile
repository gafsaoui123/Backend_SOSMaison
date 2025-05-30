# Étape 1 : Build avec Maven
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app
# Copie séparée pour une meilleure utilisation du cache Docker
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Étape 2 : Image finale
FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 10000
ENTRYPOINT ["java", "-jar", "app.jar"]