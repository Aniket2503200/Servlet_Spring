package in.sp.backend;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/error")
public class ErrorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        // Retrieve error message from request attributes
        String errorMessage = (String) request.getAttribute("errorMessage");
        
        out.println("<html><body>");
        out.println("<h1>An Error Occurred</h1>");
        if (errorMessage != null) {
            out.println("<p>Error Message: " + errorMessage + "</p>");
        } else {
            out.println("<p>Unknown error</p>");
        }
        out.println("</body></html>");
    }
}
