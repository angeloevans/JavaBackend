# SmallCRM

A lightweight Customer Relationship Management (CRM) system built with **Java Spring Boot**, **PostgreSQL**, and **RESTful APIs**.

## 🚀 Features

- Manage **Customers**, **Activities**, and **Customer Activities**
- PostgreSQL database schema via `schema.sql`
- Full CRUD functionality for each entity
- Organized structure with `models`, `repositories`, `services`, `controllers`
- Validation using `jakarta.validation`
- Easy integration and local development

## 📦 Tech Stack

- Java 17+
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Maven
- Lombok

---

## ⚙️ Setup & Installation

### 1. Clone the repository

```bash
git clone https://github.com/your-username/smallcrm.git
cd smallcrm
```

### 2. Configure PostgreSQL
Ensure PostgreSQL is running. 
Create a database named crm:

```Sql
CREATE DATABASE crm;
```

⚠️ Use the PostgreSQL shell or GUI (like pgAdmin) for this.

### 3. Configure application.properties
Update src/main/resources/application.properties with your PostgreSQL credentials:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/crm
spring.datasource.username=yourusername
spring.datasource.password=yourpassword

spring.jpa.hibernate.ddl-auto=none
spring.sql.init.mode=always
```
### 4. Run the application
Use Maven Wrapper:

```bash
./mvnw spring-boot:run
```

The app will start on:
📍 http://localhost:8080

🔗 API Endpoints

**Customers**
- GET /customers
- GET /customers/{id}
- POST /customers
- PUT /customers/{id}
- DELETE /customers/{id}

**Activities**
- GET /activities
- POST /activities
etc.

**Customer Activities**
- GET /customer-activities
etc.

**All endpoints return JSON and support full CRUD.**

📁 Project Structure
```css
src/
 └── main/
      ├── java/com/smallcrm/crmapp/
      │    ├── controllers/
      │    ├── models/
      │    ├── repositories/
      │    ├── services/
      │    └── CrmappApplication.java
      └── resources/
           ├── application.properties
           └── schema.sql
``` 

## ✅ future improvements - ToDo

- [ ] Write tests for all API endpoints
- [ ] Implement authentication (e.g., JWT)
- [ ] Create frontend UI (React)
- [ ] Deploy to Heroku / Render / Railway

📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

🙋‍♂️ Author

Built with ❤️ by Angelo Evangelopoulos