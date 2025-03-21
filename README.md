

```markdown
# To-Do Application (Java, JSP, Servlet) - MVC Model  

## Overview  
This is a **simple To-Do application** built using **Java Servlets, JSP, and MySQL**, following the **MVC architecture**. It allows users to **add, view, and delete tasks**.  

## Prerequisites  
Ensure you have the following installed:  
- **Eclipse IDE** (for Java EE Developers)  
- **Apache Tomcat 9+**  
- **MySQL Database**  
- **MySQL Connector/J** (JDBC driver)  
- **JDK 8 or later**  

## Project Setup  

### 1. Clone the Repository  
```sh
git clone https://github.com/pawal-karki/todoapplicatoin-java-jsp-servlet.git
```

### 2. Import the Project in Eclipse  
- Open **Eclipse** → **File** → **Import** → **Existing Projects into Workspace**  
- Select the cloned folder and click **Finish**  

### 3. Configure Project Settings  
- **Set Dynamic Web Module to 5.0**  
  - Right-click project → **Properties** → **Project Facets** → Set **Dynamic Web Module** to **5.0**  
- **Add MySQL Connector/J**  
  - Right-click project → **Build Path** → **Add External JARs** → Select `mysql-connector-java-<version>.jar`  

### 4. Configure Tomcat Server  
- Go to **Window** → **Preferences** → **Server** → **Runtime Environments**  
- Click **Add**, select **Apache Tomcat**, and set the installation directory  

### 5. Set Up MySQL Database  
Run the following SQL commands:  
```sql
CREATE DATABASE todo_database;
USE todo_database;

CREATE TABLE todo_table (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    description TEXT,
    completed BOOLEAN DEFAULT false
);
```

### 6. Update Database Configuration  
Edit `db.properties` (or modify `TodoDAO.java`):  
```properties
db.url=jdbc:mysql://localhost:3306/todo_database
db.user=root
db.password=your_password
```

### 7. Run the Project  
- Right-click the project → **Run As** → **Run on Server**  
- Open your browser and go to:  
  ```
  http://localhost:8080/todoapplicatoin-java-jsp-servlet/
  ```

## Features  
✔ **Add tasks**  
✔ **View all tasks**  
✔ **Delete tasks**  

## Folder Structure  
```
TodoApplication/
├── src/main/java/          
│   ├── controller/    # Servlets (TaskServlet.java)
│   ├── model/         # Business logic (Task.java, TaskDAO.java)
├── src/main/webapp/        
│   ├── WEB-INF/       # Config files
│   ├── view/          # JSP files (add-task.jsp, list-tasks.jsp)
│   └── index.jsp      # Home page
```

## Technologies Used  
- **Java (JDK 8+)**  
- **JSP & Servlets**  
- **MySQL Database**  
- **JDBC (MySQL Connector/J)**  
- **Apache Tomcat 9+**  
- **Eclipse IDE**  

## Contribution  
Feel free to fork this repo and submit pull requests.  

## License  
This project is open-source and available under the **MIT License**.  

---

**Happy Coding!** 🚀
```
