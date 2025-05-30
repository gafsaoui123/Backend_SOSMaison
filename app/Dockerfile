# Étape 1 : Construction avec Maven
FROM maven:3.9.6-eclipse-temurin-17 AS builder

# Définit le répertoire de travail
WORKDIR /app

# Copie les fichiers de configuration Maven en premier (optimisation du cache)
COPY pom.xml .
COPY .mvn/ .mvn
COPY mvnw .
COPY src/ src/

# Exécute le build Maven
RUN mvn clean package -DskipTests

# Étape 2 : Image d'exécution finale
FROM eclipse-temurin:17-jre-alpine

WORKDIR /app

# Copie le JAR depuis l'étape de build
COPY --from=builder /app/target/*.jar app.jar

# Port exposé (doit correspondre à celui de votre application)
EXPOSE 10000

# Commande de lancement
ENTRYPOINT ["java", "-jar", "app.jar"]