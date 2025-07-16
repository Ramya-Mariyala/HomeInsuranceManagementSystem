# Home Insurance Management System (HIMS)

A full-stack web application to manage home insurance policies, customers, and admin functionalities.

---

## Table of Contents

- [About](#about)  
- [Features](#features)  
- [Tech Stack](#tech-stack)  
- [Project Structure](#project-structure)  
- [Getting Started](#getting-started)  
  - [Backend Setup](#backend-setup)  
  - [Frontend Setup](#frontend-setup)  
- [Usage](#usage)  
- [Author](#author)  
- [License](#license)  

---

## About

HIMS is designed to provide a seamless experience for customers and administrators to handle insurance policies efficiently. The system includes features like user authentication, policy management, claim processing, and role-based access.

---

## Features

- User and Admin login with JWT authentication  
- Create, update, and delete insurance policies  
- Policy renewal and claims management  
- Responsive frontend built with Angular  
- RESTful APIs developed with Spring Boot  
- Secure and scalable architecture  

---

## Tech Stack

- **Frontend:** Angular 15, TypeScript, HTML5, CSS3  
- **Backend:** Java, Spring Boot, Hibernate, MySQL  
- **Security:** JWT for authentication and authorization  
- **Tools:** Git, Maven, Node.js, npm  

---

## Project Structure

HomeInsuranceManagementSystem/
├── HIMS_angular/ # Angular frontend source code
├── Backend/ # Spring Boot backend source code
├── README.md # Project documentation
├── .gitignore # Git ignore rules

---

## Getting Started

### Backend Setup

1. Navigate to the backend folder:
   cd Backend
Build and run the Spring Boot application:


mvn clean install
mvn spring-boot:run
Ensure MySQL is running and database connection properties are correctly set in application.properties.

Frontend Setup
Navigate to the frontend folder:

cd HIMS_angular
Install dependencies:

npm install
Run the Angular development server:

ng serve
Open your browser and go to http://localhost:4200

Usage
Use the admin account to manage policies and users.

Customers can register and view their policies.

The frontend communicates with the backend API for all data operations.

Author
Ramya Mariyala
MS in Information Systems | Full Stack Developer
