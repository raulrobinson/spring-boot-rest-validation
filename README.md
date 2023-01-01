# Java Spring Boot REST Validation

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

curl -X POST "http://localhost:8081/api/v1/spring-boot-rest-validation/movies" -H "accept: application/json" -H "Content-Type: application/json" -d "{ \"author\": \"string\", \"id\": 0, \"name\": \"string\", \"score\": 0}"

```json
{
  "id": 4,
  "name": "string",
  "author": "string",
  "score": 0
}
```