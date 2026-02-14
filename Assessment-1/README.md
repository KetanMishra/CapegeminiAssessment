# Employee ID Card Management System

## Overview
A Java-based Employee ID Card Management System built using Hibernate/JPA framework. This application demonstrates the implementation of a one-to-one relationship between Employee and IDCard entities with complete CRUD operations persistence.

## Technologies Used
- **Java 17**
- **Hibernate 6.3.1** - ORM Framework
- **Jakarta Persistence API 3.1.0** - JPA Specification
- **MySQL 8.4.0** - Database
- **Maven** - Build Tool

## Project Structure
```
Assessment-1/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/capgemini/assessment/employee_IDCard_Management_System/
│   │   │       ├── App.java
│   │   │       ├── Employee.java
│   │   │       └── IDCard.java
│   │   └── resources/
│   │       └── META-INF/
│   │           └── persistence.xml
└── pom.xml
```

## Features
- One-to-One bidirectional relationship between Employee and IDCard
- Automatic table creation and schema management
- Cascade operations for related entities
- MySQL database integration
- Entity persistence and retrieval operations

## Database Configuration
Update the `persistence.xml` file with your MySQL credentials:
```xml
<property name="jakarta.persistence.jdbc.url" value="jdbc:mysql://localhost:3306/assessment"/>
<property name="jakarta.persistence.jdbc.user" value="root"/>
<property name="jakarta.persistence.jdbc.password" value="root"/>
```

## Setup Instructions

### Prerequisites
1. Java 17 or higher
2. MySQL Server 8.0+
3. Maven 3.6+

### Database Setup
```sql
CREATE DATABASE assessment;
```

### Run the Application
1. Clone or download the project
2. Configure database credentials in `persistence.xml`
3. Run the following commands:
```bash
mvn clean install
mvn exec:java -Dexec.mainClass="com.capgemini.assessment.employee_IDCard_Management_System.App"
```

## Entity Relationships
- **Employee** (1) ↔ (1) **IDCard**
- Cascade Type: ALL
- Fetch Type: EAGER (default)

## Author
Digital - 2026
