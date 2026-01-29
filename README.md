# URL Shortener Backend System

A RESTful backend application built using Java, Spring Boot, and MySQL that converts long URLs into short, shareable links and redirects users to the original URLs.

---

## Overview

This project demonstrates backend development fundamentals including REST API design, layered architecture, database integration, and request validation. It is designed to reflect real-world backend workflows and Software Development Life Cycle (SDLC) practices.

---

## Problem Statement

Long URLs are difficult to manage and share. The goal of this project is to provide a backend service that generates unique short URLs and reliably redirects users to the original long URLs.

---

## Solution

The application exposes REST APIs to:
- Generate a short URL for a given long URL
- Redirect users from the short URL to the original URL
- Persist URL mappings using a relational database

---

## Tech Stack

- Language: Java  
- Framework: Spring Boot  
- Database: MySQL  
- Build Tool: Maven  
- API Testing: Postman  

---

## Features

- REST API for URL shortening
- URL redirection handling
- Persistent storage using MySQL
- Layered architecture (Controller, Service, Repository)
- Input validation and exception handling

---

## Project Structure

src/
├── controller/ # REST API endpoints
├── service/ # Business logic
├── repository/ # Database access layer
├── model/ # Entity classes
└── application.properties

yaml
Copy code

---

## API Endpoints

| Endpoint | Method | Description |
|--------|--------|------------|
| `/api/shorten` | POST | Generate a short URL |
| `/r/{shortCode}` | GET | Redirect to original URL |

### Sample Request

POST /api/shorten
Content-Type: application/json

{
"url": "https://example.com/very/long/url"
}

yaml
Copy code

---

## How to Run the Application

1. Clone the repository:
   ```bash
   git clone https://github.com/Alexander-679/URL_Shortener.git
Create a MySQL database (for example: url_shortener_db).

Update database credentials in application.properties.

Build and run the application:

bash
Copy code
mvn clean install
mvn spring-boot:run
Test the APIs using Postman or any REST client.

Key Learnings
REST API development using Spring Boot

Database integration with MySQL

Layered architecture and separation of concerns

API testing and validation

Basic backend error handling strategies

Future Improvements
Add URL click analytics

Support custom short URLs

Implement URL expiration

Add unit and integration tests

Author
Sandrapati Alexander
Final-year B.Tech student (AI & Data Science)
Aspiring Software Engineering Intern
