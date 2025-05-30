# Étape 1 : utiliser une image Java officielle
FROM openjdk:17-jdk-alpine

# Étape 2 : dossier où le JAR sera copié
WORKDIR /app

# Étape 3 : copier le jar dans l'image
COPY target/*.jar app.jar

# Étape 4 : exposer le port (par défaut 8080)
EXPOSE 9090

# Étape 5 : commande de lancement
ENTRYPOINT ["java", "-jar", "app.jar"]