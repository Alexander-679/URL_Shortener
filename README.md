URL Shortener

A simple and efficient URL Shortener built using Java Spring Boot, MySQL, and a modern HTML/CSS/JavaScript frontend.
This application converts long URLs into short, shareable links and redirects users to the original URL when accessed.

1. Features

Convert long URLs into short URLs

Fast redirection to original links

Clean and modern user interface

Copy-to-clipboard functionality

Persistent storage using MySQL

RESTful backend architecture

2. Tech Stack

Backend

Java

Spring Boot

Spring Data JPA

MySQL

Frontend

HTML

CSS

JavaScript (Fetch API)

3. Project Structure
url-shortener
│
├── controller     → Handles HTTP requests
├── service        → Business logic
├── repository     → Database access layer
├── model          → Entity classes
│
├── static
│   ├── index.html
│   ├── style.css
│   └── script.js
│
└── application.properties

4. How It Works

The user enters a long URL in the UI

The frontend sends the URL to the backend using a REST API

The backend generates a unique short code

The original URL and short code are stored in the database

When the short URL is accessed, the user is redirected to the original URL

5. API Endpoints
Shorten URL
POST /api/shorten


Request Body

{
  "url": "https://www.example.com"
}

Redirect URL
GET /r/{shortCode}

6. Database

The application uses MySQL for persistent storage.
Tables are automatically created using Hibernate (JPA).

7. How to Run the Project

Clone the repository

Configure MySQL credentials in application.properties

Start MySQL server

Run the Spring Boot application

Open browser and visit:

http://localhost:8080/index.html

8. Key Learnings

REST API design using Spring Boot

Layered architecture (Controller, Service, Repository)

Database integration with JPA & Hibernate

Frontend–Backend communication using Fetch API

UI enhancement using modern CSS

9. Future Enhancements

URL validation

Click count analytics

Custom short URLs

Link expiration

User authentication

Author

Sandrapati Alexander
Java Backend Developer (Fresher)
Passionate about building scalable backend applications and learning modern web technologies.
