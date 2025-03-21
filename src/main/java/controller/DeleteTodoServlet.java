package controller;

import model.TodoDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/DeleteTodoServlet")
public class DeleteTodoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        // 1. Get the todo ID from the request parameters
        String todoIdParam = request.getParameter("id");
        
        try {
            // 2. Parse the ID as an integer
            int todoId = Integer.parseInt(todoIdParam);
            
            // 3. Delete the todo from the database
            boolean deleted = TodoDAO.removeTodo(todoId);
            
            // 4. Set success or error message
            if (deleted) {
                request.getSession().setAttribute("successMessage", "Todo successfully deleted");
            } else {
                request.getSession().setAttribute("errorMessage", "Failed to delete todo");
            }
        } catch (NumberFormatException e) {
            // Handle invalid ID format
            request.getSession().setAttribute("errorMessage", "Invalid todo ID");
            e.printStackTrace();
        }
        
        // 5. Redirect back to the list page
        response.sendRedirect("ListTodoServlet");
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        // For security reasons, deletions should typically be handled via POST
        // But we can support GET requests by redirecting to the list page
        response.sendRedirect("ListTodoServlet");
    }
}