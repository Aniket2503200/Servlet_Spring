package in.sp.backend;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/welcome")
public class Question3 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve the form data from the request
        String name = request.getParameter("name");
        String email = request.getParameter("email");

        // Set the content type of the response
        response.setContentType("text/html");

        // Get the writer to send output to the client
        PrintWriter out = response.getWriter();

        // Write the response
        out.println("<html><body>");
        out.println("<h1>Welcome, " + name + "!</h1>");
        out.println("<p>Your email is: " + email + "</p>");
        out.println("</body></html>");
    }
}
