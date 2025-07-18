📚 Course Search App

A Spring Boot application integrated with **Elasticsearch** for full-text search of courses. It provides REST APIs to index, search, and manage course data, with support for Dockerized Elasticsearch deployment.


##🧰 Tech Stack

- Java 17+
- Spring Boot 3.x
- Spring Data Elasticsearch
- Elasticsearch 8.12
- Maven
- Docker & Docker Compose

---

## 🚀 Features

- Add and search course data using REST APIs
- Elasticsearch integration for fast and flexible search
- Dockerized setup for easy local development
- Modular project structure using Spring Boot

---

## 🧑‍💻 Getting Started

### ✅ Prerequisites

- Java 17+
- Maven installed
- Docker & Docker Compose

---

### 🔄 Clone the Repository

```bash
git clone https://github.com/your-username/course-search-app.git
cd course-search-app

---

## 🐳 Run Elasticsearch with Docker
```bash
docker-compose up -d
This will start Elasticsearch at http://localhost:9200.

---

### ⚙️ Configure Spring Boot
spring.application.name=course-search-app
server.port=8080

spring.elasticsearch.uris=http://localhost:9200
spring.elasticsearch.connection-timeout=5s
spring.elasticsearch.socket-timeout=30s

---

### 📦 Build and Run the App
mvn clean install
mvn spring-boot:run
App will be available at: http://localhost:8080

---

### 🧪 Run Tests
```bash
mvn test

---

### 📄 Docker Compose Configuration
docker-compose.yml:
version: '3.8'
services:
  elasticsearch:
    image: docker.elastic.co/elasticsearch/elasticsearch:8.12.0
    environment:
      - discovery.type=single-node
      - xpack.security.enabled=false
    ports:
      - "9200:9200"
    volumes:
      - es_data:/usr/share/elasticsearch/data
volumes:
  es_data:

---

### 🙋‍♂️ AuthorGitHub:
GitHub: @Kanishk-Malav

---
