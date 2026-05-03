#  Personal Finance Tracker

A modern, full-stack financial management application. This project bridges a **Java Spring Boot** REST API with a dynamic **Vanilla JavaScript** frontend to track income and expenses in real-time.

##  Features
- **Real-time Calculations:** Instant balance updates using asynchronous logic.
- **Full CRUD:** Add, view, and delete transactions.
- **Categorization:** Organize spending into Food, Transport, Salary, and more.
- **Modern UI:** Responsive dark-themed interface built with CSS Flexbox.

##  Tech Stack
- **Backend:** Java 21, Spring Boot, Spring Data JPA, H2 (In-Memory Database).
- **Frontend:** HTML5, CSS3 (Variables & Flexbox), JavaScript (Fetch API).
- **Communication:** RESTful API with JSON serialization.

##  Architectural Overview
I implemented a **Three-Layer Architecture** to ensure clean code and separation of concerns:
1. **Controller Layer:** Handles incoming HTTP requests and API routing.
2. **Service Layer:** Manages business logic (e.g., calculating total balance).
3. **Repository Layer:** Interfaces with the H2 database using Spring Data JPA.



##  How to Run
1. **Clone:** `git clone https://github.com/Yernar-Myrzabek/Finance-tracker.git`
2. **Build:** Open the project in IntelliJ IDEA and let Maven download dependencies.
3. **Launch:** Run `FinanceTrackerApplication.java`.
4. **View:** Open `http://localhost:8080` in your browser.

##  API Endpoints
| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/api/transactions` | Retrieve all transaction history |
| POST | `/api/transactions` | Create a new income/expense record |
| DELETE | `/api/transactions/{id}` | Remove a specific record by ID |
| GET | `/api/balance` | Calculate and return current net balance |
