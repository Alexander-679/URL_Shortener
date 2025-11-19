# Java Full-Stack URL Shortener (Spring Boot + React)

A modern, full-stack application designed to shorten long URLs and redirect users efficiently.  
This project demonstrates proficiency in building robust RESTful APIs with Spring Boot and creating dynamic, state-managed user interfaces with React.js.

---

## 🌟 Key Features

| Feature              | Description                                                                 | Stack Demonstrated             |
|----------------------|-----------------------------------------------------------------------------|--------------------------------|
| **URL Shortening API** | Generates a unique, short, 6-character alphanumeric code for any URL.        | Spring Boot, Service Layer     |
| **Efficient Redirection** | Uses a dedicated Spring `@Controller` to find the long URL and perform a 302 redirect. | Spring MVC, Routing            |
| **Persistence**        | Stores the mapping between short code and long URL in an in-memory database. | Spring Data JPA, H2 Database   |
| **CORS Handling**      | Configured to allow the React frontend (port 3000) to communicate with backend (8080). | Spring Security / Web Config   |
| **Responsive UI**      | Clean, intuitive frontend interface for URL input and displaying results. | React.js, State Management     |

---

## 💻 Technologies Used

### **Backend**
- Java 17+
- Spring Boot 3+
- Spring Data JPA
- H2 Database
- Maven

### **Frontend**
- React.js
- JavaScript (ES6+)
- Fetch API

### **Tools**
- VS Code

---

## 🚀 Getting Started

Follow these steps to run the application locally.

### **Prerequisites**
- Java Development Kit (JDK) 17+
- Node.js & npm (or yarn)
- Maven

---

## 1. Backend Setup & Run

Navigate to the backend directory:

cd backend

Run the Spring Boot application:

./mvnw spring-boot:run


Wait until the server starts on port 8080.

2. Frontend Setup & Run

Open a second terminal and navigate to the frontend:

cd frontend


Install dependencies:

npm install


Start the React development server:

npm start


The app will open in your browser at:

http://localhost:3000

⚙️ Backend Endpoints (API Documentation)
1. Shorten URL

POST /api/v1/shorten
Request Body:

{ "longUrl": "..." }


Response Body:

{ "shortUrl": "http://localhost:8080/aBcD12" }

2. Redirect

GET /{shortCode}
Redirects (302) to the original long URL.

💡 Architecture Overview

This project follows a standard Client–Server Architecture:

The React client (port 3000) sends the long URL via
POST /api/v1/shorten.

The Spring Boot controller receives the request and forwards it to the UrlService.

The UrlService:

Generates a unique short code

Saves the mapping using the UrlMappingRepository (JPA + H2)

Returns the full short URL

The React UI displays the short URL.

When opening the short URL (http://localhost:8080/{code}), the RedirectController performs a lookup and issues a 302 Redirect to the original long URL.

```bash
cd backend
