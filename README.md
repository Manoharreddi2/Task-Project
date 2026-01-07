# Task Management API (Spring Boot + JWT)

A secure **Task Management REST API** built using **Spring Boot**, **Spring Security (JWT)**, **JPA/Hibernate**, and **MySQL**.  
Implements **JWT-based authentication** and **user-specific task management**.

---

## Features
- User Registration & Login
- JWT Authentication (Stateless)
- Secure APIs with Spring Security
- Create, View & Delete Tasks
- Password encryption using BCrypt
- MySQL database integration

---

## Tech Stack
- Java 21  
- Spring Boot  
- Spring Security + JWT  
- Spring Data JPA / Hibernate  
- MySQL  
- Maven  

---


## 📂 Project Structure


com.manohar.taskproject
│
├── controller
│ ├── AuthController
│ └── TaskController
│
├── entity
│ ├── Users
│ └── Task
│
├── repository
│ ├── UserRepository
│ └── TaskRepository
│
├── service
│ ├── TaskService
│ └── UserService
│
├── serviceimpl
│ ├── TaskServiceImpl
│ └── UserServiceImpl
│
├── security
│ ├── JwtTokenProvider
│ ├── JwtAuthenticationFilter
│ └── CustomUserDetailsService
│
├── securityconfig
│ └── SecurityConfig
│
├── payload
│ ├── LoginDto
│ ├── UserDto
│ ├── TaskDto
│ └── JWTAuthResponse
│
├── exception
│ ├── APIException
│ ├── UserNotFound
│ └── TaskNotFound
│
└── TaskprojectApplication

## API Flow
1. Register user  
2. Login to generate JWT token  
3. Use token to access protected APIs  

---

## API Endpoints

### Register
