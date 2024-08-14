package in.sp.backend;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

@WebServlet("/user-list")
public class Question6 extends HttpServlet {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydatabase1A";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "aniket25";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to the database
            Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            // Create a statement to execute SQL queries
            Statement stmt = conn.createStatement();

            // Execute a query to retrieve all users
            String sql = "SELECT id, name, email FROM users";
            ResultSet rs = stmt.executeQuery(sql);

            // Generate HTML output
            out.println("<html><body>");
            out.println("<h1>List of Users</h1>");
            out.println("<table border='1'>");
            out.println("<tr><th>ID</th><th>Name</th><th>Email</th></tr>");

            // Iterate over the result set and display the users
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");

                out.println("<tr>");
                out.println("<td>" + id + "</td>");
                out.println("<td>" + name + "</td>");
                out.println("<td>" + email + "</td>");
                out.println("</tr>");
            }

            out.println("</table>");
            out.println("</body></html>");

            // Close the resources
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace(out);
        } finally {
            out.close();
        }
    }
}
