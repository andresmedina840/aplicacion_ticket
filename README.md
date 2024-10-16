# Proyecto de Gestión de Tickets - Spring Boot MySQL

Este proyecto es una API para la gestión de tickets, desarrollada con **Spring Boot** y una base de datos **MySQL** utilizando contenedores Docker.

## Tecnologías Utilizadas

- **Java 21 - Amazon Corretto**
- **Spring Boot**
- **MySQL 8**
- **Docker & Docker Compose**
- **Maven**
- **Lombok**

## Prerrequisitos

Antes de ejecutar el proyecto, asegúrate de tener instalados los siguientes componentes:

- [Docker](https://www.docker.com/get-started)
- [Docker Compose](https://docs.docker.com/compose/install/)
- [JDK 21](https://docs.aws.amazon.com/corretto/latest/corretto-21-ug/downloads-list.html)
- [Maven](https://maven.apache.org/install.html)

## Configuración del Entorno

El proyecto utiliza un archivo `.env` para definir las variables de entorno necesarias para la configuración de la base de datos MySQL.

### Crear el archivo `.env`

En la raíz del proyecto, debe crear un archivo llamado `.env` con el siguiente contenido:

MYSQL_DATABASE=ticketsdb
MYSQL_ROOT_PASSWORD=rootpassword
MYSQL_USER=user
MYSQL_PASSWORD=password
TZ=America/Bogota

## Instrucciones para clona el proyecto

git clone https://github.com/andresmedina840/aplicacion_ticket.git
cd aplicacion_ticket

## Instrucciones para correr la aplicación y crear la base de datos MySql
## Construir y ejecutar los contenedores con Docker Compose

Para correr la base de datos MySQL y la aplicación, utiliza Docker Compose con el archivo docker-compose_ticket.yml, deben
estar ubicados donde esta el archivo .yml:

docker-compose -f docker-compose_ticket.yml up -d --build

## Detener el contenedor de la base de datos MySql y Spring Boot

Para detener y eliminar los contenedores, ejecuta el siguiente comando:

docker-compose -f docker-compose_ticket.yml down

