# REST-API-SPRINGBOOT-MAVEN
Implementación de una API RESTful para la gestión de usuarios y sus direcciones. La aplicación ha sido desarrollada utilizando Spring Boot.

## Documentación Técnica

**Información del Proyecto**

* **Creado por:** Maximiliano Salazar Rosales
* **Fecha:** 20/08/2024
* **Versión:** v1.0.0
* **Tecnologías:** Java, Spring Boot, Maven, IntelliJ IDEA, Postman
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

```xml
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

## API Endpoints

### User Endpoints

**GET /api/v1/users?sortedBy={attribute}**

* **Descripción:** Obtiene una lista de usuarios, ordenada por el atributo especificado.
* **Request:** GET http://localhost:8080/api/v1/users?sortedBy=email
* **Response:**
```json
[
    {
        "id": 124,
        "email": "user1@mail.com",
        "name": "user2",
        "password": "1f8ac10f23c5b5bc1167bda84b833e5c057a77d2",
        "createdAt": "20-08-2024 21:52:25",
        "addresses": {
            "workaddress": {
                "id": 3,
                "street": "Street No. 3",
                "countryCode": "US"
            },
            "homeaddress": {
                "id": 4,
                "street": "Street No. 4",
                "countryCode": "CA"
            }
        }
    },
    {
        "id": 123,
        "email": "user2@mail.com",
        "name": "user1",
        "password": "7c4a8d09ca3762af61e59520943dc26494f8941b",
        "createdAt": "20-08-2024 21:52:25",
        "addresses": {
            "workaddress": {
                "id": 1,
                "street": "Street No. 1",
                "countryCode": "UK"
            },
            "homeaddress": {
                "id": 2,
                "street": "Street No. 2",
                "countryCode": "AU"
            },
            "mexicoaddress": {
                "id": 5,
                "street": "Del Carmen 26",
                "countryCode": "MX"
            }
        }
    }
]
```

**GET /api/v1/users/{user_id}/addresses**

* **Descripción:** Obtiene una lista de direcciones asociadas al ID del usuario.
* **Request:** GET http://localhost:8080/api/v1/users/123/addresses
* **Response:**
```json
[
    {
        "id": 1,
        "street": "Street No. 1",
        "countryCode": "UK"
    },
    {
        "id": 2,
        "street": "Street No. 2",
        "countryCode": "AU"
    },
    {
        "id": 5,
        "street": "Del Carmen 26",
        "countryCode": "MX"
    }
]
```

**POST /api/v1/users**

* **Descripción:** Agrega un nuevo usuario al array.
* **Request:** POST http://localhost:8080/api/v1/users
* **Body:**
```json
{
    "id": 356,
    "email": "user3@gmail.com",
    "name": "Richie",
    "password": "456789",
    "createdAt": null,
    "addresses": {
        "workaddress": {
            "id": 1,
            "street": "Fascination Street",
            "countryCode": "UK"
        },
        "homeaddress": {
            "id": 2,
            "street": "Pico Boulevard",
            "countryCode": "US"
        }
    }
}
```
* **Response:**
```json
{
    "id": 356,
    "email": "user3@gmail.com",
    "name": "Richie",
    "password": "456789",
    "createdAt": null,
    "addresses": {
        "workaddress": {
            "id": 1,
            "street": "Fascination Street",
            "countryCode": "UK"
        },
        "homeaddress": {
            "id": 2,
            "street": "Pico Boulevard",
            "countryCode": "US"
        }
    }
}
```

**PUT /api/v1/users/{user_id}/addresses/{address_id}**

* **Descripción:** Actualiza una dirección asociada tanto al ID del usuario como al ID del domicilio.
* **Request:** PUT http://localhost:8080/api/v1/users/356/addresses/1
* **Body:**
```json
{
    "id": 1,
    "street": "Cuckoo Avenue",
    "countryCode": "CN"
}
```
* **Response:**
```json
{
    "id": 1,
    "street": "Cuckoo Avenue",
    "countryCode": "CN"
}
```

**PATCH /api/v1/users/{user_id}**

* **Descripción:** Actualiza atributo de usuario asociado por un ID.
* **Request:** PATCH http://localhost:8080/api/v1/users/369
* **Body:**
```json
{
    "name": "Josh"
}
```
* **Response:**
```json
{
    "id": 369,
    "email": "wufudufu@email.com",
    "name": "Josh",
    "password": "75aaaecf714a8797fc8acc2df8e3bd51b88264dc",
    "createdAt": "20-08-2024 22:22:38",
    "addresses": {
        "homeaddress": {
            "id": 9,
            "street": "Wacko Street",
            "countryCode": "SP"
        },
        "workaddress": {
            "id": 10,
            "street": "Misery District 84",
            "countryCode": "UK"
        },
        "spainaddress": {
            "id": 12,
            "street": "Centro 42",
            "countryCode": "AR"
        }
    }
}
```

**DELETE /api/v1/users/{user_id}**

* **Descripción:** Elimina usuario asociado por un ID.
* **Request:** DELETE http://localhost:8080/api/v1/users/369
* **Response:**
```json
User deleted successfully
```

## Herramientas y tecnologías

* **Spring Boot:** Framework principal utilizado para desarrollar la API.
* **Maven:** Gestión de dependencias y construcción del proyecto.
* **IntelliJ IDEA:** IDE utilizado para el desarrollo del proyecto.
* **Postman:** Prueba de endpoints

## Requisitos para Ejecutar la Aplicación

Para poder ejecutar esta aplicación, es necesario cumplir con los siguientes requisitos:

1. **Java Development Kit (JDK) 17**
2. **IDE compatible con Maven**
