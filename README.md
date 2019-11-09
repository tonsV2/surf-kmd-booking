# Simple KMD bookings aggregator

## Inspiration
* https://guides.micronaut.io/micronaut-http-client-kotlin/guide/index.html
* https://micronaut-projects.github.io/micronaut-views/latest/guide/
* https://devcenter.heroku.com/articles/container-registry-and-runtime#getting-started

## Run locally
```bash
export AUTHENTICATION_CODE=xxx
./gradlew run
```

## Run locally with Docker
```bash
./gradlew jibDockerBuild
docker run -it -p 8080:8080 --env-file .env registry.heroku.com/surf-kmd-booking/web
```
Or with docker-compose
```bash
docker-compose up
```

## Deploy to Heroku
```bash
docker login --username=_ --password=$(heroku auth:token) registry.heroku.com
./gradlew jib
heroku container:release web
```
