# Image Maven pour builder l'application
FROM maven:3.9.1-eclipse-temurin-17 AS build

WORKDIR /app

# Copie les fichiers Maven
COPY pom.xml .
COPY src ./src

# Compile et package l'application
RUN mvn clean package -DskipTests

# Image runtime pour exécuter le JAR
FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

# Copie le JAR depuis l'image build
COPY --from=build /app/target/*.jar app.jar

# Expose le port
EXPOSE 8080

# Démarre l'application
ENTRYPOINT ["java", "-jar", "app.jar"]