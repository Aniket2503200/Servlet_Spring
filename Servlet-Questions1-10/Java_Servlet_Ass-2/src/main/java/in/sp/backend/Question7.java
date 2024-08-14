package in.sp.backend;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/upload")
@MultipartConfig
public class Question7 extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Set response content type
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        // Get the uploaded file part
        Part filePart = request.getPart("file");
        
        if (filePart != null) {
            String fileName = filePart.getSubmittedFileName();
            long fileSize = filePart.getSize();
            
            // Display file name and size
            out.println("<html><body>");
            out.println("<h3>File Uploaded Successfully!</h3>");
            out.println("<p>File Name: " + fileName + "</p>");
            out.println("<p>File Size: " + fileSize + " bytes</p>");
            out.println("</body></html>");
        } else {
            out.println("<html><body>");
            out.println("<h3>No file uploaded</h3>");
            out.println("</body></html>");
        }
    }
}
