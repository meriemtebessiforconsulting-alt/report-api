# Utilise l'image Java officielle
FROM eclipse-temurin:17-jdk-alpine

# Définit le répertoire de travail
WORKDIR /app

# Copie les fichiers Maven
COPY pom.xml .
COPY src ./src

# Compile l'application
RUN ./mvnw clean package -DskipTests

# Copie le JAR généré
COPY target/*.jar app.jar

# Expose le port de l'application
EXPOSE 8080

# Commande pour démarrer l'application
ENTRYPOINT ["java", "-jar", "app.jar"]
