package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TodoDAO {

    private static final String URL = "jdbc:mysql://localhost:3306/todo_database";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Failed to Load SQL Driver", e);
        }
    }
    
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static int addTodo(TodoModel todoModel) throws SQLException {
        String sql = "INSERT INTO todo_table(title, description, completed) VALUES (?,?,?)";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            
            stmt.setString(1, todoModel.getTitle());
            stmt.setString(2, todoModel.getDescription());
            stmt.setBoolean(3, todoModel.getCompleted());

            int affectedRows = stmt.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Insert Failed, no rows Affected");
            }
            
            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1);
                } else {
                    throw new SQLException("Inserting todo failed, no id obtained");
                }
            }
        }
    }

    public static boolean removeTodo(int todoId) {
        String query = "DELETE FROM todo_table WHERE id = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, todoId);
            return pstmt.executeUpdate() > 0; // Returns true if a row was deleted

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Method to list all todos from the database
    public static ArrayList<TodoModel> listTodo() {
        ArrayList<TodoModel> todoList = new ArrayList<>();
        String query = "SELECT * FROM todo_table";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                TodoModel todo = new TodoModel(
                    rs.getInt("id"),
                    rs.getString("title"),
                    rs.getString("description"),
                    rs.getBoolean("completed")
                );
                todoList.add(todo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return todoList;
    }
}