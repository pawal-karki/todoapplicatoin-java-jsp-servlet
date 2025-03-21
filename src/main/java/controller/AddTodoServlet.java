package controller;

import model.TodoModel;
import model.TodoDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/AddTodoServlet")
public class AddTodoServlet extends HttpServlet {
    public class DeleteTodoServlet {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        // 1. Retrieve form data (title, description, completed status)
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        boolean completed = Boolean.parseBoolean(request.getParameter("completed"));
        
        // Validate input
        if (title == null || title.trim().isEmpty()) {
            request.setAttribute("errorMessage", "Title cannot be empty");
            request.getRequestDispatcher("/view/add-todo.jsp").forward(request, response);
            return;
        }
        
        // 2. Create a new TodoModel object with the form data
        TodoModel todoModel = new TodoModel(0,title, description, completed);
        todoModel.setTitle(title);
        todoModel.setDescription(description);
        todoModel.setCompleted(completed);
        
        try {
            // 3. Add the todo to the database using TodoDAO
            int todoId = TodoDAO.addTodo(todoModel);
            
            // 4. Redirect to the list page after successful addition
            response.sendRedirect("ListTodoServlet");
        } catch (SQLException e) {
            // Handle database errors
            request.setAttribute("errorMessage", "Failed to add todo: " + e.getMessage());
            request.getRequestDispatcher("/view/add-todo.jsp").forward(request, response);
            e.printStackTrace();
        }
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        // Display the add todo form
        request.getRequestDispatcher("/view/add-todo.jsp").forward(request, response);
    }
}