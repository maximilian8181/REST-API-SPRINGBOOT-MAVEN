# REST-API-SPRINGBOOT-MAVEN
implementación de una API RESTful para la gestión de usuarios y sus direcciones. La aplicación ha sido desarrollada utilizando Spring Boot.

## Documentación Técnica

**Información del Proyecto**

* **Creado por:** Maximiliano Salazar Rosales
* **Fecha:** 20/08/2024
* **Versión:** v1.0.0
* **Tecnologías:** Java, Spring Boot, Maven, IntelliJ IDEA
* **Objetivo:** Desarrollar una API que permita realizar operaciones CRUD sobre usuarios y direcciones, con cifrado de contraseñas y manejo de fechas de creación.

## Arquitectura del Proyecto

El proyecto está organizado en los siguientes paquetes:

* **model**: Contiene las clases de datos, como `User` y `Address`.
* **repository**: Define la capa de acceso a datos, con `UserRepository`.
* **service**: Implementa la lógica de negocio y operaciones sobre los datos.
* **controller**: Maneja las solicitudes HTTP y mapea los endpoints a las operaciones del servicio.
* **util**: Contiene utilidades, como `PasswordUtil` para el cifrado de contraseñas.

## Dependencias Clave

El proyecto utiliza las siguientes dependencias clave, especificadas en el archivo `pom.xml`:

```
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-test</artifactId>
        <scope>test</scope>
    </dependency>
</dependencies>
```
