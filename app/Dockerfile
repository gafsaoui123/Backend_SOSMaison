# Étape 1 : Build avec Maven
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app
COPY app/pom.xml .
COPY . .
RUN mvn clean package -DskipTests

# Étape 2 : Image finale avec JDK seulement
FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar

# Port exposé
EXPOSE 10000

# Commande de lancement
ENTRYPOINT ["java", "-jar", "app.jar"]
