rc/main/java/com/example/crmapp/
├── config/           # DB config (e.g., DataSource, JPA settings)
├── controllers/      # REST Controllers (e.g., CustomerController.java)
├── models/           # Entities like Customer, Activity
├── repositories/     # Spring Data JPA Repositories (CRUD)
├── services/         # Business logic (optional, clean separation)
└── CrmappApplication.java 

RUN :
./mvnw spring-boot:run