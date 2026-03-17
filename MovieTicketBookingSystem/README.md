# Movie Ticket Booking System

This project is a Spring Boot microservices implementation for movie discovery and ticket booking.

## Services

- `config-server` (`8888`): centralized configuration source
- `eureka-server` (`8761`): service registry
- `movie-service` (`8081`): movie catalog APIs
- `booking-service` (`8082`): booking APIs and movie-service integration
- `api-gateway` (`8080`): single entry point and routing

## Prerequisites

- Java 21+ installed
- Maven 3.9+ (or use each module's `mvnw.cmd`)
- Windows PowerShell (for helper scripts)

## Run Order

Start services in this order to avoid registration/config timing issues:

1. `config-server`
2. `eureka-server`
3. `movie-service`
4. `booking-service`
5. `api-gateway`

You can use the helper script:

```powershell
powershell -ExecutionPolicy Bypass -File .\start-all.ps1
```

To stop all started windows by title:

```powershell
powershell -ExecutionPolicy Bypass -File .\stop-all.ps1
```

## API Quick Test

Gateway route examples:

- `GET http://localhost:8080/movies`
- `POST http://localhost:8080/bookings`

Eureka dashboard:

- `http://localhost:8761`

## Notes

- Each module is independently buildable via Maven.
- Root `.gitignore` excludes generated build outputs and IDE artifacts.