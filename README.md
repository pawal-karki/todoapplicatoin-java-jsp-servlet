---

# To-Do Application (Java, JSP, Servlet) - MVC Model  

## Overview  

This project is a **To-Do List application** developed using **Java Servlets, JSP, and the Model-View-Controller (MVC)** architecture. It enables users to **add, update, delete, and view tasks** stored in a **MySQL database**.  

## Prerequisites  

Ensure you have the following installed:  

- **Eclipse IDE** (preferably Eclipse IDE for Java EE Developers)  
- **Apache Tomcat 9+** (tested with Tomcat 9)  
- **MySQL Database**  
- **MySQL Connector/J** (JDBC driver for MySQL)  
- **JDK 8 or later**
- - **Dynamic Web Verion 5.0**  

## Project Setup in Eclipse  

### 1. Clone the Repository  
```sh
git clone https://github.com/pawal-karki/todoapplicatoin-java-jsp-servlet.git
```

### 2. Open Project in Eclipse  
- Open **Eclipse IDE**  
- Navigate to **File** → **Import** → **Existing Projects into Workspace**  
- Select the cloned project folder and click **Finish**  

### 3. Configure Build Path  
- **Right-click** on the project → **Build Path** → **Configure Build Path**  
- **Add JAR**: Select **MySQL Connector/J** (`mysql-connector-java-<version>.jar`)  

### 4. Set Up Apache Tomcat  
- Go to **Window** → **Preferences** → **Server** → **Runtime Environments**  
- Click **Add**, select **Apache Tomcat**, and set the Tomcat installation directory  

### 5. Set Up MySQL Database  
Run the following SQL script to create the database and table:  

```sql
CREATE DATABASE tododb;
USE tododb;

CREATE TABLE tasks (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    description TEXT,
    status BOOLEAN DEFAULT FALSE
);
```

### 6. Update Database Configuration  
Edit `db.properties` (or update directly in `TaskDAO.java` if hardcoded):  

```properties
db.url=jdbc:mysql://localhost:3306/tododb
db.user=root
db.password=your_password
```

### 7. Run the Project  
- **Right-click** on the project → **Run As** → **Run on Server**  
- **Select Tomcat Server** and click **Finish**  
- Open your browser and go to:  
  ```
  http://localhost:8080/todoapplicatoin-java-jsp-servlet/
  ```

## Features  

✔ **Add new tasks**  
✔ **Update task details**  
✔ **Delete tasks**  
✔ **View all tasks**  

## Project Structure  

```
/src/main/java/
  ├── model/        # Data model classes (Task.java)
  ├── dao/          # Database access layer (TaskDAO.java)
  ├── controller/   # Servlet controllers (TaskServlet.java)
/src/main/webapp/
  ├── index.jsp     # Home page
  ├── addTask.jsp   # Add new task
  ├── editTask.jsp  # Edit existing task
  ├── listTasks.jsp # View tasks
```

## Technologies Used  

- **Java (JDK 8+)**  
- **JSP & Servlets**  
- **MySQL Database**  
- **JDBC (MySQL Connector/J)**  
- **Apache Tomcat Server**  
- **Eclipse IDE**  

## Contribution  

Feel free to **fork** this repository and submit **pull requests** for improvements.  

## License  

This project is open-source and available under the **MIT License**.  

---

**Happy Coding!** 🚀
