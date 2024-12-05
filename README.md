## Pasos para Iniciar el Proyecto con Maven

### Requisitos Previos
Asegúrate de tener instalados los siguientes componentes:
- **Java 21** o una versión compatible.
- **Maven** (verifica si Maven está instalado ejecutando `mvn -v` en la terminal).

### Clonar el Repositorio
Si el proyecto está alojado en un repositorio remoto (como GitHub), puedes clonarlo utilizando Git:

git clone https://github.com/eduballesteros/API-WebProject.git

### Verificar la Configuración de Maven
Asegúrate de que el proyecto contiene el archivo pom.xml en su raíz. Este archivo define todas las dependencias, el ciclo de vida del proyecto y otras configuraciones necesarias.

### Configurar la Base de Datos
Si estás utilizando una base de datos (como MySQL o PostgreSQL), asegúrate de que el archivo application.properties o application.yml esté correctamente configurado.

### Ejemplo de configuración para MySQL en application.properties:

properties
-  spring.datasource.url=jdbc:mysql://localhost:3306/tu_base_de_datos
-  spring.datasource.username=tu_usuario
-  spring.datasource.password=tu_contraseña
-  spring.jpa.hibernate.ddl-auto=update
-  spring.jpa.show-sql=true

### Construir el Proyecto
En la terminal, navega hasta el directorio raíz del proyecto y ejecuta el siguiente comando para construir el proyecto con Maven:
mvn clean install

Después de construir el proyecto, puedes ejecutar la aplicación de Spring Boot con Maven usando el siguiente comando:
- mvn spring-boot:run 
Esto iniciará el servidor y la aplicación estará disponible para su uso.

### Verificar la Ejecución
Una vez que la aplicación esté en ejecución, deberías ver un mensaje en la terminal indicando que el servidor está corriendo, normalmente en http://localhost:8080.

### Probar la API
Ahora puedes probar los endpoints de la API utilizando herramientas como Postman o cURL.

# Controladores
Esta sección describe los controladores disponibles en la API, sus métodos HTTP y los parámetros.

## Controlador de Usuarios
El controlador de Usuarios maneja todas las operaciones relacionadas con la entidad Usuarios. Permite crear, obtener, autenticar y borrar usuarios.

Endpoints
### 1. Crear Usuario
- **Método HTTP**: `POST`
- **Endpoint**: `/api/usuarios`
- **Descripción**: Crea un nuevo usuario.

#### Cuerpo de la solicitud:
```json
[
{
  "nickUser": "usuario1",
  "nameUser": "Usuario Uno",
  "passwordUser": "password123",
  "email": "usuario@dominio.com"
}
]
```

### 3. Autenticar Usuario
- **Método HTTP**: `POST`
- **Endpoint**: `/api/usuarios/authenticate`
- **Descripción**: `Autentica a un usuario utilizando su nickname y contraseña.`


 #### Cuerpo de la solicitud:
```json

{
  "nickUser": "usuario1",
  "passwordUser": "password123"
}
```



# DTOs (Data Transfer Objects)

### 1. **UsuarioDTO**
Este DTO representa la estructura de datos de un **Usuario**.

#### Estructura:
```json
{
  "idUser": 1,
  "nickUser": "usuario1",
  "nameUser": "Usuario Uno",
  "passwordUser": "password123",
  "email": "usuario@dominio.com"
}
```
- idUser: ID único del usuario (generado automáticamente por la base de datos).
- nickUser: Nickname del usuario, utilizado para autenticación.
- nameUser: Nombre completo del usuario.
- passwordUser: Contraseña del usuario.
- email: Correo electrónico del usuario.

# Modelos
### Campos y Tipos de Datos de los Modelos **Usuario** y **Club**

#### **Modelo Usuario**

| Campo          | Tipo de Dato       | Descripción                                                                 |
|----------------|--------------------|-----------------------------------------------------------------------------|
| `idUser`       | `Long`             | Identificador único del usuario (clave primaria). Se genera automáticamente. |
| `nickUser`     | `String` (50)      | Nombre de usuario único utilizado para la autenticación. (No puede ser nulo) |
| `nameUser`     | `String` (100)     | Nombre completo del usuario. (No puede ser nulo)                            |
| `passwordUser` | `String` (255)     | Contraseña del usuario. (No puede ser nulo)                                 |
| `dni`          | `String` (15)      | Número de identificación único del usuario (DNI). (No puede ser nulo)      |
| `email`        | `String` (100)     | Correo electrónico único del usuario. (No puede ser nulo)                   |
| `address`      | `String` (255)     | Dirección del usuario (opcional).                                           |
| `imgUser`      | `String` (2083)    | Ruta de la imagen del usuario (opcional).                                    |
| `admin`        | `Boolean`          | Indicador de si el usuario es administrador o no (por defecto `FALSE`).      |
| `idClub`       | `Long`             | Clave foránea que hace referencia al club al que pertenece el usuario.      |



# Servicios de la API

### **Servicio de Usuarios**

El servicio de usuarios maneja toda la lógica relacionada con las operaciones CRUD de la entidad **Usuarios**. Estas operaciones incluyen la creación, actualización, obtención y eliminación de usuarios.

#### **Métodos Disponibles**

1. **Crear Usuario**
   - **Descripción**: Crea un nuevo usuario en la base de datos.
   - **Método**: `POST`
   - **Endpoint**: `/api/usuarios`
   - **Parámetros**:
     ```json
     {
       "nickUser": "usuario1",
       "nameUser": "Usuario Uno",
       "passwordUser": "password123",
       "email": "usuario@dominio.com"
     }
     ```
   - **Respuesta**:
     ```json
     {
       "idUser": 1,
       "nickUser": "usuario1",
       "nameUser": "Usuario Uno",
       "email": "usuario@dominio.com"
     }
     ```
   - **Descripción**: Este servicio crea un nuevo usuario con los datos proporcionados en la solicitud.


3. **Autenticar Usuario**
   - **Descripción**: Autentica un usuario utilizando su nickname , email y contraseña.
   - **Método**: `POST`
   - **Endpoint**: `/api/usuarios/authenticate`
   - **Parámetros**:
     ```json
     {
       "nickUser": "usuario1",
       "passwordUser": "password123"
     }
     ```
   - **Respuesta**:
     ```json
     {
       "status": "success",
       "message": "User authenticated successfully."
     }
     ```
   - **Descripción**: Este servicio autentica un usuario validando su nickname y contraseña.


---

