# Movie Directors Microservice

## Overview

This microservice provides a list of the most acclaimed movie directors based on a specified threshold value. The response includes the directors sorted alphabetically.

### Key Features:
- Retrieve a list of movie directors whose acclaim exceeds a configurable threshold.
- The directors are returned as a list of strings in alphabetical order.

---

## API Documentation

The API exposes the following endpoint:

### GET `/api/directors`

**Description:**  
Returns a list of acclaimed movie directors who have directed more movies than the specified threshold.
The microservice fetches data from an external API that provides information about movies, directors, and other related details.

**Query Parameters:**
- `threshold` (required): An integer value representing the minimum number of movies a director must have directed to be included in the response.

**Response:**
- **200 OK**: A list of directors sorted alphabetically.

```json
{
  "directors": [
  "Christopher Nolan",
  "Martin Scorsese",
  "Steven Spielberg"
  ]
}
```

## Swagger Documentation

Swagger is integrated into the microservice to provide interactive API documentation.

Swagger UI: http://localhost:8080/swagger-ui.html

OpenAPI JSON Specification: http://localhost:8080/v3/api-docs


# Setup and Execution

This microservice is built using **Java 17**, **Maven**, and **Spring Boot**. Follow the steps below to set up, build, and run the application.

## Prerequisites

Ensure the following are installed on your system:

- **Java 17** (JDK 17)
- **Maven** (for build automation)
- **Spring Boot** (embedded as part of the Maven dependencies)

## Steps to Run the Microservice

### 1. Clone the Repository

Clone the repository and navigate to the project directory:

```bash
git clone https://github.com/CamiloBoada/movies-microservice.git
cd movies-microservice



