# 🌱 Sistema de Gestión de Suelos

Este proyecto es una aplicación desarrollada con **Spring Boot** para gestionar registros de suelos. Permite realizar operaciones **CRUD** y utiliza **Spring Data JPA** para interactuar con una base de datos **PostgreSQL** que se ejecuta en un contenedor **Docker**.

Además, se aplica el **patrón de diseño Decorator** para extender la funcionalidad del servicio. En este caso, se implementa un `MetricsDecorator` que mide y registra el tiempo de ejecución de las operaciones.

---

## 🚀 Tecnologías Utilizadas

- ☕ **Java** 21  
- 🌱 **Spring Boot** 3.4.4
- 📦 **Spring Data JPA**  
- 🐘 **PostgreSQL** (en Docker)  
- 🧰 **Maven**  
- ✨ **Lombok**

---

## 🧱 Estructura del Proyecto

### 🧬 Dominio

- **Modelo**: `Soil` con atributos:
  - `id`, `type`, `ubication`, `ph`, `moisture`, `nitrogen`, `phosphorus`, `potassium`, `organicMatter`, `contaminantLevel`, `classification`, `managementRecommendation`.

- **Repositorio**: Interfaz que extiende `JpaRepository` para operaciones CRUD.

### 🧠 Aplicación

- **Servicio**: Interfaz `SoilService` y su implementación `SoilServiceImpl`.
- **Decorador**: `MetricsDecorator` para medir el rendimiento de los métodos CRUD.

### ▶️ Ejecución

Inicia la aplicación desde la clase:

```java
SoilMonitoringApplication
```

### 🛠️ Infraestructura

- **Controladores REST**: Exponen endpoints para interactuar con el servicio.
- **Configuración**: Clase de configuración que encadena el servicio y el `MetricsDecorator`.

---

## ✨ Funcionalidades

- 🔹 **CRUD**: Crear, leer, actualizar (PUT/PATCH) y eliminar registros.
- 🔹 **Métricas**: `MetricsDecorator` registra los tiempos de ejecución de las operaciones.

---

## ⚙️ Configuración

### 🐳 Base de Datos (Docker)

Ejecuta este comando para iniciar el contenedor PostgreSQL:

```bash
docker run --name postgres-suelos \
  -e POSTGRES_USER=admin \
  -e POSTGRES_PASSWORD=admin \
  -e POSTGRES_DB=suelos \
  -p 5432:5432 \
  -d postgres

```
## ⚙️ Otros

### 🔧 `application.properties`

```properties
spring.application.name=monitoreo_suelos
spring.datasource.url=jdbc:postgresql://localhost:5432/suelos
spring.datasource.username=admin
spring.datasource.password=admin
spring.datasource.driver-class-name=org.postgresql.Driver
spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

```
---

### 📡 Endpoints

```markdown
### 📡 Endpoints

| Método | Endpoint        | Descripción                                                                 |
|--------|------------------|-----------------------------------------------------------------------------|
| POST   | `/soils`         | Crea un nuevo registro. `classification` y `managementRecommendation` se generan automáticamente. |
| GET    | `/soils`         | Lista todos los registros.                                                 |
| GET    | `/soils/{id}`    | Obtiene un registro específico.                                            |
| PUT    | `/soils/{id}`    | Actualiza completamente un registro.                                       |
| PATCH  | `/soils/{id}`    | Actualiza parcialmente un registro.                                        |
| DELETE | `/soils/{id}`    | Elimina un registro.                                                       |


