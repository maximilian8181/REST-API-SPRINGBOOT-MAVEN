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

## Iniciar la Aplicación

Para ejecutar la aplicación, sigue estos pasos:

1. **Descargar el proyecto**: Descarga el archivo ZIP del proyecto desde el repositorio y descomprímelo en tu sistema local.

2. **Importar el proyecto**: Abre tu IDE de preferencia, como IntelliJ IDEA o Eclipse, y utiliza la opción de importar proyectos Maven para cargar el proyecto en el entorno.

3. **Ejecutar la clase principal**: Una vez importado, localiza la clase `SpringbootAppApplication` dentro del proyecto. Esta clase contiene el método `main`, que es el punto de entrada de la aplicación.

4. **Ejecutar la aplicación**: Haz clic derecho sobre la clase `SpringbootAppApplication` y selecciona la opción de "Run" o "Ejecutar". Esto iniciará la aplicación Spring Boot en tu entorno local.
