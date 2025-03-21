<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add New Todo</title>
    <link rel="stylesheet" href="assets/styles.css">
</head>
<body>
    <div class="container">
        <header>
            <h1>Todo Application</h1>
            <nav>
                <ul>
                    <li><a href="ListTodoServlet">View All Todos</a></li>
                    <li><a href="AddTodoServlet" class="active">Add New Todo</a></li>
                </ul>
            </nav>
        </header>
        
        <main>
            <section class="form-container">
                <h2>Add New Todo</h2>
                
                <% if(request.getAttribute("errorMessage") != null) { %>
                    <div class="error-message">
                        <p><%= request.getAttribute("errorMessage") %></p>
                    </div>
                <% } %>
                
                <form action="AddTodoServlet" method="post">
                    <div class="form-group">
                        <label for="title">Title:</label>
                        <input type="text" id="title" name="title" required>
                    </div>
                    
                    <div class="form-group">
                        <label for="description">Description:</label>
                        <textarea id="description" name="description" rows="4"></textarea>
                    </div>
                    
                    <div class="form-group checkbox-group">
                        <input type="checkbox" id="completed" name="completed" value="true">
                        <label for="completed">Completed</label>
                    </div>
                    
                    <div class="form-actions">
                        <button type="submit" class="btn btn-primary">Add Todo</button>
                        <a href="ListTodoServlet" class="btn btn-secondary">Cancel</a>
                    </div>
                </form>
            </section>
        </main>
        
        <footer>
            <p>&copy; 2024 Todo Application</p>
        </footer>
    </div>
    
    <script src="script.js"></script>
</body>
</html>