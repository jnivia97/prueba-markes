# 📌 Sistema de Préstamos Bancarios - Spring Boot API REST

Este proyecto consiste en una API REST desarrollada con **Spring Boot** para gestionar un sistema de préstamos bancarios.

## ✅ Funcionalidades principales

El sistema debe permitir a los usuarios:

1. **Solicitar un préstamo:** los usuarios pueden solicitar un préstamo indicando el monto y el plazo.
2. **Aprobar o rechazar préstamos:** los administradores pueden aprobar o rechazar solicitudes de préstamo.
3. **Ver el estado de los préstamos:** los usuarios pueden consultar el estado de sus préstamos (aprobados o rechazados).

## 💻 Interfaz Front-End

Se debe implementar una interfaz en **Angular** o **Thymeleaf** que consuma esta API. Esta interfaz permitirá:

- Enviar solicitudes de préstamo.
- Consultar el estado de los préstamos.
- Permitir a los administradores ver y cambiar el estado de los préstamos.

## 🛠️ Requerimientos Técnicos

### Backend (Spring Boot)

- ✔️ API REST con Spring Boot.
- ✔️ Persistencia con **Spring Data JPA** y **Hibernate Validator**.
- ✔️ Se puede usar **Spring WebFlux** en casos necesarios.
- ✔️ Arquitectura limpia o hexagonal (separación entre dominio, aplicación e infraestructura).
- ✔️ Implementación de **caché** (recomendado: Ehcache).
- ✔️ Seguridad con **Spring Security** (solo administradores pueden aprobar o rechazar préstamos).
- ✔️ Transacciones consistentes en procesos de aprobación.
- ✔️ Test unitarios con **JUnit 5** y **Spring Boot Starter Test**.
- ✔️ Manejo adecuado de errores y respuestas HTTP claras.
- ✔️ Uso de base de datos relacional (**MySQL**, **PostgreSQL**) o en memoria (**H2**).

## Endpoints

Consultar prestamo:

- http://localhost:8084/loan/prestamo?idLoan=1

Crear Prestamo:

http://localhost:8084/loan/new

request:
{
    "monto":[int],
    "plazo":[int],
    "estado":"pendiente",
    "fechaSolicitud": null,
    "fechaRespuesta": null,
    "idUsuario":1,
    "idAdmin":null

}

Actualizar estado:

- http://localhost:8084/loan/update
Request:
{
    "id":[int] (id del prestamo),
    "monto":null,
    "plazo":null,
    "estado":"aprobado" - "rechazado",
    "fechaSolicitud": null,
    "fechaRespuesta": null,
    "idUsuario":null,
    "idAdmin":[int] (id del admin)

}


## ▶️ Ejecución del Proyecto


Para correr el proyecto localmente en el puerto **8084**, utiliza el siguiente comando:

```bash
mvn spring-boot:run
