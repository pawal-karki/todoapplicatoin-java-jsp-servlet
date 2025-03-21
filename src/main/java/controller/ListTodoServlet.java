package controller;

import model.TodoModel;
import model.TodoDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/ListTodoServlet")
public class ListTodoServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        // 1. Retrieve all todos from the database
        ArrayList<TodoModel> todoList = TodoDAO.listTodo();
        
        // 2. Set the todos as an attribute in the request
        request.setAttribute("todoList", todoList);
        
        // 3. Forward to the JSP to display the todos
        request.getRequestDispatcher("/view/list-todo.jsp").forward(request, response);
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        // Handle any post requests by redirecting to doGet
        doGet(request, response);
    }
}