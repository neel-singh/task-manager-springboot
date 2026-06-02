# Task Manager API

A robust RESTful API for managing tasks, built with Java, Spring Boot, Spring Data JPA, and Lombok.

## 🚀 Features

    CRUD Operations: Create, Read, Update, and Delete tasks.

    Flexible Lookups: Retrieve and update tasks by ID or by unique Title.

    Status Management: Dedicated endpoint to mark tasks as complete.

    Error Handling: Global exception handling for cleaner API responses.

    Validation: Built-in constraint validation for task due dates.

## 🛠 Tech Stack

    Java 17+

    Spring Boot

    Spring Data JPA (Hibernate)

    Lombok (for boilerplate code reduction)

    H2/MySQL/PostgreSQL (Configure in application.properties)

## 📋 API Endpoints

Method	Endpoint	Description
POST	/task	Create a new task
GET	/task	Retrieve all tasks
GET	/task/{id}	Get task by ID
GET	/task/title/{title}	Get task by title
PUT	/task/{id}	Update task by ID
PUT	/task/title/{title}	Update task by title
PATCH	/task/{id}/complete	Mark task as complete
DELETE	/task/{id}	Delete task by ID

## ⚙️ How to Run

    Clone the repository:
    Bash

    git clone <your-repository-url>

    Configure Database: Check src/main/resources/application.properties and ensure your database connection string, username, and password are correct.

    Build and Run:
    Bash

    ./mvnw spring-boot:run

    Access API: The server will start on http://localhost:8080.

## 🛡 Exception Handling

The API includes a GlobalExceptionHandler that intercepts errors:

    Returns 404 Not Found when a requested task does not exist.

    Returns 500 Internal Server Error for unexpected system issues.

## 📝 License

This project is open-source and available for educational purposes.
