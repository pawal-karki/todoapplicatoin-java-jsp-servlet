<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, model.TodoModel" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Todo List</title>
    <link rel="stylesheet" href="assets/styles.css">
</head>
<body>
    <div class="container">
        <header>
            <h1>Todo Application</h1>
            <nav>
                <ul>
                    <li><a href="ListTodoServlet" class="active">View All Todos</a></li>
                    <li><a href="AddTodoServlet">Add New Todo</a></li>
                </ul>
            </nav>
        </header>
        
        <main>
            <section class="todo-list">
                <h2>Your Todos</h2>
                
                <% if(session.getAttribute("successMessage") != null) { %>
                    <div class="success-message">
                        <p><%= session.getAttribute("successMessage") %></p>
                    </div>
                    <% session.removeAttribute("successMessage"); %>
                <% } %>
                
                <% if(session.getAttribute("errorMessage") != null) { %>
                    <div class="error-message">
                        <p><%= session.getAttribute("errorMessage") %></p>
                    </div>
                    <% session.removeAttribute("errorMessage"); %>
                <% } %>
                
                <div class="add-new-btn">
                    <a href="AddTodoServlet" class="btn btn-primary">Add New Todo</a>
                </div>
                
                <%
                ArrayList<TodoModel> todoList = (ArrayList<TodoModel>) request.getAttribute("todoList");
                if(todoList == null || todoList.isEmpty()) {
                %>
                    <div class="empty-list">
                        <p>No todos found. Start by adding a new todo!</p>
                    </div>
                <% } else { %>
                    <table class="todo-table">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Title</th>
                                <th>Description</th>
                                <th>Status</th>
                                <th>Actions</th>
                            </tr>
                        </thead>
                        <tbody>
                            <% for(TodoModel todo : todoList) { %>
                                <tr class="<%= todo.getCompleted() ? "completed" : "" %>">
                                    <td><%= todo.getId() %></td>
                                    <td><%= todo.getTitle() %></td>
                                    <td><%= todo.getDescription() %></td>
                                    <td>
                                        <span class="status-badge <%= todo.getCompleted() ? "status-completed" : "status-pending" %>">
                                            <%= todo.getCompleted() ? "Completed" : "Pending" %>
                                        </span>
                                    </td>
                                    <td class="actions">
                                        <form action="DeleteTodoServlet" method="post" class="delete-form">
                                            <input type="hidden" name="id" value="<%= todo.getId() %>">
                                            <button type="submit" class="btn btn-danger">Delete</button>
                                        </form>
                                    </td>
                                </tr>
                            <% } %>
                        </tbody>
                    </table>
                <% } %>
            </section>
        </main>
        
        <footer>
            <p>&copy; 2024 Todo Application</p>
        </footer>
    </div>
    
    <script src="script.js"></script>
</body>
</html>