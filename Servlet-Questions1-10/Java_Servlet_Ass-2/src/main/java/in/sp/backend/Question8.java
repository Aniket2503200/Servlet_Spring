package in.sp.backend;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/errorDemo")
public class Question8 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            // Simulate an exception
            throw new RuntimeException("Simulated Exception");
        } catch (RuntimeException e) {
            // Set error message and forward to error page
            request.setAttribute("errorMessage", e.getMessage());
            request.getRequestDispatcher("/error").forward(request, response);
        }
    }
}
