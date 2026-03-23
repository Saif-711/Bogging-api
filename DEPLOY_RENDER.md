# Deploy To Render (A-Z)

## 1) Push latest code to GitHub
From repo root:

```powershell
git add .
git commit -m "add render deployment config and env-based app settings"
git push origin main
```

## 2) Prepare a production MySQL database
Render does not provide managed MySQL in all plans/regions, so use any hosted MySQL provider.
You need:

- `SPRING_DATASOURCE_URL` (example: `jdbc:mysql://<host>:3306/blogging?sslMode=REQUIRED`)
- `SPRING_DATASOURCE_USERNAME`
- `SPRING_DATASOURCE_PASSWORD`

## 3) Create Web Service on Render
1. Open Render dashboard.
2. Click **New +** -> **Blueprint**.
3. Select your GitHub repo.
4. Render will detect `render.yaml`.
5. Create service.

## 4) Set environment variables in Render
In Render service -> **Environment**, set:

- `SPRING_DATASOURCE_URL`
- `SPRING_DATASOURCE_USERNAME`
- `SPRING_DATASOURCE_PASSWORD`

Optional:

- `SPRING_JPA_HIBERNATE_DDL_AUTO=update`
- `SPRING_JPA_SHOW_SQL=false`

Note: Render provides `PORT` automatically. App already uses it.

## 5) Deploy and verify
1. Trigger deploy (or wait for auto deploy).
2. Open service URL and test:

- `GET https://<your-service>.onrender.com/posts`
- `POST https://<your-service>.onrender.com/posts`

## 6) Troubleshooting
- **App starts then fails DB connection**: check DB host/port/user/password and network allowlist.
- **SSL error with hosted DB**: add SSL options in JDBC URL, e.g. `?sslMode=REQUIRED`.
- **Slow first request** on free plan: service may be sleeping.
