# Portfolio Service

## Service Overview

This service is written in Kotlin and is responsible for processing portfolio-related data. It provides a classic REST API for interacting with portfolio information. It is part of the larger portfolio management application and communicates with other services via REST APIs.

## Main README

For the overall project description and demo instructions, see the main README [here](https://github.com/PawelSolecki/PRTF#).

## Tech Stack
![Kotlin](https://img.shields.io/badge/kotlin-%237F52FF.svg?style=flat-square&logo=kotlin&logoColor=white) 
![Spring Boot](https://img.shields.io/badge/Spring_Boot-6DB33F?style=flat-square&logo=springboot&logoColor=white) 
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-336791?style=flat-square&logo=postgresql&logoColor=white) 
![Flyway](https://img.shields.io/badge/Flyway-0077C9?style=flat-square&logo=flyway&logoColor=white)
![OpenFeign](https://img.shields.io/badge/OpenFeign-0078D7?style=flat-square) 
![OAuth2](https://img.shields.io/badge/OAuth2-000000?style=flat-square&logo=oauth&logoColor=white)

## Setup & Configuration

### 1. Run with Docker Compose (recommended)
   1.	Make sure you have Docker and Docker Compose installed.
2.	From the project root, run:
```shell
docker compose up --build
   ```
   3.	The service will be available at:
      http://localhost:8082


**Environment variables are defined in the .env file.**

Example:
```
DB_USER=user
DB_PASSWORD=password
```


