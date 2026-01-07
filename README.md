# Task Management API (Spring Boot + JWT)

A secure **Task Management REST API** built using **Spring Boot**, **Spring Security (JWT)**, **JPA/Hibernate**, and **MySQL**.  
Implements **JWT-based authentication** and **user-specific task management**.

---

## ✨ Features
- 👤 User Registration & Login  
- 🔐 JWT Authentication (Stateless)  
- 🛡️ Secure APIs with Spring Security  
- 📝 Create, View & Delete Tasks  
- 🔑 Password Encryption using BCrypt  
- 🗄️ MySQL Database Integration  
- ⚙️ RESTful API Design  
- 🚀 Fast & Scalable Backend Architecture  


---

## 🛠️ Tech Stack
- ☕ Java 21  
- 🌱 Spring Boot  
- 🔐 Spring Security + JWT  
- 🗃️ Spring Data JPA / Hibernate  
- 🐬 MySQL  
- 📦 Maven  


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






## 🔗 API Endpoints

### 🔐 Authentication

| Method | Endpoint | Description |
|------|---------|-------------|
| POST | `/api/auth/register` | Register a new user |
| POST | `/api/auth/login` | Login & get JWT token |

### 📋 Tasks (JWT Protected)

| Method | Endpoint | Description |
|------|---------|-------------|
| POST | `/api/{userId}/tasks` | Create a task |
| GET | `/api/{userId}/tasks` | Get all tasks |
| GET | `/api/{userId}/tasks/{taskId}` | Get task by ID |
| DELETE | `/api/{userId}/tasks/{taskId}` | Delete task |





## 🔐 JWT Authentication Flow

1. User registers using `/api/auth/register`
2. User logs in via `/api/auth/login`
3. Server returns a JWT token
4. Client sends token in request header:
   

