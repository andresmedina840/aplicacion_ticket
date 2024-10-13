# Etapa 1: Construcción de la aplicación
FROM maven:3.9.8-eclipse-temurin-21 AS build

# Definir el directorio de trabajo a /app
WORKDIR /app

# Copiar los archivos de configuración de Maven (pom.xml)
COPY pom.xml .

# Descargar las dependencias de Maven para aprovechar el caché de Docker
RUN mvn dependency:go-offline -B

# Copiar el resto de los archivos del proyecto
COPY src ./src

# Compilar el proyecto y crear el paquete. Utiliza el perfil 'dev' y omite las pruebas
RUN mvn clean package -Pdev -DskipTests

# Etapa 2: Ejecución de la aplicación
FROM eclipse-temurin:21-jdk-alpine

# Definir el directorio de trabajo a /app
WORKDIR /app

# Copiar el archivo JAR de la etapa anterior
COPY --from=build /app/target/*.jar app.jar

# Exponer el puerto en el que la aplicación escucha (8085)
EXPOSE 8085

# Definir el punto de entrada para iniciar la aplicación con opciones de memoria ajustadas
ENTRYPOINT ["java", "-Xms512m", "-Xmx1024m", "-XX:+UseG1GC", "-jar", "app.jar"]
