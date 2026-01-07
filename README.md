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

```
com.manohar.taskproject
├── controller
│   ├── AuthController.java
│   └── TaskController.java
│
├── entity
│   ├── Users.java
│   └── Task.java
│
├── repository
│   ├── UserRepository.java
│   └── TaskRepository.java
│
├── service
│   ├── UserService.java
│   └── TaskService.java
│
├── serviceimpl
│   ├── UserServiceImpl.java
│   └── TaskServiceImpl.java
│
├── security
│   ├── JwtTokenProvider.java
│   ├── JwtAuthenticationFilter.java
│   └── CustomUserDetailsService.java
│
├── securityconfig
│   └── SecurityConfig.java
│
├── payload
│   ├── LoginDto.java
│   ├── UserDto.java
│   ├── TaskDto.java
│   └── JWTAuthResponse.java
│
├── exception
│   ├── APIException.java
│   ├── UserNotFound.java
│   └── TaskNotFound.java
│
└── TaskprojectApplication.java
```
