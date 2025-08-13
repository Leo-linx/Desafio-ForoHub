Desafío: ForoHub Interactivo
Este proyecto es una API REST para un foro de discusión, desarrollada como parte de un desafío de programación. La API permite a los usuarios autenticados crear, leer, actualizar y eliminar tópicos de discusión (CRUD).
La aplicación está construida con Java y Spring Boot 3, utilizando un esquema de seguridad basado en Tokens JWT para proteger los endpoints.

✨ Características Principales
API RESTful: Endpoints claros y consistentes para la gestión de tópicos.
CRUD Completo: Operaciones para Crear, Leer, Actualizar y Eliminar tópicos.
Seguridad con JWT: Autenticación de usuarios y protección de rutas mediante JSON Web Tokens.
Validaciones: Reglas de negocio y validaciones a nivel de DTOs para garantizar la integridad de los datos.
Manejo de Excepciones: Respuestas de error personalizadas y centralizadas para una mejor experiencia del cliente.
Base de Datos PostgreSQL: Persistencia de datos robusta y confiable.

🛠️ Tecnologías Utilizadas
Lenguaje: Java 17
Framework: Spring Boot 3
Dependencias Principales:
spring-boot-starter-web: Para la creación de la API REST.
spring-boot-starter-data-jpa: Para la persistencia de datos con JPA y Hibernate.
spring-boot-starter-security: Para la implementación de la seguridad.
spring-boot-starter-validation: Para las validaciones de los datos de entrada.
jjwt-api, jjwt-impl, jjwt-jackson: Para la generación y validación de Tokens JWT.
Gestor de Dependencias: Maven
Base de Datos: PostgreSQL
Herramienta de Pruebas: Insomnia

🚀 Instalación y Puesta en Marcha
Sigue estos pasos para configurar y ejecutar el proyecto en tu entorno local.
1. Prerrequisitos
JDK 17 o superior.
Apache Maven 3.8 o superior.
PostgreSQL instalado y en ejecución.
Insomnia (o cualquier otro cliente de API REST como Postman).

2. Clonar el Repositorio
code
Bash
git clone <URL_DE_TU_REPOSITORIO>
cd desafio-forohub

3. Configurar la Base de Datos
Abre tu cliente de PostgreSQL (como psql o pgAdmin).
Crea una nueva base de datos para el proyecto.
code
SQL
CREATE DATABASE forohub_db;



🗂️ Estructura del Proyecto (Simplificada)


Code
src/main/java/com/example/forohub
├── controller/       # Controladores REST (manejan las peticiones HTTP)
├── dto/              # Data Transfer Objects (para validaciones y transferencia de datos)
├── exception/        # Manejadores de excepciones globales
├── model/            # Entidades JPA (representan las tablas de la BD)
├── repository/       # Interfaces de Spring Data JPA (para interactuar con la BD)
├── security/         # Clases relacionadas con Spring Security y JWT
└── service/          # Lógica de negocio










