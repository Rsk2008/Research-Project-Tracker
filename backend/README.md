# Research Project Tracker - Backend (Spring Boot)

Implements entities (Project, Milestone, Document, User), JWT auth, and REST endpoints exactly as specified.

## Requirements
- Java 17
- Maven
- MySQL (or MariaDB)

## Configure
Edit `src/main/resources/application.properties` with your DB creds and a strong `jwt.secret`.

## Run
```bash
mvn spring-boot:run
```

## API (selection)
- `POST /api/auth/signup`
- `POST /api/auth/login`
- `GET /api/projects`, `GET /api/projects/{id}`, `POST /api/projects`, `PUT /api/projects/{id}`, `PATCH /api/projects/{id}/status`, `DELETE /api/projects/{id}`
- `GET /api/projects/{id}/milestones`, `POST /api/projects/{id}/milestones`, `PUT /api/milestones/{id}`, `DELETE /api/milestones/{id}`
- `GET /api/projects/{id}/documents`, `POST /api/projects/{id}/documents`, `DELETE /api/documents/{id}`
- `GET /api/users`, `GET /api/users/{id}`, `DELETE /api/users/{id}`

Swagger UI at `/swagger-ui/index.html`.
