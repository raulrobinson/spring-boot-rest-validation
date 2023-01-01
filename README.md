# Java Spring Boot REST Validation

Bean validation and custom validator.

### GET ALL MOVIES.
curl -X GET "http://localhost:8081/api/v1/spring-boot-rest-validation/movies" -H "accept: application/json"

```json
[
    {
        "id": 1,
        "name": "El martir del Calvario",
        "author": "Miguel Morayta",
        "score": 15.41
    },
    {
        "id": 2,
        "name": "La pasion de Cristo",
        "author": "Mel Gibson",
        "score": 9.69
    },
    {
        "id": 3,
        "name": "Le Tout Nouveau Testament",
        "author": "Jaco van Dormael",
        "score": 47.99
    }
]
```

### CREATE MOVIE. 

curl -X POST "http://localhost:8081/api/v1/spring-boot-rest-validation/movies" -H "accept: application/json" -H "Content-Type: application/json" -d "{ \"author\": \"string\", \"id\": 0, \"name\": \"string\", \"score\": 0}"

```json
{
    "id": 4,
    "name": "string",
    "author": "string",
    "score": 0
}
```

### GET MOVIE BY ID.

curl -X GET "http://localhost:8081/api/v1/spring-boot-rest-validation/movies/1" -H "accept: application/json"

```json
{
    "id": 1,
    "name": "El martir del Calvario",
    "author": "Miguel Morayta",
    "score": 15.41
}
```

### SAVE OR UPDATE MOVIE.

curl -X PUT "http://localhost:8081/api/v1/spring-boot-rest-validation/movies/2" -H "accept: application/json" -H "Content-Type: application/json" -d "{ \"author\": \"nuevo\", \"name\": \"nombre nuevo\", \"score\": 15}"

```json
{
    "id": 2,
    "name": "nombre nuevo",
    "author": "nuevo",
    "score": 15
}
```

### DELETE MOVIE.

curl -X DELETE "http://localhost:8081/api/v1/spring-boot-rest-validation/movies/1" -H "accept: application/json"

### MANAGE HANDLER EXCEPTION.

curl -X PATCH "http://localhost:8081/api/v1/spring-boot-rest-validation/movies/3" -H "accept: application/json" -H "Content-Type: application/json" -d "{ \"additionalProp1\": \"string\", \"additionalProp2\": \"string\", \"additionalProp3\": \"string\"}"

```json
{
    "timestamp": "2023-01-01T21:09:16.170+00:00",
    "status": 405,
    "error": "Method Not Allowed",
    "path": "/api/v1/spring-boot-rest-validation/movies/3"
}

```
