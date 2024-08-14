package in.sp.backend;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/visit-counter")
public class Question4 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Get the session (create one if it doesn't exist)
        HttpSession session = request.getSession(true);

        // Retrieve the visit count from the session, if available
        Integer visitCount = (Integer) session.getAttribute("visitCount");

        // If it's the first visit, initialize the visit count
        if (visitCount == null) {
            visitCount = 0;
        }

        // Increment the visit count
        visitCount++;

        // Store the updated visit count back into the session
        session.setAttribute("visitCount", visitCount);

        // Set the content type of the response
        response.setContentType("text/html");

        // Get the writer to send output to the client
        PrintWriter out = response.getWriter();

        // Write the response
        out.println("<html><body>");
        out.println("<h1>Visit Counter</h1>");
        out.println("<p>You have visited this page " + visitCount + " times during this session.</p>");
        out.println("</body></html>");
    }
}
