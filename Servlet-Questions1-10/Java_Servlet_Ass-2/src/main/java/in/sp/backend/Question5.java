package in.sp.backend;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;

@WebServlet("/forwarder")
public class Question5 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve the user's choice from the form
        String destination = request.getParameter("destination");

        // Determine where to forward the request
        String targetPage = null;
        if ("welcome".equals(destination)) {
            // Forward to the welcome.jsp page
            targetPage = "welcome.jsp";
        } else if ("goodbye".equals(destination)) {
            // Forward to the goodbye.jsp page
            targetPage = "goodbye.jsp";
        } else {
            // If an unknown option is selected, send an error response
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid destination");
            return;
        }

        // Forward the request to the target JSP page
        RequestDispatcher dispatcher = request.getRequestDispatcher(targetPage);
        dispatcher.forward(request, response);
    }
}
