# Three-Tier Notes Application

A containerized three-tier web application built using **Java Servlets, JSP, JDBC, Apache Tomcat, and MySQL**, managed completely via **Docker Compose**. Designed for learning multi-container networking, persistent volumes, and containerized deployment without Spring Boot.

---

## 🏗️ Architecture Overview

1. **Presentation & Frontend Layer:** JSP (JavaServer Pages), HTML, and CSS.
2. **Application & Business Logic Layer:** Java Servlets, JDBC, and Apache Tomcat.
3. **Data Layer:** MySQL Server with automated database initialization and persistent Docker volumes.

---

## 📂 Project Directory Structure

```text
three-tier-notes-app/
├── .env
├── compose.yaml
├── database/
│   └── init.sql
└── java-app/
    ├── Dockerfile
    ├── pom.xml
    └── src/
        └── main/
            ├── java/
            │   └── com/notes/
            │       ├── servlet/
            │       │   └── NoteServlet.java
            │       └── util/
            │           └── DBConnection.java
            └── webapp/
                └── index.jsp
```

---

## 🚀 Getting Started & Deployment

### 1. Clone the Repository
```bash
git clone <your-repository-url>
cd three-tier-notes-app
```

### 2. Configure Environment Variables
Create a `.env` file in the root directory:
```env
MYSQL_ROOT_PASSWORD=rootpass
MYSQL_DATABASE=notesdb
MYSQL_USER=notesuser
MYSQL_PASSWORD=notespass
```

### 3. Build and Run with Docker Compose
Run the following command from the root folder:
```bash
docker compose up -d --build
```

### 4. Access the Application
Open your browser and navigate to:
* **Local:** `http://localhost:8080/notes`
* **AWS EC2:** `http://<your-ec2-public-ip>:8080/notes`

### 5. Stop and Clean Up Containers
```bash
docker compose down
```