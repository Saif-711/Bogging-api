# Blogging Platform API

Project link: https://roadmap.sh/projects/blogging-platform-api

## Tech
Spring Boot (Maven) + MySQL + JPA

## Local run (recommended with Docker)
1. Start MySQL + API:
```powershell
docker compose up --build
```
2. API will be available at: `http://localhost:8888/posts`

## Local run (without Docker)
1. Create DB:
```sql
CREATE DATABASE blogging;
```
2. Configure MySQL credentials in `System/System/src/main/resources/application.properties`
3. Build & run:
```powershell
cd System\System
mvn spring-boot:run
```

## Endpoints
`/posts`
- `GET /posts` - get all posts
- `GET /posts/{id}` - get one post
- `POST /posts` - create post
- `PUT /posts/{id}` - update post
- `DELETE /posts/{id}` - delete post

### Create/Update JSON
```json
{
  "title": "My title",
  "content": "Post content",
  "category": "Tech",
  "tags": ["java", "spring"]
}
```

## CI/CD (GitHub Actions)
This repo includes `.github/workflows/ci.yml` which runs:
- `mvn test`
- `mvn package`
using a MySQL service in the workflow.

## Render deploy
Deployment files are included:
- `render.yaml`
- `DEPLOY_RENDER.md`

Follow `DEPLOY_RENDER.md` step-by-step.

