# Étape 1 : utiliser une image Java officielle
FROM openjdk:17-jdk-alpine

WORKDIR /app
COPY --from=build /app/app/target/*.jar app.jar

# Étape 4 : exposer le port (par défaut 8080)
EXPOSE 10000

# Étape 5 : commande de lancement
ENTRYPOINT ["java", "-jar", "app.jar"]